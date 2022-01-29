package love.distributedrebirth.demo4d.base2t;

import java.util.function.Consumer;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public enum T03PartTrit implements BasePartIdentifierTone {

	PART_1("0","˦"),
	PART_2("1","˧"),
	PART_3("2","˨"),
	;
	
	public static int LENGTH = 3;
	private final String identifier;
	private final String identifierTone;
	
	private T03PartTrit(String identifier, String identifierTone) {
		this.identifier = identifier;
		this.identifierTone = identifierTone;
	}
	
	@Override
	public String getIdentifier() {
		return identifier;
	}
	
	@Override
	public String getIdentifierTone() {
		return identifierTone;
	}
	
	public static void forEach(Consumer<T03PartTrit> consumer) {
		for (T03PartTrit value:values()) {
			consumer.accept(value);
		}
	}
}
