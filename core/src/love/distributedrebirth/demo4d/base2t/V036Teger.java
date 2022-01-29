package love.distributedrebirth.demo4d.base2t;

public final class V036Teger implements BaseNumberTyte<V036Teger> {

	private V018Tord[] values = new V018Tord[T02PartBinary.LENGTH];
	
	public V036Teger() {
		this(new V018Tord(), new V018Tord());
	}
	
	public V036Teger(T08PartOctalBaseIterator values) {
		this(new V018Tord(values), new V018Tord(values));
	}
	
	public V036Teger(V009TyteBaseIterator values) {
		this(new V018Tord(values), new V018Tord(values));
	}
	
	public V036Teger(V018Tord valueHigh, V018Tord valueLow) {
		setValue(T02PartBinary.PART_1, valueHigh);
		setValue(T02PartBinary.PART_2, valueLow);
	}
	
	public V018Tord getValue(T02PartBinary part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T02PartBinary part, V018Tord value) {
		values[part.ordinal()] = value;
	}
	
	public V009Tyte getTytePart(T04PartQuad part) {
		return getValue(part.splitPartBinary(T02PartBinary.PART_1))
				.getValue(part.splitPartBinary(T02PartBinary.PART_2));
	}
	
	public void setTytePart(T04PartQuad part, V009Tyte value) {
		getValue(part.splitPartBinary(T02PartBinary.PART_1))
		.setValue(part.splitPartBinary(T02PartBinary.PART_2), value);
	}
	
	@Override
	public int getBitCount() {
		return T08PartOctal.BIT_COUNT * T12PartUncial.LENGTH;
	}
	
	@Override
	public V036Teger toClone() {
		return new V036Teger(cloneIterator());
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
