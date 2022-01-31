package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.numberxd.base2t.facet.BasePart;

public final class BasePartFactory {

	private static final int[] SUPPORTED_BASES = {2,3,4,5,6,7,8,12,16,20,60};
	
	public static int[] getSupportedBases() {
		return SUPPORTED_BASES;
	}
	
	public static BasePart[] buildBasePartsByBase(int base) {
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
			throw new IllegalArgumentException("Unsupported base: "+base);
		case 10:
			throw new IllegalArgumentException("Unsupported base: "+base);
		case 11:
			throw new IllegalArgumentException("Unsupported base: "+base);
		case 12:
			return T12PartUncial.values();
		case 16:
			return T16PartHex.values();
		case 20:
			return T20PartScore.values();
		case 60:
			return T60Sexagesimal.values();
		default:
			throw new IllegalArgumentException("Unsupported base: "+base);
		}
	}
}