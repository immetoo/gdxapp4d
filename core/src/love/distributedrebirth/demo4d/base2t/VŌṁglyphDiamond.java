package love.distributedrebirth.demo4d.base2t;

public class VŌṁglyphDiamond extends VŌṁglyph<VŌṁglyphDiamond> {

	// 0th = 1 * V144Tocta (1)
	// 1th = 1+3 * V144Tocta (4)
	// 2th = 1+3+6 * V144Tocta (10)
	// 3th = 1+3+6+14 * V144Tocta (24)
	// etc
	
	public VŌṁglyphDiamond(byte level) {
		super(level);
	}
	
	protected int resolveFractalLevel(byte level) {
		// TODO
		return level;
	}
	
	@Override
	protected VŌṁglyphDiamond toCloneFractal(byte level) {
		return new VŌṁglyphDiamond(level);
	}
}
