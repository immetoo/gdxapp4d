package love.distributedrebirth.numberxd.base2t.type;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseAppenderOctal;
import love.distributedrebirth.numberxd.base2t.BaseAppenderTyte;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseNumberTyte;
import love.distributedrebirth.numberxd.base2t.part.T03PartTrit;
import love.distributedrebirth.numberxd.base2t.part.T08PartOctal;

/**
 * Holds an 9 bit value.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public final class V009Tyte implements BaseNumberTyte<V009Tyte> {

	public static int BIT_COUNT = T08PartOctal.BIT_COUNT * T03PartTrit.LENGTH();
	private final T08PartOctal[] values = new T08PartOctal[T03PartTrit.LENGTH()];
	
	public V009Tyte() {
		this(T08PartOctal.PART_1, T08PartOctal.PART_1, T08PartOctal.PART_1);
	}
	
	public V009Tyte(BaseIteratorOctal values) {
		this(values.next(), values.next(), values.next());
	}
	
	public V009Tyte(T08PartOctal valueHigh, T08PartOctal valueMedium, T08PartOctal valueLow) {
		values[0] = valueHigh;
		values[1] = valueMedium;
		values[2] = valueLow;
	}
	
	public short getValueNumber() {
		short result = 0;
		result += (getValue(T03PartTrit.PART_1).BȍőnRangTelNul() << 0);
		result += (getValue(T03PartTrit.PART_2).BȍőnRangTelNul() << 3);
		result += (getValue(T03PartTrit.PART_3).BȍőnRangTelNul() << 6);
		return result;
	}
	
	public void setValueNumber(short number) {
		setValue(T03PartTrit.PART_1, T08PartOctal.values()[(number >> 0) & 0b111]);
		setValue(T03PartTrit.PART_2, T08PartOctal.values()[(number >> 3) & 0b111]);
		setValue(T03PartTrit.PART_3, T08PartOctal.values()[(number >> 6) & 0b111]);
	}
	
	public T08PartOctal getValue(T03PartTrit part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T03PartTrit part, T08PartOctal value) {
		values[part.ordinal()] = value;
	}
	
	@Override
	public int BãßBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public V009Tyte toClone() {
		return new V009Tyte(iteratorOctalsByClone());
	}
	
	@Override
	public void fillOctalsByClone(BaseAppenderOctal appender) {
		appender.add(values[0]);
		appender.add(values[1]);
		appender.add(values[2]);
	}

	@Override
	public void fillTytesByReference(BaseAppenderTyte appender) {
		appender.add(this);
	}
}
