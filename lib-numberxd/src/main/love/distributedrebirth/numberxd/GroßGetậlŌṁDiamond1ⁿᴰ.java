package love.distributedrebirth.numberxd;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctalStack;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class GroßGetậlŌṁDiamond1ⁿᴰ extends AbstractGroßGetậlŌṁ1ⁿᴰ<GroßGetậlŌṁDiamond1ⁿᴰ> {

	// 1th = 1 * V144Tocta (1)
	// 2th = 1+3 * V144Tocta (4)
	// 3th = 1+3+6 * V144Tocta (10)
	// 4th = 1+3+6+14 * V144Tocta (24)
	// etc
	
	public GroßGetậlŌṁDiamond1ⁿᴰ(int level) {
		super(level);
	}
	
	public GroßGetậlŌṁDiamond1ⁿᴰ(int level, BaseIteratorOctal values) {
		super(level, values);
	}
	
	protected int resolveFractalLevel(int n) {
		if (n == 1) {
			return 1;
		} else {
			int result =  1 + n * resolveFractalLevel(n - 1);
			return result;
		}
	}
	
	@Override
	public GroßGetậlŌṁDiamond1ⁿᴰ toClone(BaseIteratorOctal values) {
		return new GroßGetậlŌṁDiamond1ⁿᴰ(getFractalLevel(), values);
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
