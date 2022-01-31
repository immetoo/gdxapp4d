package love.distributedrebirth.numberxd;

import love.distributedrebirth.numberxd.base2t.BaseNumberTyte;
import love.distributedrebirth.numberxd.base2t.T08PartOctalBaseAppender;
import love.distributedrebirth.numberxd.base2t.T08PartOctalBaseIterator;
import love.distributedrebirth.numberxd.base2t.V009TyteBaseAppender;

/**
 *  Array of KlompGetậl sliced as cheese.
 *  
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public class ŌṁKaassGetậl4D implements BaseNumberTyte<ŌṁKaassGetậl4D> {
	
	private ŌṁKlompGetậl4D[] kaas;
	private final int kaasCuts;
	
	public ŌṁKaassGetậl4D(int kaasCuts) {
		this.kaasCuts = kaasCuts;
		this.kaas = new ŌṁKlompGetậl4D[kaasCuts];
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
	
	public final ŌṁKlompGetậl4D getValue(int part) {
		return kaas[validatePartRequest(part)];
	}
	
	public final void setValue(int part, ŌṁKlompGetậl4D value) {
		kaas[validatePartRequest(part)] = value;
	}
	
	@Override
	public final ŌṁKaassGetậl4D toClone() {
		ŌṁKaassGetậl4D result = new ŌṁKaassGetậl4D(getKaasCuts());
		T08PartOctalBaseIterator clonedOctals = iteratorOctalsByClone();
		for (int i=0;i<getKaasCuts();i++) {
			result.setValue(i, new ŌṁKlompGetậl4D(clonedOctals));
		}
		return result;
	}
	
	@Override
	public final int getBitCount() {
		return ŌṁKlompGetậl4D.BIT_COUNT * kaasCuts;
	}
	
	@Override
	public final void fillOctalsByClone(T08PartOctalBaseAppender appender) {
		for (ŌṁKlompGetậl4D value:kaas) {
			value.fillOctalsByClone(appender);
		}
	}
	
	@Override
	public void fillTytesByReference(V009TyteBaseAppender appender) {
		for (ŌṁKlompGetậl4D value:kaas) {
			value.fillTytesByReference(appender);
		}
	}
}
