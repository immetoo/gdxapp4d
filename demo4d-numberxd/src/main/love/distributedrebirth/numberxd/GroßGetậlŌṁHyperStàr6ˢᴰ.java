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
	public GroßGetậlŌṁHyperStàr6ˢᴰ toClone(BaseIteratorOctal values) {
		return new GroßGetậlŌṁHyperStàr6ˢᴰ(getFractalLevel(), values);
	}
	
	@Override
	public BaseIteratorOctal iteratorOctalsByClone() {
		BaseIteratorOctalStack cloneStack = new BaseIteratorOctalStack();
		for (int x=0;x<getMatrix1Length();x++) {
			setMatrix1(x);
			for (int y=0;y<getMatrix2Length();y++) {
				setMatrix2(y);
				for (int z=0;z<getMatrix2Length();z++) {
					setMatrix2(z);
					cloneStack.addIterator(getValue().iteratorOctalsByClone());
				}
			}
		}
		return cloneStack;
	}
}