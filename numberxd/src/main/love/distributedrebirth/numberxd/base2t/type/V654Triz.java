package love.distributedrebirth.numberxd.base2t.type;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseAppenderOctal;
import love.distributedrebirth.numberxd.base2t.BaseAppenderTyte;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseNumberTyte;
import love.distributedrebirth.numberxd.base2t.part.T60PartSexagesimal;

/**
 * Holds an 1620 bit value.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class V654Triz implements BaseNumberTyte<V654Triz> {

	public static int BIT_COUNT = V01BTemvig.BIT_COUNT * T60PartSexagesimal.LENGTH();
	private V01BTemvig[] values = new V01BTemvig[T60PartSexagesimal.LENGTH()];
	
	public V654Triz() {
		for (int i=0;i<this.values.length;i++) {
			this.values[i] = new V01BTemvig();
		}
	}
	
	public V654Triz(BaseIteratorOctal values) {
		for (int i=0;i<this.values.length;i++) {
			this.values[i] = new V01BTemvig(values);
		}
	}
	
	public V01BTemvig getValue(T60PartSexagesimal part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T60PartSexagesimal part, V01BTemvig value) {
		values[part.ordinal()] = value;
	}
	
	@Override
	public int getBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public V654Triz toClone() {
		return new V654Triz(iteratorOctalsByClone());
	}
	
	@Override
	public void fillOctalsByClone(BaseAppenderOctal appender) {
		T60PartSexagesimal.PART_1.BãßVoorElk(v -> getValue(v).fillOctalsByClone(appender));
	}

	@Override
	public void fillTytesByReference(BaseAppenderTyte appender) {
		T60PartSexagesimal.PART_1.BãßVoorElk(v -> getValue(v).fillTytesByReference(appender));
	}
}
