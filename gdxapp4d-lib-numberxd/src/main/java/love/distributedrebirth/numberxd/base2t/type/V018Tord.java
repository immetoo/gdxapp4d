package love.distributedrebirth.numberxd.base2t.type;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseAppenderOctal;
import love.distributedrebirth.numberxd.base2t.BaseAppenderTyte;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorTyte;
import love.distributedrebirth.numberxd.base2t.BaseNumberTyte;
import love.distributedrebirth.numberxd.base2t.part.T02PartBinary;
import love.distributedrebirth.numberxd.base2t.part.T06PartSeximal;
import love.distributedrebirth.numberxd.base2t.part.T08PartOctal;

/**
 * Holds an 18 bit value.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public final class V018Tord implements BaseNumberTyte<V018Tord> {

	public static int BIT_COUNT = V009Tyte.BIT_COUNT * T02PartBinary.LENGTH();
	private V009Tyte[] values = new V009Tyte[T02PartBinary.LENGTH()];
	
	public V018Tord() {
		this(new V009Tyte(), new V009Tyte());
	}
	
	public V018Tord(BaseIteratorOctal values) {
		this(new V009Tyte(values), new V009Tyte(values));
	}
	
	public V018Tord(BaseIteratorTyte values) {
		this(values.next(), values.next());
	}
	
	private V018Tord(V009Tyte valueHigh, V009Tyte valueLow) {
		setValue(T02PartBinary.PART_1, valueHigh);
		setValue(T02PartBinary.PART_2, valueLow);
	}
	
	public int getValueNumber() {
		int result = 0;
		result += (getValue(T02PartBinary.PART_1).getValueNumber() << 0);
		result += (getValue(T02PartBinary.PART_2).getValueNumber() << 9);
		return result;
	}
	
	public void setValueNumber(int number) {
		getValue(T02PartBinary.PART_1).setValueNumber((short) ((number >> 0) & 0b111111111));
		getValue(T02PartBinary.PART_2).setValueNumber((short) ((number >> 9) & 0b111111111));
	}
	
	public V009Tyte getValue(T02PartBinary part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T02PartBinary part, V009Tyte value) {
		values[part.ordinal()] = value;
	}
	
	public T08PartOctal getTimblePart(T06PartSeximal part) {
		return getValue(part.splitPartBinary()).getValue(part.splitPartTrit());
	}
	
	public void setTimblePart(T06PartSeximal part, T08PartOctal value) {
		getValue(part.splitPartBinary()).setValue(part.splitPartTrit(), value);
	}
	
	@Override
	public int BãßBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public V018Tord toClone(BaseIteratorOctal values) {
		return new V018Tord(values);
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
