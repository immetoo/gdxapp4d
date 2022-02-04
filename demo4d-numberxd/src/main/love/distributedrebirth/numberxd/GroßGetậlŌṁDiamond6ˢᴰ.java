package love.distributedrebirth.numberxd;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctalStack;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class GroßGetậlŌṁDiamond6ˢᴰ extends AbstractGroßGetậlŌṁ6ˢᴰ<GroßGetậlŌṁDiamond6ˢᴰ> {

	// 0th = 1 * V144Tocta (1)
	// 1th = 1+3 * V144Tocta (4)
	// 2th = 1+3+6 * V144Tocta (10)
	// 3th = 1+3+6+14 * V144Tocta (24)
	// etc
	
	public GroßGetậlŌṁDiamond6ˢᴰ(int level) {
		super(level);
	}
	
	public GroßGetậlŌṁDiamond6ˢᴰ(int level, BaseIteratorOctal values) {
		super(level, values);
	}
	
	protected int resolveFractalLevel(int level) {
		// TODO
		return level;
	}
	
	@Override
	public GroßGetậlŌṁDiamond6ˢᴰ toClone() {
		BaseIteratorOctalStack cloneStack = new BaseIteratorOctalStack();
		for (int x=0;x<getMatrix0Length();x++) {
			setMatrix0(x);
			for (int y=0;y<getMatrix1Length();y++) {
				setMatrix1(y);
				for (int z=0;z<getMatrix1Length();z++) {
					setMatrix1(z);
					cloneStack.addIterator(getValue().iteratorOctalsByClone());
				}
			}
		}
		return new GroßGetậlŌṁDiamond6ˢᴰ(getFractalLevel(), cloneStack);
	}
}
