package love.distributedrebirth.numberxd.base2t.glyph;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnGlyphSetNumberInfoʸᴰ(base = BaseGlyphSetNumberType.BASE_10)
public final class BaseGlyphSetNumber10 implements BaseGlyphSetNumber {
	
	private final String char0;
	private final String char1;
	private final String char2;
	private final String char3;
	private final String char4;
	private final String char5;
	private final String char6;
	private final String char7;
	private final String char8;
	private final String char9;
	
	public BaseGlyphSetNumber10(String char0, String char1, String char2, String char3, String char4, String char5,
			String char6, String char7, String char8, String char9) {
		super();
		this.char0 = char0;
		this.char1 = char1;
		this.char2 = char2;
		this.char3 = char3;
		this.char4 = char4;
		this.char5 = char5;
		this.char6 = char6;
		this.char7 = char7;
		this.char8 = char8;
		this.char9 = char9;
	}
	
	public String BȍőnCharFor(int number) {
		switch (number) {
		case 0:
			return char0;
		case 1:
			return char1;
		case 2:
			return char2;
		case 3:
			return char3;
		case 4:
			return char4;
		case 5:
			return char5;
		case 6:
			return char6;
		case 7:
			return char7;
		case 8:
			return char8;
		case 9:
			return char9;
		default:
			throw new IllegalArgumentException("Can't handle higher numbers: "+number);
		}
	}
	
	public String getChar0() {
		return char0;
	}
	
	public String getChar1() {
		return char1;
	}
	
	public String getChar2() {
		return char2;
	}
	
	public String getChar3() {
		return char3;
	}
	
	public String getChar4() {
		return char4;
	}
	
	public String getChar5() {
		return char5;
	}
	
	public String getChar6() {
		return char6;
	}
	
	public String getChar7() {
		return char7;
	}
	
	public String getChar8() {
		return char8;
	}
	
	public String getChar9() {
		return char9;
	}
}
