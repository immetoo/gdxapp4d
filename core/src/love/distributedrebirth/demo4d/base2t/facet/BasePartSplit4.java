package love.distributedrebirth.demo4d.base2t.facet;

import love.distributedrebirth.demo4d.base2t.T02PartBinary;

public interface BasePartSplit4 extends BaseFacet {

	default T02PartBinary splitPartBinary(T02PartBinary part) {
		return T02PartBinary.values()[(ordinal() >> part.ordinal()) & 1];
	}
}
