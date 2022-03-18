package love.distributedrebirth.gdxapp4d.app.glyphdemo.apps;

import java.util.ResourceBundle;

import imgui.ImGui;
import imgui.flag.ImGuiStyleVar;
import imgui.flag.ImGuiTableFlags;
import imgui.type.ImBoolean;
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
	private final ImBoolean render4DPlane0 = new ImBoolean(false);
	
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
		ImGui.checkbox(getTxt("render4DPlane0"), render4DPlane0);
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
			if (plane.isPlane0() && render4DPlane0.get() == false) {
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
				ImGui.pushStyleVar(ImGuiStyleVar.ItemSpacing, 0f, 0f);
				DrawCharacter drawChar2 = unicode4DService.getCharacterForUnicode(' ');
				if (drawChar2 != null) {
					ImCharacter.render(drawChar2);
					ImGui.sameLine(); // print before beginChild to fix row height of table
				}
				int offset = 33;
				ImGui.beginChild("row"+plane.name()); // workaround for error; Too many vertices in ImDrawList using 16-bit indices.
				for (int i=plane.getStart()+offset;i<plane.getStart()+33+offset;i++) {
					DrawCharacter drawChar = unicode4DService.getCharacterForUnicode(i);
					if (drawChar != null) {
						ImCharacter.render(drawChar);
					} else {
						ImGui.text("?");
					}
					ImGui.sameLine();
				}
				ImGui.endChild();
				ImGui.popStyleVar();
			}
		}
		ImGui.endTable();
	}
}
