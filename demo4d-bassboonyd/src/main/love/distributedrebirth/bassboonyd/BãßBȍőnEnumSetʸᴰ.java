package love.distributedrebirth.bassboonyd;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface BãßBȍőnEnumSetʸᴰ<T> extends BãßBȍőnEnumʸᴰ<T> {

	int ordinal();
	
	default int BȍőnRangTelNul() {
		return ordinal();
	}
	
	default int BȍőnRangTelEen() {
		return ordinal() + 1;
	}
	
	default List<T> BãßInstancesList() {
		return Arrays.asList(BãßInstances());
	}
	
	default Iterator<T> BãßInstancesIterator() {
		return BãßInstancesList().iterator();
	}
	
	default Stream<T> BãßInstancesStream() {
		return BãßInstancesList().stream();
	}
	
	default T BȍőnVolgende() {
		T[] values = BãßInstances();
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
	
	default T BȍőnVorige() {
		T[] values = BãßInstances();
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
	
	default void BãßVoorElk(Consumer<T> consumer) {
		for (T value:BãßInstances()) {
			consumer.accept(value);
		}
	}
}
