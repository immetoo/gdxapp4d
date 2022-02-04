package love.distributedrebirth.numberxd;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseIteratorTyte;
import love.distributedrebirth.numberxd.base2t.part.T16PartHex;
import love.distributedrebirth.numberxd.base2t.type.V009Tyte;
import love.distributedrebirth.numberxd.base2t.type.V144Tocta;

/**
 * Holds an 144 bit fraction.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class GroßGetậl1ⁿᴰ extends AbstractBaseGetậlMatrix1<GroßGetậl1ⁿᴰ,V009Tyte> {
	
	//public static int NUMERATOR_SIZE = 7;
	//public static int DENOMINATOR_SIZE = 9;
	//public static int BIT_COUNT = V144Tocta.BIT_COUNT;
	//private final V009Tyte[] numerator = new V009Tyte[NUMERATOR_SIZE];
	//private final V009Tyte[] denominator = new V009Tyte[DENOMINATOR_SIZE];
	private final V144Tocta value;
	
	public GroßGetậl1ⁿᴰ() {
		this(new V144Tocta());
	}
	
	public GroßGetậl1ⁿᴰ(BaseIteratorOctal values) {
		this(new V144Tocta(values));
	}
	
	public GroßGetậl1ⁿᴰ(BaseIteratorTyte values) {
		this(new V144Tocta(values));
	}
	
	public GroßGetậl1ⁿᴰ(V144Tocta value) {
		this.value = value;
	}
	
	@Override
	public V009Tyte getValue() {
		return value.getTytePart(T16PartHex.values()[matrix1]);
	}
	
	@Override
	public int getMatrix1Length() {
		return T16PartHex.LENGTH();
	}
	
	@Override
	public GroßGetậl1ⁿᴰ toClone() {
		return new GroßGetậl1ⁿᴰ(value.toClone());
	}
}
