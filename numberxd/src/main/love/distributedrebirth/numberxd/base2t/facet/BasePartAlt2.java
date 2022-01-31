package love.distributedrebirth.numberxd.base2t.facet;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public interface BasePartAlt2 extends BasePartAlt1 {

	default String getAlt2Value() {
		return (String)getFacetStore().get(BaseFacetKey.ALT_2_VALUE);
	}
	
	default String getAlt2Name() {
		return (String)getFacetStore().get(BaseFacetKey.ALT_2_NAME);
	}
	
	default String getAlt2Wiki() {
		return (String)getFacetStore().get(BaseFacetKey.ALT_2_WIKI);
	}
}
