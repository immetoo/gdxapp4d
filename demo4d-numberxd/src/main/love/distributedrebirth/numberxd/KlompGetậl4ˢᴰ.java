package love.distributedrebirth.numberxd;

import love.distributedrebirth.numberxd.base2t.typexl.V0x000CA8ˣᴸ;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctalStack;
import love.distributedrebirth.numberxd.base2t.part.T08PartOctal;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class KlompGetậl4ˢᴰ extends AbstractBaseGetậlLevel0<KlompGetậl4ˢᴰ,V0x000CA8ˣᴸ> {

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
	
	@Override
	public V0x000CA8ˣᴸ getValue() {
		return values[valueIndex0];
	}
	
	@Override
	public int getValueIndex0Length() {
		return T08PartOctal.LENGTH();
	}
	
	@Override
	public KlompGetậl4ˢᴰ toClone() {
		BaseIteratorOctalStack cloneStack = new BaseIteratorOctalStack();
		for (int i=0;i<this.values.length;i++) {
			cloneStack.addIterator(this.values[i].iteratorOctalsByClone());
		}
		return new KlompGetậl4ˢᴰ(cloneStack);
	}
}
