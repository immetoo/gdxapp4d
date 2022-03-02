package love.distributedrebirth.bassboonyd.jmx;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.AttributeNotFoundException;
import javax.management.DynamicMBean;
import javax.management.InvalidAttributeValueException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanNotificationInfo;
import javax.management.ReflectionException;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class MBeanDynamicᴶᴹˣ implements DynamicMBean {
	
	private final String description;
	private final Map<String, Object> guages;
	
	public MBeanDynamicᴶᴹˣ(String description, Map<String, Object> guages) {
		this.description = description;
		this.guages = guages;
	}
	
	@Override
	public MBeanInfo getMBeanInfo() {
		MBeanAttributeInfo[] dAttributes = new MBeanAttributeInfo[guages.keySet().size()];
		List<String> keySet = guages.keySet().stream().collect(Collectors.toList());
		for (int i = 0; i < dAttributes.length; i++) {
			String name = keySet.get(i);
			MBeanAttributeᴶᴹˣ gc = MBeanAttributeᴶᴹˣ.class.cast(guages.get(name));
			dAttributes[i] = new MBeanAttributeInfo(gc.getName(), gc.BãßValueType().getSimpleName(),
					gc.getDescription(), true, false, false);
		}
		return new MBeanInfo(this.getClass().getName(), description, dAttributes, null, null,
				new MBeanNotificationInfo[0]);
	}
	
	@Override
	public Object getAttribute(String name) throws AttributeNotFoundException, MBeanException, ReflectionException {
		MBeanAttributeᴶᴹˣ gc = MBeanAttributeᴶᴹˣ.class.cast(guages.get(name));
		return gc.getValue();
	}
	
	@Override
	public AttributeList getAttributes(String[] arg0) {
		return null;
	}
	
	@Override
	public Object invoke(String arg0, Object[] arg1, String[] arg2) throws MBeanException, ReflectionException {
		return null;
	}
	
	@Override
	public void setAttribute(Attribute arg0)
			throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
	}
	
	@Override
	public AttributeList setAttributes(AttributeList arg0) {
		return null;
	}
}