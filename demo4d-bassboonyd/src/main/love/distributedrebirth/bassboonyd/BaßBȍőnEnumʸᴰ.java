package love.distributedrebirth.bassboonyd;

/**
 * Inject Enum methods.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public interface BaßBȍőnEnumʸᴰ<T> {

	int ordinal();
	
	String name();
	
	default String naam() {
		return name(); // Deutsche code
	}
}
