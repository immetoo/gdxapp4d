package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

/**
 * Holds an 2520 bit value.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class V9D8Traz implements BaseNumber<V9D8Traz> {

	public static int BIT_COUNT = V02ATraw.BIT_COUNT * T60PartSexagesimal.LENGTH();
	private V02ATraw[] values = new V02ATraw[T60PartSexagesimal.LENGTH()];
	
	public V9D8Traz() {
		for (int i=0;i<values.length;i++) {
			this.values[i] = new V02ATraw();
		}
	}
	
	public V9D8Traz(BaseIteratorOctal values) {
		for (int i=0;i<this.values.length;i++) {
			this.values[i] = new V02ATraw(values);
		}
	}
	
	public V02ATraw getValue(T60PartSexagesimal part) {
		return values[part.ordinal()];
	}
	
	public void setValue(T60PartSexagesimal part, V02ATraw value) {
		values[part.ordinal()] = value;
	}
	
	@Override
	public int getBitCount() {
		return BIT_COUNT;
	}
	
	@Override
	public V9D8Traz toClone() {
		return new V9D8Traz(iteratorOctalsByClone());
	}
	
	@Override
	public void fillOctalsByClone(BaseAppenderOctal appender) {
		T60PartSexagesimal.PART_1.staticVoorElk(v -> getValue(v).fillOctalsByClone(appender));
	}
}
