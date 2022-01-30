package love.distributedrebirth.demo4d.base2t.facet;

public interface BasePartAlt1 extends BaseFacet {

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
