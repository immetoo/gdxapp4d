package love.distributedrebirth.numberxd.base2t;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import love.distributedrebirth.numberxd.base2t.bone.BassBone;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneCoffin;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneName;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneStoreKey;

/**
 * The distribution by 2.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
@BassBoneName("T02PartBinary")
public enum T02PartBinary implements BassBone {

	PART_1("˧","0", "低", "low"),
	PART_2("꜔","1", "高", "high"),
	;
	
	public static int LENGTH() { return values().length; };
	private final BassBoneCoffin bbc = BassBoneCoffin.newInstance();
	private static final Map<String, T02PartBinary> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final Map<String, T02PartBinary> CHINA_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
	
	private T02PartBinary(String idTone, String idLetter, String chinaKey, String chinaValue) {
		this.getBBC().putInit(BassBoneStoreKey.ID_TONE, idTone);
		this.getBBC().putInit(BassBoneStoreKey.ID_LETTER, idLetter);
		this.getBBC().putInit(BassBoneStoreKey.CHINA_KEY, chinaKey);
		this.getBBC().putInit(BassBoneStoreKey.CHINA_VALUE, chinaValue);
	}
	
	@Override
	public BassBoneCoffin getBBC() {
		return bbc;
	}
	
	public static void forEach(Consumer<T02PartBinary> consumer) {
		for (T02PartBinary value:values()) {
			consumer.accept(value);
		}
	}
	
	public static T02PartBinary valueOfTone(String identifierTone) {
		return TONE_MAP.get(identifierTone);
	}
	
	public static T02PartBinary valueOfChina(String chinaKey) {
		return CHINA_MAP.get(chinaKey);
	}
}
