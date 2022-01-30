package love.distributedrebirth.demo4d.fraction4d;

public class GroßGetậlŌṁGlyphHyperStar extends GroßGetậlŌṁGlyph<GroßGetậlŌṁGlyphHyperStar> {

	// 0th = V144Tocta
	// 1th = 5 * V144Tocta
	// 2th = 5 * 12 * V144Tocta
	// etc
	
	public GroßGetậlŌṁGlyphHyperStar(byte level) {
		super(level);
	}
	
	protected int resolveFractalLevel(byte level) {
		// TODO
		return level;
	}

	@Override
	protected GroßGetậlŌṁGlyphHyperStar toCloneFractal(byte level) {
		return new GroßGetậlŌṁGlyphHyperStar(level);
	}
}