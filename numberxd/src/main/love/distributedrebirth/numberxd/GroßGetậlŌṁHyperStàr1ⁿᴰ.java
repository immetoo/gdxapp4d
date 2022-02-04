package love.distributedrebirth.numberxd;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class GroßGetậlŌṁHyperStàr1ⁿᴰ extends GroßGetậlŌṁ1ⁿᴰ<GroßGetậlŌṁHyperStàr1ⁿᴰ> {

	// 0th = V144Tocta
	// 1th = 5 * V144Tocta
	// 2th = 5 * 12 * V144Tocta
	// etc
	
	public GroßGetậlŌṁHyperStàr1ⁿᴰ(byte level) {
		super(level);
	}
	
	protected int resolveFractalLevel(byte level) {
		// TODO
		return level;
	}

	@Override
	protected GroßGetậlŌṁHyperStàr1ⁿᴰ toCloneFractal(byte level) {
		return new GroßGetậlŌṁHyperStàr1ⁿᴰ(level);
	}
}