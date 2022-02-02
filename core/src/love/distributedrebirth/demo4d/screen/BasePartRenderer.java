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
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPart;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt1;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt2;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt3;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt4;

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
		
		List<String> bases = new ArrayList<>();
		for (int base:BasePartFactory.getSupportedBases()) {
			bases.add(Integer.toString(base));
		}
		String[] items = new String[bases.size()];
		items = bases.toArray(items);
		String selectedItem = items[selectedBasePart.get()];
		Integer baseNumber = Integer.valueOf(selectedItem);
		BãßBȍőnPart<?>[] baseParts = BasePartFactory.buildBassBonesByBase(baseNumber);
		
		ImGui.text("Base:");
		ImGui.sameLine();
		ImGui.text(baseParts[0].BãßNaam());
		ImGui.sameLine();
		ImGui.combo("Type", selectedBasePart, items);
		
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
		
		for (BãßBȍőnPart<?> part:baseParts) {
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
			if (part instanceof BãßBȍőnPartAlt1) {
				ImGui.text(BãßBȍőnPartAlt1.class.cast(part).getAlt1Value());
			} else {
				ImGui.text("");
			}
			ImGui.tableNextColumn();
			if (part instanceof BãßBȍőnPartAlt2) {
				ImGui.text(BãßBȍőnPartAlt2.class.cast(part).getAlt2Value());
			} else {
				ImGui.text("");
			}
			ImGui.tableNextColumn();
			if (part instanceof BãßBȍőnPartAlt3) {
				ImGui.text(BãßBȍőnPartAlt3.class.cast(part).getAlt3Value());
			} else {
				ImGui.text("");
			}
			ImGui.tableNextColumn();
			if (part instanceof BãßBȍőnPartAlt4) {
				ImGui.text(BãßBȍőnPartAlt4.class.cast(part).getAlt4Value());
			} else {
				ImGui.text("");
			}
		}
		
		ImGui.endTable();
		
		ImGui.end();
	}
}
