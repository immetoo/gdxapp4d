package love.distributedrebirth.numberxd.base2t.bone;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public interface BassBone<T extends BassBone<T>> extends BassBoneEnum<T>, BassBoneStore {
	
	default String staticBoneNaam() {
		return getClass().getAnnotation(BassBoneName.class).value();
	}
	
	default String getIdentifierTone() {
		return getBBC().getString(BassBoneStoreKey.ID_TONE);
	}
	
	default String getIdentifierLetter() {
		return getBBC().getString(BassBoneStoreKey.ID_LETTER);
	}
	
	default String getChinaKey() {
		return getBBC().getString(BassBoneStoreKey.CHINA_KEY);
	}
	
	default String getChinaValue() {
		return getBBC().getString(BassBoneStoreKey.CHINA_VALUE);
	}
	
	@SuppressWarnings("unchecked")
	default T staticValueOfTone(String identifierTone) {
		Map<String,Object> mapTone = getBBC().getMapObject(BassBoneStoreKey.MAP_TONE);
		if (mapTone.isEmpty()) {
			mapTone.putAll(staticInstancesStream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
		}
		return (T) mapTone.get(identifierTone);
	}
	
	@SuppressWarnings("unchecked")
	default T staticValueOfChina(String chinaKey) {
		Map<String,Object> mapChina = getBBC().getMapObject(BassBoneStoreKey.MAP_CHINA);
		if (mapChina.isEmpty()) {
			mapChina.putAll(staticInstancesStream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
		}
		return (T) mapChina.get(chinaKey);
	}
}
