package love.distributedrebirth.numberxd;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctalStack;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class GroßGetậlŌṁDiamond1ⁿᴰ extends AbstractGroßGetậlŌṁ1ⁿᴰ<GroßGetậlŌṁDiamond1ⁿᴰ> {

	// 0th = 1 * V144Tocta (1)
	// 1th = 1+3 * V144Tocta (4)
	// 2th = 1+3+6 * V144Tocta (10)
	// 3th = 1+3+6+14 * V144Tocta (24)
	// etc
	
	public GroßGetậlŌṁDiamond1ⁿᴰ(byte level) {
		super(level);
	}
	
	public GroßGetậlŌṁDiamond1ⁿᴰ(byte level, BaseIteratorOctal values) {
		super(level, values);
	}
	
	protected int resolveFractalLevel(byte level) {
		// TODO
		return level;
	}
	
	@Override
	public GroßGetậlŌṁDiamond1ⁿᴰ toClone() {
		BaseIteratorOctalStack cloneStack = new BaseIteratorOctalStack();
		for (int x=0;x<getValueIndex0Length();x++) {
			setValueIndex0(x);
			for (int y=0;y<getValueIndex1Length();y++) {
				setValueIndex1(y);
				cloneStack.addIterator(getValue().iteratorOctalsByClone());
			}
		}
		return new GroßGetậlŌṁDiamond1ⁿᴰ(getFractalLevel(), cloneStack);
	}
}
