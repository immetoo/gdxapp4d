package love.distributedrebirth.numberxd;

import love.distributedrebirth.numberxd.base2t.BaseNumberTyte;
import love.distributedrebirth.numberxd.base2t.T08PartOctalBaseAppender;
import love.distributedrebirth.numberxd.base2t.T08PartOctalBaseIterator;
import love.distributedrebirth.numberxd.base2t.V009TyteBaseAppender;

/**
 *  Array of ŌṁKlompGetậl4ˢᴰ sliced as cheese.
 *  
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class ŌṁKaassGetậl4ˢᴰ implements BaseNumberTyte<ŌṁKaassGetậl4ˢᴰ> {
	
	private ŌṁKlompGetậl4ˢᴰ[] kaas;
	private final int kaasCuts;
	
	public ŌṁKaassGetậl4ˢᴰ(int kaasCuts) {
		this.kaasCuts = kaasCuts;
		this.kaas = new ŌṁKlompGetậl4ˢᴰ[kaasCuts];
	}
	
	public final int getKaasCuts() {
		return kaasCuts;
	}
	
	private final int validatePartRequest(int part) {
		if (part < 0) {
			throw new IllegalArgumentException("Requested part is negative");
		}
		if (part > kaasCuts) {
			throw new IllegalArgumentException("Requested part exceeds kaasCuts storage");
		}
		return part;
	}
	
	public final ŌṁKlompGetậl4ˢᴰ getValue(int part) {
		return kaas[validatePartRequest(part)];
	}
	
	public final void setValue(int part, ŌṁKlompGetậl4ˢᴰ value) {
		kaas[validatePartRequest(part)] = value;
	}
	
	@Override
	public final ŌṁKaassGetậl4ˢᴰ toClone() {
		ŌṁKaassGetậl4ˢᴰ result = new ŌṁKaassGetậl4ˢᴰ(getKaasCuts());
		T08PartOctalBaseIterator clonedOctals = iteratorOctalsByClone();
		for (int i=0;i<getKaasCuts();i++) {
			result.setValue(i, new ŌṁKlompGetậl4ˢᴰ(clonedOctals));
		}
		return result;
	}
	
	@Override
	public final int getBitCount() {
		return ŌṁKlompGetậl4ˢᴰ.BIT_COUNT * kaasCuts;
	}
	
	@Override
	public final void fillOctalsByClone(T08PartOctalBaseAppender appender) {
		for (ŌṁKlompGetậl4ˢᴰ value:kaas) {
			value.fillOctalsByClone(appender);
		}
	}
	
	@Override
	public void fillTytesByReference(V009TyteBaseAppender appender) {
		for (ŌṁKlompGetậl4ˢᴰ value:kaas) {
			value.fillTytesByReference(appender);
		}
	}
}
