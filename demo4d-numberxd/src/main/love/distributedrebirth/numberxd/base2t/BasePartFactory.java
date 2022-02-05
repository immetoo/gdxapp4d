package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnEnumInstanceʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.T02PartBinary;
import love.distributedrebirth.numberxd.base2t.part.T03PartTrit;
import love.distributedrebirth.numberxd.base2t.part.T04PartQuad;
import love.distributedrebirth.numberxd.base2t.part.T05PartPental;
import love.distributedrebirth.numberxd.base2t.part.T06PartSeximal;
import love.distributedrebirth.numberxd.base2t.part.T07PartPlanIt;
import love.distributedrebirth.numberxd.base2t.part.T08PartOctal;
import love.distributedrebirth.numberxd.base2t.part.T09PartNonary;
import love.distributedrebirth.numberxd.base2t.part.T10PartDecimal;
import love.distributedrebirth.numberxd.base2t.part.T11PartUndecimal;
import love.distributedrebirth.numberxd.base2t.part.T12PartUncial;
import love.distributedrebirth.numberxd.base2t.part.T16PartHex;
import love.distributedrebirth.numberxd.base2t.part.T20PartScore;
import love.distributedrebirth.numberxd.base2t.part.T60PartSexagesimal;
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnClassInfoʸᴰ(name = "BasePartFactory", purpose = "Factory to access the bases.")
public enum BasePartFactory implements BãßBȍőnEnumInstanceʸᴰ<BasePartFactory> {

	INSTANCE;
	
	private static final int[] SUPPORTED_BASES = {2,3,4,5,6,7,8,9,10,11,12,16,20,60};
	
	public int[] BãßBases() {
		return SUPPORTED_BASES;
	}
	
	public BãßBȍőnPartʸᴰ<?>[] BãßBuildPartsByBase(int base) {
		switch (base) {
		case 2:
			return T02PartBinary.values();
		case 3:
			return T03PartTrit.values();
		case 4:
			return T04PartQuad.values();
		case 5:
			return T05PartPental.values();
		case 6:
			return T06PartSeximal.values();
		case 7:
			return T07PartPlanIt.values();
		case 8:
			return T08PartOctal.values();
		case 9:
			return T09PartNonary.values();
		case 10:
			return T10PartDecimal.values();
		case 11:
			return T11PartUndecimal.values();
		case 12:
			return T12PartUncial.values();
		case 16:
			return T16PartHex.values();
		case 20:
			return T20PartScore.values();
		case 60:
			return T60PartSexagesimal.values();
		default:
			throw new IllegalArgumentException("Unsupported base: "+base);
		}
	}
}
