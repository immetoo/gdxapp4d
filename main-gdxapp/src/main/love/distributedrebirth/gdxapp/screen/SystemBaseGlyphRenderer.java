package love.distributedrebirth.gdxapp.screen;

import imgui.ImGui;
import imgui.flag.ImGuiCond;
import imgui.flag.ImGuiTableFlags;
import imgui.type.ImBoolean;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp.GDXAppMain;
import love.distributedrebirth.gdxapp.ImGuiRendererMain;
import love.distributedrebirth.numberxd.glyph.BaseGlyphSet;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class SystemBaseGlyphRenderer extends ImGuiRendererMain {
	
	public SystemBaseGlyphRenderer(GDXAppMain main) {
		super(main);
	}

	@Override
	public void render(ImBoolean widgetOpen) {
		ImGui.setNextWindowPos(200, 200, ImGuiCond.FirstUseEver);
		ImGui.setNextWindowSize(640, 480, ImGuiCond.FirstUseEver);
		if (ImGui.begin("Base Glyph Set", widgetOpen)) {
						
			int flags = ImGuiTableFlags.ScrollX | ImGuiTableFlags.RowBg | ImGuiTableFlags.BordersOuter | ImGuiTableFlags.BordersV;
			ImGui.beginTable("base-part", 3, flags);
			ImGui.tableSetupColumn("Script");
			ImGui.tableSetupColumn("10Numbers");
			ImGui.tableSetupColumn("16Numbers");
			ImGui.tableHeadersRow();
			
			for (BaseGlyphSet set:BaseGlyphSet.values()) {
				ImGui.tableNextRow();
				ImGui.tableNextColumn();
				ImGui.text(set.BȍőnNaam());
				ImGui.tableNextColumn();
				ImGui.text(print10Numbers(set));
				ImGui.tableNextColumn();
				ImGui.text(print16Numbers(set));
			}
			
			ImGui.endTable();
		}
		ImGui.end();
	}
	
	private String print10Numbers(BaseGlyphSet set) {
		StringBuilder buf = new StringBuilder();
		for (int i=0;i<10;i++) {
			buf.append(set.BȍőnGlyphSetNumber10().BȍőnCharFor(i));
			buf.append(set.BȍőnGlyphSetNumber10().BȍőnCharSeperator());
		}
		return buf.toString();
	}
	
	private String print16Numbers(BaseGlyphSet set) {
		StringBuilder buf = new StringBuilder();
		int x=240;
		for (int i=0;i<16;i++) {
			buf.append(set.BȍőnPrintGlyphSetNumber16(i + x, 99));
			buf.append(" ");
			x = x - 16;
		}
		return buf.toString();
	}
}
