package love.distributedrebirth.numberxd.base2t.facet;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public interface BasePartAlt3 extends BasePartAlt2 {

	default String getAlt3Value() {
		return getBFM().getString(BaseFacetKey.ALT_3_VALUE);
	}
	
	default String getAlt3Name() {
		return getBFM().getString(BaseFacetKey.ALT_3_NAME);
	}
	
	default String getAlt3Wiki() {
		return getBFM().getString(BaseFacetKey.ALT_3_WIKI);
	}
}
