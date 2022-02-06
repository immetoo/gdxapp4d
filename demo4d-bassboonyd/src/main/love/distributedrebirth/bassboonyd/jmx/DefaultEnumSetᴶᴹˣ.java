package love.distributedrebirth.bassboonyd.jmx;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import love.distributedrebirth.bassboonyd.BãßBȍőnAnnotationInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinStoreKeyʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnConstantsʸᴰ;
import love.distributedrebirth.bassboonyd.DefaultEnumSetʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnAnnotationInfoʸᴰ(required = {BãßBȍőnClassInfoʸᴰ.class, BãßBȍőnAuthorInfoʸᴰ.class})
public interface DefaultEnumSetᴶᴹˣ<T,K extends BãßBȍőnCoffinStoreKeyʸᴰ> extends DefaultEnumBaseᴶᴹˣ<T,K>,DefaultEnumSetʸᴰ<T> {
	
	@SuppressWarnings("unchecked")
	default void BȍőnJmxInit(K key) {
		BãßBȍőnCoffinOpenʸᴰ<K> coffin = BãßBȍőnCoffinOpenʸᴰ.class.cast(GET_BBC());
		coffin.PUT_MAP(key);
		try {
			StringBuilder name = new StringBuilder();
			name.append(BãßPackageNaam());
			name.append(BãßBȍőnConstantsʸᴰ.STR_COLON);
			name.append(BãßBȍőnConstantsʸᴰ.STR_TYPE);
			name.append(BãßBȍőnConstantsʸᴰ.STR_IS);
			name.append(BãßClassNaam());
			name.append(BãßBȍőnConstantsʸᴰ.STR_COMMA);
			name.append(BãßBȍőnConstantsʸᴰ.STR_NAME);
			name.append(BãßBȍőnConstantsʸᴰ.STR_IS);
			name.append(BȍőnNaam());
			
			MBeanServer server = ManagementFactory.getPlatformMBeanServer();
			ObjectName objectName1 = new ObjectName(name.toString());
			server.registerMBean(new MBeanDynamicᴶᴹˣ(GET_BBC().GET_MAP_OBJ(key)), objectName1);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
