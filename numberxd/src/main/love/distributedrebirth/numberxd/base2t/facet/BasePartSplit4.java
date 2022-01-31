package love.distributedrebirth.numberxd.base2t.facet;

import love.distributedrebirth.numberxd.base2t.T02PartBinary;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public interface BasePartSplit4 extends BasePart {

	default T02PartBinary splitPartBinary(T02PartBinary part) {
		return T02PartBinary.values()[(ordinal() >> part.ordinal()) & 1];
	}
}
