package love.distributedrebirth.numberxd.base2t.part;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface BãßBȍőnPartShiftBitsʸᴰ<T extends BãßBȍőnPartʸᴰ<T>> extends BãßBȍőnPartʸᴰ<T> {

	default Integer getShiftBits() {
		return GET_BBC().GET_INT(BãßBȍőnPartKeyʸᴰ.SHIFT_BITS);
	}
}
