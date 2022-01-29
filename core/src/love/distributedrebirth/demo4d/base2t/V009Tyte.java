package love.distributedrebirth.demo4d.base2t;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public final class V009Tyte implements BaseNumberTyte<V009Tyte> {

	private V003Timble[] values = new V003Timble[T03PartTrit.LENGTH];
	
	public V009Tyte() {
		this(new V003Timble(), new V003Timble(), new V003Timble());
	}
	
	public V009Tyte(T08PartOctalBaseIterator values) {
		this(new V003Timble(values), new V003Timble(values), new V003Timble(values));
	}
	
	public V009Tyte(T08PartOctal valueHigh, T08PartOctal valueMedium, T08PartOctal valueLow) {
		this(new V003Timble(valueHigh), new V003Timble(valueMedium), new V003Timble(valueLow));
	}
	
	public V009Tyte(V003Timble valueHigh, V003Timble valueMedium, V003Timble valueLow) {
		setValue(T03PartTrit.PART_1, valueHigh);
		setValue(T03PartTrit.PART_2, valueMedium);
		setValue(T03PartTrit.PART_3, valueLow);
	}
	
	public V003Timble getValue(T03PartTrit part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T03PartTrit part, V003Timble value) {
		values[part.ordinal()] = value;
	}
	
	@Override
	public int getBitCount() {
		return T08PartOctal.BIT_COUNT * T03PartTrit.LENGTH;
	}
	
	@Override
	public V009Tyte toClone() {
		return new V009Tyte(cloneIterator());
	}
	
	@Override
	public void fillOctalValues(T08PartOctalBaseAppender appender) {
		T03PartTrit.forEach(v -> getValue(v).fillOctalValues(appender));
	}

	@Override
	public void fillTyteValues(V009TyteBaseAppender appender) {
		appender.add(this);
	}
}
