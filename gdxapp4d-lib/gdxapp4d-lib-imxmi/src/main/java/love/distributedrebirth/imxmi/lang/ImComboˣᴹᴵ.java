package love.distributedrebirth.imxmi.lang;

import imgui.ImGui;
import imgui.type.ImInt;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class ImComboˣᴹᴵ extends AbstractImComponentˣᴹᴵ  {
	
	private String label;
	private final ImInt currentItem = new ImInt();
	private String[] items;
	private Runnable callback;
	
	public ImComboˣᴹᴵ() {
	}
	
	public ImComboˣᴹᴵ(String label) {
		setLabel(label);
	}
	
	@Override
	public void renderComponent() {
		if (ImGui.combo(label, currentItem, items) && callback != null) {
			callback.run();
		}
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public Runnable getCallback() {
		return callback;
	}
	
	public void setCallback(Runnable callback) {
		this.callback = callback;
	}
	
	public ImInt getCurrentItem() {
		return currentItem;
	}
	
	public String[] getItems() {
		return items;
	}
	
	public void setItems(String[] items) {
		this.items = items;
	}
}
