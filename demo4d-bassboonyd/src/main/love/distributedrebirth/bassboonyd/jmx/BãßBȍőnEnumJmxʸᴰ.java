package love.distributedrebirth.bassboonyd.jmx;

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

import love.distributedrebirth.bassboonyd.BãßBȍőnAnnotationInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinStoreKeyʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinStoreʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnEnumʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnAnnotationInfoʸᴰ(required = {BãßBȍőnClassInfoʸᴰ.class, BãßBȍőnAuthorInfoʸᴰ.class})
public interface BãßBȍőnEnumJmxʸᴰ<T,K extends BãßBȍőnCoffinStoreKeyʸᴰ> extends BãßBȍőnEnumʸᴰ<T>,BãßBȍőnCoffinStoreʸᴰ<K> {
	
	@SuppressWarnings("unchecked")
	default void BȍőnJmxInit(K key) {
		BãßBȍőnCoffinOpenʸᴰ<K> coffin = BãßBȍőnCoffinOpenʸᴰ.class.cast(GET_BBC());
		coffin.PUT_MAP(key);
		try {
			MBeanServer server = ManagementFactory.getPlatformMBeanServer();
			ObjectName objectName1 = new ObjectName(BãßPackageNaam() + ":name=" + BãßClassNaam());
			server.registerMBean(new GuageDynamicMBean(GET_BBC().GET_MAP_OBJ(key)), objectName1);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	default GuageCounterᴶᴹˣ BȍőnJmxInitGuageCounter(K key, String name) {
		return BȍőnJmxInitGuageCounter(key,name,"");
	}
	
	default GuageCounterᴶᴹˣ BȍőnJmxInitGuageCounter(K key, String name, String description) {
		GuageCounterᴶᴹˣ result = new GuageCounterᴶᴹˣ(name, description);
		GET_BBC().GET_MAP_OBJ(key).put(name, result);
		return result; 
	}
	
	default StringAttributeᴶᴹˣ BȍőnJmxInitStringAttribute(K key, String name, String description) {
		StringAttributeᴶᴹˣ result = new StringAttributeᴶᴹˣ(name, description);
		GET_BBC().GET_MAP_OBJ(key).put(name, result);
		return result; 
	}
	
	default BooleanAttributeᴶᴹˣ BȍőnJmxInitBooleanAttribute(K key, String name, String description) {
		BooleanAttributeᴶᴹˣ result = new BooleanAttributeᴶᴹˣ(name, description);
		GET_BBC().GET_MAP_OBJ(key).put(name, result);
		return result; 
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
				MBeanAttributeᴶᴹˣ gc = MBeanAttributeᴶᴹˣ.class.cast(guages.get(name));
				dAttributes[i] = new MBeanAttributeInfo(gc.getName(), gc.BãßValueType().getSimpleName(),
						gc.getDescription(), true, false, false);
			}
			return new MBeanInfo(this.getClass().getName(), null, dAttributes, null, null,
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
}
