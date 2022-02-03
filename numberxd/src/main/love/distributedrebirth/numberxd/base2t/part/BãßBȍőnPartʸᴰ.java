package love.distributedrebirth.numberxd.base2t.part;

import java.util.Map;
import java.util.stream.Collectors;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinStoreʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnEnumSetʸᴰ;
import love.distributedrebirth.numberxd.base2t.glyph.BaseGlyphSet;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface BãßBȍőnPartʸᴰ<T extends BãßBȍőnPartʸᴰ<T>> extends BãßBȍőnEnumSetʸᴰ<T>, BãßBȍőnCoffinStoreʸᴰ<BãßBȍőnPartKeyʸᴰ> {
	
	default String BȍőnIdentifierTone() {
		return GET_BBC().GET_STR(BãßBȍőnPartKeyʸᴰ.ID_TONE);
	}
	
	default String BȍőnChinaKey() {
		return GET_BBC().GET_STR(BãßBȍőnPartKeyʸᴰ.CHINA_KEY);
	}
	
	default String BȍőnChinaValue() {
		return GET_BBC().GET_STR(BãßBȍőnPartKeyʸᴰ.CHINA_VALUE);
	}
	
	default String BȍőnGlyphSetNumber16(BaseGlyphSet glyphSet) {
		StringBuilder buf = new StringBuilder();
		T[] values = BãßInstances();
		if (values.length <= 16) {
			buf.append(glyphSet.BȍőnGlyphSetNumber16().BȍőnCharFor(BȍőnRangTelNul()));
		} else if (values.length <= 256) {
			buf.append(glyphSet.BȍőnGlyphSetNumber16().BȍőnCharFor(BȍőnRangTelNul() >> 4));
			buf.append(glyphSet.BȍőnGlyphSetNumber16().BȍőnCharFor(BȍőnRangTelNul() & 0x0F));
		} else if (values.length <= 0xFFF+1) {
			buf.append(glyphSet.BȍőnGlyphSetNumber16().BȍőnCharFor((BȍőnRangTelNul() >> 8) & 0x0F));
			buf.append(glyphSet.BȍőnGlyphSetNumber16().BȍőnCharFor((BȍőnRangTelNul() >> 4) & 0x0F));
			buf.append(glyphSet.BȍőnGlyphSetNumber16().BȍőnCharFor(BȍőnRangTelNul() & 0x0F));
		} else {
			throw new IllegalStateException("Can't handle more than 0xFFF values.");
		}
		if (BaseGlyphSet.HEBREW.equals(glyphSet)) {
			return buf.reverse().toString();
		}
		return buf.toString();
	}
	
	default String BȍőnGlyphSetNumber36(BaseGlyphSet glyphSet) {
		StringBuilder buf = new StringBuilder();
		T[] values = BãßInstances();
		if (values.length <= 9) {
			buf.append(glyphSet.BȍőnGlyphSetNumber36().BȍőnCharFor(BȍőnRangTelEen()));
		} else if (values.length <= 99) {
			int count = BȍőnRangTelNul();
			int mod10 = count % 9 + 1;
			int div10 = count / 9 + 1;
			buf.append(glyphSet.BȍőnGlyphSetNumber36().BȍőnCharFor(div10));
			buf.append(glyphSet.BȍőnGlyphSetNumber36().BȍőnCharFor(mod10));
		} else if (values.length <= 999) {
			int count = BȍőnRangTelNul();
			int mod10 = count % 9 + 1;
			int div10 = count / 90 + 1;
			int div100 = count / 900 + 1;
			buf.append(glyphSet.BȍőnGlyphSetNumber16().BȍőnCharFor(div10));
			buf.append(glyphSet.BȍőnGlyphSetNumber16().BȍőnCharFor(div100));
			buf.append(glyphSet.BȍőnGlyphSetNumber16().BȍőnCharFor(mod10));
		} else {
			throw new IllegalStateException("Can't handle more than 1000 values.");
		}
		if (BaseGlyphSet.HEBREW.equals(glyphSet)) {
			return buf.reverse().toString();
		}
		return buf.toString();
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
