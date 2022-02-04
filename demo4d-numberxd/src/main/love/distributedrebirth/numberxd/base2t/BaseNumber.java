package love.distributedrebirth.numberxd.base2t;

import java.util.ArrayList;
import java.util.List;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.T08PartOctal;

/**
 * Octal base based number interface.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface BaseNumber<V extends BaseNumber<V>> {
	
	static float CIRCLE_DEGREE = 360f;
	
	int getBitCount();
	
	default float getSliceAngle() {
		return CIRCLE_DEGREE/getBitCount();
	}
	
	V toClone();
	
	void fillOctalsByClone(BaseAppenderOctal appender);
	
	default BaseIteratorOctal iteratorOctalsByClone() {
		List<T08PartOctal> octals = new ArrayList<>();
		fillOctalsByClone(new BaseAppenderOctal(octals));
		return new BaseIteratorOctalAdapter(octals.iterator());
	}
}
