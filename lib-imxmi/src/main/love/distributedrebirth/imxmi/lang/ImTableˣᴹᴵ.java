package love.distributedrebirth.imxmi.lang;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import imgui.ImGui;
import imgui.flag.ImGuiTableFlags;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class ImTableˣᴹᴵ extends AbstractImComponentˣᴹᴵ {
	
	private String id;
	private int flags;
	private List<String> columns;
	private Supplier<List<Object>> dataSupplier;
	private List<ImComponentDataˣᴹᴵ> components = new ArrayList<>();
	
	
	public ImTableˣᴹᴵ() {
		this(null);
	}
	
	public ImTableˣᴹᴵ(String id) {
		this.id = id;
		this.columns = new ArrayList<>();
		this.flags = ImGuiTableFlags.ScrollX | ImGuiTableFlags.RowBg | ImGuiTableFlags.BordersOuter | ImGuiTableFlags.BordersV;
	}
	
	@Override
	public void renderBegin() {
		ImGui.beginTable(id, columns.size(), flags);
		for (String column:columns) {
			ImGui.tableSetupColumn(column);
		}
		ImGui.tableHeadersRow();
	}
	
	@Override
	public void renderComponent() {
		List<Object> rows = dataSupplier.get();
		for (Object row:rows) {
			ImGui.tableNextRow();
			for (ImComponentDataˣᴹᴵ comp:getComponents()) {
				ImGui.tableNextColumn();
				comp.setData(row);
				comp.renderBegin();
				comp.renderComponent();
				comp.renderEnd();
			}
		}
	}
	
	@Override
	public void renderEnd() {
		ImGui.endTable();
	}
	
	public void addComponent(ImComponentDataˣᴹᴵ comp) {
		components.add(comp);
	}
	
	public void removeComponent(ImComponentDataˣᴹᴵ comp) {
		components.remove(comp);
	}
	
	public List<ImComponentDataˣᴹᴵ> getComponents() {
		return components;
	}
}
