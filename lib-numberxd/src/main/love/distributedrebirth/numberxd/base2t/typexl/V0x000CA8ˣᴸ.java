package love.distributedrebirth.numberxd.base2t.typexl;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseAppenderOctal;
import love.distributedrebirth.numberxd.base2t.BaseAppenderTyte;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseNumberTyteˣᴸ;
import love.distributedrebirth.numberxd.base2t.part.T02PartBinary;

/**
 * Holds an 3240 bit value.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class V0x000CA8ˣᴸ implements BaseNumberTyteˣᴸ<V0x000CA8ˣᴸ> {

	public static int BIT_COUNT = V0x000654ˣᴸ.BIT_COUNT * T02PartBinary.LENGTH();
	private V0x000654ˣᴸ[] values = new V0x000654ˣᴸ[T02PartBinary.LENGTH()];
	
	public V0x000CA8ˣᴸ() {
		this(new V0x000654ˣᴸ(), new V0x000654ˣᴸ());
	}
	
	public V0x000CA8ˣᴸ(BaseIteratorOctal values) {
		this(new V0x000654ˣᴸ(values), new V0x000654ˣᴸ(values));
	}
	
	private V0x000CA8ˣᴸ(V0x000654ˣᴸ valueHigh, V0x000654ˣᴸ valueLow) {
		setValue(T02PartBinary.PART_1, valueHigh);
		setValue(T02PartBinary.PART_2, valueLow);
	}
	
	public V0x000654ˣᴸ getValue(T02PartBinary part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T02PartBinary part, V0x000654ˣᴸ value) {
		values[part.ordinal()] = value;
	}
	
	@Override
	public int getBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public V0x000CA8ˣᴸ toClone() {
		return new V0x000CA8ˣᴸ(iteratorOctalsByClone());
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
