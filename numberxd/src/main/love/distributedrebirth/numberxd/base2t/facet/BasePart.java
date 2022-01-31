package love.distributedrebirth.numberxd.base2t.facet;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public interface BasePart extends BaseFacetStore {

	int ordinal();
	
	default String getIdentifierTone() {
		return getBFM().getString(BaseFacetKey.ID_TONE);
	}
	
	default String getIdentifierLetter() {
		return getBFM().getString(BaseFacetKey.ID_LETTER);
	}
	
	default String getChinaKey() {
		return getBFM().getString(BaseFacetKey.CHINA_KEY);
	}
	
	default String getChinaValue() {
		return getBFM().getString(BaseFacetKey.CHINA_VALUE);
	}
}
