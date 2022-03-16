package love.distributedrebirth.gdxapp4d.app.notepad;

import imgui.ImColor;
import imgui.ImDrawList;
import imgui.ImGui;
import imgui.ImVec2;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.vrgem4.service.VrGem4Unicode4DService;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.AbstractDeskApp;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppContourSection;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppRenderer;
import love.distributedrebirth.unicode4d.draw.DrawCharacter;
import love.distributedrebirth.unicode4d.draw.DrawGlyphPath.ImGlyphLineTo;
import love.distributedrebirth.unicode4d.draw.DrawGlyphPath.ImGlyphPathCommand;
import love.distributedrebirth.unicode4d.draw.DrawGlyphPath.ImGlyphQuadCurveTo;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class NotepadDeskApp extends AbstractDeskApp implements DeskAppRenderer {

	private final VrGem4Unicode4DService unicode4DService;
	private String value = "";
	
	public NotepadDeskApp(VrGem4Unicode4DService unicode4DService) {
		this.unicode4DService = unicode4DService;
	}
	
	public void create() {
		getContours().setTitle("Notepad");
		getContours().registrateContour(DeskAppContourSection.MAIN, this);
	}
	
	@Override
	public void render() {
		ImGui.text("Value:");
		ImGui.text(value);
		
		//Integer.parseInt("27d6", 16)
		//new Character('ﷲ').charValue()
		//new ImCharacter(unicode4DService.getCharacterForUnicode(Integer.parseInt("27d6", 16))).render();
		new ImCharacter(unicode4DService.getCharacterForUnicode(new Character('ﷲ').charValue())).render();
		ImGui.sameLine();
		new ImCharacter(unicode4DService.getCharacterForUnicode(new Character('v').charValue())).render();
		ImGui.sameLine();
		new ImCharacter(unicode4DService.getCharacterForUnicode(new Character('r').charValue())).render();
		//ImGui.sameLine();
		new ImCharacter(unicode4DService.getCharacterForUnicode(new Character('G').charValue())).render();
		ImGui.sameLine();
		new ImCharacter(unicode4DService.getCharacterForUnicode(new Character('E').charValue())).render();
		ImGui.sameLine();
		new ImCharacter(unicode4DService.getCharacterForUnicode(new Character('M').charValue())).render();
		ImGui.sameLine();
		new ImCharacter(unicode4DService.getCharacterForUnicode(new Character('⁴').charValue())).render();
		
		new ImCharacter(unicode4DService.getCharacterForUnicode(Integer.parseInt("27d6", 16))).render();
		ImGui.sameLine();
		new ImCharacter(unicode4DService.getCharacterForUnicode(new Character('仙').charValue())).render();
	}
	

	class ImCharacter {
		
		private final DrawCharacter drawChar;
		
		public ImCharacter(DrawCharacter drawChar) {
			this.drawChar = drawChar;
		}
		
		public void render() {
			ImVec2 size = new ImVec2(50f, 70f);
			ImGui.invisibleButton("canvas", size.x, size.y);
			ImVec2 p0 = ImGui.getItemRectMin();
			ImVec2 p1 = ImGui.getItemRectMax(); // p1 = p0 + size
			ImDrawList drawList = ImGui.getWindowDrawList();
			drawList.pushClipRect(p0.x, p0.y, p1.x, p1.y);
			
			// draw unicode4D
			float xOff = p0.x;
			float yOff = p0.y + 55f;
			float yFlip = -1f;
			float scale = 0.025f;
			ImGlyphPathCommand first = null;
			ImGlyphPathCommand prev = null;
			int color = ImColor.intToColor(255, 127, 63, 255);
			for (ImGlyphPathCommand cmd: drawChar.getGlyphPath().getPath()) {
				if (cmd.isImGlyphMoveTo()) {
					first = cmd;
					prev = cmd;
					continue;
				}
				if (cmd.isImGlyphLineTo()) {
					ImGlyphLineTo lineTo = cmd.toImGlyphLineTo();
					drawList.addLine(xOff+prev.getX()*scale, yOff+prev.getY()*scale*yFlip, xOff+lineTo.getX()*scale, yOff+lineTo.getY()*scale*yFlip, color);
					prev = cmd;
					continue;
				}
				if (cmd.isImGlyphQuadCurveTo()) {
					ImGlyphQuadCurveTo quadCurveTo = cmd.toImGlyphQuadCurveTo();
					drawList.addBezierQuadratic(xOff+prev.getX()*scale, yOff+prev.getY()*scale*yFlip, xOff+quadCurveTo.getX1()*scale, yOff+quadCurveTo.getY1()*scale*yFlip, xOff+quadCurveTo.getX()*scale, yOff+quadCurveTo.getY()*scale*yFlip, color, 1);
					prev = cmd;
					continue;
				}
				if (cmd.isImGlyphClosePath()) {
					drawList.addLine(xOff+prev.getX()*scale, yOff+prev.getY()*scale*yFlip, xOff+first.getX()*scale, yOff+first.getY()*scale*yFlip, color);
				}
			}
			drawList.addQuad(p0.x, p0.y, p0.x+size.x, p0.y, p1.x, p1.y, p0.x, p0.y+size.y,
					ImColor.intToColor(127, 127, 255, 255), 1f);
			drawList.popClipRect();
		}
	}
}
