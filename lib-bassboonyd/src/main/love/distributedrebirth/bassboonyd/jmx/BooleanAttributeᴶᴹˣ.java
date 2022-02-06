package love.distributedrebirth.bassboonyd.jmx;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@MBeanAttributeTypeᴶᴹˣ(Boolean.class)
public class BooleanAttributeᴶᴹˣ extends AbstractMBeanAttributeᴶᴹˣ {
	private Boolean value;
	
	public BooleanAttributeᴶᴹˣ(String name, String description) {
		super(name, description);
	}
	
	public void setValueBoolean(Boolean value) {
		this.value = value;
	}
	
	public Boolean getValueBoolean() {
		return value;
	}
	
	public Object getValue() {
		return value;
	}
}
