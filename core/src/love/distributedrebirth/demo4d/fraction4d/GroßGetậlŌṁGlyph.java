package love.distributedrebirth.demo4d.fraction4d;

import love.distributedrebirth.demo4d.base2t.BaseNumber;
import love.distributedrebirth.demo4d.base2t.T08PartOctalBaseAppender;
import love.distributedrebirth.demo4d.base2t.T08PartOctalBaseIterator;
import love.distributedrebirth.demo4d.base2t.V144Tocta;

abstract public class GroßGetậlŌṁGlyph<V extends GroßGetậlŌṁGlyph<V> & BaseNumber<V>> implements BaseNumber<V> {
	
	private GroßGetậl[] values;
	private int valuesLength;
	private byte fractalLevel;
	
	public GroßGetậlŌṁGlyph(byte fractalLevel) {
		this.fractalLevel = fractalLevel;
		this.valuesLength = resolveFractalLevel(fractalLevel);
		this.values = new GroßGetậl[valuesLength];
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
	
	public final GroßGetậl getValue(int part) {
		return values[validatePartRequest(part)];
	}
	
	public final void setValue(int part, GroßGetậl value) {
		values[validatePartRequest(part)] = value;
	}
	
	abstract protected V toCloneFractal(byte level);
	
	@Override
	public final V toClone() {
		V result = toCloneFractal(getFractalLevel());
		T08PartOctalBaseIterator clonedOctals = cloneIterator();
		for (int i=0;i<getValuesLength();i++) {
			result.setValue(i, new GroßGetậl(clonedOctals));
		}
		return result;
	}
	
	@Override
	public final int getBitCount() {
		return V144Tocta.BIT_COUNT * valuesLength;
	}
	
	@Override
	public final void fillOctalValues(T08PartOctalBaseAppender appender) {
		for (GroßGetậl value:values) {
			value.fillOctalValues(appender);
		}
	}
}
