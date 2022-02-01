package love.distributedrebirth.numberxd.base2t.bone;

import java.util.HashMap;
import java.util.Map;

public interface BassBoneCoffin {

	Object PUT_INIT(BassBoneStoreKey key, Object value);
	
	Object GET(BassBoneStoreKey key);
	
	default String GET_STR(BassBoneStoreKey key) {
		return String.class.cast(GET(key));
	}
	
	default Integer GET_INT(BassBoneStoreKey key) {
		return Integer.class.cast(GET(key));
	}
	
	default Long GET_LONG(BassBoneStoreKey key) {
		return Long.class.cast(GET(key));
	}
	
	default Boolean GET_BOOL(BassBoneStoreKey key) {
		return Boolean.class.cast(GET(key));
	}

	@SuppressWarnings("unchecked")
	default Map<String,Object> GET_MAP_OBJ(BassBoneStoreKey key) {
		if (GET(key) == null) {
			PUT_INIT(key, new HashMap<>());
		}
		return Map.class.cast(GET(key));
	}
	
	@SuppressWarnings("unchecked")
	default Map<String,String> GET_MAP_STR(BassBoneStoreKey key) {
		if (GET(key) == null) {
			PUT_INIT(key, new HashMap<>());
		}
		return Map.class.cast(GET(key));
	}
	
	static BassBoneCoffin newInstance() {
		return new BassBoneCoffin() {		
			final Map<BassBoneStoreKey,Object> initMap = new HashMap<>();
		
			@Override
			public Object GET(BassBoneStoreKey key) {
				return initMap.get(key);
			}
	
			@Override
			public Object PUT_INIT(BassBoneStoreKey key, Object value) {
				return initMap.put(key, value);
			}
		};
	}
}
