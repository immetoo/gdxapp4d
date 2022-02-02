package love.distributedrebirth.numberxd.base2t.part;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public interface BãßBȍőnPartShiftBits<T extends BãßBȍőnPart<T>> extends BãßBȍőnPart<T> {

	default Integer getShiftBits() {
		return GET_BBC().GET_INT(BãßBȍőnPartKey.SHIFT_BITS);
	}
}
