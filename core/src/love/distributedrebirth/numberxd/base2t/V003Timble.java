package love.distributedrebirth.numberxd.base2t;

/**
 * Holds an 3 bit value.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public final class V003Timble implements BaseNumber<V003Timble> {

	public static int BIT_COUNT = T08PartOctal.BIT_COUNT;
	private final T08PartOctal value;
	
	public V003Timble() {
		this(T08PartOctal.PART_1);
	}
	
	public V003Timble(T08PartOctalBaseIterator values) {
		this(values.next());
	}
	
	public V003Timble(T08PartOctal value) {
		this.value = value;
	}
	
	public T08PartOctal getValue() {
		return value;
	}
	
	@Override
	public int getBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public V003Timble toClone() {
		return new V003Timble(getValue());
	}
	
	@Override
	public void fillOctalsByClone(T08PartOctalBaseAppender appender) {
		appender.add(getValue());
	}
}
