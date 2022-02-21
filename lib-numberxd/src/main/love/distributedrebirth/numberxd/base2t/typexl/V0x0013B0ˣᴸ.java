package love.distributedrebirth.numberxd.base2t.typexl;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseAppenderOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseNumberˣᴸ;
import love.distributedrebirth.numberxd.base2t.part.T06PartSeximal;

/**
 * Holds an 5040 bit value.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class V0x0013B0ˣᴸ implements BaseNumberˣᴸ<V0x0013B0ˣᴸ> {

	public static int BIT_COUNT = V0x000348ˣᴸ.BIT_COUNT * T06PartSeximal.LENGTH();
	private V0x000348ˣᴸ[] values = new V0x000348ˣᴸ[T06PartSeximal.LENGTH()];
	
	public V0x0013B0ˣᴸ() {
		for (int i=0;i<values.length;i++) {
			this.values[i] = new V0x000348ˣᴸ();
		}
	}
	
	public V0x0013B0ˣᴸ(BaseIteratorOctal values) {
		for (int i=0;i<this.values.length;i++) {
			this.values[i] = new V0x000348ˣᴸ(values);
		}
	}
	
	public V0x000348ˣᴸ getValue(T06PartSeximal part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T06PartSeximal part, V0x000348ˣᴸ value) {
		values[part.ordinal()] = value;
	}
	
	@Override
	public int BãßBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public V0x0013B0ˣᴸ toClone() {
		return new V0x0013B0ˣᴸ(iteratorOctalsByClone());
	}
	
	@Override
	public void fillOctalsByClone(BaseAppenderOctal appender) {
		T06PartSeximal.PART_1.BãßVoorElk(v -> getValue(v).fillOctalsByClone(appender));
	}
}
