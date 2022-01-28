package love.distributedrebirth.demo4d.base2t;

import java.util.ArrayList;
import java.util.List;

public interface BaseNumber<V extends BaseNumber<V>> {
	
	int getBitCount();
	
	default int getSliceAngle() {
		return 360/getBitCount();
	}
	
	V toClone();
	
	void fillOctalValues(T08PartOctalBaseAppender appender);
	
	default T08PartOctalIterator cloneIterator() {
		List<T08PartOctal> octals = new ArrayList<>();
		fillOctalValues(new T08PartOctalBaseAppender(octals));
		return new T08PartOctalIterator(octals.iterator());
	}
}
