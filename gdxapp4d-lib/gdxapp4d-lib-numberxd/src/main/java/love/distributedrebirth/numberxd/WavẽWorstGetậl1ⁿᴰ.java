package love.distributedrebirth.numberxd;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctalStack;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartʸᴰ;
import love.distributedrebirth.numberxd.base2t.typexl.V0x0013B0ˣᴸ;

/**
 * Wave getal in x parts.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class WavẽWorstGetậl1ⁿᴰ extends AbstractBaseGetậlMatrix1<WavẽWorstGetậl1ⁿᴰ, V0x0013B0ˣᴸ> {
	
	private final V0x0013B0ˣᴸ[] values;
	private final BãßBȍőnPartʸᴰ<?> worstCut;
	private final int worstCutLength;
	
	public WavẽWorstGetậl1ⁿᴰ(BãßBȍőnPartʸᴰ<?> worstCut) {
		this.worstCut = worstCut;
		this.worstCutLength = worstCut.BãßInstances().length;
		this.values = new V0x0013B0ˣᴸ[this.worstCutLength];
		for (int i=0;i<this.values.length;i++) {
			this.values[i] = new V0x0013B0ˣᴸ();
		}
	}
	
	public WavẽWorstGetậl1ⁿᴰ(BãßBȍőnPartʸᴰ<?> worstCut, BaseIteratorOctal values) {
		this.worstCut = worstCut;
		this.worstCutLength = worstCut.BãßInstances().length;
		this.values = new V0x0013B0ˣᴸ[this.worstCutLength];
		for (int i=0;i<this.values.length;i++) {
			this.values[i] = new V0x0013B0ˣᴸ(values);
		}
	}
	
	@Override
	public V0x0013B0ˣᴸ getValue() {
		return values[matrix1];
	}
	
	@Override
	public int getMatrix1Length() {
		return worstCutLength;
	}
	
	@Override
	public WavẽWorstGetậl1ⁿᴰ toClone(BaseIteratorOctal values) {
		return new WavẽWorstGetậl1ⁿᴰ(worstCut, values);
	}
	
	@Override
	public BaseIteratorOctal iteratorOctalsByClone() {
		BaseIteratorOctalStack cloneStack = new BaseIteratorOctalStack();
		for (int i=0;i<this.values.length;i++) {
			cloneStack.addIterator(this.values[i].iteratorOctalsByClone());
		}
		return cloneStack;
	}
}
