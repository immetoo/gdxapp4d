package love.distributedrebirth.demo4d.screen;

import java.util.Arrays;
import java.util.List;

import imgui.ImGui;
import imgui.flag.ImGuiCond;
import imgui.flag.ImGuiTableFlags;
import imgui.type.ImBoolean;
import love.distributedrebirth.demo4d.Demo4DMain;
import love.distributedrebirth.demo4d.ImGuiRendererMain;
import love.distributedrebirth.numberxd.base2t.T60Sexagesimal;
import love.distributedrebirth.numberxd.base2t.facet.BasePart;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class BasePartRenderer extends ImGuiRendererMain {

	public BasePartRenderer(Demo4DMain main) {
		super(main);
	}

	@Override
	public void render(ImBoolean widgetOpen) {
		ImGui.setNextWindowPos(200, 200, ImGuiCond.FirstUseEver);
		ImGui.setNextWindowSize(640, 480, ImGuiCond.FirstUseEver);
		ImGui.begin("Base part", widgetOpen);
		
		ImGui.text("Current part type:");
		ImGui.sameLine();
		ImGui.text("T60Sexagesimal");
		int flags = ImGuiTableFlags.ScrollX | ImGuiTableFlags.RowBg | ImGuiTableFlags.BordersOuter | ImGuiTableFlags.BordersV;
		ImGui.beginTable("base-part", 5, flags);
		ImGui.tableSetupColumn("ordinal");
		ImGui.tableSetupColumn("idTone");
		ImGui.tableSetupColumn("idLetter");
		ImGui.tableSetupColumn("ChinaKey");
		ImGui.tableSetupColumn("ChinaValue");
		ImGui.tableHeadersRow();

		List<BasePart> parts = Arrays.asList(T60Sexagesimal.values());
		
		for (BasePart part:parts) {
			ImGui.tableNextRow();
			ImGui.tableNextColumn();
			ImGui.text(Integer.toString(part.ordinal()));
			ImGui.tableNextColumn();
			ImGui.text(part.getIdentifierTone());
			ImGui.tableNextColumn();
			ImGui.text(part.getIdentifierLetter());
			ImGui.tableNextColumn();
			ImGui.text(part.getChinaKey());
			ImGui.tableNextColumn();
			ImGui.text(part.getChinaValue());
		}
		ImGui.endTable();
		
		ImGui.end();
	}
}
