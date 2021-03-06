package love.distributedrebirth.gdxapp4d.app.glyphdemo.apps;

import java.util.ResourceBundle;

import imgui.ImGui;
import imgui.flag.ImGuiTableFlags;
import imgui.type.ImBoolean;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.AbstractDeskApp;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppContourSection;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppRenderer;
import love.distributedrebirth.unicode4d.BaseGlyphSet;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class DemoGlyphSetDeskApp extends AbstractDeskApp {
	
	private final ResourceBundle bundle;
	private final ImBoolean showBase27 = new ImBoolean(false);
	
	public DemoGlyphSetDeskApp(ResourceBundle bundle) {
		this.bundle = bundle;
	}
	
	private String getTxt(String key) {
		return bundle.getString(DemoGlyphSetDeskApp.class.getSimpleName()+"."+key);
	}
	
	public void create() {
		getContours().setTitle(getTxt("title"));
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
