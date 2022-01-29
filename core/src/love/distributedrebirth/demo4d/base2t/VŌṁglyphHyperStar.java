package love.distributedrebirth.demo4d.base2t;

public class VŌṁglyphHyperStar extends VŌṁglyph<VŌṁglyphHyperStar> {

	// 0th = V144Tocta
	// 1th = 5 * V144Tocta
	// 2th = 5 * 12 * V144Tocta
	// etc
	
	public VŌṁglyphHyperStar(byte level) {
		super(level);
	}
	
	protected int resolveFractalLevel(byte level) {
		// TODO
		return level;
	}

	@Override
	protected VŌṁglyphHyperStar toCloneFractal(byte level) {
		return new VŌṁglyphHyperStar(level);
	}
}