package love.distributedrebirth.numberxd.base2t.bone;

import java.util.HashMap;
import java.util.Map;

public interface BassBoneCoffin {

	Object putInit(BassBoneStoreKey key, Object value);
	
	Object get(BassBoneStoreKey key);
	
	default String getString(BassBoneStoreKey key) {
		return String.class.cast(get(key));
	}
	
	default Integer getInteger(BassBoneStoreKey key) {
		return Integer.class.cast(get(key));
	}
	
	default Long getLong(BassBoneStoreKey key) {
		return Long.class.cast(get(key));
	}
	
	default Boolean getBoolean(BassBoneStoreKey key) {
		return Boolean.class.cast(get(key));
	}

	@SuppressWarnings("unchecked")
	default Map<String,Object> getMapObject(BassBoneStoreKey key) {
		if (get(key) == null) {
			putInit(key, new HashMap<>());
		}
		return Map.class.cast(get(key));
	}
	
	@SuppressWarnings("unchecked")
	default Map<String,String> getMapString(BassBoneStoreKey key) {
		if (get(key) == null) {
			putInit(key, new HashMap<>());
		}
		return Map.class.cast(get(key));
	}
	
	static BassBoneCoffin newInstance() {
		return new BassBoneCoffin() {		
			final Map<BassBoneStoreKey,Object> initMap = new HashMap<>();
		
			@Override
			public Object get(BassBoneStoreKey key) {
				return initMap.get(key);
			}
	
			@Override
			public Object putInit(BassBoneStoreKey key, Object value) {
				return initMap.put(key, value);
			}
		};
	}
}
