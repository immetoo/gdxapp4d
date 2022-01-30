package love.distributedrebirth.numberxd;

public class GroßGetậlŌṁHyperStar6D extends GroßGetậlŌṁ6D<GroßGetậlŌṁHyperStar6D> {

	// 0th = V144Tocta
	// 1th = 5 * V144Tocta
	// 2th = 5 * 12 * V144Tocta
	// etc
	
	public GroßGetậlŌṁHyperStar6D(byte level) {
		super(level);
	}
	
	protected int resolveFractalLevel(byte level) {
		// TODO
		return level;
	}

	@Override
	protected GroßGetậlŌṁHyperStar6D toCloneFractal(byte level) {
		return new GroßGetậlŌṁHyperStar6D(level);
	}
}