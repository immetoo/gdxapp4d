package love.distributedrebirth.numberxd;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctalStack;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartʸᴰ;
import love.distributedrebirth.numberxd.base2t.typexl.V0x0013B0ˣᴸ;

/**
 * Wave channel in y parts.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class WavẽWorstGetậl2ⁿᴰ extends AbstractBaseGetậlMatrix2<WavẽWorstGetậl2ⁿᴰ, V0x0013B0ˣᴸ> {

	private final V0x0013B0ˣᴸ[][] values;
	private final BãßBȍőnPartʸᴰ<?> worstCut;
	private final int worstCutLength;
	private final BãßBȍőnPartʸᴰ<?> worstChannel;
	private final int worstChannelLength;
	
	public WavẽWorstGetậl2ⁿᴰ(BãßBȍőnPartʸᴰ<?> worstCut, BãßBȍőnPartʸᴰ<?> worstChannel) {
		this.worstCut = worstCut;
		this.worstCutLength = worstCut.BãßInstances().length;
		this.worstChannel = worstChannel;
		this.worstChannelLength = worstChannel.BãßInstances().length;
		this.values = new V0x0013B0ˣᴸ[this.worstCutLength][this.worstChannelLength];
		for (int x=0;x<this.worstCutLength;x++) {
			for (int y=0;y<this.worstChannelLength;y++) {
				this.values[x][y] = new V0x0013B0ˣᴸ();
			}
		}
	}
	
	public WavẽWorstGetậl2ⁿᴰ(BãßBȍőnPartʸᴰ<?> worstCut, BãßBȍőnPartʸᴰ<?> worstChannel, BaseIteratorOctal values) {
		this.worstCut = worstCut;
		this.worstCutLength = worstCut.BãßInstances().length;
		this.worstChannel = worstChannel;
		this.worstChannelLength = worstChannel.BãßInstances().length;
		this.values = new V0x0013B0ˣᴸ[this.worstCutLength][this.worstChannelLength];
		for (int x=0;x<this.worstCutLength;x++) {
			for (int y=0;y<this.worstChannelLength;y++) {
				this.values[x][y] = new V0x0013B0ˣᴸ(values);
			}
		}
	}
	
	@Override
	public V0x0013B0ˣᴸ getValue() {
		return values[matrix1][matrix2];
	}
	
	@Override
	public int getMatrix1Length() {
		return worstCutLength;
	}
	
	@Override
	public int getMatrix2Length() {
		return worstChannelLength;
	}
	
	@Override
	public WavẽWorstGetậl2ⁿᴰ toClone(BaseIteratorOctal values) {
		return new WavẽWorstGetậl2ⁿᴰ(worstCut, worstChannel, values);
	}
	
	@Override
	public BaseIteratorOctal iteratorOctalsByClone() {
		BaseIteratorOctalStack cloneStack = new BaseIteratorOctalStack();
		for (int x=0;x<this.worstCutLength;x++) {
			for (int y=0;y<this.worstChannelLength;y++) {
				cloneStack.addIterator(this.values[x][y].iteratorOctalsByClone());
			}
		}
		return cloneStack;
	}
}
