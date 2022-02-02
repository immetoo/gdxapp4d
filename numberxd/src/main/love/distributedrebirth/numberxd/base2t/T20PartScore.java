package love.distributedrebirth.numberxd.base2t;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import love.distributedrebirth.bassboonyd.BãßBȍőnCoffin;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpen;
import love.distributedrebirth.bassboonyd.BãßBȍőnInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1Info;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt2Info;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt3;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt3Info;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneStoreKey;

/**
 * The distribution by 20.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
@BãßBȍőnInfoʸᴰ(name = "T20PartScore", purpose = "The distribution by 20.")
@BassBoneAlt1Info(name="Vigesimal", website="https://en.wikipedia.org/wiki/Vigesimal#Places")
@BassBoneAlt2Info(name="Vigesimal Alternative", website="https://en.wikipedia.org/wiki/Vigesimal#Places")
@BassBoneAlt3Info(name="Open Location Code", website="https://en.wikipedia.org/wiki/Open_Location_Code")
public enum T20PartScore implements BassBoneAlt3<T20PartScore> {

	PART_1 ("˥","Y", "尧","yotta","0","0","2"),
	PART_2 ("˦","Z", "泽","zetta","1","1","3"),
	PART_3 ("˧","E", "艾","exa",  "2","2","4"),
	PART_4 ("˨","P", "拍","peta", "3","3","5"),
	PART_5 ("˩","T", "太","tera", "4","4","6"),
	PART_6 ("꜒","G", "吉","giga", "5","5","7"),
	PART_7 ("꜓","M", "兆","mega", "6","6","8"),
	PART_8 ("꜔","k", "千","kilo", "7","7","9"),
	PART_9 ("꜕","h", "百","hecto","8","8","C"),
	PART_10("꜖","da","十","deca", "9","9","F"),
	PART_11("꜈","d", "分","deci", "A","A","G"),
	PART_12("꜉","c", "厘","centi","B","B","H"),
	PART_13("꜊","m", "毫","milli","C","C","J"),
	PART_14("꜋","µ", "微","micro","D","D","M"),
	PART_15("꜌","n", "纳","nano", "E","E","P"),
	PART_16("꜍","p", "皮","pico", "F","F","Q"),
	PART_17("꜎","f", "飞","femto","G","G","R"),
	PART_18("꜏","a", "阿","atto", "H","H","V"),
	PART_19("꜐","z", "仄","zepto","I","J","W"),
	PART_20("꜑","y", "幺","yocto","J","K","X"),
	;
	
	private static final Map<String, T20PartScore> OPENLC_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getAlt3Value(), v -> v)));
	private final BãßBȍőnCoffinOpen<BassBoneStoreKey> BBC = BãßBȍőnCoffinOpen.newInstance();
	public BãßBȍőnCoffin<BassBoneStoreKey> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };
	
	private T20PartScore(String idTone, String idLetter, String chinaKey, String chinaValue,
			String alt1Value, String alt2Value, String alt3Value) {
		BBC.PUT_OBJ(BassBoneStoreKey.ID_TONE, idTone);
		BBC.PUT_OBJ(BassBoneStoreKey.ID_LETTER, idLetter);
		BBC.PUT_OBJ(BassBoneStoreKey.CHINA_KEY, chinaKey);
		BBC.PUT_OBJ(BassBoneStoreKey.CHINA_VALUE, chinaValue);
		BBC.PUT_OBJ(BassBoneStoreKey.ALT_1_VALUE, alt1Value);
		BBC.PUT_OBJ(BassBoneStoreKey.ALT_2_VALUE, alt2Value);
		BBC.PUT_OBJ(BassBoneStoreKey.ALT_3_VALUE, alt3Value);
		BBC.PUT_MAP(BassBoneStoreKey.MAP_TONE);
		BBC.PUT_MAP(BassBoneStoreKey.MAP_CHINA);
	}
	
	public T20PartScore staticValueOfOpenLC(String openLCKey) {
		return OPENLC_MAP.get(openLCKey);
	}
}
