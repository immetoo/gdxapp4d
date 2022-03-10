package love.distributedrebirth.gdxapp4d.vrsys5.apps;

import imgui.ImGui;
import imgui.type.ImBoolean;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.AbstractDeskApp;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppContourSection;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppRenderer;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class ImGuiDeskApp extends AbstractDeskApp implements DeskAppRenderer {
	
	protected ImBoolean showImGuiDemo = new ImBoolean(false);
	
	public void create() {
		getContours().setTitle("ImGui Demo");
		getContours().registrateContour(DeskAppContourSection.MAIN, this);
	}

	@Override
	public void render() {
		ImGui.text("Display the ImGui demo window;");
		if (ImGui.button("Show")) {
			showImGuiDemo.set(true);
		}
		if (showImGuiDemo.get()) {
			ImGui.showDemoWindow(showImGuiDemo);
		}
	}
}
