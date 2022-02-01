package love.distributedrebirth.demo4d.screen;

import java.util.ArrayList;
import java.util.List;

import imgui.ImGui;
import imgui.flag.ImGuiCond;
import imgui.flag.ImGuiTableFlags;
import imgui.type.ImBoolean;
import imgui.type.ImInt;
import love.distributedrebirth.demo4d.Demo4DMain;
import love.distributedrebirth.demo4d.ImGuiRendererMain;
import love.distributedrebirth.numberxd.base2t.BasePartFactory;
import love.distributedrebirth.numberxd.base2t.facet.BasePart;
import love.distributedrebirth.numberxd.base2t.facet.BasePartAlt1;
import love.distributedrebirth.numberxd.base2t.facet.BasePartAlt2;
import love.distributedrebirth.numberxd.base2t.facet.BasePartAlt3;
import love.distributedrebirth.numberxd.base2t.facet.BasePartAlt4;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class BasePartRenderer extends ImGuiRendererMain {

	private ImInt selectedBasePart = new ImInt();
	
	public BasePartRenderer(Demo4DMain main) {
		super(main);
	}

	@Override
	public void render(ImBoolean widgetOpen) {
		ImGui.setNextWindowPos(200, 200, ImGuiCond.FirstUseEver);
		ImGui.setNextWindowSize(640, 480, ImGuiCond.FirstUseEver);
		ImGui.begin("Base part", widgetOpen);
		
		ImGui.text("Current Part");
		ImGui.sameLine();
		
		List<String> bases = new ArrayList<>();
		for (int base:BasePartFactory.getSupportedBases()) {
			bases.add(Integer.toString(base));
		}
		String[] items = new String[bases.size()];
		
		ImGui.combo("Type", selectedBasePart, bases.toArray(items));
		String selectedItem = items[selectedBasePart.get()];
		Integer baseNumber = Integer.valueOf(selectedItem);
		BasePart[] baseParts = BasePartFactory.buildBasePartsByBase(baseNumber);
		
		int flags = ImGuiTableFlags.ScrollX | ImGuiTableFlags.RowBg | ImGuiTableFlags.BordersOuter | ImGuiTableFlags.BordersV;
		ImGui.beginTable("base-part", 10, flags);
		ImGui.tableSetupColumn("Name");
		ImGui.tableSetupColumn("Ordinal");
		ImGui.tableSetupColumn("Tone");
		ImGui.tableSetupColumn("Letter");
		ImGui.tableSetupColumn("ChinaK");
		ImGui.tableSetupColumn("ChinaV");
		ImGui.tableSetupColumn("Alt1");
		ImGui.tableSetupColumn("Alt2");
		ImGui.tableSetupColumn("Alt3");
		ImGui.tableSetupColumn("Alt4");
		ImGui.tableHeadersRow();
		
		for (BasePart part:baseParts) {
			ImGui.tableNextRow();
			ImGui.tableNextColumn();
			ImGui.text(part.name());
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
			
			ImGui.tableNextColumn();
			if (part instanceof BasePartAlt1) {
				ImGui.text(BasePartAlt1.class.cast(part).getAlt1Value());
			} else {
				ImGui.text("");
			}
			ImGui.tableNextColumn();
			if (part instanceof BasePartAlt2) {
				ImGui.text(BasePartAlt2.class.cast(part).getAlt2Value());
			} else {
				ImGui.text("");
			}
			ImGui.tableNextColumn();
			if (part instanceof BasePartAlt3) {
				ImGui.text(BasePartAlt3.class.cast(part).getAlt3Value());
			} else {
				ImGui.text("");
			}
			ImGui.tableNextColumn();
			if (part instanceof BasePartAlt4) {
				ImGui.text(BasePartAlt4.class.cast(part).getAlt4Value());
			} else {
				ImGui.text("");
			}
		}
		
		ImGui.endTable();
		
		ImGui.end();
	}
}
