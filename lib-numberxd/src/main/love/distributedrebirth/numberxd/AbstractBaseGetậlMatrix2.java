package love.distributedrebirth.numberxd;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseNumber;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
abstract public class AbstractBaseGetậlMatrix2<T extends BaseGetậl<T,V>,V extends BaseNumber<V>> extends AbstractBaseGetậlMatrix1<T,V> implements BaseGetậlMatrix2<T,V> {
	
	protected int matrix2;
	
	@Override
	public void setMatrix2(int matrix2) {
		this.matrix2 = matrix2;
	}
	
	@Override
	public int getMatrix2() {
		return matrix2;
	}
}
