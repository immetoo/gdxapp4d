package love.distributedrebirth.numberxd.base2t.type;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseAppenderOctal;
import love.distributedrebirth.numberxd.base2t.BaseAppenderTyte;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorTyte;
import love.distributedrebirth.numberxd.base2t.BaseNumberTyte;
import love.distributedrebirth.numberxd.base2t.part.T02PartBinary;
import love.distributedrebirth.numberxd.base2t.part.T03PartTrit;
import love.distributedrebirth.numberxd.base2t.part.T04PartQuad;
import love.distributedrebirth.numberxd.base2t.part.T08PartOctal;
import love.distributedrebirth.numberxd.base2t.part.T16PartHex;

/**
 * Holds an 144 bit value.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public final class V144Tocta implements BaseNumberTyte<V144Tocta> {

	public static int BIT_COUNT = V072Tong.BIT_COUNT * T02PartBinary.LENGTH();
	private V072Tong[] values = new V072Tong[T02PartBinary.LENGTH()];
	
	public V144Tocta() {
		this(new V072Tong(), new V072Tong());
	}
	
	public V144Tocta(BaseIteratorOctal values) {
		this(new V072Tong(values), new V072Tong(values));
	}
	
	public V144Tocta(BaseIteratorTyte values) {
		this(new V072Tong(values), new V072Tong(values));
	}
	
	private V144Tocta(V072Tong valueHigh, V072Tong valueLow) {
		setValue(T02PartBinary.PART_1, valueHigh);
		setValue(T02PartBinary.PART_2, valueLow);
	}
	
	public V072Tong getValue(T02PartBinary part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T02PartBinary part, V072Tong value) {
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
	
	public V018Tord getTordPart(T08PartOctal part) {
		return getValue(part.splitPartBinary(T03PartTrit.PART_1))
			.getValue(part.splitPartBinary(T03PartTrit.PART_2))
			.getValue(part.splitPartBinary(T03PartTrit.PART_3));
	}
	
	public void setTordPart(T08PartOctal part, V018Tord value) {
		getValue(part.splitPartBinary(T03PartTrit.PART_1))
		.getValue(part.splitPartBinary(T03PartTrit.PART_2))
		.setValue(part.splitPartBinary(T03PartTrit.PART_3), value);
	}
	
	@Override
	public int BãßBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public V144Tocta toClone(BaseIteratorOctal values) {
		return new V144Tocta(values);
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
