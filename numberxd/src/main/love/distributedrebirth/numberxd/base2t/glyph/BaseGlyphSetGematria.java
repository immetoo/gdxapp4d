package love.distributedrebirth.numberxd.base2t.glyph;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class BaseGlyphSetGematria {

	private final String char1;
	private final String char2;
	private final String char3;
	private final String char4;
	private final String char5;
	private final String char6;
	private final String char7;
	private final String char8;
	private final String char9;
	private final String char10;
	private final String char20;
	private final String char30;
	private final String char40;
	private final String char50;
	private final String char60;
	private final String char70;
	private final String char80;
	private final String char90;
	private final String char100;
	private final String char200;
	private final String char300;
	private final String char400;
	private final String char500;
	private final String char600;
	private final String char700;
	private final String char800;
	private final String char900;
	
	public BaseGlyphSetGematria(String char1, String char2, String char3, String char4, String char5, String char6,
			String char7, String char8, String char9, String char10, String char20, String char30, String char40,
			String char50, String char60, String char70, String char80, String char90, String char100, String char200,
			String char300, String char400, String char500, String char600, String char700, String char800,
			String char900) {
		super();
		this.char1 = char1;
		this.char2 = char2;
		this.char3 = char3;
		this.char4 = char4;
		this.char5 = char5;
		this.char6 = char6;
		this.char7 = char7;
		this.char8 = char8;
		this.char9 = char9;
		this.char10 = char10;
		this.char20 = char20;
		this.char30 = char30;
		this.char40 = char40;
		this.char50 = char50;
		this.char60 = char60;
		this.char70 = char70;
		this.char80 = char80;
		this.char90 = char90;
		this.char100 = char100;
		this.char200 = char200;
		this.char300 = char300;
		this.char400 = char400;
		this.char500 = char500;
		this.char600 = char600;
		this.char700 = char700;
		this.char800 = char800;
		this.char900 = char900;
	}
	
	public String getCharFor(int number) {
		switch (number) {
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
			return char10;
		case 20:
			return char20;
		case 30:
			return char30;
		case 40:
			return char40;
		case 50:
			return char50;
		case 60:
			return char60;
		case 70:
			return char70;
		case 80:
			return char80;
		case 90:
			return char90;
		case 100:
			return char100;
		case 200:
			return char200;
		case 300:
			return char300;
		case 400:
			return char400;
		case 500:
			return char500;
		case 600:
			return char600;
		case 700:
			return char700;
		case 800:
			return char800;
		case 900:
			return char900;
		default:
			throw new IllegalArgumentException("Can't handle higher numbers: "+number);
		}
	}
}
