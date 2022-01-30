package love.distributedrebirth.demo4d.number4d;

public class GroßGetậlŌṁGlyphDiamond extends GroßGetậlŌṁGlyph<GroßGetậlŌṁGlyphDiamond> {

	// 0th = 1 * V144Tocta (1)
	// 1th = 1+3 * V144Tocta (4)
	// 2th = 1+3+6 * V144Tocta (10)
	// 3th = 1+3+6+14 * V144Tocta (24)
	// etc
	
	public GroßGetậlŌṁGlyphDiamond(byte level) {
		super(level);
	}
	
	protected int resolveFractalLevel(byte level) {
		// TODO
		return level;
	}
	
	@Override
	protected GroßGetậlŌṁGlyphDiamond toCloneFractal(byte level) {
		return new GroßGetậlŌṁGlyphDiamond(level);
	}
}
