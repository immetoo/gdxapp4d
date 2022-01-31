package love.distributedrebirth.numberxd.base2t.facet;

import love.distributedrebirth.numberxd.base2t.T02PartBinary;
import love.distributedrebirth.numberxd.base2t.T04PartQuad;

public interface BasePartSplit16 extends BasePart {

	default T02PartBinary splitPartBinary(T04PartQuad part) {
		return T02PartBinary.values()[(ordinal() >> part.ordinal()) & 1];
	}
}
