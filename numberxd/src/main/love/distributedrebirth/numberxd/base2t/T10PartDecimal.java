package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt1Info;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt2Info;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt3Info;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt4;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartAlt4Info;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartKey;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnInfoʸᴰ(name = "T10PartDecimal", purpose = "The distribution by 10.")
@BãßBȍőnPartAlt1Info(name="Korean numerals", website="https://en.wikipedia.org/wiki/Korean_numerals")
@BãßBȍőnPartAlt2Info(name="Burmese numerals", website="https://en.wikipedia.org/wiki/Burmese_numerals")
@BãßBȍőnPartAlt3Info(name="Bengali numerals", website="https://en.wikipedia.org/wiki/Bengali_numerals")
@BãßBȍőnPartAlt4Info(name="Sinhala Lith Illakkam", website="https://en.wikipedia.org/wiki/Sinhala_numerals#Numerals")
public enum T10PartDecimal implements BãßBȍőnPartAlt4<T10PartDecimal> {
 
	PART_1 ("˥","ō","零","zero", "영","\u1040","০", "෦"),
	PART_2 ("˦","α","壹","one",  "일","\u1041","১", "෧"),
	PART_3 ("˧","β","貳","two",  "이","\u1042","২","෨"),
	PART_4 ("˨","γ","參","three","삼","\u1043","৩","෩"),
	PART_5 ("˩","δ","肆","four", "사","\u1044","৪","෪"),
	PART_6 ("꜒","ε","伍","five", "오","\u1045","৫","෫"),
	PART_7 ("꜓","ϝ","陸","six",  "육","\u1046","৬","෬"),
	PART_8 ("꜔","ζ","柒","seven","칠","\u1047","৭","෭"),
	PART_9 ("꜕","η","捌","eight","팔","\u1048","৮","෮"),
	PART_10("꜖","θ","玖","nine", "구","\u1049","৯","෯"),
	;
	
	private final BãßBȍőnCoffinOpenʸᴰ<BãßBȍőnPartKey> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<BãßBȍőnPartKey> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };
	
	private T10PartDecimal(String idTone, String idLetter, String chinaKey, String chinaValue,
			String alt1Value, String alt2Value, String alt3Value, String alt4Value) {
		BBC.PUT_OBJ(BãßBȍőnPartKey.ID_TONE, idTone);
		BBC.PUT_OBJ(BãßBȍőnPartKey.ID_LETTER, idLetter);
		BBC.PUT_OBJ(BãßBȍőnPartKey.CHINA_KEY, chinaKey);
		BBC.PUT_OBJ(BãßBȍőnPartKey.CHINA_VALUE, chinaValue);
		BBC.PUT_OBJ(BãßBȍőnPartKey.ALT_1_VALUE, alt1Value);
		BBC.PUT_OBJ(BãßBȍőnPartKey.ALT_2_VALUE, alt2Value);
		BBC.PUT_OBJ(BãßBȍőnPartKey.ALT_3_VALUE, alt3Value);
		BBC.PUT_OBJ(BãßBȍőnPartKey.ALT_4_VALUE, alt4Value);
		BBC.PUT_MAP(BãßBȍőnPartKey.MAP_TONE);
		BBC.PUT_MAP(BãßBȍőnPartKey.MAP_CHINA);
	}
}
