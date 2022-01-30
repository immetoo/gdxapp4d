package love.distributedrebirth.demo4d.base2t;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public final class V072Tong implements BaseNumberTyte<V072Tong> {

	public static int BIT_COUNT = V036Teger.BIT_COUNT * T02PartBinary.LENGTH;
	private V036Teger[] values = new V036Teger[T02PartBinary.LENGTH];
	
	public V072Tong() {
		this(new V036Teger(), new V036Teger());
	}
	
	public V072Tong(T08PartOctalBaseIterator values) {
		this(new V036Teger(values), new V036Teger(values));
	}
	
	public V072Tong(V009TyteBaseIterator values) {
		this(new V036Teger(values), new V036Teger(values));
	}
	
	private V072Tong(V036Teger valueHigh, V036Teger valueLow) {
		setValue(T02PartBinary.PART_1, valueHigh);
		setValue(T02PartBinary.PART_2, valueLow);
	}
	
	public V036Teger getValue(T02PartBinary part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T02PartBinary part, V036Teger value) {
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
