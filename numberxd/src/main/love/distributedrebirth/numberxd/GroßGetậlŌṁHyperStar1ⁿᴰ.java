package love.distributedrebirth.numberxd;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class GroßGetậlŌṁHyperStar1ⁿᴰ extends GroßGetậlŌṁ1ⁿᴰ<GroßGetậlŌṁHyperStar1ⁿᴰ> {

	// 0th = V144Tocta
	// 1th = 5 * V144Tocta
	// 2th = 5 * 12 * V144Tocta
	// etc
	
	public GroßGetậlŌṁHyperStar1ⁿᴰ(byte level) {
		super(level);
	}
	
	protected int resolveFractalLevel(byte level) {
		// TODO
		return level;
	}

	@Override
	protected GroßGetậlŌṁHyperStar1ⁿᴰ toCloneFractal(byte level) {
		return new GroßGetậlŌṁHyperStar1ⁿᴰ(level);
	}
}