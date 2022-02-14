package love.distributedrebirth.gdxapp.desktop.apps;

import imgui.ImColor;
import imgui.ImDrawList;
import imgui.ImGui;
import imgui.ImVec2;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp.desktop.DefaultDeskApp;
import love.distributedrebirth.gdxapp.desktop.DeskAppContourSection;
import love.distributedrebirth.gdxapp.desktop.DeskAppRenderer;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class Unicode4DApp extends DefaultDeskApp implements DeskAppRenderer {

	public Unicode4DApp() {
		setTitle("Unicode4D");
		getContours().registrateContour(DeskAppContourSection.MAIN, this);
	}

	@Override
	public void render() {
		ImGui.text("There is unicode and unicode4D");
		ImVec2 size = new ImVec2(144f, 48f);
		ImGui.invisibleButton("canvas", size.x, size.y);
		ImVec2 p0 = ImGui.getItemRectMin();
		ImVec2 p1 = ImGui.getItemRectMax(); // p1 = p0 + size
		ImDrawList drawList = ImGui.getWindowDrawList();
		drawList.pushClipRect(p0.x, p0.y, p1.x, p1.y);
		// draw unicode4D
		drawList.addQuad(p0.x, p0.y, p0.x+size.x, p0.y, p1.x, p1.y, p0.x, p0.y+size.y,
				ImColor.intToColor(127, 127, 255, 255), 5f);
		
		drawList.addLine(p0.x+10, p0.y+40, p0.x+20, p0.y+10, ImColor.intToColor(255, 127, 63, 255));
		drawList.addLine(p0.x+30, p0.y+40, p0.x+20, p0.y+10, ImColor.intToColor(255, 127, 63, 255));
		drawList.addLine(p0.x+13, p0.y+30, p0.x+27, p0.y+30, ImColor.intToColor(255, 127, 63, 255));
		
		drawList.popClipRect();
			
		//System.out.println("p0.x="+p0.x+" p0.y="+p0.y);
		//System.out.println("p1.x="+p1.x+" p1.y="+p1.y);
		
//		for (int n = 0; n < (1.0f + Math.sin(ImGui.getTime() * 5.7f)) * 40.0f; n++) {
//			drawList.addCircle(p0.x + size.x * 0.5f, p0.y + size.y * 0.5f, size.y * (0.01f + n * 0.03f), 
//				ImColor.intToColor(255, 140 - n * 4, n * 3, 255)
//			);
//		}
	}
}
