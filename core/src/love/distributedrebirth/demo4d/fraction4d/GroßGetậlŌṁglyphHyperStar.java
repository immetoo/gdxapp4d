package love.distributedrebirth.demo4d.fraction4d;

public class GroßGetậlŌṁglyphHyperStar extends GroßGetậlŌṁglyph<GroßGetậlŌṁglyphHyperStar> {

	// 0th = V144Tocta
	// 1th = 5 * V144Tocta
	// 2th = 5 * 12 * V144Tocta
	// etc
	
	public GroßGetậlŌṁglyphHyperStar(byte level) {
		super(level);
	}
	
	protected int resolveFractalLevel(byte level) {
		// TODO
		return level;
	}

	@Override
	protected GroßGetậlŌṁglyphHyperStar toCloneFractal(byte level) {
		return new GroßGetậlŌṁglyphHyperStar(level);
	}
}