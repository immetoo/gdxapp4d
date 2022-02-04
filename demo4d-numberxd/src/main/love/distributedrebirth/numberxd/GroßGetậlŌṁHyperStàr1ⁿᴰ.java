package love.distributedrebirth.numberxd;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctalStack;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class GroßGetậlŌṁHyperStàr1ⁿᴰ extends AbstractGroßGetậlŌṁ1ⁿᴰ<GroßGetậlŌṁHyperStàr1ⁿᴰ> {

	// 0th = V144Tocta
	// 1th = 5 * V144Tocta
	// 2th = 5 * 12 * V144Tocta
	// etc
	
	public GroßGetậlŌṁHyperStàr1ⁿᴰ(byte level) {
		super(level);
	}
	
	public GroßGetậlŌṁHyperStàr1ⁿᴰ(byte level, BaseIteratorOctal values) {
		super(level, values);
	}
	
	protected int resolveFractalLevel(byte level) {
		// TODO
		return level;
	}
	
	@Override
	public GroßGetậlŌṁHyperStàr1ⁿᴰ toClone() {
		BaseIteratorOctalStack cloneStack = new BaseIteratorOctalStack();
		for (int x=0;x<getValueIndex0Length();x++) {
			setValueIndex0(x);
			for (int y=0;y<getValueIndex1Length();y++) {
				setValueIndex1(y);
				cloneStack.addIterator(getValue().iteratorOctalsByClone());
			}
		}
		return new GroßGetậlŌṁHyperStàr1ⁿᴰ(getFractalLevel(), cloneStack);
	}
}