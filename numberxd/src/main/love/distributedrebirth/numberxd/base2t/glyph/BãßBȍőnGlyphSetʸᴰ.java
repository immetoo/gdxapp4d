package love.distributedrebirth.numberxd.base2t.glyph;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinStoreʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnEnumSetʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface BãßBȍőnGlyphSetʸᴰ<T extends BãßBȍőnGlyphSetʸᴰ<T>> extends BãßBȍőnEnumSetʸᴰ<T>, BãßBȍőnCoffinStoreʸᴰ<BãßBȍőnGlyphSetKeyʸᴰ> {

	default BaseGlyphSetNumber BȍőnGlyphSetNumber10() {
		return GET_BBC().GET_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.NUMBERS, BaseGlyphSetNumber.class);
	}
	
	default BaseGlyphSetNumber BȍőnGlyphSetNumber16() {
		return GET_BBC().GET_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.HEXIMALS, BaseGlyphSetNumber.class);
	}
	
	default BaseGlyphSetNumber BȍőnGlyphSetNumber36() {
		return GET_BBC().GET_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.GEMATRIA, BaseGlyphSetNumber.class);
	}
}
