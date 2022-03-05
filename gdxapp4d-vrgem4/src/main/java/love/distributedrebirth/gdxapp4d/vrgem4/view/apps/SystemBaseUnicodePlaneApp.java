package love.distributedrebirth.gdxapp4d.vrgem4.view.apps;

import java.util.Locale;
import java.util.ResourceBundle;

import imgui.ImGui;
import imgui.flag.ImGuiTableFlags;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.AbstractDeskApp;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppContourSection;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppRenderer;
import love.distributedrebirth.unicode4d.UnicodePlaneᶻᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class SystemBaseUnicodePlaneApp extends AbstractDeskApp {
	
	private String getTxt(String key) {
		ResourceBundle bundle = ResourceBundle.getBundle("love.distributedrebirth.gdxapp.Main", new Locale("en"));
		return bundle.getString("SystemBaseUnicodePlaneApp."+key);
	}
	
	public void create() {
		getContours().setTitle(getTxt("title"));
		getContours().registrateContour(DeskAppContourSection.MAIN, new DeskAppRenderer() {
			
			@Override
			public void render() {
				int flags = ImGuiTableFlags.ScrollX | ImGuiTableFlags.RowBg | ImGuiTableFlags.BordersOuter | ImGuiTableFlags.BordersV | ImGuiTableFlags.Resizable;
				ImGui.beginTable("base-part", 2, flags);
				ImGui.tableSetupColumn(getTxt("colPlane"));
				ImGui.tableSetupColumn(getTxt("colText"));
				ImGui.tableHeadersRow();
				for (UnicodePlaneᶻᴰ plane:UnicodePlaneᶻᴰ.values()) {
					ImGui.tableNextRow();
					ImGui.tableNextColumn();
					ImGui.text(plane.name());
					ImGui.tableNextColumn();
					StringBuilder buf = new StringBuilder();
					for (int i=plane.getStart();i<plane.getStart()+33;i++) {
						if (i < 65536) {
							buf.append((char)i);
						}
						buf.append(" ");
					}
					ImGui.text(buf.toString());
					
				}
				ImGui.endTable();
			}
		});
	}
}