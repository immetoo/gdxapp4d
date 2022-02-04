package love.distributedrebirth.numberxd;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctalStack;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class GroßGetậlŌṁHyperStàr6ˢᴰ extends AbstractGroßGetậlŌṁ6ˢᴰ<GroßGetậlŌṁHyperStàr6ˢᴰ> {

	// 0th = V144Tocta
	// 1th = 5 * V144Tocta
	// 2th = 5 * 12 * V144Tocta
	// etc
	
	public GroßGetậlŌṁHyperStàr6ˢᴰ(int level) {
		super(level);
	}
	
	public GroßGetậlŌṁHyperStàr6ˢᴰ(int level, BaseIteratorOctal values) {
		super(level, values);
	}
	
	protected int resolveFractalLevel(int level) {
		// TODO
		return level;
	}

	@Override
	public GroßGetậlŌṁHyperStàr6ˢᴰ toClone() {
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
		return new GroßGetậlŌṁHyperStàr6ˢᴰ(getFractalLevel(), cloneStack);
	}
}