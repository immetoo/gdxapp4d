package love.distributedrebirth.demo4d.fraction4d;

import java.util.ArrayList;
import java.util.List;

import love.distributedrebirth.demo4d.base2t.V009Tyte;
import love.distributedrebirth.demo4d.base2t.V009TyteBaseAppender;
import love.distributedrebirth.demo4d.base2t.V009TyteBaseIterator;
import love.distributedrebirth.demo4d.base2t.V144Tocta;

public class GroßGetậl {
	
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
		List<V009Tyte> tytes = new ArrayList<>();
		for (int i=0;i<NUMERATOR_SIZE;i++) {
			tytes.add(numerator[i]);
		}
		for (int i=0;i<DENOMINATOR_SIZE;i++) {
			tytes.add(denominator[i]);
		}
		V009TyteBaseIterator iterator = new V009TyteBaseIterator(tytes.iterator());
		V144Tocta result = new V144Tocta(iterator);
		return result;
	}
}
