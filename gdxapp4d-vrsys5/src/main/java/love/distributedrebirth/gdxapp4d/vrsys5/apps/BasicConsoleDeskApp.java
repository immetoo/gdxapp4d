package love.distributedrebirth.gdxapp4d.vrsys5.apps;

import imgui.ImGui;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.AbstractDeskApp;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppContourSection;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppRenderer;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class BasicConsoleDeskApp extends AbstractDeskApp implements DeskAppRenderer {

	public void create() {
		getContours().setTitle("Basic Console");
		getContours().registrateContour(DeskAppContourSection.MAIN, this);
	}

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
}
