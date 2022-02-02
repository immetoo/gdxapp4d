package love.distributedrebirth.numberxd.base2t.part;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface BãßBȍőnPartShiftBits<T extends BãßBȍőnPart<T>> extends BãßBȍőnPart<T> {

	default Integer getShiftBits() {
		return GET_BBC().GET_INT(BãßBȍőnPartKey.SHIFT_BITS);
	}
}
