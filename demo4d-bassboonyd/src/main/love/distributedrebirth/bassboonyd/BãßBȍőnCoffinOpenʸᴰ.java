package love.distributedrebirth.bassboonyd;

import java.util.HashMap;
import java.util.Map;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface BãßBȍőnCoffinOpenʸᴰ<T extends BãßBȍőnCoffinStoreKeyʸᴰ> extends BãßBȍőnCoffinʸᴰ<T> {

	Object PUT_OBJ(T key, Object value);
	
	default void PUT_MAP(T key) {
		PUT_OBJ(key, new HashMap<>());
	}
	
	default void PUT_LIST(T key) {
		PUT_OBJ(key, new HashMap<>());
	}
	
	static <Y extends BãßBȍőnCoffinStoreKeyʸᴰ> BãßBȍőnCoffinOpenʸᴰ<Y> newInstance() {
		return new BãßBȍőnCoffinOpenʸᴰ<Y>() {
			final Map<Y,Object> initMap = new HashMap<>();
		
			@Override
			public Object GET_OBJ(Y key) {
				return initMap.get(key);
			}
	
			@Override
			public Object PUT_OBJ(Y key, Object value) {
				return initMap.put(key, value);
			}
		};
	}
}
