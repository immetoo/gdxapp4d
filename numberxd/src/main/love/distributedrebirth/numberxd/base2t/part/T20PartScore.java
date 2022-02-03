package love.distributedrebirth.numberxd.base2t.part;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnClassInfoʸᴰ(name = "T20PartScore", purpose = "The distribution by 20.")
@BãßBȍőnPartAlt1Infoʸᴰ(name = "SI-Unit Types", website = "https://en.wikipedia.org/wiki/Metric_prefix")
@BãßBȍőnPartAlt2Infoʸᴰ(name = "Vigesimal", website = "https://en.wikipedia.org/wiki/Vigesimal#Places")
@BãßBȍőnPartAlt3Infoʸᴰ(name = "Vigesimal Alternative", website = "https://en.wikipedia.org/wiki/Vigesimal#Places")
@BãßBȍőnPartAlt4Infoʸᴰ(name = "Open Location Code", website = "https://en.wikipedia.org/wiki/Open_Location_Code")
public enum T20PartScore implements BãßBȍőnPartAlt4ʸᴰ<T20PartScore> {

	PART_1 ("˥", "尧", "yotta", "Y", "0", "0", "2"),
	PART_2 ("˦", "泽", "zetta", "Z", "1", "1", "3"),
	PART_3 ("˧", "艾", "exa",   "E", "2", "2", "4"),
	PART_4 ("˨", "拍", "peta",  "P", "3", "3", "5"),
	PART_5 ("˩", "太", "tera",  "T", "4", "4", "6"),
	PART_6 ("꜒", "吉", "giga",  "G", "5", "5", "7"),
	PART_7 ("꜓", "兆", "mega",  "M", "6", "6", "8"),
	PART_8 ("꜔", "千", "kilo",  "k", "7", "7", "9"),
	PART_9 ("꜕", "百", "hecto", "h", "8", "8", "C"),
	PART_10("꜖", "十", "deca",  "da","9", "9", "F"),
	PART_11("꜈", "分", "deci",  "d", "A", "A", "G"),
	PART_12("꜉", "厘", "centi", "c", "B", "B", "H"),
	PART_13("꜊", "毫", "milli", "m", "C", "C", "J"),
	PART_14("꜋", "微", "micro", "µ", "D", "D", "M"),
	PART_15("꜌", "纳", "nano",  "n", "E", "E", "P"),
	PART_16("꜍", "皮", "pico",  "p", "F", "F", "Q"),
	PART_17("꜎", "飞", "femto", "f", "G", "G", "R"),
	PART_18("꜏", "阿", "atto",  "a", "H", "H", "V"),
	PART_19("꜐", "仄", "zepto", "z", "I", "J", "W"),
	PART_20("꜑", "幺", "yocto", "y", "J", "K", "X"),
	;
	
	private static final Map<String, T20PartScore> OPENLC_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.BȍőnAlt4Value(), v -> v)));
	private final BãßBȍőnCoffinOpenʸᴰ<BãßBȍőnPartKeyʸᴰ> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<BãßBȍőnPartKeyʸᴰ> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };
	
	private T20PartScore(String idTone, String chinaKey, String chinaValue,
			String alt1Value, String alt2Value, String alt3Value, String alt4Value) {
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.ID_TONE, idTone);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_KEY, chinaKey);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_VALUE, chinaValue);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.ALT_1_VALUE, alt1Value);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.ALT_2_VALUE, alt2Value);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.ALT_3_VALUE, alt3Value);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.ALT_4_VALUE, alt4Value);
		BBC.PUT_MAP(BãßBȍőnPartKeyʸᴰ.MAP_TONE);
		BBC.PUT_MAP(BãßBȍőnPartKeyʸᴰ.MAP_CHINA);
	}
	
	public T20PartScore BãßValueOfOpenLC(String openLCKey) {
		return OPENLC_MAP.get(openLCKey);
	}
}
