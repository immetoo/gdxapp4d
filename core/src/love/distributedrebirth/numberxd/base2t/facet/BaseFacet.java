package love.distributedrebirth.numberxd.base2t.facet;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public interface BaseFacet extends BaseFacetStore {

	int ordinal();
	
	default String getIdentifierTone() {
		return (String)getFacetStore().get(BaseFacetKey.ID_TONE);
	}
	
	default String getIdentifierLetter() {
		return (String)getFacetStore().get(BaseFacetKey.ID_LETTER);
	}
	
	default String getChinaKey() {
		return (String)getFacetStore().get(BaseFacetKey.CHINA_KEY);
	}
	
	default String getChinaValue() {
		return (String)getFacetStore().get(BaseFacetKey.CHINA_VALUE);
	}
}
