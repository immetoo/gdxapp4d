package love.distributedrebirth.bassboonyd.jmx;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@MBeanAttributeTypeᴶᴹˣ(String.class)
public class StringAttributeᴶᴹˣ extends AbstractMBeanAttributeᴶᴹˣ {
	private String value;
	
	public StringAttributeᴶᴹˣ(String name, String description) {
		super(name, description);
	}
	
	public void setValueString(String value) {
		this.value = value;
	}
	
	public String getValueString() {
		return value;
	}
	
	public Object getValue() {
		return value;
	}
}
