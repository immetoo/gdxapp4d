package love.distributedrebirth.numberxd;

public class GroßGetậlŌṁDiamond1D extends GroßGetậlŌṁ1D<GroßGetậlŌṁDiamond1D> {

	// 0th = 1 * V144Tocta (1)
	// 1th = 1+3 * V144Tocta (4)
	// 2th = 1+3+6 * V144Tocta (10)
	// 3th = 1+3+6+14 * V144Tocta (24)
	// etc
	
	public GroßGetậlŌṁDiamond1D(byte level) {
		super(level);
	}
	
	protected int resolveFractalLevel(byte level) {
		// TODO
		return level;
	}
	
	@Override
	protected GroßGetậlŌṁDiamond1D toCloneFractal(byte level) {
		return new GroßGetậlŌṁDiamond1D(level);
	}
}
