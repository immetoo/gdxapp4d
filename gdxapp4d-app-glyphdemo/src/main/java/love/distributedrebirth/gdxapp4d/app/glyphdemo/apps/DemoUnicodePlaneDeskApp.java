package love.distributedrebirth.gdxapp4d.app.glyphdemo.apps;

import java.util.ResourceBundle;

import imgui.ImGui;
import imgui.flag.ImGuiTableFlags;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.vrgem4.service.VrGem4Unicode4DService;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.AbstractDeskApp;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppContourSection;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppRenderer;
import love.distributedrebirth.unicode4d.UnicodePlaneᶻᴰ;
import love.distributedrebirth.unicode4d.draw.DrawCharacter;
import love.distributedrebirth.unicode4d.draw.ImCharacter;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class DemoUnicodePlaneDeskApp extends AbstractDeskApp implements DeskAppRenderer {
	
	private final VrGem4Unicode4DService unicode4DService;
	private final ResourceBundle bundle;
	
	public DemoUnicodePlaneDeskApp(ResourceBundle bundle, VrGem4Unicode4DService unicode4DService) {
		this.unicode4DService = unicode4DService;
		this.bundle = bundle;
	}
	
	private String getTxt(String key) {
		return bundle.getString(DemoUnicodePlaneDeskApp.class.getSimpleName()+"."+key);
	}
	
	public void create() {
		getContours().setTitle(getTxt("title"));
		getContours().registrateContour(DeskAppContourSection.MAIN, this);
	}
	
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
			if (plane.isPlane0()) {
				StringBuilder buf = new StringBuilder();
				int offset = 33;
				for (int i=plane.getStart()+offset;i<plane.getStart()+33+offset;i++) {
					if (i < 65536) {
						buf.append((char)i);
					}
					buf.append(" ");
				}
				ImGui.text(buf.toString());
			} else {
				// LIMITED;
				// Dear ImGui Assertion Failed: draw_list->_VtxCurrentIdx < (1 << 16) && "Too many vertices in ImDrawList using 16-bit indices. Read comment above"
				// Assertion Located At: /tmp/imgui/jni/imgui.cpp:4526
				int offset = 33;
				for (int i=plane.getStart()+offset;i<plane.getStart()+7+offset;i++) {
					DrawCharacter drawChar = unicode4DService.getCharacterForUnicode(i);
					if (drawChar != null) {
						new ImCharacter(drawChar).render();
					} else {
						ImGui.text("?");
					}
					ImGui.sameLine();
				}
			}
		}
		ImGui.endTable();
	}
}
