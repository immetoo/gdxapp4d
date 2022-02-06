package love.distributedrebirth.numberxd;

import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.part.T12PartUncial;
import love.distributedrebirth.numberxd.base2t.part.T16PartHex;
import love.distributedrebirth.numberxd.base2t.type.V009Tyte;
import love.distributedrebirth.numberxd.base2t.type.V144Tocta;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
abstract public class AbstractGroßGetậlŌṁ6ˢᴰ<T extends BaseGetậl<T,V009Tyte>> extends AbstractBaseGetậlMatrix3<T,V009Tyte> {
	
	private V144Tocta[][] values;
	private int valuesLength;
	private int fractalLevel;
	
	public AbstractGroßGetậlŌṁ6ˢᴰ(int fractalLevel) {
		this.fractalLevel = fractalLevel;
		this.valuesLength = resolveFractalLevel(fractalLevel);
		this.values = new V144Tocta[T12PartUncial.LENGTH()][valuesLength];
		for (int x=0;x<this.values.length;x++) {
			for (int y=0;y<this.values[x].length;y++) {
				this.values[x][y] = new V144Tocta();
			}
		}
	}
	
	public AbstractGroßGetậlŌṁ6ˢᴰ(int fractalLevel, BaseIteratorOctal values) {
		this.fractalLevel = fractalLevel;
		this.valuesLength = resolveFractalLevel(fractalLevel);
		this.values = new V144Tocta[T12PartUncial.LENGTH()][valuesLength];
		for (int x=0;x<this.values.length;x++) {
			for (int y=0;y<this.values[x].length;y++) {
				this.values[x][y] = new V144Tocta(values);
			}
		}
	}
	
	abstract protected int resolveFractalLevel(int level);
	
	public V009Tyte getValue() {
		return values[matrix2][matrix3].getTytePart(T16PartHex.values()[matrix1]);
	}
	
	public int getFractalLevel() {
		return fractalLevel;
	}
	
	@Override
	public int getMatrix1Length() {
		return T16PartHex.LENGTH();
	}
	
	@Override
	public int getMatrix2Length() {
		return T12PartUncial.LENGTH();
	}
	
	@Override
	public int getMatrix3Length() {
		return valuesLength;
	}
}
