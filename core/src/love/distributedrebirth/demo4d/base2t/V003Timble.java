package love.distributedrebirth.demo4d.base2t;

public final class V003Timble implements BaseNumber<V003Timble> {

	private T08PartOctal value;
	
	public V003Timble() {
		this(T08PartOctal.PART_1);
	}
	
	public V003Timble(T08PartOctalBaseIterator values) {
		this(values.next());
	}
	
	public V003Timble(T08PartOctal value) {
		setValue(value);
	}
	
	public void setValue(T08PartOctal value) {
		this.value = value;
	}
	
	public T08PartOctal getValue() {
		return value;
	}
	
	@Override
	public int getBitCount() {
		return T08PartOctal.BIT_COUNT;
	}
	
	@Override
	public V003Timble toClone() {
		return new V003Timble(getValue());
	}
	
	@Override
	public void fillOctalValues(T08PartOctalBaseAppender appender) {
		appender.add(getValue());
	}
}
