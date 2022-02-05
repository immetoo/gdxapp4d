package love.distributedrebirth.numberxd.base2t.part;

import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnClassInfoʸᴰ(name = "T06PartSeximal", purpose = "The distribution by 6 (numbers4/9).")
@BãßBȍőnPartAlt1Infoʸᴰ(name = "ADFGVX cipher", website = "https://en.wikipedia.org/wiki/ADFGVX_cipher")
public enum T06PartSeximal implements BãßBȍőnPartAlt1ʸᴰ<T06PartSeximal> {

	PART_1("˦","四","4","A"),
	PART_2("˨","五","5","D"),
	PART_3("꜓","六","6","F"),
	PART_4("꜕","七","7","G"),
	PART_5("꜊","八","8","V"),
	PART_6("꜏","九","9","X"),
	;
	
	private final BãßBȍőnCoffinOpenʸᴰ<BãßBȍőnPartKeyʸᴰ> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<BãßBȍőnPartKeyʸᴰ> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };
	
	private T06PartSeximal(String dialTone, String chinaKey, String chinaValue, String alt1Value) {
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.DIAL_TONE, dialTone);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_KEY, chinaKey);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_VALUE, chinaValue);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.ALT_1_VALUE, alt1Value);
		BBC.INIT_BOON(this);
	}
	
	public T02PartBinary splitPartBinary() {
		return T02PartBinary.values()[ordinal() & 1];
	}
	
	public T03PartTrit splitPartTrit() {
		return T03PartTrit.values()[ordinal() >> 1];
	}
}
