package love.distributedrebirth.numberxd.base2t.glyph;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface BaseGlyphSetNumber {

	default BaseGlyphSetNumberType BãßNumberType() {
		return getClass().getAnnotation(BãßBȍőnGlyphSetNumberInfoʸᴰ.class).base();
	}
	
	String BȍőnCharFor(int number);
	
	String BȍőnCharSeperator();
}
