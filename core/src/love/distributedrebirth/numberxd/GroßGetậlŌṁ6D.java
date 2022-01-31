package love.distributedrebirth.numberxd;

import love.distributedrebirth.numberxd.base2t.BaseNumber;
import love.distributedrebirth.numberxd.base2t.T08PartOctalBaseAppender;
import love.distributedrebirth.numberxd.base2t.T08PartOctalBaseIterator;

abstract public class GroßGetậlŌṁ6D<V extends GroßGetậlŌṁ6D<V> & BaseNumber<V>> implements BaseNumber<V> {
	
	private GroßGetậl6D[] values;
	private int valuesLength;
	private byte fractalLevel;
	
	public GroßGetậlŌṁ6D(byte fractalLevel) {
		this.fractalLevel = fractalLevel;
		this.valuesLength = resolveFractalLevel(fractalLevel);
		this.values = new GroßGetậl6D[valuesLength];
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
	
	public final GroßGetậl6D getValue(int part) {
		return values[validatePartRequest(part)];
	}
	
	public final void setValue(int part, GroßGetậl6D value) {
		values[validatePartRequest(part)] = value;
	}
	
	abstract protected V toCloneFractal(byte level);
	
	@Override
	public final V toClone() {
		V result = toCloneFractal(getFractalLevel());
		T08PartOctalBaseIterator clonedOctals = iteratorOctalsByClone();
		for (int i=0;i<getValuesLength();i++) {
			result.setValue(i, new GroßGetậl6D(clonedOctals));
		}
		return result;
	}
	
	@Override
	public final int getBitCount() {
		return GroßGetậl6D.BIT_COUNT * valuesLength;
	}
	
	@Override
	public final void fillOctalsByClone(T08PartOctalBaseAppender appender) {
		for (GroßGetậl6D value:values) {
			value.fillOctalsByClone(appender);
		}
	}
}
