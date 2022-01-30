package love.distributedrebirth.demo4d.numberxd;

import love.distributedrebirth.demo4d.base2t.BaseNumberTyte;
import love.distributedrebirth.demo4d.base2t.T08PartOctalBaseAppender;
import love.distributedrebirth.demo4d.base2t.T08PartOctalBaseIterator;
import love.distributedrebirth.demo4d.base2t.V009TyteBaseAppender;

/**
 *  Array of KlompGetậl sliced as cheese.
 *  
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public class ŌṁKaassGetậl implements BaseNumberTyte<ŌṁKaassGetậl> {
	
	private ŌṁKlompGetậl[] kaas;
	private final int kaasCuts;
	
	public ŌṁKaassGetậl(int kaasCuts) {
		this.kaasCuts = kaasCuts;
		this.kaas = new ŌṁKlompGetậl[kaasCuts];
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
	
	public final ŌṁKlompGetậl getValue(int part) {
		return kaas[validatePartRequest(part)];
	}
	
	public final void setValue(int part, ŌṁKlompGetậl value) {
		kaas[validatePartRequest(part)] = value;
	}
	
	@Override
	public final ŌṁKaassGetậl toClone() {
		ŌṁKaassGetậl result = new ŌṁKaassGetậl(getKaasCuts());
		T08PartOctalBaseIterator clonedOctals = cloneIterator();
		for (int i=0;i<getKaasCuts();i++) {
			result.setValue(i, new ŌṁKlompGetậl(clonedOctals));
		}
		return result;
	}
	
	@Override
	public final int getBitCount() {
		return ŌṁKlompGetậl.BIT_COUNT * kaasCuts;
	}
	
	@Override
	public final void fillOctalValues(T08PartOctalBaseAppender appender) {
		for (ŌṁKlompGetậl value:kaas) {
			value.fillOctalValues(appender);
		}
	}
	
	@Override
	public void fillTyteValues(V009TyteBaseAppender appender) {
		for (ŌṁKlompGetậl value:kaas) {
			value.fillTyteValues(appender);
		}
	}
}
