package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

/**
 * Holds an 144 bit value.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public final class V090Tocta implements BaseNumberTyte<V090Tocta> {

	public static int BIT_COUNT = V048Tong.BIT_COUNT * T02PartBinary.LENGTH();
	private V048Tong[] values = new V048Tong[T02PartBinary.LENGTH()];
	
	public V090Tocta() {
		this(new V048Tong(), new V048Tong());
	}
	
	public V090Tocta(BaseIteratorOctal values) {
		this(new V048Tong(values), new V048Tong(values));
	}
	
	public V090Tocta(BaseIteratorTyte values) {
		this(new V048Tong(values), new V048Tong(values));
	}
	
	private V090Tocta(V048Tong valueHigh, V048Tong valueLow) {
		setValue(T02PartBinary.PART_1, valueHigh);
		setValue(T02PartBinary.PART_2, valueLow);
	}
	
	public V048Tong getValue(T02PartBinary part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T02PartBinary part, V048Tong value) {
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
	
	public V012Tord getTordPart(T08PartOctal part) {
		return getValue(part.splitPartBinary(T03PartTrit.PART_1))
			.getValue(part.splitPartBinary(T03PartTrit.PART_2))
			.getValue(part.splitPartBinary(T03PartTrit.PART_3));
	}
	
	public void setTordPart(T08PartOctal part, V012Tord value) {
		getValue(part.splitPartBinary(T03PartTrit.PART_1))
		.getValue(part.splitPartBinary(T03PartTrit.PART_2))
		.setValue(part.splitPartBinary(T03PartTrit.PART_3), value);
	}
	
	@Override
	public int getBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public V090Tocta toClone() {
		return new V090Tocta(iteratorOctalsByClone());
	}
	
	@Override
	public void fillOctalsByClone(BaseAppenderOctal appender) {
		T02PartBinary.PART_1.staticVoorElk(v -> getValue(v).fillOctalsByClone(appender));
	}

	@Override
	public void fillTytesByReference(BaseAppenderTyte appender) {
		T02PartBinary.PART_1.staticVoorElk(v -> getValue(v).fillTytesByReference(appender));
	}
}
