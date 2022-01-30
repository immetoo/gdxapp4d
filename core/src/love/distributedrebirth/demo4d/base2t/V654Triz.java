package love.distributedrebirth.demo4d.base2t;

/**
 * Holds an 1620 bit value.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public class V654Triz implements BaseNumberTyte<V654Triz> {

	public static int BIT_COUNT = V01BTemvig.BIT_COUNT * T60Sexagesimal.LENGTH;
	private V01BTemvig[] values = new V01BTemvig[T60Sexagesimal.LENGTH];
	
	public V654Triz() {
		for (int i=0;i<T60Sexagesimal.LENGTH;i++) {
			this.values[i] = new V01BTemvig();
		}
	}
	
	public V654Triz(T08PartOctalBaseIterator values) {
		for (int i=0;i<T60Sexagesimal.LENGTH;i++) {
			this.values[i] = new V01BTemvig(values);
		}
	}
	
	public V01BTemvig getValue(T60Sexagesimal part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T60Sexagesimal part, V01BTemvig value) {
		values[part.ordinal()] = value;
	}
	
	@Override
	public int getBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public V654Triz toClone() {
		return new V654Triz(cloneIterator());
	}
	
	@Override
	public void fillOctalValues(T08PartOctalBaseAppender appender) {
		T60Sexagesimal.forEach(v -> getValue(v).fillOctalValues(appender));
	}

	@Override
	public void fillTyteValues(V009TyteBaseAppender appender) {
		T60Sexagesimal.forEach(v -> getValue(v).fillTyteValues(appender));
	}
}
