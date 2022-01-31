package love.distributedrebirth.numberxd.base2t.facet;

public interface BasePartShiftBits extends BasePart {

	default Integer getShiftBits() {
		return (Integer)getFacetStore().get(BaseFacetKey.SHIFT_BITS);
	}
}
