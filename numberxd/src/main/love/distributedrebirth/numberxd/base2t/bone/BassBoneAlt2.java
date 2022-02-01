package love.distributedrebirth.numberxd.base2t.bone;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public interface BassBoneAlt2<T extends BassBone<T>> extends BassBoneAlt1<T> {

	default String getAlt2Value() {
		return GET_BBC().GET_STR(BassBoneStoreKey.ALT_2_VALUE);
	}
	
	default String staticAlt2Name() {
		return getClass().getAnnotation(BassBoneAlt2Info.class).name();
	}
	
	default String staticAlt2Website() {
		return getClass().getAnnotation(BassBoneAlt2Info.class).website();
	}
}
