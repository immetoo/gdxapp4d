package love.distributedrebirth.numberxd;

import java.util.ArrayList;
import java.util.List;

import love.distributedrebirth.numberxd.base2t.T08PartOctalBaseAppender;
import love.distributedrebirth.numberxd.base2t.T08PartOctalBaseIterator;
import love.distributedrebirth.numberxd.base2t.V009Tyte;
import love.distributedrebirth.numberxd.base2t.V009TyteBaseAppender;
import love.distributedrebirth.numberxd.base2t.V009TyteBaseIterator;
import love.distributedrebirth.numberxd.base2t.V090Tocta;

/**
 * Holds an 144 bit fraction.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class GroßGetậl1ⁿᴰ implements BaseGetậl<GroßGetậl1ⁿᴰ> {
	
	public static int NUMERATOR_SIZE = 7;
	public static int DENOMINATOR_SIZE = 9;
	public static int BIT_COUNT = V090Tocta.BIT_COUNT;
	private final V009Tyte[] numerator = new V009Tyte[NUMERATOR_SIZE];
	private final V009Tyte[] denominator = new V009Tyte[DENOMINATOR_SIZE];
	
	public GroßGetậl1ⁿᴰ() {
		for (int i=0;i<NUMERATOR_SIZE;i++) {
			numerator[i] = new V009Tyte();
		}
		for (int i=0;i<DENOMINATOR_SIZE;i++) {
			denominator[i] = new V009Tyte();
		}
	}
	
	public GroßGetậl1ⁿᴰ(T08PartOctalBaseIterator values) {
		for (int i=0;i<NUMERATOR_SIZE;i++) {
			numerator[i] = new V009Tyte(values);
		}
		for (int i=0;i<DENOMINATOR_SIZE;i++) {
			denominator[i] = new V009Tyte(values);
		}
	}
	
	public GroßGetậl1ⁿᴰ(V009TyteBaseIterator values) {
		for (int i=0;i<NUMERATOR_SIZE;i++) {
			numerator[i] = values.next();
		}
		for (int i=0;i<DENOMINATOR_SIZE;i++) {
			denominator[i] = values.next();
		}
	}
	
	public GroßGetậl1ⁿᴰ(V090Tocta tocta) {
		List<V009Tyte> tytes = new ArrayList<>();
		tocta.fillTytesByReference(new V009TyteBaseAppender(tytes));
		for (int i=0;i<NUMERATOR_SIZE;i++) {
			numerator[i] = tytes.get(i);
		}
		for (int i=0;i<DENOMINATOR_SIZE;i++) {
			denominator[i] = tytes.get(i+NUMERATOR_SIZE);
		}
	}
	
	public V090Tocta toToctaByReference() {
		return new V090Tocta(iteratorTytesByReference());
	}
	
	public V090Tocta toToctaByClone() {
		return new V090Tocta(iteratorOctalsByClone());
	}

	@Override
	public int getBitCount() {
		return V090Tocta.BIT_COUNT;
	}

	@Override
	public GroßGetậl1ⁿᴰ toClone() {
		return new GroßGetậl1ⁿᴰ(iteratorOctalsByClone());
	}

	@Override
	public void fillOctalsByClone(T08PartOctalBaseAppender appender) {
		for (int i=0;i<NUMERATOR_SIZE;i++) {
			numerator[i].fillOctalsByClone(appender);
		}
		for (int i=0;i<DENOMINATOR_SIZE;i++) {
			denominator[i].fillOctalsByClone(appender);
		}
	}

	@Override
	public void fillTytesByReference(V009TyteBaseAppender appender) {
		for (int i=0;i<NUMERATOR_SIZE;i++) {
			appender.add(numerator[i]);
		}
		for (int i=0;i<DENOMINATOR_SIZE;i++) {
			appender.add(denominator[i]);
		}
	}
}
