package love.distributedrebirth.numberxd.base2t.bone;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public interface BassBoneAlt3<T extends BassBone<T>> extends BassBoneAlt2<T> {

	default String getAlt3Value() {
		return getBBC().getString(BassBoneStoreKey.ALT_3_VALUE);
	}
	
	default String staticAlt3Name() {
		return getClass().getAnnotation(BassBoneAlt3Info.class).name();
	}
	
	default String staticAlt3Website() {
		return getClass().getAnnotation(BassBoneAlt3Info.class).website();
	}
}
