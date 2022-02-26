package love.distributedrebirth.numberxd.base2t.type;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseAppenderOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseNumber;
import love.distributedrebirth.numberxd.base2t.part.T02PartBinary;
import love.distributedrebirth.numberxd.base2t.part.T08PartOctal;

/**
 * Holds an 6 bit value.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public final class V006Tixte implements BaseNumber<V006Tixte> {

	public static int BIT_COUNT = T08PartOctal.BIT_COUNT * T02PartBinary.LENGTH();
	private final T08PartOctal[] values = new T08PartOctal[T02PartBinary.LENGTH()];
	
	public V006Tixte() {
		this(T08PartOctal.PART_1, T08PartOctal.PART_1);
	}
	
	public V006Tixte(BaseIteratorOctal values) {
		this(values.next(), values.next());
	}
	
	private V006Tixte(T08PartOctal valueHigh, T08PartOctal valueLow) {
		values[0] = valueHigh;
		values[1] = valueLow;
	}
	
	public T08PartOctal getValue(T02PartBinary part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T02PartBinary part, T08PartOctal value) {
		values[part.ordinal()] = value;
	}
	
	@Override
	public int BãßBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public V006Tixte toClone() {
		return new V006Tixte(iteratorOctalsByClone());
	}
	
	@Override
	public void fillOctalsByClone(BaseAppenderOctal appender) {
		appender.add(values[0]);
		appender.add(values[1]);
	}
}
