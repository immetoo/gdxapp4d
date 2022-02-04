package love.distributedrebirth.numberxd;

import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctalStack;
import love.distributedrebirth.numberxd.base2t.part.T08PartOctal;
import love.distributedrebirth.numberxd.base2t.typexl.V0x000CA8ˣᴸ;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

/**
 *  Array of ŌṁKlompGetậl4ˢᴰ sliced as cheese.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class KlompÅtŌṁKāassGetậl4ˢᴰ extends AbstractBaseGetậlLevel1<KlompÅtŌṁKāassGetậl4ˢᴰ, V0x000CA8ˣᴸ> {
	
	private final V0x000CA8ˣᴸ[][] kaas;
	private final int kaasCuts;
	
	public KlompÅtŌṁKāassGetậl4ˢᴰ(int kaasCuts) {
		if (kaasCuts < 2) {
			throw new IllegalArgumentException("Can't slice cheese into less than one peace.");
		}
		this.kaasCuts = kaasCuts;
		this.kaas = new V0x000CA8ˣᴸ[T08PartOctal.LENGTH()][kaasCuts];
		for (int x=0;x<this.kaas.length;x++) {
			for (int y=0;y<this.kaas[x].length;y++) {
				this.kaas[x][y] = new V0x000CA8ˣᴸ();
			}
		}
	}
	
	public KlompÅtŌṁKāassGetậl4ˢᴰ(int kaasCuts, BaseIteratorOctal values) {
		if (kaasCuts < 2) {
			throw new IllegalArgumentException("Can't slice cheese into less than one peace.");
		}
		this.kaasCuts = kaasCuts;
		this.kaas = new V0x000CA8ˣᴸ[T08PartOctal.LENGTH()][kaasCuts];
		for (int x=0;x<this.kaas.length;x++) {
			for (int y=0;y<this.kaas[x].length;y++) {
				this.kaas[x][y] = new V0x000CA8ˣᴸ(values);
			}
		}
	}
	
	public int getKaasCuts() {
		return kaasCuts;
	}
	
	@Override
	public V0x000CA8ˣᴸ getValue() {
		return kaas[valueIndex0][valueIndex1];
	}
	
	@Override
	public int getValueIndex0Length() {
		return T08PartOctal.LENGTH();
	}

	@Override
	public int getValueIndex1Length() {
		return kaasCuts;
	}

	@Override
	public KlompÅtŌṁKāassGetậl4ˢᴰ toClone() {
		BaseIteratorOctalStack cloneStack = new BaseIteratorOctalStack();
		for (int x=0;x<getValueIndex0Length();x++) {
			setValueIndex0(x);
			for (int y=0;y<getValueIndex1Length();y++) {
				setValueIndex1(y);
				cloneStack.addIterator(getValue().iteratorOctalsByClone());
			}
		}
		return new KlompÅtŌṁKāassGetậl4ˢᴰ(getKaasCuts(), cloneStack);
	}
}
