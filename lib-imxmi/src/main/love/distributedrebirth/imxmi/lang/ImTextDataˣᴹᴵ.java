package love.distributedrebirth.imxmi.lang;

import java.util.function.Function;

import imgui.ImGui;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class ImTextDataˣᴹᴵ extends AbstractImComponentDataˣᴹᴵ {
	
	private String text;
	
	public ImTextDataˣᴹᴵ() {
	}
	
	public ImTextDataˣᴹᴵ(Function<Object, Object> dataExtractor) {
		setDataExtractor(dataExtractor);
	}
	
	@Override
	public void renderComponent() {
		ImGui.text(text);
	}

	@Override
	public void setData(Object value) {
		text = String.class.cast(getDataExtractor().apply(value));
	}
}
