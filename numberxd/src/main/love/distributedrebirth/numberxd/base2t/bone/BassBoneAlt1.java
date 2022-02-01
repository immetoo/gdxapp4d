package love.distributedrebirth.numberxd.base2t.bone;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public interface BassBoneAlt1<T extends BassBone<T>> extends BassBone<T> {

	default String getAlt1Value() {
		return GET_BBC().GET_STR(BassBoneStoreKey.ALT_1_VALUE);
	}
	
	default String staticAlt1Name() {
		return getClass().getAnnotation(BassBoneAlt1Info.class).name();
	}
	
	default String staticAlt1Website() {
		return getClass().getAnnotation(BassBoneAlt1Info.class).website();
	}
}
