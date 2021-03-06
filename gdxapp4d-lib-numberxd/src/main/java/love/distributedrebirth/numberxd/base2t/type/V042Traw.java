package love.distributedrebirth.numberxd.base2t.type;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseAppenderOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseNumber;
import love.distributedrebirth.numberxd.base2t.part.T07PartPlanIt;

/**
 * Holds an 42 bit value.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public final class V042Traw implements BaseNumber<V042Traw> {

	public static int BIT_COUNT = V006Tixte.BIT_COUNT * T07PartPlanIt.LENGTH();
	private V006Tixte[] values = new V006Tixte[T07PartPlanIt.LENGTH()];
	
	public V042Traw() {
		for (int i=0;i<values.length;i++) {
			this.values[i] = new V006Tixte();
		}
	}
	
	public V042Traw(BaseIteratorOctal values) {
		for (int i=0;i<this.values.length;i++) {
			this.values[i] = new V006Tixte(values);
		}
	}
	
	public V006Tixte getValue(T07PartPlanIt part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T07PartPlanIt part, V006Tixte value) {
		values[part.ordinal()] = value;
	}
	
	@Override
	public int BãßBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public V042Traw toClone(BaseIteratorOctal values) {
		return new V042Traw(values);
	}
	
	@Override
	public void fillOctalsByClone(BaseAppenderOctal appender) {
		T07PartPlanIt.PART_1.BãßVoorElk(v -> getValue(v).fillOctalsByClone(appender));
	}
}
