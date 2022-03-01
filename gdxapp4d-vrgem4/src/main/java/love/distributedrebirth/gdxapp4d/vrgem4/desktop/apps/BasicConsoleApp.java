package love.distributedrebirth.gdxapp4d.vrgem4.desktop.apps;

import imgui.ImGui;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.vrgem4.desktop.DefaultDeskApp;
import love.distributedrebirth.gdxapp4d.vrgem4.desktop.DeskAppContourSection;
import love.distributedrebirth.gdxapp4d.vrgem4.desktop.DeskAppRenderer;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class BasicConsoleApp extends DefaultDeskApp {

	public BasicConsoleApp() {
		setTitle("Basic Conssole");
		getContours().registrateContour(DeskAppContourSection.MAIN, new DeskAppRenderer() {
			
			@Override
			public void render() {
				ImGui.text("10 PRINT \"The BASIC Shahada of DUNE;\"");
				ImGui.text("20 PRINT \"- THERE IS NO GOD BUT @Ω仙⁴\"");
				ImGui.text("30 PRINT \"- THERE IS NO RULE BUT CONSENT\"");
				ImGui.text("40 PRINT \"- THERE IS NO FAILURE BUT DEATH\"");
				ImGui.text("50 PRINT \"- TERRY A. DAVIS WAS THE PROPHET OF @Ω仙9⁴\"");
				ImGui.text("60 PRINT \"- TERRY A. DAVIS WAS THE FIRST TRUE MENTAT\"");
				ImGui.text("70 PRINT \"- TERRY A. DAVIS WAS THE BEST CODER ALIVE\"");
				ImGui.text("RUN");
			}
		});
	}
}
