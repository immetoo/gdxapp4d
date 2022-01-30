package love.distributedrebirth.demo4d.fraction4d;

import java.util.ArrayList;
import java.util.List;

import love.distributedrebirth.demo4d.base2t.BaseNumberTyte;
import love.distributedrebirth.demo4d.base2t.T08PartOctalBaseAppender;
import love.distributedrebirth.demo4d.base2t.T08PartOctalBaseIterator;
import love.distributedrebirth.demo4d.base2t.V009Tyte;
import love.distributedrebirth.demo4d.base2t.V009TyteBaseAppender;
import love.distributedrebirth.demo4d.base2t.V009TyteBaseIterator;
import love.distributedrebirth.demo4d.base2t.V144Tocta;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public class GroßGetậl implements BaseNumberTyte<GroßGetậl> {
	
	public static int NUMERATOR_SIZE = 7;
	public static int DENOMINATOR_SIZE = 9;
	private final V009Tyte[] numerator = new V009Tyte[NUMERATOR_SIZE];
	private final V009Tyte[] denominator = new V009Tyte[DENOMINATOR_SIZE];
	
	public GroßGetậl() {
		for (int i=0;i<NUMERATOR_SIZE;i++) {
			numerator[i] = new V009Tyte();
		}
		for (int i=0;i<DENOMINATOR_SIZE;i++) {
			denominator[i] = new V009Tyte();
		}
	}
	
	public GroßGetậl(T08PartOctalBaseIterator values) {
		for (int i=0;i<NUMERATOR_SIZE;i++) {
			numerator[i] = new V009Tyte(values);
		}
		for (int i=0;i<DENOMINATOR_SIZE;i++) {
			denominator[i] = new V009Tyte(values);
		}
	}
	
	public GroßGetậl(V009TyteBaseIterator values) {
		for (int i=0;i<NUMERATOR_SIZE;i++) {
			numerator[i] = values.next();
		}
		for (int i=0;i<DENOMINATOR_SIZE;i++) {
			denominator[i] = values.next();
		}
	}
	
	public GroßGetậl(V144Tocta tocta) {
		List<V009Tyte> tytes = new ArrayList<>();
		tocta.fillTyteValues(new V009TyteBaseAppender(tytes));
		for (int i=0;i<NUMERATOR_SIZE;i++) {
			numerator[i] = tytes.get(i);
		}
		for (int i=0;i<DENOMINATOR_SIZE;i++) {
			denominator[i] = tytes.get(i+NUMERATOR_SIZE);
		}
	}
	
	public V144Tocta toTocta() {
		return new V144Tocta(cloneIterator());
	}

	@Override
	public int getBitCount() {
		return V144Tocta.BIT_COUNT;
	}

	@Override
	public GroßGetậl toClone() {
		return new GroßGetậl(cloneIterator());
	}

	@Override
	public void fillOctalValues(T08PartOctalBaseAppender appender) {
		for (int i=0;i<NUMERATOR_SIZE;i++) {
			numerator[i].fillOctalValues(appender);
		}
		for (int i=0;i<DENOMINATOR_SIZE;i++) {
			denominator[i].fillOctalValues(appender);
		}
	}

	@Override
	public void fillTyteValues(V009TyteBaseAppender appender) {
		for (int i=0;i<NUMERATOR_SIZE;i++) {
			appender.add(numerator[i]);
		}
		for (int i=0;i<DENOMINATOR_SIZE;i++) {
			appender.add(denominator[i]);
		}
	}
}
