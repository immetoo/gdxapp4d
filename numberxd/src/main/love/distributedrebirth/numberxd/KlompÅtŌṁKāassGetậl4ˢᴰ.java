package love.distributedrebirth.numberxd;

import love.distributedrebirth.numberxd.base2t.BaseNumberTyte;
import love.distributedrebirth.numberxd.base2t.BaseAppenderOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseAppenderTyte;

/**
 *  Array of ŌṁKlompGetậl4ˢᴰ sliced as cheese.
 *  
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class KlompÅtŌṁKāassGetậl4ˢᴰ implements BaseNumberTyte<KlompÅtŌṁKāassGetậl4ˢᴰ> {
	
	private KlompGetậl4ˢᴰ[] kaas;
	private final int kaasCuts;
	
	public KlompÅtŌṁKāassGetậl4ˢᴰ(int kaasCuts) {
		this.kaasCuts = kaasCuts;
		this.kaas = new KlompGetậl4ˢᴰ[kaasCuts];
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
	
	public final KlompGetậl4ˢᴰ getValue(int part) {
		return kaas[validatePartRequest(part)];
	}
	
	public final void setValue(int part, KlompGetậl4ˢᴰ value) {
		kaas[validatePartRequest(part)] = value;
	}
	
	@Override
	public final KlompÅtŌṁKāassGetậl4ˢᴰ toClone() {
		KlompÅtŌṁKāassGetậl4ˢᴰ result = new KlompÅtŌṁKāassGetậl4ˢᴰ(getKaasCuts());
		BaseIteratorOctal clonedOctals = iteratorOctalsByClone();
		for (int i=0;i<getKaasCuts();i++) {
			result.setValue(i, new KlompGetậl4ˢᴰ(clonedOctals));
		}
		return result;
	}
	
	@Override
	public final int getBitCount() {
		return KlompGetậl4ˢᴰ.BIT_COUNT * kaasCuts;
	}
	
	@Override
	public final void fillOctalsByClone(BaseAppenderOctal appender) {
		for (KlompGetậl4ˢᴰ value:kaas) {
			value.fillOctalsByClone(appender);
		}
	}
	
	@Override
	public void fillTytesByReference(BaseAppenderTyte appender) {
		for (KlompGetậl4ˢᴰ value:kaas) {
			value.fillTytesByReference(appender);
		}
	}
}
