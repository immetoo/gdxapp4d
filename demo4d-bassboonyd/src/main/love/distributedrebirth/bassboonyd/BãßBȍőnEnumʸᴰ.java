package love.distributedrebirth.bassboonyd;

/**
 * Inject Enum methods.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public interface BãßBȍőnEnumʸᴰ<T> {
	
	String name();
	
	default String BȍőnNaam() {
		return name(); 
	}
	
	default String BȍőnNaamI18N() {
		return BãßNaam() + BãßBȍőnConstants.STR_DOT + name(); 
	}
	
	default String BãßNaam() {
		return getClass().getAnnotation(BãßBȍőnNaamʸᴰ.class).value();
	}
}
