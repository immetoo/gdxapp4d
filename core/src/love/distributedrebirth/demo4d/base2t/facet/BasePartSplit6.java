package love.distributedrebirth.demo4d.base2t.facet;

import love.distributedrebirth.demo4d.base2t.T02PartBinary;
import love.distributedrebirth.demo4d.base2t.T03PartTrit;

public interface BasePartSplit6 extends BaseFacet {

	default T02PartBinary splitPartBinary() {
		return T02PartBinary.values()[ordinal() & 1];
	}
	
	default T03PartTrit splitPartTrit() {
		return T03PartTrit.values()[ordinal() >> 1];
	}
}
