package love.distributedrebirth.demo4d.fraction4d;

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
public class OKaassGetậl implements BaseNumberTyte<OKaassGetậl> {
	
	private OKlompGetậl[] kaas;
	private final int kaasCuts;
	
	public OKaassGetậl(int kaasCuts) {
		this.kaasCuts = kaasCuts;
		this.kaas = new OKlompGetậl[kaasCuts];
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
	
	public final OKlompGetậl getValue(int part) {
		return kaas[validatePartRequest(part)];
	}
	
	public final void setValue(int part, OKlompGetậl value) {
		kaas[validatePartRequest(part)] = value;
	}
	
	@Override
	public final OKaassGetậl toClone() {
		OKaassGetậl result = new OKaassGetậl(getKaasCuts());
		T08PartOctalBaseIterator clonedOctals = cloneIterator();
		for (int i=0;i<getKaasCuts();i++) {
			result.setValue(i, new OKlompGetậl(clonedOctals));
		}
		return result;
	}
	
	@Override
	public final int getBitCount() {
		return OKlompGetậl.BIT_COUNT * kaasCuts;
	}
	
	@Override
	public final void fillOctalValues(T08PartOctalBaseAppender appender) {
		for (OKlompGetậl value:kaas) {
			value.fillOctalValues(appender);
		}
	}
	
	@Override
	public void fillTyteValues(V009TyteBaseAppender appender) {
		for (OKlompGetậl value:kaas) {
			value.fillTyteValues(appender);
		}
	}
}
