package love.distributedrebirth.bassboonyd;

import java.util.HashMap;
import java.util.Map;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface BãßBȍőnCoffinOpenʸᴰ<T extends BãßBȍőnCoffinStoreKeyʸᴰ> extends BãßBȍőnCoffinʸᴰ<T> {

	void LOCK_COFFIN();
	
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
			volatile boolean deathLock = false;
		
			@Override
			public void LOCK_COFFIN() {
				deathLock = true;
			}
			
			@Override
			public Object GET_OBJ(Y key) {
				return initMap.get(key);
			}
	
			@Override
			public Object PUT_OBJ(Y key, Object value) {
				if (deathLock) {
					throw new IllegalStateException("Can't cheat death in closed coffin.");
				}
				return initMap.put(key, value);
			}
		};
	}
}
