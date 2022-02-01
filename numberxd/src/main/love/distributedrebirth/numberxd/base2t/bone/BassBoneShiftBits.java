package love.distributedrebirth.numberxd.base2t.bone;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public interface BassBoneShiftBits<T extends BassBone<T>> extends BassBone<T> {

	default Integer getShiftBits() {
		return GET_BBC().GET_INT(BassBoneStoreKey.SHIFT_BITS);
	}
}
