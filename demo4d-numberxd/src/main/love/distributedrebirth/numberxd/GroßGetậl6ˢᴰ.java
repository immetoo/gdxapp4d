package love.distributedrebirth.numberxd;

import love.distributedrebirth.numberxd.base2t.part.T12PartUncial;
import love.distributedrebirth.numberxd.base2t.part.T16PartHex;
import love.distributedrebirth.numberxd.base2t.type.V009Tyte;
import love.distributedrebirth.numberxd.base2t.type.V144Tocta;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctalStack;

/**
 * Holds an 864 bit fraction.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class GroßGetậl6ˢᴰ extends AbstractBaseGetậlMatrix2<GroßGetậl6ˢᴰ,V009Tyte> {
	
	private final V144Tocta[] values = new V144Tocta[T12PartUncial.LENGTH()];
	
	public GroßGetậl6ˢᴰ() {
		for (int i=0;i<this.values.length;i++) {
			this.values[i] = new V144Tocta();
		}
	}
	
	public GroßGetậl6ˢᴰ(BaseIteratorOctal values) {
		for (int i=0;i<this.values.length;i++) {
			this.values[i] = new V144Tocta(values);
		}
	}
	
	public V009Tyte getValue() {
		return values[matrix2].getTytePart(T16PartHex.values()[matrix1]);
	}
	
	@Override
	public int getMatrix1Length() {
		return T16PartHex.LENGTH();
	}
	
	@Override
	public int getMatrix2Length() {
		return T12PartUncial.LENGTH();
	}
	
	@Override
	public GroßGetậl6ˢᴰ toClone() {
		BaseIteratorOctalStack cloneStack = new BaseIteratorOctalStack();
		for (int i=0;i<this.values.length;i++) {
			cloneStack.addIterator(this.values[i].iteratorOctalsByClone());
		}
		return new GroßGetậl6ˢᴰ(cloneStack);
	}
}
