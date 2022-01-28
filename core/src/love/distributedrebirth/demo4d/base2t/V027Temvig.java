package love.distributedrebirth.demo4d.base2t;

public final class V027Temvig implements BaseNumberTyte<V027Temvig> {

	private V009Tyte[] values = new V009Tyte[T03PartTrit.LENGTH];
	
	public V027Temvig() {
		this(new V009Tyte(), new V009Tyte(), new V009Tyte());
	}
	
	public V027Temvig(T08PartOctalIterator values) {
		this(new V009Tyte(values), new V009Tyte(values), new V009Tyte(values));
	}
	
	public V027Temvig(V009TyteIterator values) {
		this(values.next(), values.next(), values.next());
	}
	
	public V027Temvig(V009Tyte valueHigh, V009Tyte valueMedium, V009Tyte valueLow) {
		setValue(T03PartTrit.PART_1, valueHigh);
		setValue(T03PartTrit.PART_2, valueMedium);
		setValue(T03PartTrit.PART_3, valueLow);
	}
	
	public V009Tyte getValue(T03PartTrit part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T03PartTrit part, V009Tyte value) {
		values[part.ordinal()] = value;
	}
	
	@Override
	public int getBitCount() {
		return T08PartOctal.BIT_COUNT * T03PartTrit.LENGTH * T03PartTrit.LENGTH;
	}
	
	@Override
	public V027Temvig toClone() {
		return new V027Temvig(cloneIterator());
	}
	
	@Override
	public void fillOctalValues(T08PartOctalBaseAppender appender) {
		T03PartTrit.forEach(v -> getValue(v).fillOctalValues(appender));
	}

	@Override
	public void fillTyteValues(V009TyteBaseAppender appender) {
		T03PartTrit.forEach(v -> getValue(v).fillTyteValues(appender));
	}
}
