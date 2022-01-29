package love.distributedrebirth.demo4d.screen;

import imgui.ImColor;
import imgui.ImDrawList;
import imgui.ImGui;
import imgui.ImVec2;
import imgui.flag.ImGuiCond;
import love.distributedrebirth.demo4d.Demo4DMain;
import love.distributedrebirth.demo4d.Demo4DMainAdapter;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public class ScreenUnicode4D extends Demo4DMainAdapter {
	
	public ScreenUnicode4D(final Demo4DMain main) {
		super(main);
	}
	
	@Override
	public void render(float delta) {
		main.batch.begin();
		main.font.draw(main.batch, "Tap anywhere to begin!", main.viewWidth/2 - 73, 33);
		main.batch.end();
		
		ImGui.setNextWindowPos(400, 200, ImGuiCond.FirstUseEver);
		ImGui.setNextWindowSize(320, 240, ImGuiCond.FirstUseEver);
		ImGui.begin("Unicode4D test");
		ImGui.text("There is unicode and unicode4D");
		ImVec2 size = new ImVec2(144f, 48f);
		ImGui.invisibleButton("canvas", size.x, size.y);
		ImVec2 p0 = ImGui.getItemRectMin();
		ImVec2 p1 = ImGui.getItemRectMax();
		ImDrawList drawList = ImGui.getWindowDrawList();
		drawList.pushClipRect(p0.x, p0.y, p1.x, p1.y);
		// draw unicode4D
		//System.out.println("p0.x="+p0.x+" p0.y="+p0.y);
		//System.out.println("p1.x="+p1.x+" p1.y="+p1.y);
		
//		for (int n = 0; n < (1.0f + Math.sin(ImGui.getTime() * 5.7f)) * 40.0f; n++) {
//			drawList.addCircle(p0.x + size.x * 0.5f, p0.y + size.y * 0.5f, size.y * (0.01f + n * 0.03f), 
//				ImColor.intToColor(255, 140 - n * 4, n * 3, 255)
//			);
//		}
		
		drawList.addQuad(p0.x, p0.y, p0.x+size.x, p0.y, p1.x, p1.y, p0.x, p0.y+size.y,
				ImColor.intToColor(127, 127, 255, 255), 5f);
		
		drawList.addLine(p0.x+10, p0.y+40, p0.x+20, p0.y+10, ImColor.intToColor(255, 127, 63, 255));
		drawList.addLine(p0.x+30, p0.y+40, p0.x+20, p0.y+10, ImColor.intToColor(255, 127, 63, 255));
		drawList.addLine(p0.x+13, p0.y+30, p0.x+27, p0.y+30, ImColor.intToColor(255, 127, 63, 255));
		
		drawList.popClipRect();
		ImGui.end();
	}
}
