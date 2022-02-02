package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

/**
 * Holds an 6 bit value.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public final class V006Tixte implements BaseNumber<V006Tixte> {

	public static int BIT_COUNT = V003Timble.BIT_COUNT * T02PartBinary.LENGTH();
	private V003Timble[] values = new V003Timble[T02PartBinary.LENGTH()];
	
	public V006Tixte() {
		this(new V003Timble(), new V003Timble());
	}
	
	public V006Tixte(BaseIteratorOctal values) {
		this(new V003Timble(values), new V003Timble(values));
	}
	
	private V006Tixte(V003Timble valueHigh, V003Timble valueLow) {
		setValue(T02PartBinary.PART_1, valueHigh);
		setValue(T02PartBinary.PART_2, valueLow);
	}
	
	public V003Timble getValue(T02PartBinary part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T02PartBinary part, V003Timble value) {
		values[part.ordinal()] = value;
	}
	
	@Override
	public int getBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public V006Tixte toClone() {
		return new V006Tixte(iteratorOctalsByClone());
	}
	
	@Override
	public void fillOctalsByClone(BaseAppenderOctal appender) {
		T02PartBinary.PART_1.BãßVoorElk(v -> getValue(v).fillOctalsByClone(appender));
	}
}
