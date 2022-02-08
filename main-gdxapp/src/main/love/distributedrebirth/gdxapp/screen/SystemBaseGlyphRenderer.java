package love.distributedrebirth.gdxapp.screen;

import java.util.ArrayList;
import java.util.List;

import imgui.ImGui;
import imgui.flag.ImGuiCond;
import imgui.flag.ImGuiTableFlags;
import imgui.type.ImBoolean;
import imgui.type.ImInt;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp.GDXAppMain;
import love.distributedrebirth.gdxapp.ImGuiRendererMain;
import love.distributedrebirth.numberxd.glyph.BaseGlyphSet;
import love.distributedrebirth.numberxd.glyph.BaseGlyphSetNumber;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class SystemBaseGlyphRenderer extends ImGuiRendererMain {

	private ImInt selectedGlyphPart = new ImInt();
	
	public SystemBaseGlyphRenderer(GDXAppMain main) {
		super(main);
	}

	@Override
	public void render(ImBoolean widgetOpen) {
		ImGui.setNextWindowPos(200, 200, ImGuiCond.FirstUseEver);
		ImGui.setNextWindowSize(640, 480, ImGuiCond.FirstUseEver);
		if (ImGui.begin("Base glyph", widgetOpen)) {
			List<BaseGlyphSet> bases = new ArrayList<>();
			for (BaseGlyphSet glyphSet:BaseGlyphSet.values()) {
				bases.add(glyphSet);
			}
			String[] items = new String[bases.size()];
			for (int i=0;i<items.length;i++) {
				items[i] = bases.get(i).BȍőnNaam();
			}
			String selectedItem = items[selectedGlyphPart.get()];
			BaseGlyphSet glyphSet = BaseGlyphSet.valueOf(selectedItem);
			
			ImGui.text("Glyph:");
			ImGui.sameLine();
			ImGui.combo("Set", selectedGlyphPart, items);
			
			int flags = ImGuiTableFlags.ScrollX | ImGuiTableFlags.RowBg | ImGuiTableFlags.BordersOuter | ImGuiTableFlags.BordersV;
			ImGui.beginTable("base-part", 7, flags);
			ImGui.tableSetupColumn("Example");
			ImGui.tableSetupColumn("tel10");
			ImGui.tableSetupColumn("hon10");
			ImGui.tableSetupColumn("tel16");
			ImGui.tableSetupColumn("hon16");
			ImGui.tableSetupColumn("tel36");
			ImGui.tableSetupColumn("hon36");
			ImGui.tableHeadersRow();
			
			int[] numberSet = {0,1,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,
					24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42};
			
			for (int number:numberSet) {
				int number100 = number * 1;
				BaseGlyphSetNumber number10 = glyphSet.BȍőnGlyphSetNumber10();
				BaseGlyphSetNumber number16 = glyphSet.BȍőnGlyphSetNumber16();
				BaseGlyphSetNumber number36 = glyphSet.BȍőnGlyphSetNumber36();
				
				ImGui.tableNextRow();
				ImGui.tableNextColumn();
				ImGui.text(Integer.toString(number));
				
				if (number10 != null) {
					ImGui.tableNextColumn();
					ImGui.text(glyphSet.BȍőnPrintGlyphSetNumber10(number, 50));
					ImGui.tableNextColumn();
					ImGui.text(glyphSet.BȍőnPrintGlyphSetNumber10(number100, 500));
				} else {
					ImGui.tableNextColumn();
					ImGui.text("");
					ImGui.tableNextColumn();
					ImGui.text("");
				}
				if (number16 != null) {
					ImGui.tableNextColumn();
					ImGui.text(glyphSet.BȍőnPrintGlyphSetNumber16(number, 50));
					ImGui.tableNextColumn();
					ImGui.text(glyphSet.BȍőnPrintGlyphSetNumber16(number100, 500));
				} else {
					ImGui.tableNextColumn();
					ImGui.text("");
					ImGui.tableNextColumn();
					ImGui.text("");
				}
				if (number36 != null) {
					ImGui.tableNextColumn();
					ImGui.text(glyphSet.BȍőnPrintGlyphSetNumber36(number, 50));
					ImGui.tableNextColumn();
					ImGui.text(glyphSet.BȍőnPrintGlyphSetNumber36(number100, 500));
				} else {
					ImGui.tableNextColumn();
					ImGui.text("");
					ImGui.tableNextColumn();
					ImGui.text("");
				}
			}
			
			ImGui.endTable();
		}
		ImGui.end();
	}
}
