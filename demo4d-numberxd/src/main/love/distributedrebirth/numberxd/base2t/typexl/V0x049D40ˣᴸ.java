package love.distributedrebirth.numberxd.base2t.typexl;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseAppenderOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseNumberˣᴸ;
import love.distributedrebirth.numberxd.base2t.part.T60PartSexagesimal;

/**
 * Holds an 302400 bit value. (37800 bytes)
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class V0x049D40ˣᴸ implements BaseNumberˣᴸ<V0x049D40ˣᴸ> {

	public static int BIT_COUNT = V0x0013B0ˣᴸ.BIT_COUNT * T60PartSexagesimal.LENGTH();
	private V0x0013B0ˣᴸ[] values = new V0x0013B0ˣᴸ[T60PartSexagesimal.LENGTH()];
	
	public V0x049D40ˣᴸ() {
		for (int i=0;i<values.length;i++) {
			this.values[i] = new V0x0013B0ˣᴸ();
		}
	}
	
	public V0x049D40ˣᴸ(BaseIteratorOctal values) {
		for (int i=0;i<this.values.length;i++) {
			this.values[i] = new V0x0013B0ˣᴸ(values);
		}
	}
	
	public V0x0013B0ˣᴸ getValue(T60PartSexagesimal part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T60PartSexagesimal part, V0x0013B0ˣᴸ value) {
		values[part.ordinal()] = value;
	}
	
	@Override
	public int getBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public V0x049D40ˣᴸ toClone() {
		return new V0x049D40ˣᴸ(iteratorOctalsByClone());
	}
	
	@Override
	public void fillOctalsByClone(BaseAppenderOctal appender) {
		T60PartSexagesimal.PART_1.BãßVoorElk(v -> getValue(v).fillOctalsByClone(appender));
	}
}
