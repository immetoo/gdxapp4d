package love.distributedrebirth.bassboonyd;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface BãßBȍőnEnumʸᴰ<T> {
	
	String name();
	
	default String BȍőnNaam() {
		return name(); 
	}
	
	default String BȍőnNaamI18N() {
		return BãßNaam() + BãßBȍőnConstants.STR_DOT + name(); 
	}
	
	default String BãßNaam() {
		return getClass().getAnnotation(BãßBȍőnInfoʸᴰ.class).name();
	}
	
	@SuppressWarnings("unchecked")
	default T[] BãßInstances() {
		try {
			Object result = getClass().getMethod(BãßBȍőnConstants.STR_VALUES).invoke(null);
			return (T[]) result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
