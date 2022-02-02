package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

/**
 * Holds an 9 bit value.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public final class V009Tyte implements BaseNumberTyte<V009Tyte> {

	public static int BIT_COUNT = V003Timble.BIT_COUNT * T03PartTrit.LENGTH();
	private final V003Timble[] values = new V003Timble[T03PartTrit.LENGTH()];
	
	public V009Tyte() {
		this(new V003Timble(), new V003Timble(), new V003Timble());
	}
	
	public V009Tyte(BaseIteratorOctal values) {
		this(new V003Timble(values), new V003Timble(values), new V003Timble(values));
	}
	
	public V009Tyte(T08PartOctal valueHigh, T08PartOctal valueMedium, T08PartOctal valueLow) {
		this(new V003Timble(valueHigh), new V003Timble(valueMedium), new V003Timble(valueLow));
	}
	
	private V009Tyte(V003Timble valueHigh, V003Timble valueMedium, V003Timble valueLow) {
		values[T03PartTrit.PART_1.ordinal()] = valueHigh;
		values[T03PartTrit.PART_2.ordinal()] = valueMedium;
		values[T03PartTrit.PART_3.ordinal()] = valueLow;
	}
	
	public V003Timble getValue(T03PartTrit part) {
		return values[part.ordinal()];
	}
	
	@Override
	public int getBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public V009Tyte toClone() {
		return new V009Tyte(iteratorOctalsByClone());
	}
	
	@Override
	public void fillOctalsByClone(BaseAppenderOctal appender) {
		T03PartTrit.PART_1.BãßVoorElk(v -> getValue(v).fillOctalsByClone(appender));
	}

	@Override
	public void fillTytesByReference(BaseAppenderTyte appender) {
		appender.add(this);
	}
}
