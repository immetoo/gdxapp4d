package love.distributedrebirth.numberxd.base2t.part;

import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnClassInfoʸᴰ(name = "T10PartDecimal", purpose = "The distribution by 10.")
@BãßBȍőnPartAlt1Infoʸᴰ(name = "Tone Letter LR", website = "https://en.wikipedia.org/wiki/Tone_letter")
@BãßBȍőnPartAlt2Infoʸᴰ(name = "Tone Letter RL", website = "https://en.wikipedia.org/wiki/Tone_letter")
public enum T10PartDecimal implements BãßBȍőnPartAlt2ʸᴰ<T10PartDecimal> {
 
	PART_1 ("˥","零","zero", "˥","꜒"),
	PART_2 ("˦","壹","one",  "˦","꜓"),
	PART_3 ("˧","貳","two",  "˧","꜔"),
	PART_4 ("˨","參","three","˨","꜕"),
	PART_5 ("˩","肆","four", "˩","꜖"),
	PART_6 ("꜖","伍","five", "꜌","꜑"),
	PART_7 ("꜕","陸","six",  "꜋","꜐"),
	PART_8 ("꜔","柒","seven","꜊","꜏"),
	PART_9 ("꜓","捌","eight","꜉","꜎"),
	PART_10("꜒","玖","nine", "꜈","꜍"),
	;
	
	private final BãßBȍőnCoffinOpenʸᴰ<BãßBȍőnPartKeyʸᴰ> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<BãßBȍőnPartKeyʸᴰ> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };
	
	private T10PartDecimal(String dialTone, String chinaKey, String chinaValue, String alt1Value, String alt2Value) {
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.DIAL_TONE, dialTone);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_KEY, chinaKey);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_VALUE, chinaValue);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.ALT_1_VALUE, alt1Value);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.ALT_2_VALUE, alt2Value);
		BBC.INIT_BOON(this);
	}
}
