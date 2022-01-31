package love.distributedrebirth.numberxd.base2t;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public interface BaseNumber<V extends BaseNumber<V>> {
	
	static float CIRCLE_DEGREE = 360f;
	
	int getBitCount();
	
	default float getSliceAngle() {
		return CIRCLE_DEGREE/getBitCount();
	}
	
	V toClone();
	
	void fillOctalsByClone(T08PartOctalBaseAppender appender);
	
	default T08PartOctalBaseIterator iteratorOctalsByClone() {
		List<T08PartOctal> octals = new ArrayList<>();
		fillOctalsByClone(new T08PartOctalBaseAppender(octals));
		return new T08PartOctalBaseIterator(octals.iterator());
	}
}
