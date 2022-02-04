package love.distributedrebirth.numberxd;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctalStack;
import love.distributedrebirth.numberxd.base2t.part.T04PartQuad;
import love.distributedrebirth.numberxd.base2t.typexl.V0x049D40ˣᴸ;

/**
 * Wave quad channel.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class WaveGetậl1ᑫᴰ extends AbstractBaseGetậlMatrix1<WaveGetậl1ᑫᴰ, V0x049D40ˣᴸ> {

	private final V0x049D40ˣᴸ[] values = new V0x049D40ˣᴸ[T04PartQuad.LENGTH()];
	
	public WaveGetậl1ᑫᴰ() {
		for (int i=0;i<this.values.length;i++) {
			this.values[i] = new V0x049D40ˣᴸ();
		}
	}
	
	public WaveGetậl1ᑫᴰ(BaseIteratorOctal values) {
		for (int i=0;i<this.values.length;i++) {
			this.values[i] = new V0x049D40ˣᴸ(values);
		}
	}
	
	@Override
	public V0x049D40ˣᴸ getValue() {
		return values[matrix1];
	}
	
	@Override
	public int getMatrix1Length() {
		return T04PartQuad.LENGTH();
	}
	
	@Override
	public WaveGetậl1ᑫᴰ toClone() {
		BaseIteratorOctalStack cloneStack = new BaseIteratorOctalStack();
		for (int i=0;i<this.values.length;i++) {
			cloneStack.addIterator(this.values[i].iteratorOctalsByClone());
		}
		return new WaveGetậl1ᑫᴰ(cloneStack);
	}
}
