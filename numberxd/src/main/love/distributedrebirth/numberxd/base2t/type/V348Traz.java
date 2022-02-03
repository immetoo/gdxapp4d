package love.distributedrebirth.numberxd.base2t.type;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseAppenderOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseNumber;
import love.distributedrebirth.numberxd.base2t.part.T20PartScore;

/**
 * Holds an 840 bit value.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class V348Traz implements BaseNumber<V348Traz> {

	public static int BIT_COUNT = V02ATraw.BIT_COUNT * T20PartScore.LENGTH();
	private V02ATraw[] values = new V02ATraw[T20PartScore.LENGTH()];
	
	public V348Traz() {
		for (int i=0;i<values.length;i++) {
			this.values[i] = new V02ATraw();
		}
	}
	
	public V348Traz(BaseIteratorOctal values) {
		for (int i=0;i<this.values.length;i++) {
			this.values[i] = new V02ATraw(values);
		}
	}
	
	public V02ATraw getValue(T20PartScore part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T20PartScore part, V02ATraw value) {
		values[part.ordinal()] = value;
	}
	
	@Override
	public int getBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public V348Traz toClone() {
		return new V348Traz(iteratorOctalsByClone());
	}
	
	@Override
	public void fillOctalsByClone(BaseAppenderOctal appender) {
		T20PartScore.PART_1.BãßVoorElk(v -> getValue(v).fillOctalsByClone(appender));
	}
}
