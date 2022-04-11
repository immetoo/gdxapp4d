package love.distributedrebirth.numberxd.base2t.typexl;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseAppenderOctal;
import love.distributedrebirth.numberxd.base2t.BaseAppenderTyte;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorTyte;
import love.distributedrebirth.numberxd.base2t.BaseNumberTyteˣᴸ;
import love.distributedrebirth.numberxd.base2t.part.T60PartSexagesimal;
import love.distributedrebirth.numberxd.base2t.type.V027Temvig;

/**
 * Holds an 1620 bit value.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class V0x000654ˣᴸ implements BaseNumberTyteˣᴸ<V0x000654ˣᴸ> {

	public static int BIT_COUNT = V027Temvig.BIT_COUNT * T60PartSexagesimal.LENGTH();
	private V027Temvig[] values = new V027Temvig[T60PartSexagesimal.LENGTH()];
	
	public V0x000654ˣᴸ() {
		for (int i=0;i<this.values.length;i++) {
			this.values[i] = new V027Temvig();
		}
	}
	
	public V0x000654ˣᴸ(BaseIteratorOctal values) {
		for (int i=0;i<this.values.length;i++) {
			this.values[i] = new V027Temvig(values);
		}
	}
	
	public V0x000654ˣᴸ(BaseIteratorTyte values) {
		for (int i=0;i<this.values.length;i++) {
			this.values[i] = new V027Temvig(values);
		}
	}
	
	public V027Temvig getValue(T60PartSexagesimal part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T60PartSexagesimal part, V027Temvig value) {
		values[part.ordinal()] = value;
	}
	
	@Override
	public int BãßBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public V0x000654ˣᴸ toClone(BaseIteratorOctal values) {
		return new V0x000654ˣᴸ(values);
	}
	
	@Override
	public void fillOctalsByClone(BaseAppenderOctal appender) {
		T60PartSexagesimal.PART_1.BãßVoorElk(v -> getValue(v).fillOctalsByClone(appender));
	}
	
	@Override
	public V0x000654ˣᴸ toReference(BaseIteratorTyte values) {
		return new V0x000654ˣᴸ(values);
	}
	
	@Override
	public void fillTytesByReference(BaseAppenderTyte appender) {
		T60PartSexagesimal.PART_1.BãßVoorElk(v -> getValue(v).fillTytesByReference(appender));
	}
}
