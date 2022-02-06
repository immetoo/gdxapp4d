package love.distributedrebirth.numberxd.base2t;

import java.util.ArrayList;
import java.util.List;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.type.V009Tyte;

/**
 * Adds Tyte fill and reference support.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface BaseNumberTyte<V extends BaseNumber<V>> extends BaseNumber<V> {
	
	void fillTytesByReference(BaseAppenderTyte appender);
	
	default BaseIteratorTyte iteratorTytesByReference() {
		List<V009Tyte> tytes = new ArrayList<>();
		fillTytesByReference(new BaseAppenderTyte(tytes));
		return new BaseIteratorTyte(tytes.iterator());
	}
}
