package love.distributedrebirth.numberxd.base2t.typexl;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseAppenderOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseNumberXL;
import love.distributedrebirth.numberxd.base2t.part.T20PartScore;
import love.distributedrebirth.numberxd.base2t.type.V042Traw;

/**
 * Holds an 840 bit value.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class V0x000348ˣᴸ implements BaseNumberXL<V0x000348ˣᴸ> {

	public static int BIT_COUNT = V042Traw.BIT_COUNT * T20PartScore.LENGTH();
	private V042Traw[] values = new V042Traw[T20PartScore.LENGTH()];
	
	public V0x000348ˣᴸ() {
		for (int i=0;i<values.length;i++) {
			this.values[i] = new V042Traw();
		}
	}
	
	public V0x000348ˣᴸ(BaseIteratorOctal values) {
		for (int i=0;i<this.values.length;i++) {
			this.values[i] = new V042Traw(values);
		}
	}
	
	public V042Traw getValue(T20PartScore part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T20PartScore part, V042Traw value) {
		values[part.ordinal()] = value;
	}
	
	@Override
	public int getBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public V0x000348ˣᴸ toClone() {
		return new V0x000348ˣᴸ(iteratorOctalsByClone());
	}
	
	@Override
	public void fillOctalsByClone(BaseAppenderOctal appender) {
		T20PartScore.PART_1.BãßVoorElk(v -> getValue(v).fillOctalsByClone(appender));
	}
}
