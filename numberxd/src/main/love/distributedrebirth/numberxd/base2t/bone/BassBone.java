package love.distributedrebirth.numberxd.base2t.bone;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public interface BassBone<T extends BassBone<T>> extends BassBoneEnumSet<T>, BassBoneStore {
	
	default String staticBoneNaam() {
		return getClass().getAnnotation(BassBoneName.class).value();
	}
	
	default String getIdentifierTone() {
		return GET_BBC().GET_STR(BassBoneStoreKey.ID_TONE);
	}
	
	default String getIdentifierLetter() {
		return GET_BBC().GET_STR(BassBoneStoreKey.ID_LETTER);
	}
	
	default String getChinaKey() {
		return GET_BBC().GET_STR(BassBoneStoreKey.CHINA_KEY);
	}
	
	default String getChinaValue() {
		return GET_BBC().GET_STR(BassBoneStoreKey.CHINA_VALUE);
	}
	
	@SuppressWarnings("unchecked")
	default T staticValueOfTone(String identifierTone) {
		Map<String,Object> mapTone = GET_BBC().GET_MAP_OBJ(BassBoneStoreKey.MAP_TONE);
		if (mapTone.isEmpty()) {
			mapTone.putAll(staticInstancesStream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
		}
		return (T) mapTone.get(identifierTone);
	}
	
	@SuppressWarnings("unchecked")
	default T staticValueOfChina(String chinaKey) {
		Map<String,Object> mapChina = GET_BBC().GET_MAP_OBJ(BassBoneStoreKey.MAP_CHINA);
		if (mapChina.isEmpty()) {
			mapChina.putAll(staticInstancesStream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
		}
		return (T) mapChina.get(chinaKey);
	}
}
