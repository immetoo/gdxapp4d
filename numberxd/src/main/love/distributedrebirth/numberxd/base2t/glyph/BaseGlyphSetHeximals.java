package love.distributedrebirth.numberxd.base2t.glyph;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class BaseGlyphSetHeximals {

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
	private final String charA;
	private final String charB;
	private final String charC;
	private final String charD;
	private final String charE;
	private final String charF;
	
	public BaseGlyphSetHeximals(String char0, String char1, String char2, String char3, String char4, String char5,
			String char6, String char7, String char8, String char9, String charA, String charB, String charC,
			String charD, String charE, String charF) {
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
		this.charA = charA;
		this.charB = charB;
		this.charC = charC;
		this.charD = charD;
		this.charE = charE;
		this.charF = charF;
	}

	public String getCharFor(int number) {
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
		case 10:
			return charA;
		case 20:
			return charB;
		case 30:
			return charC;
		case 40:
			return charD;
		case 50:
			return charE;
		case 60:
			return charF;
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

	public String getCharA() {
		return charA;
	}

	public String getCharB() {
		return charB;
	}

	public String getCharC() {
		return charC;
	}

	public String getCharD() {
		return charD;
	}

	public String getCharE() {
		return charE;
	}

	public String getCharF() {
		return charF;
	}
}
