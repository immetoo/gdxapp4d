package love.distributedrebirth.demo4d.numberxd;

public class GroßGetậlŌṁGlyphHyperStar6D extends GroßGetậlŌṁGlyph6D<GroßGetậlŌṁGlyphHyperStar6D> {

	// 0th = V144Tocta
	// 1th = 5 * V144Tocta
	// 2th = 5 * 12 * V144Tocta
	// etc
	
	public GroßGetậlŌṁGlyphHyperStar6D(byte level) {
		super(level);
	}
	
	protected int resolveFractalLevel(byte level) {
		// TODO
		return level;
	}

	@Override
	protected GroßGetậlŌṁGlyphHyperStar6D toCloneFractal(byte level) {
		return new GroßGetậlŌṁGlyphHyperStar6D(level);
	}
}