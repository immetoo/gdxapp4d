package love.distributedrebirth.numberxd;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class GroßGetậlŌṁDiamond6ˢᴰ extends GroßGetậlŌṁ6ˢᴰ<GroßGetậlŌṁDiamond6ˢᴰ> {

	// 0th = 1 * V144Tocta (1)
	// 1th = 1+3 * V144Tocta (4)
	// 2th = 1+3+6 * V144Tocta (10)
	// 3th = 1+3+6+14 * V144Tocta (24)
	// etc
	
	public GroßGetậlŌṁDiamond6ˢᴰ(byte level) {
		super(level);
	}
	
	protected int resolveFractalLevel(byte level) {
		// TODO
		return level;
	}
	
	@Override
	protected GroßGetậlŌṁDiamond6ˢᴰ toCloneFractal(byte level) {
		return new GroßGetậlŌṁDiamond6ˢᴰ(level);
	}
}
