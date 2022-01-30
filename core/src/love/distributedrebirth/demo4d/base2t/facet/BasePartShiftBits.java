package love.distributedrebirth.demo4d.base2t.facet;

public interface BasePartShiftBits extends BaseFacet {

	default Integer getShiftBits() {
		return (Integer)getFacetStore().get(BaseFacetKey.SHIFT_BITS);
	}
}
