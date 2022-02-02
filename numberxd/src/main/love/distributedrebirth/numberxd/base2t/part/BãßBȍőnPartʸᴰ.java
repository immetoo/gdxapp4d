package love.distributedrebirth.numberxd.base2t.part;

import java.util.Map;
import java.util.stream.Collectors;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinStoreʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnEnumSetʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface BãßBȍőnPartʸᴰ<T extends BãßBȍőnPartʸᴰ<T>> extends BãßBȍőnEnumSetʸᴰ<T>, BãßBȍőnCoffinStoreʸᴰ<BãßBȍőnPartKeyʸᴰ> {
	
	default String BȍőnIdentifierTone() {
		return GET_BBC().GET_STR(BãßBȍőnPartKeyʸᴰ.ID_TONE);
	}
	
	default String BȍőnIdentifierLetter() {
		return GET_BBC().GET_STR(BãßBȍőnPartKeyʸᴰ.ID_LETTER);
	}
	
	default String BȍőnChinaKey() {
		return GET_BBC().GET_STR(BãßBȍőnPartKeyʸᴰ.CHINA_KEY);
	}
	
	default String BȍőnChinaValue() {
		return GET_BBC().GET_STR(BãßBȍőnPartKeyʸᴰ.CHINA_VALUE);
	}
	
	default String BȍőnIdentifierLetterSupper() {
		return GET_BBC().GET_STR(BãßBȍőnPartKeyʸᴰ.CHINA_KEY);
	}
	
	default String BȍőnIdentifierLetterGreek() {
		int ordinalOne = BȍőnRangTelEen();
		return GET_BBC().GET_STR(BãßBȍőnPartKeyʸᴰ.CHINA_KEY);
	}
	
	@SuppressWarnings("unchecked")
	default T BãßValueOfTone(String identifierTone) {
		Map<String,Object> mapTone = GET_BBC().GET_MAP_OBJ(BãßBȍőnPartKeyʸᴰ.MAP_TONE);
		if (mapTone.isEmpty()) {
			mapTone.putAll(BãßInstancesStream().collect(Collectors.toMap(v -> v.BȍőnIdentifierTone(), v -> v)));
		}
		return (T) mapTone.get(identifierTone);
	}
	
	@SuppressWarnings("unchecked")
	default T BãßValueOfChina(String chinaKey) {
		Map<String,Object> mapChina = GET_BBC().GET_MAP_OBJ(BãßBȍőnPartKeyʸᴰ.MAP_CHINA);
		if (mapChina.isEmpty()) {
			mapChina.putAll(BãßInstancesStream().collect(Collectors.toMap(v -> v.BȍőnChinaKey(), v -> v)));
		}
		return (T) mapChina.get(chinaKey);
	}
}
