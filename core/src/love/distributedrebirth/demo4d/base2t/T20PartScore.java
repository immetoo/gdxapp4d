package love.distributedrebirth.demo4d.base2t;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public enum T20PartScore implements BasePartIdentifierAlt {

	// TODO: fixup tone letters for 20 parts
	PART_1 ("˥","0","2"),
	PART_2 ("˦","1","3"),
	PART_3 ("˧","2","4"),
	PART_4 ("˨","3","5"),
	PART_5 ("˩","4","6"),
	PART_6 ("˥","5","7"),
	PART_7 ("˥","6","8"),
	PART_8 ("˥","7","9"),
	PART_9 ("˥","8","C"),
	PART_10("˥","9","F"),
	PART_11("˥","A","G"),
	PART_12("˥","B","H"),
	PART_13("˥","C","J"),
	PART_14("˥","D","M"),
	PART_15("˥","E","P"),
	PART_16("˥","F","Q"),
	PART_17("˥","G","R"),
	PART_18("˥","H","V"),
	PART_19("˥","I","W"),
	PART_20("˥","J","X"),
	;
	
	public static int LENGTH = 20;
	private final String identifierTone;
	private final String identifierLetter;
	private final String identifierAlt;
	
	private static final Map<String, T20PartScore> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	private static final BasePartIdentifierAltInfo ALT_INFO = new BasePartIdentifierAltInfo(
			"Open Location Code","https://en.wikipedia.org/wiki/Open_Location_Code");
	
	private T20PartScore(String identifierTone, String identifierLetter, String identifierAlt) {
		this.identifierTone = identifierTone;
		this.identifierLetter = identifierLetter;
		this.identifierAlt = identifierAlt;
	}
	
	@Override
	public String getIdentifierTone() {
		return identifierTone;
	}
	
	@Override
	public String getIdentifierLetter() {
		return identifierLetter;
	}
	
	@Override
	public String getIdentifierAlt() {
		return identifierAlt;
	}
	
	@Override
	public BasePartIdentifierAltInfo getIdentifierAltInfo() {
		return ALT_INFO;
	}
	
	public static void forEach(Consumer<T20PartScore> consumer) {
		for (T20PartScore value:values()) {
			consumer.accept(value);
		}
	}
	
	public static T20PartScore valueOfTone(String identifierTone) {
		return TONE_MAP.get(identifierTone);
	}
}
