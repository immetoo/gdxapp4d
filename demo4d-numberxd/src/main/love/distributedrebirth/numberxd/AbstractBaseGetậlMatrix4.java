package love.distributedrebirth.numberxd;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseNumber;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
abstract public class AbstractBaseGetậlMatrix4<T extends BaseGetậl<T,V>,V extends BaseNumber<V>> extends AbstractBaseGetậlMatrix3<T,V> implements BaseGetậlMatrix4<T,V> {
	
	protected int matrix4;
	
	@Override
	public void setMatrix4(int matrix4) {
		this.matrix4 = matrix4;
	}
	
	@Override
	public int getMatrix4() {
		return matrix4;
	}
}
