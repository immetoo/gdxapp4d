package love.distributedrebirth.gdxapp4d.vrgem4.desktop.apps;

import java.util.Locale;
import java.util.ResourceBundle;

import imgui.ImGui;
import imgui.flag.ImGuiTableFlags;
import imgui.type.ImBoolean;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.vrgem4.desktop.DefaultDeskApp;
import love.distributedrebirth.gdxapp4d.vrgem4.desktop.DeskAppContourSection;
import love.distributedrebirth.gdxapp4d.vrgem4.desktop.DeskAppRenderer;
import love.distributedrebirth.numberxd.glyph.BaseGlyphSet;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class SystemBaseGlyphApp extends DefaultDeskApp {
	
	private final ImBoolean showBase27 = new ImBoolean(false);
	
	private String getTxt(String key) {
		ResourceBundle bundle = ResourceBundle.getBundle("love.distributedrebirth.gdxapp.Main", new Locale("en"));
		return bundle.getString("SystemBaseGlyphApp."+key);
	}
	
	public SystemBaseGlyphApp() {
		setTitle(getTxt("title"));
		getContours().registrateContour(DeskAppContourSection.MAIN, new DeskAppRenderer() {
			
			@Override
			public void render() {
				ImGui.checkbox(getTxt("showBase27"), showBase27);
				int flags = ImGuiTableFlags.ScrollX | ImGuiTableFlags.RowBg | ImGuiTableFlags.BordersOuter | ImGuiTableFlags.BordersV | ImGuiTableFlags.Resizable;
				ImGui.beginTable("base-part", 3, flags);
				ImGui.tableSetupColumn(getTxt("colScript"));
				ImGui.tableSetupColumn(getTxt("col10Num"));
				if (showBase27.get()) {
					ImGui.tableSetupColumn(getTxt("col27Num"));
				} else {
					ImGui.tableSetupColumn(getTxt("col16Num"));
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
			buf.append(set.BȍőnPrintNumber10(i, 9));
			buf.append(" ");
		}
		return buf.toString();
	}
	
	private String print16Numbers(BaseGlyphSet set) {
		StringBuilder buf = new StringBuilder();
		if (set.BȍőnNumber16() == null) {
			return buf.toString();
		}
		int x=240;
		for (int i=0;i<16;i++) {
			buf.append(set.BȍőnPrintNumber16(i + x, 16)); // hex; +one 
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
		for (int i=0;i<27;i++) {
			buf.append(set.BȍőnPrintNumber27(i, 26));
			buf.append(" ");
		}
		return buf.toString();
	}
}
