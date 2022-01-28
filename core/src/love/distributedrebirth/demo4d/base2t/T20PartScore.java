package love.distributedrebirth.demo4d.base2t;

import java.util.function.Consumer;

public enum T20PartScore implements BasePartIdentifierAlt {

	PART_1("0","2"),
	PART_2("1","3"),
	PART_3("2","4"),
	PART_4("3","5"),
	PART_5("4","6"),
	PART_6("5","7"),
	PART_7("6","8"),
	PART_8("7","9"),
	PART_9("8","C"),
	PART_10("9","F"),
	PART_11("A","G"),
	PART_12("B","H"),
	PART_13("C","J"),
	PART_14("D","M"),
	PART_15("E","P"),
	PART_16("F","Q"),
	PART_17("G","R"),
	PART_18("H","V"),
	PART_19("I","W"),
	PART_20("J","X"),
	;
	
	public static int LENGTH = 20;
	private final String identifier;
	private final String identifierAlt;
	private static final BasePartIdentifierAltInfo ALT_INFO = new BasePartIdentifierAltInfo(
			"Open Location Code","https://en.wikipedia.org/wiki/Open_Location_Code");
	
	private T20PartScore(String identifier, String identifierAlt) {
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
	
	public static void forEach(Consumer<T20PartScore> consumer) {
		for (T20PartScore value:values()) {
			consumer.accept(value);
		}
	}
}