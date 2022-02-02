package love.distributedrebirth.numberxd.base2t.part;

import java.util.Map;
import java.util.stream.Collectors;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinStoreʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnEnumSetʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface BãßBȍőnPartʸᴰ<T extends BãßBȍőnPartʸᴰ<T>> extends BãßBȍőnEnumSetʸᴰ<T>, BãßBȍőnCoffinStoreʸᴰ<BãßBȍőnPartKeyʸᴰ> {
	
	default String getIdentifierTone() {
		return GET_BBC().GET_STR(BãßBȍőnPartKeyʸᴰ.ID_TONE);
	}
	
	default String getIdentifierLetter() {
		return GET_BBC().GET_STR(BãßBȍőnPartKeyʸᴰ.ID_LETTER);
	}
	
	default String getChinaKey() {
		return GET_BBC().GET_STR(BãßBȍőnPartKeyʸᴰ.CHINA_KEY);
	}
	
	default String getChinaValue() {
		return GET_BBC().GET_STR(BãßBȍőnPartKeyʸᴰ.CHINA_VALUE);
	}
	
	@SuppressWarnings("unchecked")
	default T staticValueOfTone(String identifierTone) {
		Map<String,Object> mapTone = GET_BBC().GET_MAP_OBJ(BãßBȍőnPartKeyʸᴰ.MAP_TONE);
		if (mapTone.isEmpty()) {
			mapTone.putAll(BãßInstancesStream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
		}
		return (T) mapTone.get(identifierTone);
	}
	
	@SuppressWarnings("unchecked")
	default T staticValueOfChina(String chinaKey) {
		Map<String,Object> mapChina = GET_BBC().GET_MAP_OBJ(BãßBȍőnPartKeyʸᴰ.MAP_CHINA);
		if (mapChina.isEmpty()) {
			mapChina.putAll(BãßInstancesStream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
		}
		return (T) mapChina.get(chinaKey);
	}
}
