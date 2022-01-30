package love.distributedrebirth.demo4d.base2t.facet;

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
