package love.distributedrebirth.bassboonyd;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Inject EnumSet methods.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public interface BãßBȍőnEnumSetʸᴰ<T> extends BãßBȍőnEnumʸᴰ<T> {

	int ordinal();
	
	default int dingRangTelNul() {
		return ordinal();
	}
	
	default int dingRangTelEen() {
		return ordinal() + 1;
	}
	
	@SuppressWarnings("unchecked")
	default T[] staticInstances() {
		try {
			Object result = getClass().getMethod(BãßBȍőnConstants.STR_VALUES).invoke(null);
			return (T[]) result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	default List<T> staticInstancesList() {
		return Arrays.asList(staticInstances());
	}
	
	default Iterator<T> staticInstancesIterator() {
		return staticInstancesList().iterator();
	}
	
	default Stream<T> staticInstancesStream() {
		return staticInstancesList().stream();
	}
	
	default T volgende() {
		T[] values = staticInstances();
		int resultIndex = 0;
		for (int i=0;i<values.length;i++) {
			if (this == values[i]) {
				resultIndex = i + 1;
				break;
			}
		}
		if (resultIndex == values.length) {
			resultIndex = 0;
		}
		return values[resultIndex];
	}
	
	default T vorige() {
		T[] values = staticInstances();
		int resultIndex = 0;
		for (int i=0;i<values.length;i++) {
			if (this == values[i]) {
				resultIndex = i - 1;
				break;
			}
		}
		if (resultIndex < 0) {
			resultIndex = values.length - 1;
		}
		return values[resultIndex];
	}
	
	default void staticVoorElk(Consumer<T> consumer) {
		for (T value:staticInstances()) {
			consumer.accept(value);
		}
	}
}
