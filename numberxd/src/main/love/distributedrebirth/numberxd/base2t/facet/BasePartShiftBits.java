package love.distributedrebirth.numberxd.base2t.facet;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public interface BasePartShiftBits extends BasePart {

	default Integer getShiftBits() {
		return getBFM().getInteger(BaseFacetKey.SHIFT_BITS);
	}
}
