package love.distributedrebirth.numberxd;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseNumber;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
abstract public class AbstractBaseGetậlMatrix3<T extends BaseGetậl<T,V>,V extends BaseNumber<V>> extends AbstractBaseGetậlMatrix2<T,V> implements BaseGetậlMatrix3<T,V> {
	
	protected int matrix3;
	
	@Override
	public void setMatrix3(int matrix3) {
		this.matrix3 = matrix3;
	}
	
	@Override
	public int getMatrix3() {
		return matrix3;
	}
}
