package love.distributedrebirth.demo4d.base2t;

import java.util.function.Consumer;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public enum T05PartPental implements BasePartIdentifierAlt,BasePartIdentifierTone {

	PART_1("0","\u706b","˥"),
	PART_2("1","\u571f","˦"),
	PART_3("2","\u91d1","˧"),
	PART_4("3","\u6c34","˨"),
	PART_5("4","\u6728","˩"),
	;
	
	public static int LENGTH = 5;
	private final String identifier;
	private final String identifierAlt; // escaped to keep normal line height in IDE
	private final String identifierTone;
	private static final BasePartIdentifierAltInfo ALT_INFO = new BasePartIdentifierAltInfo(
			"Wuxing","https://en.wikipedia.org/wiki/Wuxing_(Chinese_philosophy)");
	
	private T05PartPental(String identifier, String identifierAlt, String identifierTone) {
		this.identifier = identifier;
		this.identifierAlt = identifierAlt;
		this.identifierTone = identifierTone;
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
	public String getIdentifierTone() {
		return identifierTone;
	}
	
	@Override
	public BasePartIdentifierAltInfo getIdentifierAltInfo() {
		return ALT_INFO;
	}
	
	public static void forEach(Consumer<T05PartPental> consumer) {
		for (T05PartPental value:values()) {
			consumer.accept(value);
		}
	}
}
