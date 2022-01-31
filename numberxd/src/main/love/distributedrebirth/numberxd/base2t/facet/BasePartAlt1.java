package love.distributedrebirth.numberxd.base2t.facet;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public interface BasePartAlt1 extends BasePart {

	default String getAlt1Value() {
		return (String)getFacetStore().get(BaseFacetKey.ALT_1_VALUE);
	}
	
	default String getAlt1Name() {
		return (String)getFacetStore().get(BaseFacetKey.ALT_1_NAME);
	}
	
	default String getAlt1Wiki() {
		return (String)getFacetStore().get(BaseFacetKey.ALT_1_WIKI);
	}
}
