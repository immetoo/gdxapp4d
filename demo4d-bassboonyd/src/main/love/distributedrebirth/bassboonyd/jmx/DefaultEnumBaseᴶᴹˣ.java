package love.distributedrebirth.bassboonyd.jmx;

import love.distributedrebirth.bassboonyd.BãßBȍőnAnnotationInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinStoreKeyʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinStoreʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnConstantsʸᴰ;
import love.distributedrebirth.bassboonyd.DefaultEnumBaseʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnAnnotationInfoʸᴰ(required = {BãßBȍőnClassInfoʸᴰ.class, BãßBȍőnAuthorInfoʸᴰ.class})
public interface DefaultEnumBaseᴶᴹˣ<T,K extends BãßBȍőnCoffinStoreKeyʸᴰ> extends DefaultEnumBaseʸᴰ<T>,BãßBȍőnCoffinStoreʸᴰ<K> {
	
	void BȍőnJmxInit(K key);
	
	default GuageCounterᴶᴹˣ BȍőnJmxInitGuageCounter(K key, String name) {
		return BȍőnJmxInitGuageCounter(key, name, BãßBȍőnConstantsʸᴰ.STR_EMPTY);
	}
	
	default GuageCounterᴶᴹˣ BȍőnJmxInitGuageCounter(K key, String name, String description) {
		GuageCounterᴶᴹˣ result = new GuageCounterᴶᴹˣ(name, description);
		GET_BBC().GET_MAP_OBJ(key).put(name, result);
		return result; 
	}
	
	default StringAttributeᴶᴹˣ BȍőnJmxInitStringAttribute(K key, String name) {
		return BȍőnJmxInitStringAttribute(key, name, BãßBȍőnConstantsʸᴰ.STR_EMPTY);
	}
	
	default StringAttributeᴶᴹˣ BȍőnJmxInitStringAttribute(K key, String name, String description) {
		StringAttributeᴶᴹˣ result = new StringAttributeᴶᴹˣ(name, description);
		GET_BBC().GET_MAP_OBJ(key).put(name, result);
		return result; 
	}
	
	default BooleanAttributeᴶᴹˣ BȍőnJmxInitBooleanAttribute(K key, String name) {
		return BȍőnJmxInitBooleanAttribute(key, name, BãßBȍőnConstantsʸᴰ.STR_EMPTY);
	}
	
	default BooleanAttributeᴶᴹˣ BȍőnJmxInitBooleanAttribute(K key, String name, String description) {
		BooleanAttributeᴶᴹˣ result = new BooleanAttributeᴶᴹˣ(name, description);
		GET_BBC().GET_MAP_OBJ(key).put(name, result);
		return result; 
	}
}
