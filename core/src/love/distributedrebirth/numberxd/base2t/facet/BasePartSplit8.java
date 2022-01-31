package love.distributedrebirth.numberxd.base2t.facet;

import love.distributedrebirth.numberxd.base2t.T02PartBinary;
import love.distributedrebirth.numberxd.base2t.T03PartTrit;
import love.distributedrebirth.numberxd.base2t.T08PartOctal;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public interface BasePartSplit8 extends BasePartShiftBits {

	default T02PartBinary splitPartBinary(T03PartTrit part) {
		return T02PartBinary.values()[(ordinal() >> part.ordinal()) & 1];
	}
	
	default int ordinalOf(T08PartOctal group) {
		return ordinal() << group.getShiftBits();
	}
}
