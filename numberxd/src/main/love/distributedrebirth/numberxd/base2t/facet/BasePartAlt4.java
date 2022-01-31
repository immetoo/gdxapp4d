package love.distributedrebirth.numberxd.base2t.facet;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public interface BasePartAlt4 extends BasePartAlt3 {

	default String getAlt4Value() {
		return (String)getFacetStore().get(BaseFacetKey.ALT_4_VALUE);
	}
	
	default String getAlt4Name() {
		return (String)getFacetStore().get(BaseFacetKey.ALT_4_NAME);
	}
	
	default String getAlt4Wiki() {
		return (String)getFacetStore().get(BaseFacetKey.ALT_4_WIKI);
	}
}
