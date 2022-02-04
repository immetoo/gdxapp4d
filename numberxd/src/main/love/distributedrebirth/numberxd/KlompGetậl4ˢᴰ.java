package love.distributedrebirth.numberxd;

import love.distributedrebirth.numberxd.base2t.BaseNumberTyte;
import love.distributedrebirth.numberxd.base2t.part.T08PartOctal;
import love.distributedrebirth.numberxd.base2t.typexl.V0x000654ˣᴸ;
import love.distributedrebirth.numberxd.base2t.typexl.V0x000CA8ˣᴸ;
import love.distributedrebirth.numberxd.base2t.BaseAppenderOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseAppenderTyte;

/**
 * Holds an 25920 bit value. (3240 bytes)
 * 
 * 4 * VCA8Tath red
 * 4 * VCA8Tath blue
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class KlompGetậl4ˢᴰ implements BaseNumberTyte<KlompGetậl4ˢᴰ> {

	public static int BIT_COUNT = V0x000654ˣᴸ.BIT_COUNT * T08PartOctal.LENGTH();
	private final V0x000CA8ˣᴸ[] values = new V0x000CA8ˣᴸ[T08PartOctal.LENGTH()];
	
	public KlompGetậl4ˢᴰ() {
		for (int i=0;i<this.values.length;i++) {
			this.values[i] = new V0x000CA8ˣᴸ();
		}
	}
	
	public KlompGetậl4ˢᴰ(BaseIteratorOctal values) {
		for (int i=0;i<this.values.length;i++) {
			this.values[i] = new V0x000CA8ˣᴸ(values);
		}
	}
	
	public V0x000CA8ˣᴸ getValue(T08PartOctal part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T08PartOctal part, V0x000CA8ˣᴸ value) {
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
		T08PartOctal.PART_1.BãßVoorElk(v -> getValue(v).fillOctalsByClone(appender));
	}
	
	@Override
	public void fillTytesByReference(BaseAppenderTyte appender) {
		T08PartOctal.PART_1.BãßVoorElk(v -> getValue(v).fillTytesByReference(appender));
	}
}
