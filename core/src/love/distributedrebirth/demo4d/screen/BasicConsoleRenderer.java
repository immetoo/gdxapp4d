package love.distributedrebirth.demo4d.screen;

import imgui.ImGui;
import imgui.flag.ImGuiCond;
import imgui.type.ImBoolean;
import love.distributedrebirth.demo4d.Demo4DMain;
import love.distributedrebirth.demo4d.ImGuiRendererMain;

public class BasicConsoleRenderer extends ImGuiRendererMain {

	public BasicConsoleRenderer(Demo4DMain main) {
		super(main);
	}

	@Override
	public void render(ImBoolean widgetOpen) {
		ImGui.setNextWindowPos(300, 300, ImGuiCond.FirstUseEver);
		ImGui.setNextWindowSize(320, 240, ImGuiCond.FirstUseEver);
		ImGui.begin("The BASIC Shahada of DUNE", widgetOpen);
		ImGui.text("10 PRINT \"THERE IS NO GOD BUT @Ω\u4ed9⁴\"");
		ImGui.text("20 PRINT \"THERE IS NO RULE BUT CONSENT\"");
		ImGui.text("30 PRINT \"THERE IS NO FAILURE BUT DEATH\"");
		ImGui.text("40 PRINT \"TERRY A. DAVIS WAS THE PROPHET OF @Ω\u4ed9⁴\"");
		ImGui.text("50 PRINT \"TERRY A. DAVIS WAS THE FIRST TRUE MENTAT\"");
		ImGui.text("60 PRINT \"TERRY A. DAVIS WAS THE BEST CODER ALIVE\"");
		ImGui.text("RUN");
		ImGui.end();
	}
}
