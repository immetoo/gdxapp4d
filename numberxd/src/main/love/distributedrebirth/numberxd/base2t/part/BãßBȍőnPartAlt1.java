package love.distributedrebirth.numberxd.base2t.part;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public interface BãßBȍőnPartAlt1<T extends BãßBȍőnPart<T>> extends BãßBȍőnPart<T> {

	default String getAlt1Value() {
		return GET_BBC().GET_STR(BãßBȍőnPartKey.ALT_1_VALUE);
	}
	
	default String staticAlt1Name() {
		return getClass().getAnnotation(BãßBȍőnPartAlt1Info.class).name();
	}
	
	default String staticAlt1Website() {
		return getClass().getAnnotation(BãßBȍőnPartAlt1Info.class).website();
	}
}
