package love.distributedrebirth.bassboonyd.jmx;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnMBeanAttributeTypeʸᴰ(Long.class)
public class GuageCounterᴶᴹˣ extends AbstractMBeanAttributeᴶᴹˣ {
	private volatile long counter;
	
	public GuageCounterᴶᴹˣ(String name, String description) {
		super(name, description);
	}
	
	public void increment() {
		counter++;
	}
	
	public Object getValue() {
		return Long.valueOf(counter);
	}
}
