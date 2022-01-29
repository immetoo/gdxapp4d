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
public enum T02PartBinary implements BasePartIdentifier {

	PART_1("˧","0"),
	PART_2("꜔","1"),
	;
	
	public static int LENGTH = 2;
	private final String identifierTone;
	private final String identifierLetter;
	
	private static final Map<String, T02PartBinary> TONE_MAP = Collections.unmodifiableMap(
			Arrays.asList(values()).stream().collect(Collectors.toMap(v -> v.getIdentifierTone(), v -> v)));
	
	private T02PartBinary(String identifierTone, String identifierLetter) {
		this.identifierTone = identifierTone;
		this.identifierLetter = identifierLetter;
	}
	
	@Override
	public String getIdentifierTone() {
		return identifierTone;
	}
	
	@Override
	public String getIdentifierLetter() {
		return identifierLetter;
	}
	
	public static void forEach(Consumer<T02PartBinary> consumer) {
		for (T02PartBinary value:values()) {
			consumer.accept(value);
		}
	}
	
	public static T02PartBinary valueOfTone(String identifierTone) {
		return TONE_MAP.get(identifierTone);
	}
}
