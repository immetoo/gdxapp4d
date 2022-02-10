package love.distributedrebirth.numberxd.glyph;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseAppender;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public final class BaseGlyphSetNumber {
	
	private final List<String> chars = new ArrayList<>();
	private BaseGlyphSet altGlyphSet = null;
	private String charSeperator = "";
	
	public BaseGlyphSetNumber(String char0, String char1, String char2, String char3, String char4, String char5,
			String char6, String char7, String char8, String char9) {
		this.chars.add(char0);
		this.chars.add(char1);
		this.chars.add(char2);
		this.chars.add(char3);
		this.chars.add(char4);
		this.chars.add(char5);
		this.chars.add(char6);
		this.chars.add(char7);
		this.chars.add(char8);
		this.chars.add(char9);
	}
	
	public BaseGlyphSetNumber(String char0, String char1, String char2, String char3, String char4, String char5,
			String char6, String char7, String char8, String char9, String charA, String charB, String charC,
			String charD, String charE, String charF) {
		this.chars.add(char0);
		this.chars.add(char1);
		this.chars.add(char2);
		this.chars.add(char3);
		this.chars.add(char4);
		this.chars.add(char5);
		this.chars.add(char6);
		this.chars.add(char7);
		this.chars.add(char8);
		this.chars.add(char9);
		this.chars.add(charA);
		this.chars.add(charB);
		this.chars.add(charC);
		this.chars.add(charD);
		this.chars.add(charE);
		this.chars.add(charF);
	}
	
	public BaseGlyphSetNumber(String char1, String char2, String char3, String char4, String char5, String char6,
			String char7, String char8, String char9, String char10, String char20, String char30, String char40,
			String char50, String char60, String char70, String char80, String char90, String char100, String char200,
			String char300, String char400, String char500, String char600, String char700, String char800,
			String char900) {
		this.chars.add(char1);
		this.chars.add(char2);
		this.chars.add(char3);
		this.chars.add(char4);
		this.chars.add(char5);
		this.chars.add(char6);
		this.chars.add(char7);
		this.chars.add(char8);
		this.chars.add(char9);
		this.chars.add(char10);
		this.chars.add(char20);
		this.chars.add(char30);
		this.chars.add(char40);
		this.chars.add(char50);
		this.chars.add(char60);
		this.chars.add(char70);
		this.chars.add(char80);
		this.chars.add(char90);
		this.chars.add(char100);
		this.chars.add(char200);
		this.chars.add(char300);
		this.chars.add(char400);
		this.chars.add(char500);
		this.chars.add(char600);
		this.chars.add(char700);
		this.chars.add(char800);
		this.chars.add(char900);
	}
	
	public BaseGlyphSetNumber(List<String> chars) {
		this.chars.addAll(chars);
	}
	
	public BaseGlyphSetNumber(Consumer<BaseAppender<String>> consumer) {
		consumer.accept(new BaseAppender<String>() {
			
			@Override
			public void add(String value) {
				chars.add(value);
			}
		});
	}
	
	public BaseGlyphSetNumber withAltGlyphSet(BaseGlyphSet altGlyphSet) {
		BaseGlyphSetNumber result = new BaseGlyphSetNumber(chars);
		result.altGlyphSet = altGlyphSet;
		return result;
	}
	
	
	public BaseGlyphSetNumber withSeperator(String charSeperator) {
		BaseGlyphSetNumber result = new BaseGlyphSetNumber(chars);
		result.charSeperator = charSeperator;
		return result;
	}
	
	public String BȍőnCharFor(int number) {
		return chars.get(number);
	}
	
	public int BȍőnIndexOf(String str) {
		return chars.indexOf(str);
	}
	
	public String BȍőnCharSeperator() {
		return charSeperator;
	}
	
	public BaseGlyphSet BȍőnAltGlyphSet() {
		return altGlyphSet;
	}
	
	public String BȍőnCharFor36(int number) {
		switch (number) {
		case 1:
			return chars.get(0);
		case 2:
			return chars.get(1);
		case 3:
			return chars.get(2);
		case 4:
			return chars.get(3);
		case 5:
			return chars.get(4);
		case 6:
			return chars.get(5);
		case 7:
			return chars.get(6);
		case 8:
			return chars.get(7);
		case 9:
			return chars.get(8);
		case 10:
			return chars.get(9);
		case 20:
			return chars.get(10);
		case 30:
			return chars.get(11);
		case 40:
			return chars.get(12);
		case 50:
			return chars.get(13);
		case 60:
			return chars.get(14);
		case 70:
			return chars.get(15);
		case 80:
			return chars.get(16);
		case 90:
			return chars.get(17);
		case 100:
			return chars.get(18);
		case 200:
			return chars.get(19);
		case 300:
			return chars.get(20);
		case 400:
			return chars.get(21);
		case 500:
			return chars.get(22);
		case 600:
			return chars.get(23);
		case 700:
			return chars.get(24);
		case 800:
			return chars.get(25);
		case 900:
			return chars.get(26);
		default:
			throw new IllegalArgumentException("Can't handle higher numbers: "+number);
		}
	}
}
