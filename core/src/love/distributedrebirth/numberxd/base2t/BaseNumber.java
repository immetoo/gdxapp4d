package love.distributedrebirth.numberxd.base2t;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public interface BaseNumber<V extends BaseNumber<V>> {
	
	int getBitCount();
	
	default int getSliceAngle() {
		return 360/getBitCount();
	}
	
	V toClone();
	
	void fillOctalValues(T08PartOctalBaseAppender appender);
	
	default T08PartOctalBaseIterator cloneIterator() {
		List<T08PartOctal> octals = new ArrayList<>();
		fillOctalValues(new T08PartOctalBaseAppender(octals));
		return new T08PartOctalBaseIterator(octals.iterator());
	}
}
