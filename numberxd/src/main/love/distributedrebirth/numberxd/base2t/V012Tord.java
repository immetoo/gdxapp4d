package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

/**
 * Holds an 18 bit value.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public final class V012Tord implements BaseNumberTyte<V012Tord> {

	public static int BIT_COUNT = V009Tyte.BIT_COUNT * T02PartBinary.LENGTH();
	private V009Tyte[] values = new V009Tyte[T02PartBinary.LENGTH()];
	
	public V012Tord() {
		this(new V009Tyte(), new V009Tyte());
	}
	
	public V012Tord(BaseIteratorOctal values) {
		this(new V009Tyte(values), new V009Tyte(values));
	}
	
	public V012Tord(BaseIteratorTyte values) {
		this(values.next(), values.next());
	}
	
	private V012Tord(V009Tyte valueHigh, V009Tyte valueLow) {
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
	
	@Override
	public int getBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public V012Tord toClone() {
		return new V012Tord(iteratorOctalsByClone());
	}
	
	@Override
	public void fillOctalsByClone(BaseAppenderOctal appender) {
		T02PartBinary.PART_1.BãßVoorElk(v -> getValue(v).fillOctalsByClone(appender));
	}

	@Override
	public void fillTytesByReference(BaseAppenderTyte appender) {
		T02PartBinary.PART_1.BãßVoorElk(v -> getValue(v).fillTytesByReference(appender));
	}
}
