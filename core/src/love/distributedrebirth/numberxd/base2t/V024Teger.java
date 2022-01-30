package love.distributedrebirth.numberxd.base2t;

/**
 * Holds an 36 bit value.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public final class V024Teger implements BaseNumberTyte<V024Teger> {

	public static int BIT_COUNT = V012Tord.BIT_COUNT * T02PartBinary.LENGTH;
	private V012Tord[] values = new V012Tord[T02PartBinary.LENGTH];
	
	public V024Teger() {
		this(new V012Tord(), new V012Tord());
	}
	
	public V024Teger(T08PartOctalBaseIterator values) {
		this(new V012Tord(values), new V012Tord(values));
	}
	
	public V024Teger(V009TyteBaseIterator values) {
		this(new V012Tord(values), new V012Tord(values));
	}
	
	private V024Teger(V012Tord valueHigh, V012Tord valueLow) {
		setValue(T02PartBinary.PART_1, valueHigh);
		setValue(T02PartBinary.PART_2, valueLow);
	}
	
	public V012Tord getValue(T02PartBinary part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T02PartBinary part, V012Tord value) {
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
		return BIT_COUNT;
	}
	
	@Override
	public V024Teger toClone() {
		return new V024Teger(cloneIterator());
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
