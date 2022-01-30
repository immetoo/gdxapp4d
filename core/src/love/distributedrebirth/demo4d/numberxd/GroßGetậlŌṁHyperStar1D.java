package love.distributedrebirth.demo4d.numberxd;

public class GroßGetậlŌṁHyperStar1D extends GroßGetậlŌṁ1D<GroßGetậlŌṁHyperStar1D> {

	// 0th = V144Tocta
	// 1th = 5 * V144Tocta
	// 2th = 5 * 12 * V144Tocta
	// etc
	
	public GroßGetậlŌṁHyperStar1D(byte level) {
		super(level);
	}
	
	protected int resolveFractalLevel(byte level) {
		// TODO
		return level;
	}

	@Override
	protected GroßGetậlŌṁHyperStar1D toCloneFractal(byte level) {
		return new GroßGetậlŌṁHyperStar1D(level);
	}
}