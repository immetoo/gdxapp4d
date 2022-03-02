package love.distributedrebirth.imxmi.lang;

import imgui.ImGui;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class ImTextˣᴹᴵ extends AbstractImComponentˣᴹᴵ {
	
	private String text;
	
	public ImTextˣᴹᴵ() {
	}
	
	public ImTextˣᴹᴵ(String text) {
		setText(text);
	}
	
	@Override
	public void renderComponent() {
		ImGui.text(text);
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
}
