package love.distributedrebirth.gdxapp.desktop.apps;

import imgui.ImGui;
import imgui.flag.ImGuiTableFlags;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp.desktop.DefaultDeskApp;
import love.distributedrebirth.gdxapp.desktop.DeskAppContourSection;
import love.distributedrebirth.gdxapp.desktop.DeskAppRenderer;
import love.distributedrebirth.numberxd.glyph.BaseGlyphSet;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class SystemBaseGlyphApp extends DefaultDeskApp {
	
	public SystemBaseGlyphApp() {
		super("Base Glyph Set", "");
		getContours().registrateContour(DeskAppContourSection.MAIN, new DeskAppRenderer() {
			
			@Override
			public void render() {
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
		});
	}
	
	private String print10Numbers(BaseGlyphSet set) {
		StringBuilder buf = new StringBuilder();
		for (int i=0;i<10;i++) {
			buf.append(set.BȍőnNumber10().BȍőnCharFor(i));
			buf.append(set.BȍőnNumber10().BȍőnCharSeperator());
		}
		return buf.toString();
	}
	
	private String print16Numbers(BaseGlyphSet set) {
		StringBuilder buf = new StringBuilder();
		int x=240;
		for (int i=0;i<16;i++) {
			buf.append(set.BȍőnPrintNumber16(i + x, 99));
			buf.append(" ");
			x = x - 16;
		}
		return buf.toString();
	}
}
