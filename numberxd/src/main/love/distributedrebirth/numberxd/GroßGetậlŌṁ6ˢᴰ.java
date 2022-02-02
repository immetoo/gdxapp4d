package love.distributedrebirth.numberxd;

import love.distributedrebirth.numberxd.base2t.BaseNumber;
import love.distributedrebirth.numberxd.base2t.BaseAppenderOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;

/**
 * Divide GroßGetậl6ˢᴰ into resolved fractal slices.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
abstract public class GroßGetậlŌṁ6ˢᴰ<V extends GroßGetậlŌṁ6ˢᴰ<V> & BaseNumber<V>> implements BaseNumber<V> {
	
	private GroßGetậl6ˢᴰ[] values;
	private int valuesLength;
	private byte fractalLevel;
	
	public GroßGetậlŌṁ6ˢᴰ(byte fractalLevel) {
		this.fractalLevel = fractalLevel;
		this.valuesLength = resolveFractalLevel(fractalLevel);
		this.values = new GroßGetậl6ˢᴰ[valuesLength];
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
	
	public final GroßGetậl6ˢᴰ getValue(int part) {
		return values[validatePartRequest(part)];
	}
	
	public final void setValue(int part, GroßGetậl6ˢᴰ value) {
		values[validatePartRequest(part)] = value;
	}
	
	abstract protected V toCloneFractal(byte level);
	
	@Override
	public final V toClone() {
		V result = toCloneFractal(getFractalLevel());
		BaseIteratorOctal clonedOctals = iteratorOctalsByClone();
		for (int i=0;i<getValuesLength();i++) {
			result.setValue(i, new GroßGetậl6ˢᴰ(clonedOctals));
		}
		return result;
	}
	
	@Override
	public final int getBitCount() {
		return GroßGetậl6ˢᴰ.BIT_COUNT * valuesLength;
	}
	
	@Override
	public final void fillOctalsByClone(BaseAppenderOctal appender) {
		for (GroßGetậl6ˢᴰ value:values) {
			value.fillOctalsByClone(appender);
		}
	}
}
