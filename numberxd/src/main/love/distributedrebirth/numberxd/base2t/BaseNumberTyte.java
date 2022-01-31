package love.distributedrebirth.numberxd.base2t;

import java.util.ArrayList;
import java.util.List;

/**
 * Adds Tyte fill and reference support.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public interface BaseNumberTyte<V extends BaseNumber<V>> extends BaseNumber<V> {
	
	void fillTytesByReference(V009TyteBaseAppender appender);
	
	default V009TyteBaseIterator iteratorTytesByReference() {
		List<V009Tyte> tytes = new ArrayList<>();
		fillTytesByReference(new V009TyteBaseAppender(tytes));
		return new V009TyteBaseIterator(tytes.iterator());
	}
}
