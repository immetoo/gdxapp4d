package love.distributedrebirth.demo4d.base2t;

import java.util.function.Consumer;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public enum T12PartUncial implements BasePartIdentifierAlt {

	PART_1("0","0"),
	PART_2("1","1"),
	PART_3("2","2"),
	PART_4("3","3"),
	PART_5("4","4"),
	PART_6("5","5"),
	PART_7("6","6"),
	PART_8("7","7"),
	PART_9("8","8"),
	PART_10("9","9"),
	PART_11("A","\u218a"), // TURNED DIGIT TWO
	PART_12("B","\u218b"), // TURNED DIGIT THREE
	;
	
	public static int LENGTH = 12;
	private final String identifier;
	private final String identifierAlt;
	private static final BasePartIdentifierAltInfo ALT_INFO = new BasePartIdentifierAltInfo(
			"Transdecimal symbols","https://en.wikipedia.org/wiki/Duodecimal#Transdecimal_symbols");
	
	private T12PartUncial(String identifier, String identifierAlt) {
		this.identifier = identifier;
		this.identifierAlt = identifierAlt;
	}
	
	@Override
	public String getIdentifier() {
		return identifier;
	}
	
	@Override
	public String getIdentifierAlt() {
		return identifierAlt;
	}
	
	@Override
	public BasePartIdentifierAltInfo getIdentifierAltInfo() {
		return ALT_INFO;
	}
	
	public static void forEach(Consumer<T12PartUncial> consumer) {
		for (T12PartUncial value:values()) {
			consumer.accept(value);
		}
	}
}
