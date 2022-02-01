package love.distributedrebirth.numberxd.base2t.bone;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public interface BassBoneShiftBits<T extends BassBone<T>> extends BassBone<T> {

	default Integer getShiftBits() {
		return getBBC().getInteger(BassBoneStoreKey.SHIFT_BITS);
	}
}
