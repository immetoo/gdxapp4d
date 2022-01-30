package love.distributedrebirth.demo4d.numberxd;

public class GroßGetậlŌṁGlyphHyperStar1D extends GroßGetậlŌṁGlyph1D<GroßGetậlŌṁGlyphHyperStar1D> {

	// 0th = V144Tocta
	// 1th = 5 * V144Tocta
	// 2th = 5 * 12 * V144Tocta
	// etc
	
	public GroßGetậlŌṁGlyphHyperStar1D(byte level) {
		super(level);
	}
	
	protected int resolveFractalLevel(byte level) {
		// TODO
		return level;
	}

	@Override
	protected GroßGetậlŌṁGlyphHyperStar1D toCloneFractal(byte level) {
		return new GroßGetậlŌṁGlyphHyperStar1D(level);
	}
}