package love.distributedrebirth.bassboonyd;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnAnnotationInfoʸᴰ(required = {BãßBȍőnClassInfoʸᴰ.class, BãßBȍőnAuthorInfoʸᴰ.class})
public interface BãßBȍőnEnumʸᴰ<T> extends DefaultAuthorInfoʸᴰ,DefaultClassInfoʸᴰ,DefaultPackageInfoʸᴰ {
	
	String name();
	
	// Bȍőn prefix is for set instance enum object called BãßBȍőnEnumSetʸᴰ
	// Bãß prefix is for single instance enum objects called BãßBȍőnEnumInstanceʸᴰ
	
	default String BȍőnNaam() {
		return name(); 
	}
	
	@SuppressWarnings("unchecked")
	default T[] BãßInstances() {
		try {
			Object result = getClass().getMethod(BãßBȍőnConstantsʸᴰ.STR_VALUES).invoke(null);
			return (T[]) result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	default String BȍőnNaamI18N() {
		return BãßClassNaam() + BãßBȍőnConstantsʸᴰ.STR_DOT + name(); 
	}
}
