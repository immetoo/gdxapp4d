package love.distributedrebirth.numberxd.base2t.bone;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public interface BassBoneAlt4<T extends BassBone<T>> extends BassBoneAlt3<T> {

	default String getAlt4Value() {
		return GET_BBC().GET_STR(BassBoneStoreKey.ALT_4_VALUE);
	}
	
	default String staticAlt4Name() {
		return getClass().getAnnotation(BassBoneAlt4Info.class).name();
	}
	
	default String staticAlt4Website() {
		return getClass().getAnnotation(BassBoneAlt4Info.class).website();
	}
}
