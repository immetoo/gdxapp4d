package love.distributedrebirth.demo4d.base2t;

import java.util.function.Consumer;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public enum T03PartTrit implements BasePartIdentifier {

	PART_1("˦","0"),
	PART_2("˧","1"),
	PART_3("˨","2"),
	;
	
	public static int LENGTH = 3;
	private final String identifierTone;
	private final String identifierLetter;
	
	private T03PartTrit(String identifierTone, String identifierLetter) {
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
	
	public static void forEach(Consumer<T03PartTrit> consumer) {
		for (T03PartTrit value:values()) {
			consumer.accept(value);
		}
	}
}
