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
	
	public GroßGetậlŌṁHyperStàr1ⁿᴰ(int level) {
		super(level);
	}
	
	public GroßGetậlŌṁHyperStàr1ⁿᴰ(int level, BaseIteratorOctal values) {
		super(level, values);
	}
	
	protected int resolveFractalLevel(int level) {
		// TODO
		return level;
	}
	
	@Override
	public GroßGetậlŌṁHyperStàr1ⁿᴰ toClone(BaseIteratorOctal values) {
		return new GroßGetậlŌṁHyperStàr1ⁿᴰ(getFractalLevel(), values);
	}
	
	@Override
	public BaseIteratorOctal iteratorOctalsByClone() {
		BaseIteratorOctalStack cloneStack = new BaseIteratorOctalStack();
		for (int x=0;x<getMatrix1Length();x++) {
			setMatrix1(x);
			for (int y=0;y<getMatrix2Length();y++) {
				setMatrix2(y);
				cloneStack.addIterator(getValue().iteratorOctalsByClone());
			}
		}
		return cloneStack;
	}
}