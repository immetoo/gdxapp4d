package love.distributedrebirth.numberxd.base2t.glyph;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinStoreʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnEnumSetʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface BãßBȍőnGlyphSetʸᴰ<T extends BãßBȍőnGlyphSetʸᴰ<T>> extends BãßBȍőnEnumSetʸᴰ<T>, BãßBȍőnCoffinStoreʸᴰ<BãßBȍőnGlyphSetKeyʸᴰ> {

	default BaseGlyphSetNumber10 BȍőnGlyphSetNumber10() {
		return GET_BBC().GET_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.NUMBERS, BaseGlyphSetNumber10.class);
	}
	
	default BaseGlyphSetNumber16 BȍőnGlyphSetNumber16() {
		return GET_BBC().GET_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.HEXIMALS, BaseGlyphSetNumber16.class);
	}
	
	default BaseGlyphSetNumber36 BȍőnGlyphSetNumber36() {
		return GET_BBC().GET_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.GEMATRIA, BaseGlyphSetNumber36.class);
	}
}
