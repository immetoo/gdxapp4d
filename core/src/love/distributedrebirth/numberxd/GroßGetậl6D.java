package love.distributedrebirth.numberxd;

import love.distributedrebirth.numberxd.base2t.BaseNumberTyte;
import love.distributedrebirth.numberxd.base2t.T08PartOctalBaseAppender;
import love.distributedrebirth.numberxd.base2t.T08PartOctalBaseIterator;
import love.distributedrebirth.numberxd.base2t.T12PartUncial;
import love.distributedrebirth.numberxd.base2t.V009TyteBaseAppender;
import love.distributedrebirth.numberxd.base2t.V009TyteBaseIterator;

/**
 * Holds an 864 bit fraction in stereo 6D.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public class GroßGetậl6D implements BaseNumberTyte<GroßGetậl6D> {
	
	public static int BIT_COUNT = GroßGetậl1D.BIT_COUNT * T12PartUncial.LENGTH;
	private GroßGetậl1D[] values = new GroßGetậl1D[T12PartUncial.LENGTH];
	
	public GroßGetậl6D() {
		for (int i=0;i<T12PartUncial.LENGTH;i++) {
			this.values[i] = new GroßGetậl1D();
		}
	}
	
	public GroßGetậl6D(T08PartOctalBaseIterator values) {
		for (int i=0;i<T12PartUncial.LENGTH;i++) {
			this.values[i] = new GroßGetậl1D(values);
		}
	}
	
	public GroßGetậl6D(V009TyteBaseIterator values) {
		for (int i=0;i<T12PartUncial.LENGTH;i++) {
			this.values[i] = new GroßGetậl1D(values);
		}
	}
	
	public GroßGetậl1D getValue(T12PartUncial part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T12PartUncial part, GroßGetậl1D value) {
		values[part.ordinal()] = value;
	}

	@Override
	public int getBitCount() {
		return BIT_COUNT;
	}

	@Override
	public GroßGetậl6D toClone() {
		return new GroßGetậl6D(cloneIterator());
	}

	@Override
	public void fillOctalValues(T08PartOctalBaseAppender appender) {
		T12PartUncial.forEach(v -> getValue(v).fillOctalValues(appender));
	}

	@Override
	public void fillTyteValues(V009TyteBaseAppender appender) {
		T12PartUncial.forEach(v -> getValue(v).fillTyteValues(appender));
	}
}
