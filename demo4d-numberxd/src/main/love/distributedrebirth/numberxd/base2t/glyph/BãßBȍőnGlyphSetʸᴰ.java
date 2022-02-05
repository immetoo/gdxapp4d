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
	
	default String BȍőnPrintGlyphSetNumber10(int number, int numberMax) {
		StringBuilder buf = new StringBuilder();
		if (numberMax < 10) {
			buf.append(BȍőnGlyphSetNumber10().BȍőnCharFor(number));
		} else if (numberMax < 100) {
			int count = number;
			int mod10 = count % 10;
			int div10 = count / 10 % 10;
			buf.append(BȍőnGlyphSetNumber10().BȍőnCharFor(div10));
			buf.append(BȍőnGlyphSetNumber10().BȍőnCharSeperator());
			buf.append(BȍőnGlyphSetNumber10().BȍőnCharFor(mod10));
		} else if (numberMax < 1000) {
			int count = number;
			int mod10 = count % 10;
			int div10 = count / 10 % 10;
			int div100 = count / 100 % 10;
			buf.append(BȍőnGlyphSetNumber10().BȍőnCharFor(div10));
			buf.append(BȍőnGlyphSetNumber10().BȍőnCharSeperator());
			buf.append(BȍőnGlyphSetNumber10().BȍőnCharFor(div100));
			buf.append(BȍőnGlyphSetNumber10().BȍőnCharSeperator());
			buf.append(BȍőnGlyphSetNumber10().BȍőnCharFor(mod10));
		} else {
			throw new IllegalStateException("Can't handle more than 1000 values.");
		}
		if (BaseGlyphSet.HEBREW.equals(this)) {
			return buf.reverse().toString(); // TODO: ImGui workaround
		}
		return buf.toString();
	}
	
	default String BȍőnPrintGlyphSetNumber16(int number, int numberMax) {
		//BãßBȍőnGlyphSetʸᴰ<T> glyphSet = this;
		StringBuilder buf = new StringBuilder();
		if (numberMax < 16) {
			buf.append(BȍőnGlyphSetNumber16().BȍőnCharFor(number));
		} else if (numberMax < 256) {
			buf.append(BȍőnGlyphSetNumber16().BȍőnCharFor(number >> 4));
			buf.append(BȍőnGlyphSetNumber16().BȍőnCharSeperator());
			BaseGlyphSet secondGlyphSet = BȍőnGlyphSetNumber16().BȍőnAltGlyphSet();
			if (secondGlyphSet != null) {
				buf.append(secondGlyphSet.BȍőnGlyphSetNumber16().BȍőnCharFor(number & 0x0F));
			} else {
				buf.append(BȍőnGlyphSetNumber16().BȍőnCharFor(number & 0x0F));
			}
		} else if (numberMax < 0xFFF+1) {
			buf.append(BȍőnGlyphSetNumber16().BȍőnCharFor((number >> 8) & 0x0F));
			buf.append(BȍőnGlyphSetNumber16().BȍőnCharSeperator());
			BaseGlyphSet secondGlyphSet = BȍőnGlyphSetNumber16().BȍőnAltGlyphSet();
			if (secondGlyphSet != null) {
				buf.append(secondGlyphSet.BȍőnGlyphSetNumber16().BȍőnCharFor((number >> 4) & 0x0F));
				buf.append(secondGlyphSet.BȍőnGlyphSetNumber16().BȍőnCharSeperator());
				buf.append(secondGlyphSet.BȍőnGlyphSetNumber16().BȍőnCharFor(number & 0x0F));
			} else {
				buf.append(BȍőnGlyphSetNumber16().BȍőnCharFor((number >> 4) & 0x0F));
				buf.append(BȍőnGlyphSetNumber16().BȍőnCharSeperator());
				buf.append(BȍőnGlyphSetNumber16().BȍőnCharFor(number & 0x0F));
			}
		} else {
			throw new IllegalStateException("Can't handle more than 0xFFF values.");
		}
		if (BaseGlyphSet.HEBREW.equals(this)) {
			return buf.reverse().toString(); // TODO: ImGui workaround
		}
		return buf.toString();
	}
	
	default String BȍőnPrintGlyphSetNumber36(int number, int numberMax) {
		StringBuilder buf = new StringBuilder();
		if (numberMax < 9) {
			buf.append(BȍőnGlyphSetNumber36().BȍőnCharFor36(number + 1));
		} else if (numberMax < 99) {
			int count = number + 1;
			int mod10 = (count % 9) + 1;
			int div10 = ((count / 9) % 9) + 1;
			buf.append(BȍőnGlyphSetNumber36().BȍőnCharFor36(div10));
			buf.append(BȍőnGlyphSetNumber36().BȍőnCharSeperator());
			buf.append(BȍőnGlyphSetNumber36().BȍőnCharFor36(mod10));
		} else if (numberMax < 999) {
			int count = number;
			int mod10 = (count % 9) + 1;
			int div10 = ((count / 90) & 9) + 1;
			int div100 = ((count / 900) & 9) + 1;
			buf.append(BȍőnGlyphSetNumber36().BȍőnCharFor36(div10));
			buf.append(BȍőnGlyphSetNumber36().BȍőnCharSeperator());
			buf.append(BȍőnGlyphSetNumber36().BȍőnCharFor36(div100));
			buf.append(BȍőnGlyphSetNumber36().BȍőnCharSeperator());
			buf.append(BȍőnGlyphSetNumber36().BȍőnCharFor36(mod10));
		} else {
			throw new IllegalStateException("Can't handle more than 1000 values.");
		}
		if (BaseGlyphSet.HEBREW.equals(this)) {
			return buf.reverse().toString(); // TODO: ImGui workaround
		}
		return buf.toString();
	}
}
