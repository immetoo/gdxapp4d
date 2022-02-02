package love.distributedrebirth.numberxd.base2t.part;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public interface BãßBȍőnPartAlt3<T extends BãßBȍőnPart<T>> extends BãßBȍőnPartAlt2<T> {

	default String getAlt3Value() {
		return GET_BBC().GET_STR(BãßBȍőnPartKey.ALT_3_VALUE);
	}
	
	default String staticAlt3Name() {
		return getClass().getAnnotation(BãßBȍőnPartAlt3Info.class).name();
	}
	
	default String staticAlt3Website() {
		return getClass().getAnnotation(BãßBȍőnPartAlt3Info.class).website();
	}
}
