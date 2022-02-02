package love.distributedrebirth.numberxd;

import love.distributedrebirth.numberxd.base2t.BaseNumberTyte;
import love.distributedrebirth.numberxd.base2t.T08PartOctal;
import love.distributedrebirth.numberxd.base2t.BaseAppenderOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseAppenderTyte;
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
public class KlompGetậl4ˢᴰ implements BaseNumberTyte<KlompGetậl4ˢᴰ> {

	public static int BIT_COUNT = V654Triz.BIT_COUNT * T08PartOctal.LENGTH();
	private final VCA8Tath[] values = new VCA8Tath[T08PartOctal.LENGTH()];
	
	public KlompGetậl4ˢᴰ() {
		for (int i=0;i<this.values.length;i++) {
			this.values[i] = new VCA8Tath();
		}
	}
	
	public KlompGetậl4ˢᴰ(BaseIteratorOctal values) {
		for (int i=0;i<this.values.length;i++) {
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
	public KlompGetậl4ˢᴰ toClone() {
		return new KlompGetậl4ˢᴰ(iteratorOctalsByClone());
	}
	
	@Override
	public void fillOctalsByClone(BaseAppenderOctal appender) {
		T08PartOctal.PART_1.staticVoorElk(v -> getValue(v).fillOctalsByClone(appender));
	}
	
	@Override
	public void fillTytesByReference(BaseAppenderTyte appender) {
		T08PartOctal.PART_1.staticVoorElk(v -> getValue(v).fillTytesByReference(appender));
	}
}
