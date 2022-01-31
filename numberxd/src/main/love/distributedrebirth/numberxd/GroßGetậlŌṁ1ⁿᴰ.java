package love.distributedrebirth.numberxd;

import love.distributedrebirth.numberxd.base2t.BaseNumber;
import love.distributedrebirth.numberxd.base2t.T08PartOctalBaseAppender;
import love.distributedrebirth.numberxd.base2t.T08PartOctalBaseIterator;

/**
 * Divide GroßGetậl1ⁿᴰ into resolved fractal slices.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
abstract public class GroßGetậlŌṁ1ⁿᴰ<V extends GroßGetậlŌṁ1ⁿᴰ<V> & BaseNumber<V>> implements BaseNumber<V> {
	
	private GroßGetậl1ⁿᴰ[] values;
	private int valuesLength;
	private byte fractalLevel;
	
	public GroßGetậlŌṁ1ⁿᴰ(byte fractalLevel) {
		this.fractalLevel = fractalLevel;
		this.valuesLength = resolveFractalLevel(fractalLevel);
		this.values = new GroßGetậl1ⁿᴰ[valuesLength];
	}
	
	abstract protected int resolveFractalLevel(byte level);
	
	public final byte getFractalLevel() {
		return fractalLevel;
	}
	
	public final int getValuesLength() {
		return valuesLength;
	}
	
	private final int validatePartRequest(int part) {
		if (part < 0) {
			throw new IllegalArgumentException("Requested part is negative");
		}
		if (part > valuesLength) {
			throw new IllegalArgumentException("Requested part exceeds fractal storage");
		}
		return part;
	}
	
	public final GroßGetậl1ⁿᴰ getValue(int part) {
		return values[validatePartRequest(part)];
	}
	
	public final void setValue(int part, GroßGetậl1ⁿᴰ value) {
		values[validatePartRequest(part)] = value;
	}
	
	abstract protected V toCloneFractal(byte level);
	
	@Override
	public final V toClone() {
		V result = toCloneFractal(getFractalLevel());
		T08PartOctalBaseIterator clonedOctals = iteratorOctalsByClone();
		for (int i=0;i<getValuesLength();i++) {
			result.setValue(i, new GroßGetậl1ⁿᴰ(clonedOctals));
		}
		return result;
	}
	
	@Override
	public final int getBitCount() {
		return GroßGetậl1ⁿᴰ.BIT_COUNT * valuesLength;
	}
	
	@Override
	public final void fillOctalsByClone(T08PartOctalBaseAppender appender) {
		for (GroßGetậl1ⁿᴰ value:values) {
			value.fillOctalsByClone(appender);
		}
	}
}
