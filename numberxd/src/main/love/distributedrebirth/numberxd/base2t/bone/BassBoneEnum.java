package love.distributedrebirth.numberxd.base2t.bone;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public interface BassBoneEnum<T> {

	int ordinal();
	
	String name();
	
	default String naam() {
		return name(); // Deutsche code
	}
}
