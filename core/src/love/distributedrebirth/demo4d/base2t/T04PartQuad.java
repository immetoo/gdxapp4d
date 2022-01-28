package love.distributedrebirth.demo4d.base2t;

import java.util.function.Consumer;

public enum T04PartQuad implements BasePartIdentifierAlt,BasePartIdentifierTone {

	PART_1("0","N","˥"),
	PART_2("1","E","˦"),
	PART_3("2","W","˨"),
	PART_4("3","S","˩"),
	;
	
	public static int LENGTH = 4;
	private final String identifier;
	private final String identifierAlt;
	private final String identifierTone;
	private static final BasePartIdentifierAltInfo ALT_INFO = new BasePartIdentifierAltInfo(
			"Cardinal direction","https://simple.wikipedia.org/wiki/Cardinal_direction");
	
	private T04PartQuad(String identifier, String identifierAlt, String identifierTone) {
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
	
	public T02PartBinary splitPartBinary(T02PartBinary part) {
		return T02PartBinary.values()[(ordinal() >> part.ordinal()) & 1];
	}
	
	public static void forEach(Consumer<T04PartQuad> consumer) {
		for (T04PartQuad value:values()) {
			consumer.accept(value);
		}
	}
}
