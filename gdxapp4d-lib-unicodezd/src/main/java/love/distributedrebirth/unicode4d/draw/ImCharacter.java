package love.distributedrebirth.unicode4d.draw;

import imgui.ImColor;
import imgui.ImDrawList;
import imgui.ImGui;
import imgui.ImVec2;
import love.distributedrebirth.unicode4d.draw.DrawGlyphPath.ImGlyphLineTo;
import love.distributedrebirth.unicode4d.draw.DrawGlyphPath.ImGlyphPathCommand;
import love.distributedrebirth.unicode4d.draw.DrawGlyphPath.ImGlyphQuadCurveTo;

public class ImCharacter {
	
	public static final float HEIGHT = 26f;
	public static final float MARGIN_MENUBAR = 4f;
	private static final ImVec2 SIZE = new ImVec2(22f, HEIGHT);
	private static final int COLOR = ImColor.intToColor(255, 255, 255, 255);
	
	public static void render(DrawCharacter drawChar) {
		ImGui.invisibleButton("canvas", SIZE.x, SIZE.y);
		ImVec2 p0 = ImGui.getItemRectMin();
		ImVec2 p1 = ImGui.getItemRectMax(); // p1 = p0 + size
		ImDrawList drawList = ImGui.getWindowDrawList();
		drawList.pushClipRect(p0.x, p0.y, p1.x, p1.y);
		
		// draw unicode4D
		float xOff = p0.x;
		float yOff = p0.y + 19f;
		float yFlip = -1f;
		float scale = 0.0199f;
		if (drawChar.getyMax() > 800) {
			scale = 0.0100f;
		}
		ImGlyphPathCommand first = null;
		ImGlyphPathCommand prev = null;
		for (ImGlyphPathCommand cmd: drawChar.getGlyphPath().getPath()) {
			if (cmd.isImGlyphMoveTo()) {
				first = cmd;
				prev = cmd;
				continue;
			}
			if (cmd.isImGlyphLineTo()) {
				ImGlyphLineTo lineTo = cmd.toImGlyphLineTo();
				drawList.addLine(
						xOff+prev.getX()*scale,
						yOff+prev.getY()*scale*yFlip,
						xOff+lineTo.getX()*scale,
						yOff+lineTo.getY()*scale*yFlip,
						COLOR);
				prev = cmd;
				continue;
			}
			if (cmd.isImGlyphQuadCurveTo()) {
				ImGlyphQuadCurveTo quadCurveTo = cmd.toImGlyphQuadCurveTo();
				drawList.addBezierQuadratic(
						xOff+prev.getX()*scale,
						yOff+prev.getY()*scale*yFlip,
						xOff+quadCurveTo.getX1()*scale,
						yOff+quadCurveTo.getY1()*scale*yFlip,
						xOff+quadCurveTo.getX()*scale,
						yOff+quadCurveTo.getY()*scale*yFlip,
						COLOR,
						1);
				prev = cmd;
				continue;
			}
			if (cmd.isImGlyphClosePath()) {
				drawList.addLine(
						xOff+prev.getX()*scale,
						yOff+prev.getY()*scale*yFlip,
						xOff+first.getX()*scale,
						yOff+first.getY()*scale*yFlip,
						COLOR);
			}
		}
		//drawList.addQuad(p0.x, p0.y, p0.x+size.x, p0.y, p1.x, p1.y, p0.x, p0.y+size.y,
		//		ImColor.intToColor(127, 127, 255, 255), 1f);
		drawList.popClipRect();
	}
}