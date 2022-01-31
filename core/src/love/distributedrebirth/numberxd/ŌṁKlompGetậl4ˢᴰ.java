package love.distributedrebirth.numberxd;

import love.distributedrebirth.numberxd.base2t.BaseNumberTyte;
import love.distributedrebirth.numberxd.base2t.T08PartOctal;
import love.distributedrebirth.numberxd.base2t.T08PartOctalBaseAppender;
import love.distributedrebirth.numberxd.base2t.T08PartOctalBaseIterator;
import love.distributedrebirth.numberxd.base2t.V009TyteBaseAppender;
import love.distributedrebirth.numberxd.base2t.V654Triz;
import love.distributedrebirth.numberxd.base2t.VCA8Tath;

/**
 * Holds an 25920 bit value. (3240 bytes)
 * 
 * 4 * VCA8Tath red
 * 4 * VCA8Tath blue
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class ŌṁKlompGetậl4ˢᴰ implements BaseNumberTyte<ŌṁKlompGetậl4ˢᴰ> {

	public static int BIT_COUNT = V654Triz.BIT_COUNT * T08PartOctal.LENGTH;
	private final VCA8Tath[] values = new VCA8Tath[T08PartOctal.LENGTH];
	
	public ŌṁKlompGetậl4ˢᴰ() {
		for (int i=0;i<T08PartOctal.LENGTH;i++) {
			this.values[i] = new VCA8Tath();
		}
	}
	
	public ŌṁKlompGetậl4ˢᴰ(T08PartOctalBaseIterator values) {
		for (int i=0;i<T08PartOctal.LENGTH;i++) {
			this.values[i] = new VCA8Tath(values);
		}
	}
	
	public VCA8Tath getValue(T08PartOctal part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T08PartOctal part, VCA8Tath value) {
		values[part.ordinal()] = value;
	}
	
	@Override
	public int getBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public ŌṁKlompGetậl4ˢᴰ toClone() {
		return new ŌṁKlompGetậl4ˢᴰ(iteratorOctalsByClone());
	}
	
	@Override
	public void fillOctalsByClone(T08PartOctalBaseAppender appender) {
		T08PartOctal.forEach(v -> getValue(v).fillOctalsByClone(appender));
	}
	
	@Override
	public void fillTytesByReference(V009TyteBaseAppender appender) {
		T08PartOctal.forEach(v -> getValue(v).fillTytesByReference(appender));
	}
}
