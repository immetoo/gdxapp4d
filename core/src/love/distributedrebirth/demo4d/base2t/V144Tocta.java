package love.distributedrebirth.demo4d.base2t;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public final class V144Tocta implements BaseNumberTyte<V144Tocta> {

	public static int BIT_COUNT = V072Tong.BIT_COUNT * T02PartBinary.LENGTH;
	private V072Tong[] values = new V072Tong[T02PartBinary.LENGTH];
	
	public V144Tocta() {
		this(new V072Tong(), new V072Tong());
	}
	
	public V144Tocta(T08PartOctalBaseIterator values) {
		this(new V072Tong(values), new V072Tong(values));
	}
	
	public V144Tocta(V009TyteBaseIterator values) {
		this(new V072Tong(values), new V072Tong(values));
	}
	
	public V144Tocta(V072Tong valueHigh, V072Tong valueLow) {
		setValue(T02PartBinary.PART_1, valueHigh);
		setValue(T02PartBinary.PART_2, valueLow);
	}
	
	public V072Tong getValue(T02PartBinary part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T02PartBinary part, V072Tong value) {
		values[part.ordinal()] = value;
	}
	
	public V009Tyte getTytePart(T16PartHex part) {
		return getValue(part.splitPartBinary(T04PartQuad.PART_1))
				.getValue(part.splitPartBinary(T04PartQuad.PART_2))
				.getValue(part.splitPartBinary(T04PartQuad.PART_3))
				.getValue(part.splitPartBinary(T04PartQuad.PART_4));
	}
	
	public void setTytePart(T16PartHex part, V009Tyte value) {
		getValue(part.splitPartBinary(T04PartQuad.PART_1))
		.getValue(part.splitPartBinary(T04PartQuad.PART_2))
		.getValue(part.splitPartBinary(T04PartQuad.PART_3))
		.setValue(part.splitPartBinary(T04PartQuad.PART_4), value);
	}
	
	public V018Tord getTordPart(T08PartOctal part) {
		return getValue(part.splitPartBinary(T03PartTrit.PART_1))
			.getValue(part.splitPartBinary(T03PartTrit.PART_2))
			.getValue(part.splitPartBinary(T03PartTrit.PART_3));
	}
	
	public void setTordPart(T08PartOctal part, V018Tord value) {
		getValue(part.splitPartBinary(T03PartTrit.PART_1))
		.getValue(part.splitPartBinary(T03PartTrit.PART_2))
		.setValue(part.splitPartBinary(T03PartTrit.PART_3), value);
	}
	
	@Override
	public int getBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public V144Tocta toClone() {
		return new V144Tocta(cloneIterator());
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
