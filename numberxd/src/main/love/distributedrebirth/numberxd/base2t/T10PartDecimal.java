package love.distributedrebirth.numberxd.base2t;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import love.distributedrebirth.numberxd.base2t.bone.BassBone;
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
public enum T10PartDecimal implements BassBone,BassBoneAlt4 {
 
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
	
	public static int LENGTH() { return values().length; };
	private final BassBoneCoffin bbc = BassBoneCoffin.newInstance();
	private static final Map<String, T10PartDecimal> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final Map<String, T10PartDecimal> CHINA_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
	
	private T10PartDecimal(String idTone, String idLetter, String chinaKey, String chinaValue,
			String alt1Value, String alt2Value, String alt3Value, String alt4Value) {
		this.getBBC().putInit(BassBoneStoreKey.ID_TONE, idTone);
		this.getBBC().putInit(BassBoneStoreKey.ID_LETTER, idLetter);
		this.getBBC().putInit(BassBoneStoreKey.CHINA_KEY, chinaKey);
		this.getBBC().putInit(BassBoneStoreKey.CHINA_VALUE, chinaValue);
		this.getBBC().putInit(BassBoneStoreKey.ALT_1_VALUE, alt1Value);
		this.getBBC().putInit(BassBoneStoreKey.ALT_2_VALUE, alt2Value);
		this.getBBC().putInit(BassBoneStoreKey.ALT_3_VALUE, alt3Value);
		this.getBBC().putInit(BassBoneStoreKey.ALT_4_VALUE, alt4Value);
	}
	
	@Override
	public BassBoneCoffin getBBC() {
		return bbc;
	}
	
	public static void forEach(Consumer<T10PartDecimal> consumer) {
		for (T10PartDecimal value:values()) {
			consumer.accept(value);
		}
	}
	
	public static T10PartDecimal valueOfTone(String identifierTone) {
		return TONE_MAP.get(identifierTone);
	}
	
	public static T10PartDecimal valueOfChina(String chinaKey) {
		return CHINA_MAP.get(chinaKey);
	}
}
