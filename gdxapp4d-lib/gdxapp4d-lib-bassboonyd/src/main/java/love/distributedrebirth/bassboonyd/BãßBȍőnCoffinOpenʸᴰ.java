package love.distributedrebirth.bassboonyd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface BãßBȍőnCoffinOpenʸᴰ<T extends BãßBȍőnCoffinStoreKeyʸᴰ> extends BãßBȍőnCoffinʸᴰ<T>, DefaultInitMethodʸᴰ {

	void LOCK_COFFIN();
	
	Object PUT_OBJ(T key, Object value);
	
	default void PUT_MAP(T key) {
		PUT_OBJ(key, new HashMap<>());
	}
	
	default void PUT_LIST(T key) {
		PUT_OBJ(key, new ArrayList<>());
	}
	
	static <T extends DefaultEnumBaseʸᴰ<?> & BãßBȍőnCoffinStoreʸᴰ<?>>  void lockCoffin(T store, Consumer<String> logHandler) {
		logHandler.accept("Lock: "+store.BãßClassNaam()+" since: "+store.BãßAuthorCopyright());
		for (Object o:store.BãßInstances()) {
			BãßBȍőnCoffinStoreʸᴰ<?> coffin = BãßBȍőnCoffinStoreʸᴰ.class.cast(o);
			BãßBȍőnCoffinOpenʸᴰ<?> coffinOpen = BãßBȍőnCoffinOpenʸᴰ.class.cast(coffin.GET_BBC());
			coffinOpen.LOCK_COFFIN();
		}
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
