package love.distributedrebirth.demo4d.base2t;

public final class V072Tong implements BaseNumberTyte<V072Tong> {

	private V036Teger[] values = new V036Teger[T02PartBinary.LENGTH];
	
	public V072Tong() {
		this(new V036Teger(), new V036Teger());
	}
	
	public V072Tong(T08PartOctalIterator values) {
		this(new V036Teger(values), new V036Teger(values));
	}
	
	public V072Tong(V009TyteIterator values) {
		this(new V036Teger(values), new V036Teger(values));
	}
	
	public V072Tong(V036Teger valueHigh, V036Teger valueLow) {
		setValue(T02PartBinary.PART_1, valueHigh);
		setValue(T02PartBinary.PART_2, valueLow);
	}
	
	public V036Teger getValue(T02PartBinary part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T02PartBinary part, V036Teger value) {
		values[part.ordinal()] = value;
	}
	
	@Override
	public int getBitCount() {
		return T08PartOctal.BIT_COUNT * T12PartUncial.LENGTH * T02PartBinary.LENGTH;
	}
	
	@Override
	public V072Tong toClone() {
		return new V072Tong(cloneIterator());
	}
	
	@Override
	public void fillOctalValues(T08PartOctalBaseAppender appender) {
		T02PartBinary.forEach(v -> getValue(v).fillOctalValues(appender));
	}

	@Override
	public void fillTyteValues(V009TyteBaseAppender appender) {
		T02PartBinary.forEach(v -> getValue(v).fillTyteValues(appender));
	}
}
