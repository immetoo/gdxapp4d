package love.distributedrebirth.demo4d.base2t;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * The distribution by 5 called Wuxing.
 * @author willemtsade ©Δ∞ 仙上主天
 */
public enum T05PartPental implements BasePartIdentifier {

	PART_1("˥","0","火","fire"),
	PART_2("˦","1","水","water"),
	PART_3("˧","2","木","wood"),
	PART_4("˨","3","金","gold"),
	PART_5("˩","4","土","earth"),
	;
	
	public static int LENGTH = 5;
	private final String identifierTone;
	private final String identifierLetter;
	private final String chinaKey;
	private final String chinaValue;
	
	private static final Map<String, T05PartPental> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	
	private T05PartPental(String identifierTone, String identifierLetter, String chinaKey, String chinaValue) {
		this.identifierTone = identifierTone;
		this.identifierLetter = identifierLetter;
		this.chinaKey = chinaKey;
		this.chinaValue = chinaValue;
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
	public String getChinaKey() {
		return chinaKey;
	}
	
	@Override
	public String getChinaValue() {
		return chinaValue;
	}
	
	public static void forEach(Consumer<T05PartPental> consumer) {
		for (T05PartPental value:values()) {
			consumer.accept(value);
		}
	}
	
	public static T05PartPental valueOfTone(String identifierTone) {
		return TONE_MAP.get(identifierTone);
	}
}
