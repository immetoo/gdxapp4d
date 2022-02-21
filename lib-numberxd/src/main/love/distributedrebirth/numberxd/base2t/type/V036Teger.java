package love.distributedrebirth.numberxd.base2t.type;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseAppenderOctal;
import love.distributedrebirth.numberxd.base2t.BaseAppenderTyte;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorTyte;
import love.distributedrebirth.numberxd.base2t.BaseNumberTyte;
import love.distributedrebirth.numberxd.base2t.part.T02PartBinary;
import love.distributedrebirth.numberxd.base2t.part.T04PartQuad;

/**
 * Holds an 36 bit value.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public final class V036Teger implements BaseNumberTyte<V036Teger> {

	public static int BIT_COUNT = V018Tord.BIT_COUNT * T02PartBinary.LENGTH();
	private V018Tord[] values = new V018Tord[T02PartBinary.LENGTH()];
	
	public V036Teger() {
		this(new V018Tord(), new V018Tord());
	}
	
	public V036Teger(BaseIteratorOctal values) {
		this(new V018Tord(values), new V018Tord(values));
	}
	
	public V036Teger(BaseIteratorTyte values) {
		this(new V018Tord(values), new V018Tord(values));
	}
	
	private V036Teger(V018Tord valueHigh, V018Tord valueLow) {
		setValue(T02PartBinary.PART_1, valueHigh);
		setValue(T02PartBinary.PART_2, valueLow);
	}
	
	public long getValueNumber() {
		int result = 0;
		result += (getValue(T02PartBinary.PART_1).getValueNumber() << 0);
		result += (getValue(T02PartBinary.PART_2).getValueNumber() << 18);
		return result;
	}
	
	public void setValueNumber(long number) {
		getValue(T02PartBinary.PART_1).setValueNumber((int) ((number >> 0) & 0b111111111111111111));
		getValue(T02PartBinary.PART_2).setValueNumber((int) ((number >> 18) & 0b111111111111111111));
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
	public int BãßBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public V036Teger toClone() {
		return new V036Teger(iteratorOctalsByClone());
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
