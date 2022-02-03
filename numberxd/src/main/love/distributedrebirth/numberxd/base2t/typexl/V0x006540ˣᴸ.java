package love.distributedrebirth.numberxd.base2t.typexl;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseAppenderOctal;
import love.distributedrebirth.numberxd.base2t.BaseAppenderTyte;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseNumberTyteXL;
import love.distributedrebirth.numberxd.base2t.part.T08PartOctal;

/**
 * Holds an 25920 bit value. (3240 bytes)
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class V0x006540ˣᴸ implements BaseNumberTyteXL<V0x006540ˣᴸ> {

	public static int BIT_COUNT = V0x000CA8ˣᴸ.BIT_COUNT * T08PartOctal.LENGTH();
	private V0x000CA8ˣᴸ[] values = new V0x000CA8ˣᴸ[T08PartOctal.LENGTH()];
	
	public V0x006540ˣᴸ() {
		for (int i=0;i<values.length;i++) {
			this.values[i] = new V0x000CA8ˣᴸ();
		}
	}
	
	public V0x006540ˣᴸ(BaseIteratorOctal values) {
		for (int i=0;i<this.values.length;i++) {
			this.values[i] = new V0x000CA8ˣᴸ(values);
		}
	}
	
	public V0x000CA8ˣᴸ getValue(T08PartOctal part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T08PartOctal part, V0x000CA8ˣᴸ value) {
		values[part.ordinal()] = value;
	}
	
	@Override
	public int getBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public V0x006540ˣᴸ toClone() {
		return new V0x006540ˣᴸ(iteratorOctalsByClone());
	}
	
	@Override
	public void fillOctalsByClone(BaseAppenderOctal appender) {
		T08PartOctal.PART_1.BãßVoorElk(v -> getValue(v).fillOctalsByClone(appender));
	}

	@Override
	public void fillTytesByReference(BaseAppenderTyte appender) {
		T08PartOctal.PART_1.BãßVoorElk(v -> getValue(v).fillTytesByReference(appender));
	}
}
