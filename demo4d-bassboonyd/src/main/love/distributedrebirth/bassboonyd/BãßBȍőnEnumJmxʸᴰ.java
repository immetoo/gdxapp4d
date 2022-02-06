package love.distributedrebirth.bassboonyd;

import java.lang.management.ManagementFactory;
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
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.ReflectionException;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnAnnotationInfoʸᴰ(required = {BãßBȍőnClassInfoʸᴰ.class, BãßBȍőnAuthorInfoʸᴰ.class})
public interface BãßBȍőnEnumJmxʸᴰ<T,K extends BãßBȍőnCoffinStoreKeyʸᴰ> extends BãßBȍőnEnumʸᴰ<T>,BãßBȍőnCoffinStoreʸᴰ<K> {
	
	@SuppressWarnings("unchecked")
	default void initJmx(K key) {
		BãßBȍőnCoffinOpenʸᴰ<K> coffin = BãßBȍőnCoffinOpenʸᴰ.class.cast(GET_BBC());
		coffin.PUT_MAP(key);
		try {
			MBeanServer server = ManagementFactory.getPlatformMBeanServer();
			ObjectName objectName1 = new ObjectName(BȍőnNaamI18N() + ":name=counters");
			server.registerMBean(new GuageDynamicMBean(GET_BBC().GET_MAP_OBJ(key)), objectName1);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	default GuageCounter BȍőnInitGuage(K key, String name) {
		return BȍőnInitGuage(key,name,"");
	}
	
	default GuageCounter BȍőnInitGuage(K key, String name, String description) {
		GuageCounter result = new GuageCounter(name, description);
		GET_BBC().GET_MAP_OBJ(key).put(name, result);
		return result; 
	}
	
	public class GuageCounter {
		private volatile long counter;
		private final String name;
		private final String description;
		
		public GuageCounter(String name, String description) {
			this.name = name;
			this.description = description;
		}
		
		public void increment() {
			counter++;
		}
		
		public long getCounter() {
			return counter;
		}
		
		public String getName() {
			return name;
		}
		
		public String getDescription() {
			return description;
		}
	}
	
	class GuageDynamicMBean implements DynamicMBean {
		
		private final Map<String, Object> guages;
		
		public GuageDynamicMBean(Map<String, Object> guages) {
			this.guages = guages;
		}
		
		@Override
		public MBeanInfo getMBeanInfo() {
			MBeanAttributeInfo[] dAttributes = new MBeanAttributeInfo[guages.keySet().size()];
			List<String> keySet = guages.keySet().stream().collect(Collectors.toList());
			for (int i = 0; i < dAttributes.length; i++) {
				String name = keySet.get(i);
				GuageCounter gc = GuageCounter.class.cast(guages.get(name));
				dAttributes[i] = new MBeanAttributeInfo(gc.getName(), Long.class.getSimpleName(),
						gc.getDescription(), true, false, false);
			}
			return new MBeanInfo(this.getClass().getName(), null, dAttributes, null, null,
					new MBeanNotificationInfo[0]);
		}
		
		@Override
		public Object getAttribute(String name) throws AttributeNotFoundException, MBeanException, ReflectionException {
			GuageCounter gc = GuageCounter.class.cast(guages.get(name));
			return gc.getCounter();
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
}
