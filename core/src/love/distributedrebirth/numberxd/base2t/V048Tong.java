package love.distributedrebirth.numberxd.base2t;

/**
 * Holds an 72 bit value.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public final class V048Tong implements BaseNumberTyte<V048Tong> {

	public static int BIT_COUNT = V024Teger.BIT_COUNT * T02PartBinary.LENGTH;
	private V024Teger[] values = new V024Teger[T02PartBinary.LENGTH];
	
	public V048Tong() {
		this(new V024Teger(), new V024Teger());
	}
	
	public V048Tong(T08PartOctalBaseIterator values) {
		this(new V024Teger(values), new V024Teger(values));
	}
	
	public V048Tong(V009TyteBaseIterator values) {
		this(new V024Teger(values), new V024Teger(values));
	}
	
	private V048Tong(V024Teger valueHigh, V024Teger valueLow) {
		setValue(T02PartBinary.PART_1, valueHigh);
		setValue(T02PartBinary.PART_2, valueLow);
	}
	
	public V024Teger getValue(T02PartBinary part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T02PartBinary part, V024Teger value) {
		values[part.ordinal()] = value;
	}
	
	public V009Tyte getTytePart(T08PartOctal part) {
		return getValue(part.splitPartBinary(T03PartTrit.PART_1))
				.getValue(part.splitPartBinary(T03PartTrit.PART_2))
				.getValue(part.splitPartBinary(T03PartTrit.PART_3));
	}
	
	public void setTytePart(T08PartOctal part, V009Tyte value) {
		getValue(part.splitPartBinary(T03PartTrit.PART_1))
		.getValue(part.splitPartBinary(T03PartTrit.PART_2))
		.setValue(part.splitPartBinary(T03PartTrit.PART_3), value);
	}
	
	@Override
	public int getBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public V048Tong toClone() {
		return new V048Tong(cloneIterator());
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
