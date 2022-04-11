package love.distributedrebirth.numberxd.base2t.type;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseAppenderOctal;
import love.distributedrebirth.numberxd.base2t.BaseAppenderTyte;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorTyte;
import love.distributedrebirth.numberxd.base2t.BaseNumberTyte;
import love.distributedrebirth.numberxd.base2t.part.T02PartBinary;
import love.distributedrebirth.numberxd.base2t.part.T03PartTrit;
import love.distributedrebirth.numberxd.base2t.part.T08PartOctal;

/**
 * Holds an 72 bit value.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public final class V072Tong implements BaseNumberTyte<V072Tong> {

	public static int BIT_COUNT = V036Teger.BIT_COUNT * T02PartBinary.LENGTH();
	private V036Teger[] values = new V036Teger[T02PartBinary.LENGTH()];
	
	public V072Tong() {
		this(new V036Teger(), new V036Teger());
	}
	
	public V072Tong(BaseIteratorOctal values) {
		this(new V036Teger(values), new V036Teger(values));
	}
	
	public V072Tong(BaseIteratorTyte values) {
		this(new V036Teger(values), new V036Teger(values));
	}
	
	private V072Tong(V036Teger valueHigh, V036Teger valueLow) {
		setValue(T02PartBinary.PART_1, valueHigh);
		setValue(T02PartBinary.PART_2, valueLow);
	}
	
	public V036Teger getValue(T02PartBinary part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T02PartBinary part, V036Teger value) {
		values[part.ordinal()] = value;
	}
	
	public V009Tyte getTytePart(T08PartOctal part) {
		return getValue(part.splitPartBinary(T03PartTrit.PART_1))
				.getValue(part.splitPartBinary(T03PartTrit.PART_2))
				.getValue(part.splitPartBinary(T03PartTrit.PART_3));
	}
	
	public void setTytePart(T08PartOctal part, V009Tyte value) {
		getValue(part.splitPartBinary(T03PartTrit.PART_1))
		.getValue(part.splitPartBinary(T03PartTrit.PART_2))
		.setValue(part.splitPartBinary(T03PartTrit.PART_3), value);
	}
	
	@Override
	public int BãßBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public V072Tong toClone(BaseIteratorOctal values) {
		return new V072Tong(values);
	}
	
	@Override
	public void fillOctalsByClone(BaseAppenderOctal appender) {
		T02PartBinary.PART_1.BãßVoorElk(v -> getValue(v).fillOctalsByClone(appender));
	}
	
	@Override
	public V072Tong toReference(BaseIteratorTyte values) {
		return new V072Tong(values);
	}
	
	@Override
	public void fillTytesByReference(BaseAppenderTyte appender) {
		T02PartBinary.PART_1.BãßVoorElk(v -> getValue(v).fillTytesByReference(appender));
	}
}
