package love.distributedrebirth.demo4d.base2t;

import java.util.function.Consumer;

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
}
