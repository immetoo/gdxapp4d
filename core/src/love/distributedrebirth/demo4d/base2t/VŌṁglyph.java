package love.distributedrebirth.demo4d.base2t;

abstract public class VŌṁglyph<V extends VŌṁglyph<V> & BaseNumber<V>> implements BaseNumber<V> {
	
	private V144Tocta[] values;
	private int valuesLength;
	private byte fractalLevel;
	
	public VŌṁglyph(byte fractalLevel) {
		this.fractalLevel = fractalLevel;
		this.valuesLength = resolveFractalLevel(fractalLevel);
		this.values = new V144Tocta[valuesLength];
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
	
	public final V144Tocta getValue(int part) {
		return values[validatePartRequest(part)];
	}
	
	public final void setValue(int part, V144Tocta value) {
		values[validatePartRequest(part)] = value;
	}
	
	abstract protected V toCloneFractal(byte level);
	
	@Override
	public final V toClone() {
		V result = toCloneFractal(getFractalLevel());
		T08PartOctalBaseIterator clonedOctals = cloneIterator();
		for (int i=0;i<getValuesLength();i++) {
			result.setValue(i, new V144Tocta(clonedOctals));
		}
		return result;
	}
	
	@Override
	public final int getBitCount() {
		return V144Tocta.BIT_COUNT * valuesLength;
	}
	
	@Override
	public final void fillOctalValues(T08PartOctalBaseAppender appender) {
		for (V144Tocta value:values) {
			value.fillOctalValues(appender);
		}
	}
}
