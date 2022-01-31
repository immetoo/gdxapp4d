package love.distributedrebirth.numberxd.base2t.facet;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public interface BasePartAlt3 extends BasePartAlt2 {

	default String getAlt3Value() {
		return (String)getFacetStore().get(BaseFacetKey.ALT_3_VALUE);
	}
	
	default String getAlt3Name() {
		return (String)getFacetStore().get(BaseFacetKey.ALT_3_NAME);
	}
	
	default String getAlt3Wiki() {
		return (String)getFacetStore().get(BaseFacetKey.ALT_3_WIKI);
	}
}
