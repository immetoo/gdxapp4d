package love.distributedrebirth.demo4d.base2t;

import java.util.function.Consumer;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public enum T02PartBinary implements BasePartIdentifierTone {

	PART_1("0","˥"),
	PART_2("1","˩"),
	;
	
	public static int LENGTH = 2;
	private final String identifier;
	private final String identifierTone;
	
	private T02PartBinary(String identifier, String identifierTone) {
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
	
	public static void forEach(Consumer<T02PartBinary> consumer) {
		for (T02PartBinary value:values()) {
			consumer.accept(value);
		}
	}
}
