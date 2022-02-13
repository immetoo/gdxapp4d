package love.distributedrebirth.gdxapp.desktop.apps;

import imgui.ImGui;
import imgui.flag.ImGuiTableFlags;
import imgui.type.ImBoolean;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp.desktop.DefaultDeskApp;
import love.distributedrebirth.gdxapp.desktop.DeskAppContourSection;
import love.distributedrebirth.gdxapp.desktop.DeskAppRenderer;
import love.distributedrebirth.numberxd.glyph.BaseGlyphSet;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class SystemBaseGlyphApp extends DefaultDeskApp {
	
	private final ImBoolean showBase27 = new ImBoolean(false);
	
	public SystemBaseGlyphApp() {
		super("Base Glyph Set", "");
		getContours().registrateContour(DeskAppContourSection.MAIN, new DeskAppRenderer() {
			
			@Override
			public void render() {
				ImGui.checkbox("Show base27", showBase27);
				int flags = ImGuiTableFlags.ScrollX | ImGuiTableFlags.RowBg | ImGuiTableFlags.BordersOuter | ImGuiTableFlags.BordersV | ImGuiTableFlags.Resizable;
				ImGui.beginTable("base-part", 3, flags);
				ImGui.tableSetupColumn("Script");
				ImGui.tableSetupColumn("10Numbers");
				if (showBase27.get()) {
					ImGui.tableSetupColumn("27Numbers");
				} else {
					ImGui.tableSetupColumn("16Numbers");
				}
				ImGui.tableHeadersRow();
				for (BaseGlyphSet set:BaseGlyphSet.values()) {
					ImGui.tableNextRow();
					ImGui.tableNextColumn();
					ImGui.text(set.BȍőnNaam());
					ImGui.tableNextColumn();
					ImGui.text(print10Numbers(set));
					ImGui.tableNextColumn();
					if (showBase27.get()) {
						ImGui.text(print27Numbers(set));
					} else {
						ImGui.text(print16Numbers(set));
					}
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
			buf.append(" ");
		}
		return buf.toString();
	}
	
	private String print16Numbers(BaseGlyphSet set) {
		StringBuilder buf = new StringBuilder();
		int x=240;
		for (int i=0;i<16;i++) {
			buf.append(set.BȍőnPrintNumber16(i + x, 99));
			buf.append(set.BȍőnNumber16().BȍőnCharSeperator());
			buf.append(" ");
			x = x - 16;
		}
		return buf.toString();
	}
	
	private String print27Numbers(BaseGlyphSet set) {
		StringBuilder buf = new StringBuilder();
		if (set.BȍőnNumber27() == null) {
			return buf.toString();
		}
		for (int i=0;i<33;i++) {
			buf.append(set.BȍőnPrintNumber27(i, 99));
			buf.append(set.BȍőnNumber27().BȍőnCharSeperator());
			buf.append(" ");
		}
		return buf.toString();
	}
}
