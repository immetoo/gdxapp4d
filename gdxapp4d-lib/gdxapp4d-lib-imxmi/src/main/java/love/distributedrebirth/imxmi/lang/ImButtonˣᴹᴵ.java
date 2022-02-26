package love.distributedrebirth.imxmi.lang;

import imgui.ImGui;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class ImButtonˣᴹᴵ extends AbstractImComponentˣᴹᴵ  {
	
	private String label;
	private Runnable callback;
	
	public ImButtonˣᴹᴵ() {
	}
	
	public ImButtonˣᴹᴵ(String label) {
		setLabel(label);
	}
	
	@Override
	public void renderComponent() {
		if (ImGui.button(label) && callback != null) {
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
}
