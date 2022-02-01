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
 * The distribution by 3.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
@BassBoneName("T03PartTrit")
public enum T03PartTrit implements BassBone {

	PART_1("˦","0","一","1"),
	PART_2("˧","1","二","2"),
	PART_3("˨","2","三","3"),
	;
	
	public static int LENGTH() { return values().length; };
	private final BassBoneCoffin bbc = BassBoneCoffin.newInstance();
	private static final Map<String, T03PartTrit> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final Map<String, T03PartTrit> CHINA_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getChinaKey(), v -> v)));
	
	private T03PartTrit(String idTone, String idLetter, String chinaKey, String chinaValue) {
		this.getBBC().putInit(BassBoneStoreKey.ID_TONE, idTone);
		this.getBBC().putInit(BassBoneStoreKey.ID_LETTER, idLetter);
		this.getBBC().putInit(BassBoneStoreKey.CHINA_KEY, chinaKey);
		this.getBBC().putInit(BassBoneStoreKey.CHINA_VALUE, chinaValue);
	}
	
	@Override
	public BassBoneCoffin getBBC() {
		return bbc;
	}
	
	public static void forEach(Consumer<T03PartTrit> consumer) {
		for (T03PartTrit value:values()) {
			consumer.accept(value);
		}
	}
	
	public static T03PartTrit valueOfTone(String identifierTone) {
		return TONE_MAP.get(identifierTone);
	}
	
	public static T03PartTrit valueOfChina(String chinaKey) {
		return CHINA_MAP.get(chinaKey);
	}
}
