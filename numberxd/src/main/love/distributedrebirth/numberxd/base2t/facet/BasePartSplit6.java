package love.distributedrebirth.numberxd.base2t.facet;

import love.distributedrebirth.numberxd.base2t.T02PartBinary;
import love.distributedrebirth.numberxd.base2t.T03PartTrit;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public interface BasePartSplit6 extends BasePart {

	default T02PartBinary splitPartBinary() {
		return T02PartBinary.values()[ordinal() & 1];
	}
	
	default T03PartTrit splitPartTrit() {
		return T03PartTrit.values()[ordinal() >> 1];
	}
}
