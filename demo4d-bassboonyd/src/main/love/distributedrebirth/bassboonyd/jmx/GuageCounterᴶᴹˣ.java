package love.distributedrebirth.bassboonyd.jmx;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnMBeanAttributeTypeᴶᴹˣ(Long.class)
public class GuageCounterᴶᴹˣ extends AbstractMBeanAttributeᴶᴹˣ {
	private volatile long counter;
	
	public GuageCounterᴶᴹˣ(String name, String description) {
		super(name, description);
	}
	
	public void increment() {
		counter++;
	}
	
	public void increment(long value) {
		counter = counter + value;
	}
	
	public Object getValue() {
		return Long.valueOf(counter);
	}
}
