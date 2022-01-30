package love.distributedrebirth.demo4d.base2t.facet;

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