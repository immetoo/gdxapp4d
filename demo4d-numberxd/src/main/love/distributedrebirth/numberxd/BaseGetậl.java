package love.distributedrebirth.numberxd;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.BaseIteratorOctal;
import love.distributedrebirth.numberxd.base2t.BaseNumber;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface BaseGetậl<T extends BaseGetậl<T,V>,V extends BaseNumber<V>> {
	
	V getValue();
	
	default T toClone() {
		return toClone(iteratorOctalsByClone());
	}
	
	T toClone(BaseIteratorOctal values);
	
	BaseIteratorOctal iteratorOctalsByClone();
}
