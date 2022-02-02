package love.distributedrebirth.numberxd;

import love.distributedrebirth.numberxd.base2t.BaseNumberTyte;
import love.distributedrebirth.numberxd.base2t.part.T12PartUncial;
import love.distributedrebirth.numberxd.base2t.BaseAppenderOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseAppenderTyte;
import love.distributedrebirth.numberxd.base2t.BaseIteratorTyte;

/**
 * Holds an 864 bit fraction.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class GroßGetậl6ˢᴰ implements BaseNumberTyte<GroßGetậl6ˢᴰ> {
	
	public static int BIT_COUNT = GroßGetậl1ⁿᴰ.BIT_COUNT * T12PartUncial.LENGTH();
	private GroßGetậl1ⁿᴰ[] values = new GroßGetậl1ⁿᴰ[T12PartUncial.LENGTH()];
	
	public GroßGetậl6ˢᴰ() {
		for (int i=0;i<this.values.length;i++) {
			this.values[i] = new GroßGetậl1ⁿᴰ();
		}
	}
	
	public GroßGetậl6ˢᴰ(BaseIteratorOctal values) {
		for (int i=0;i<this.values.length;i++) {
			this.values[i] = new GroßGetậl1ⁿᴰ(values);
		}
	}
	
	public GroßGetậl6ˢᴰ(BaseIteratorTyte values) {
		for (int i=0;i<this.values.length;i++) {
			this.values[i] = new GroßGetậl1ⁿᴰ(values);
		}
	}
	
	public GroßGetậl1ⁿᴰ getValue(T12PartUncial part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T12PartUncial part, GroßGetậl1ⁿᴰ value) {
		values[part.ordinal()] = value;
	}

	@Override
	public int getBitCount() {
		return BIT_COUNT;
	}

	@Override
	public GroßGetậl6ˢᴰ toClone() {
		return new GroßGetậl6ˢᴰ(iteratorOctalsByClone());
	}

	@Override
	public void fillOctalsByClone(BaseAppenderOctal appender) {
		T12PartUncial.PART_1.BãßVoorElk(v -> getValue(v).fillOctalsByClone(appender));
	}

	@Override
	public void fillTytesByReference(BaseAppenderTyte appender) {
		T12PartUncial.PART_1.BãßVoorElk(v -> getValue(v).fillTytesByReference(appender));
	}
}
