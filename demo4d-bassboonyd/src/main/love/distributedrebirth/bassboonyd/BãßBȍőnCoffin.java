package love.distributedrebirth.bassboonyd;

import java.util.List;
import java.util.Map;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface BãßBȍőnCoffin<T extends BãßBȍőnCoffinStoreKeyʸᴰ> {
	
	Object GET_OBJ(T key);
	
	default String GET_STR(T key) {
		return String.class.cast(GET_OBJ(key));
	}

	default Short GET_SHORT(T key) {
		return Short.class.cast(GET_OBJ(key));
	}
	
	default Character GET_CHAR(T key) {
		return Character.class.cast(GET_OBJ(key));
	}
	
	default Integer GET_INT(T key) {
		return Integer.class.cast(GET_OBJ(key));
	}
	
	default Long GET_LONG(T key) {
		return Long.class.cast(GET_OBJ(key));
	}
	
	default Boolean GET_BOOL(T key) {
		return Boolean.class.cast(GET_OBJ(key));
	}
	
	default Float GET_FLOAT(T key) {
		return Float.class.cast(GET_OBJ(key));
	}
	
	default Double GET_DOUBLE(T key) {
		return Double.class.cast(GET_OBJ(key));
	}

	@SuppressWarnings("unchecked")
	default Map<String,Object> GET_MAP_OBJ(T key) {
		return Map.class.cast(GET_OBJ(key));
	}
	
	@SuppressWarnings("unchecked")
	default Map<String,String> GET_MAP_STR(T key) {
		return Map.class.cast(GET_OBJ(key));
	}
	
	@SuppressWarnings("unchecked")
	default Map<String,Integer> GET_MAP_INT(T key) {
		return Map.class.cast(GET_OBJ(key));
	}
	
	@SuppressWarnings("unchecked")
	default List<Object> GET_LIST_OBJ(T key) {
		return List.class.cast(GET_OBJ(key));
	}
	
	@SuppressWarnings("unchecked")
	default List<String> GET_LIST_STR(T key) {
		return List.class.cast(GET_OBJ(key));
	}
	
	@SuppressWarnings("unchecked")
	default List<Integer> GET_LIST_INT(T key) {
		return List.class.cast(GET_OBJ(key));
	}
}
