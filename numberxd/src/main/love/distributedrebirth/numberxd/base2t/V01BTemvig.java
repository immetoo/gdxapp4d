package love.distributedrebirth.numberxd.base2t;

/**
 * Holds an 27 bit value.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public final class V01BTemvig implements BaseNumberTyte<V01BTemvig> {

	public static int BIT_COUNT = V009Tyte.BIT_COUNT * T03PartTrit.LENGTH();
	private V009Tyte[] values = new V009Tyte[T03PartTrit.LENGTH()];
	
	public V01BTemvig() {
		this(new V009Tyte(), new V009Tyte(), new V009Tyte());
	}
	
	public V01BTemvig(BaseIteratorOctal values) {
		this(new V009Tyte(values), new V009Tyte(values), new V009Tyte(values));
	}
	
	public V01BTemvig(BaseIteratorTyte values) {
		this(values.next(), values.next(), values.next());
	}
	
	private V01BTemvig(V009Tyte valueHigh, V009Tyte valueMedium, V009Tyte valueLow) {
		setValue(T03PartTrit.PART_1, valueHigh);
		setValue(T03PartTrit.PART_2, valueMedium);
		setValue(T03PartTrit.PART_3, valueLow);
	}
	
	public V009Tyte getValue(T03PartTrit part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T03PartTrit part, V009Tyte value) {
		values[part.ordinal()] = value;
	}
	
	@Override
	public int getBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public V01BTemvig toClone() {
		return new V01BTemvig(iteratorOctalsByClone());
	}
	
	@Override
	public void fillOctalsByClone(BaseAppenderOctal appender) {
		T03PartTrit.PART_1.staticVoorElk(v -> getValue(v).fillOctalsByClone(appender));
	}

	@Override
	public void fillTytesByReference(BaseAppenderTyte appender) {
		T03PartTrit.PART_1.staticVoorElk(v -> getValue(v).fillTytesByReference(appender));
	}
}
