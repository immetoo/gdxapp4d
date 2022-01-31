package love.distributedrebirth.numberxd.base2t.facet;

import java.util.HashMap;
import java.util.Map;

public interface BaseFacetMap {

	Object putInit(BaseFacetKey key, Object value);
	
	Object get(BaseFacetKey key);
	
	default String getString(BaseFacetKey key) {
		return String.class.cast(get(key));
	}
	
	default Integer getInteger(BaseFacetKey key) {
		return Integer.class.cast(get(key));
	}
	
	default Long getLong(BaseFacetKey key) {
		return Long.class.cast(get(key));
	}
	
	default Boolean getBoolean(BaseFacetKey key) {
		return Boolean.class.cast(get(key));
	}
	
	static BaseFacetMap newInstance() {
		return new BaseFacetMap() {		
			final Map<BaseFacetKey,Object> initMap = new HashMap<>();
		
			@Override
			public Object get(BaseFacetKey key) {
				return initMap.get(key);
			}
	
			@Override
			public Object putInit(BaseFacetKey key, Object value) {
				return initMap.put(key, value);
			}
		};
	}
}
