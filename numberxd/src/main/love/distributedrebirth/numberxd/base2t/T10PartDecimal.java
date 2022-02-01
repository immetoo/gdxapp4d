package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1Info;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt2Info;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt3Info;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt4;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt4Info;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneCoffin;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneName;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneStoreKey;

/**
 * The distribution by 10.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
@BassBoneName("T10PartDecimal")
@BassBoneAlt1Info(name="Korean numerals", website="https://en.wikipedia.org/wiki/Korean_numerals")
@BassBoneAlt2Info(name="Burmese numerals", website="https://en.wikipedia.org/wiki/Burmese_numerals")
@BassBoneAlt3Info(name="Bengali numerals", website="https://en.wikipedia.org/wiki/Bengali_numerals")
@BassBoneAlt4Info(name="Sinhala Lith Illakkam", website="https://en.wikipedia.org/wiki/Sinhala_numerals#Numerals")
public enum T10PartDecimal implements BassBoneAlt4<T10PartDecimal> {
 
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
	
	public BassBoneCoffin GET_BBC() { return bbc; }
	public static int LENGTH() { return values().length; };
	private final BassBoneCoffin bbc = BassBoneCoffin.newInstance();
	
	private T10PartDecimal(String idTone, String idLetter, String chinaKey, String chinaValue,
			String alt1Value, String alt2Value, String alt3Value, String alt4Value) {
		GET_BBC().PUT_INIT(BassBoneStoreKey.ID_TONE, idTone);
		GET_BBC().PUT_INIT(BassBoneStoreKey.ID_LETTER, idLetter);
		GET_BBC().PUT_INIT(BassBoneStoreKey.CHINA_KEY, chinaKey);
		GET_BBC().PUT_INIT(BassBoneStoreKey.CHINA_VALUE, chinaValue);
		GET_BBC().PUT_INIT(BassBoneStoreKey.ALT_1_VALUE, alt1Value);
		GET_BBC().PUT_INIT(BassBoneStoreKey.ALT_2_VALUE, alt2Value);
		GET_BBC().PUT_INIT(BassBoneStoreKey.ALT_3_VALUE, alt3Value);
		GET_BBC().PUT_INIT(BassBoneStoreKey.ALT_4_VALUE, alt4Value);
		GET_BBC().GET_MAP_OBJ(BassBoneStoreKey.MAP_TONE);
		GET_BBC().GET_MAP_OBJ(BassBoneStoreKey.MAP_CHINA);
	}
}
