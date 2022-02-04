package love.distributedrebirth.numberxd;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class GroßGetậlŌṁHyperStàr6ˢᴰ extends GroßGetậlŌṁ6ˢᴰ<GroßGetậlŌṁHyperStàr6ˢᴰ> {

	// 0th = V144Tocta
	// 1th = 5 * V144Tocta
	// 2th = 5 * 12 * V144Tocta
	// etc
	
	public GroßGetậlŌṁHyperStàr6ˢᴰ(byte level) {
		super(level);
	}
	
	protected int resolveFractalLevel(byte level) {
		// TODO
		return level;
	}

	@Override
	protected GroßGetậlŌṁHyperStàr6ˢᴰ toCloneFractal(byte level) {
		return new GroßGetậlŌṁHyperStàr6ˢᴰ(level);
	}
}