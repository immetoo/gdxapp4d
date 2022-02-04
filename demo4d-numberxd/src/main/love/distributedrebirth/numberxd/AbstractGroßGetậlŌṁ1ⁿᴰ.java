package love.distributedrebirth.numberxd;

import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.part.T16PartHex;
import love.distributedrebirth.numberxd.base2t.type.V009Tyte;
import love.distributedrebirth.numberxd.base2t.type.V144Tocta;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
abstract public class AbstractGroßGetậlŌṁ1ⁿᴰ<T extends BaseGetậl<T,V009Tyte>> extends AbstractBaseGetậlLevel1<T,V009Tyte> {
	
	private V144Tocta[] values;
	private int valuesLength;
	private int fractalLevel;
	
	public AbstractGroßGetậlŌṁ1ⁿᴰ(int fractalLevel) {
		this.fractalLevel = fractalLevel;
		this.valuesLength = resolveFractalLevel(fractalLevel);
		this.values = new V144Tocta[valuesLength];
		for (int i=0;i<this.values.length;i++) {
			this.values[i] = new V144Tocta();
		}
	}
	
	public AbstractGroßGetậlŌṁ1ⁿᴰ(int fractalLevel, BaseIteratorOctal values) {
		this.fractalLevel = fractalLevel;
		this.valuesLength = resolveFractalLevel(fractalLevel);
		this.values = new V144Tocta[valuesLength];
		for (int i=0;i<this.values.length;i++) {
			this.values[i] = new V144Tocta(values);
		}
	}
	
	abstract protected int resolveFractalLevel(int level);
	
	public V009Tyte getValue() {
		return values[matrix1].getTytePart(T16PartHex.values()[matrix0]);
	}
	
	public int getFractalLevel() {
		return fractalLevel;
	}
	
	@Override
	public int getMatrix0Length() {
		return T16PartHex.LENGTH();
	}
	
	@Override
	public int getMatrix1Length() {
		return valuesLength;
	}
}
