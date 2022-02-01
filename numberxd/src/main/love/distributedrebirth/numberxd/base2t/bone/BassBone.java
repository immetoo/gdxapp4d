package love.distributedrebirth.numberxd.base2t.bone;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public interface BassBone extends BassBoneStore {

	String name();
	
	int ordinal();
	
	default String staticBoneName() {
		return getClass().getAnnotation(BassBoneName.class).value();
	}
	
	default String getIdentifierTone() {
		return getBBC().getString(BassBoneStoreKey.ID_TONE);
	}
	
	default String getIdentifierLetter() {
		return getBBC().getString(BassBoneStoreKey.ID_LETTER);
	}
	
	default String getChinaKey() {
		return getBBC().getString(BassBoneStoreKey.CHINA_KEY);
	}
	
	default String getChinaValue() {
		return getBBC().getString(BassBoneStoreKey.CHINA_VALUE);
	}
}
