package love.distributedrebirth.numberxd.base2t.part;

import java.util.Map;
import java.util.stream.Collectors;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinStoreʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnEnumSetʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnInitMethodʸᴰ;
import love.distributedrebirth.numberxd.base2t.glyph.BaseGlyphSet;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface BãßBȍőnPartʸᴰ<T extends BãßBȍőnPartʸᴰ<T>> extends BãßBȍőnEnumSetʸᴰ<T>, BãßBȍőnCoffinStoreʸᴰ<BãßBȍőnPartKeyʸᴰ> {
	
	@BãßBȍőnInitMethodʸᴰ
	default void initMapTone(BãßBȍőnCoffinOpenʸᴰ<BãßBȍőnPartKeyʸᴰ> BBC) {
		BBC.PUT_MAP(BãßBȍőnPartKeyʸᴰ.MAP_TONE);
	}
	
	@BãßBȍőnInitMethodʸᴰ
	default void initMapChina(BãßBȍőnCoffinOpenʸᴰ<BãßBȍőnPartKeyʸᴰ> BBC) {
		BBC.PUT_MAP(BãßBȍőnPartKeyʸᴰ.MAP_CHINA);
	}
	
	default String BȍőnDialTone() {
		return GET_BBC().GET_STR(BãßBȍőnPartKeyʸᴰ.DIAL_TONE);
	}
	
	default String BȍőnChinaKey() {
		return GET_BBC().GET_STR(BãßBȍőnPartKeyʸᴰ.CHINA_KEY);
	}
	
	default String BȍőnChinaValue() {
		return GET_BBC().GET_STR(BãßBȍőnPartKeyʸᴰ.CHINA_VALUE);
	}
	
	@SuppressWarnings("unchecked")
	default T BãßValueOfDialTone(String identifierTone) {
		Map<String,Object> mapTone = GET_BBC().GET_MAP_OBJ(BãßBȍőnPartKeyʸᴰ.MAP_TONE);
		if (mapTone.isEmpty()) {
			mapTone.putAll(BãßInstancesStream().collect(Collectors.toMap(v -> v.BȍőnDialTone(), v -> v)));
		}
		return (T) mapTone.get(identifierTone);
	}
	
	@SuppressWarnings("unchecked")
	default T BãßValueOfChinaKey(String chinaKey) {
		Map<String,Object> mapChina = GET_BBC().GET_MAP_OBJ(BãßBȍőnPartKeyʸᴰ.MAP_CHINA);
		if (mapChina.isEmpty()) {
			mapChina.putAll(BãßInstancesStream().collect(Collectors.toMap(v -> v.BȍőnChinaKey(), v -> v)));
		}
		return (T) mapChina.get(chinaKey);
	}
	
	default String BȍőnPrintGlyphSetNumber10(BaseGlyphSet glyphSet) {
		return glyphSet.BȍőnPrintGlyphSetNumber10(BȍőnRangTelNul(), BãßInstances().length);
	}
	
	default String BȍőnPrintGlyphSetNumber16(BaseGlyphSet glyphSet) {
		return glyphSet.BȍőnPrintGlyphSetNumber16(BȍőnRangTelNul(), BãßInstances().length);
	}
	
	default String BȍőnPrintGlyphSetNumber36(BaseGlyphSet glyphSet) {
		return glyphSet.BȍőnPrintGlyphSetNumber36(BȍőnRangTelNul(), BãßInstances().length);
	}
}
