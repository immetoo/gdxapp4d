package love.distributedrebirth.demo4d.base2t;

import java.util.function.Consumer;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public enum T06PartSeximal implements BasePartIdentifierAlt {

	PART_1("˧˥","0","A"),
	PART_2("˧˩","1","D"),
	PART_3("˨˦","2","F"),
	PART_4("˦˨","3","G"),
	PART_5("˩˧","4","V"),
	PART_6("˥˧","5","X"),
	;
	
	public static int LENGTH = 6;
	private final String identifierTone;
	private final String identifierLetter;
	private final String identifierAlt;
	private static final BasePartIdentifierAltInfo ALT_INFO = new BasePartIdentifierAltInfo(
			"ADFGVX cipher","https://en.wikipedia.org/wiki/ADFGVX_cipher");
	
	private T06PartSeximal(String identifierTone, String identifierLetter, String identifierAlt) {
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
	
	public T02PartBinary splitPartBinary() {
		return T02PartBinary.values()[ordinal() & 1];
	}
	
	public T03PartTrit splitPartTrit() {
		return T03PartTrit.values()[ordinal() >> 1];
	}
	
	public static void forEach(Consumer<T06PartSeximal> consumer) {
		for (T06PartSeximal value:values()) {
			consumer.accept(value);
		}
	}
}
