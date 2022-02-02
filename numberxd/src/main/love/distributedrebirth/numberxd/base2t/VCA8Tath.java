package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

/**
 * Holds an 3240 bit value.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class VCA8Tath implements BaseNumberTyte<VCA8Tath> {

	public static int BIT_COUNT = V654Triz.BIT_COUNT * T02PartBinary.LENGTH();
	private V654Triz[] values = new V654Triz[T02PartBinary.LENGTH()];
	
	public VCA8Tath() {
		this(new V654Triz(), new V654Triz());
	}
	
	public VCA8Tath(BaseIteratorOctal values) {
		this(new V654Triz(values), new V654Triz(values));
	}
	
	private VCA8Tath(V654Triz valueHigh, V654Triz valueLow) {
		setValue(T02PartBinary.PART_1, valueHigh);
		setValue(T02PartBinary.PART_2, valueLow);
	}
	
	public V654Triz getValue(T02PartBinary part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T02PartBinary part, V654Triz value) {
		values[part.ordinal()] = value;
	}
	
	@Override
	public int getBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public VCA8Tath toClone() {
		return new VCA8Tath(iteratorOctalsByClone());
	}
	
	@Override
	public void fillOctalsByClone(BaseAppenderOctal appender) {
		T02PartBinary.PART_1.BãßVoorElk(v -> getValue(v).fillOctalsByClone(appender));
	}

	@Override
	public void fillTytesByReference(BaseAppenderTyte appender) {
		T02PartBinary.PART_1.BãßVoorElk(v -> getValue(v).fillTytesByReference(appender));
	}
}
