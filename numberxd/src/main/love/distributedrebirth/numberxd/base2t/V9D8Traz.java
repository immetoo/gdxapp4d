package love.distributedrebirth.numberxd.base2t;

/**
 * Holds an 2520 bit value.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class V9D8Traz implements BaseNumber<V9D8Traz> {

	public static int BIT_COUNT = V02ATraw.BIT_COUNT * T60Sexagesimal.LENGTH();
	private V02ATraw[] values = new V02ATraw[T60Sexagesimal.LENGTH()];
	
	public V9D8Traz() {
		for (int i=0;i<values.length;i++) {
			this.values[i] = new V02ATraw();
		}
	}
	
	public V9D8Traz(T08PartOctalBaseIterator values) {
		for (int i=0;i<this.values.length;i++) {
			this.values[i] = new V02ATraw(values);
		}
	}
	
	public V02ATraw getValue(T60Sexagesimal part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T60Sexagesimal part, V02ATraw value) {
		values[part.ordinal()] = value;
	}
	
	@Override
	public int getBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public V9D8Traz toClone() {
		return new V9D8Traz(iteratorOctalsByClone());
	}
	
	@Override
	public void fillOctalsByClone(T08PartOctalBaseAppender appender) {
		T60Sexagesimal.forEach(v -> getValue(v).fillOctalsByClone(appender));
	}
}
