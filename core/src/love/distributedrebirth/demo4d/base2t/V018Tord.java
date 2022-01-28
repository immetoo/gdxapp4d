package love.distributedrebirth.demo4d.base2t;

public final class V018Tord implements BaseNumberTyte<V018Tord> {

	private V009Tyte[] values = new V009Tyte[T02PartBinary.LENGTH];
	
	public V018Tord() {
		this(new V009Tyte(), new V009Tyte());
	}
	
	public V018Tord(T08PartOctalIterator values) {
		this(new V009Tyte(values), new V009Tyte(values));
	}
	
	public V018Tord(V009TyteIterator values) {
		this(values.next(), values.next());
	}
	
	public V018Tord(V009Tyte valueHigh, V009Tyte valueLow) {
		setValue(T02PartBinary.PART_1, valueHigh);
		setValue(T02PartBinary.PART_2, valueLow);
	}
	
	public V009Tyte getValue(T02PartBinary part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T02PartBinary part, V009Tyte value) {
		values[part.ordinal()] = value;
	}
	
	public V003Timble getTimblePart(T06PartSeximal part) {
		return getValue(part.splitPartBinary()).getValue(part.splitPartTrit());
	}
	
	public void setTimblePart(T06PartSeximal part, V003Timble value) {
		getValue(part.splitPartBinary()).setValue(part.splitPartTrit(), value);;
	}
	
	@Override
	public V018Tord toClone() {
		return new V018Tord(cloneIterator());
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
