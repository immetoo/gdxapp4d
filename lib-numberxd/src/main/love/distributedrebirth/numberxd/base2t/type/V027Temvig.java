package love.distributedrebirth.numberxd.base2t.type;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseAppenderOctal;
import love.distributedrebirth.numberxd.base2t.BaseAppenderTyte;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorTyte;
import love.distributedrebirth.numberxd.base2t.BaseNumberTyte;
import love.distributedrebirth.numberxd.base2t.part.T03PartTrit;

/**
 * Holds an 27 bit value.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public final class V027Temvig implements BaseNumberTyte<V027Temvig> {

	public static int BIT_COUNT = V009Tyte.BIT_COUNT * T03PartTrit.LENGTH();
	private V009Tyte[] values = new V009Tyte[T03PartTrit.LENGTH()];
	
	public V027Temvig() {
		this(new V009Tyte(), new V009Tyte(), new V009Tyte());
	}
	
	public V027Temvig(BaseIteratorOctal values) {
		this(new V009Tyte(values), new V009Tyte(values), new V009Tyte(values));
	}
	
	public V027Temvig(BaseIteratorTyte values) {
		this(values.next(), values.next(), values.next());
	}
	
	private V027Temvig(V009Tyte valueHigh, V009Tyte valueMedium, V009Tyte valueLow) {
		setValue(T03PartTrit.PART_1, valueHigh);
		setValue(T03PartTrit.PART_2, valueMedium);
		setValue(T03PartTrit.PART_3, valueLow);
	}
	
	public V009Tyte getValue(T03PartTrit part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T03PartTrit part, V009Tyte value) {
		values[part.ordinal()] = value;
	}
	
	@Override
	public int BãßBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public V027Temvig toClone() {
		return new V027Temvig(iteratorOctalsByClone());
	}
	
	@Override
	public void fillOctalsByClone(BaseAppenderOctal appender) {
		T03PartTrit.PART_1.BãßVoorElk(v -> getValue(v).fillOctalsByClone(appender));
	}

	@Override
	public void fillTytesByReference(BaseAppenderTyte appender) {
		T03PartTrit.PART_1.BãßVoorElk(v -> getValue(v).fillTytesByReference(appender));
	}
}
