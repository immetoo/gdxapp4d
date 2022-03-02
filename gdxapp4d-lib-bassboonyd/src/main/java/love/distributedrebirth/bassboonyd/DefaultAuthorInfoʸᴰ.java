package love.distributedrebirth.bassboonyd;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnAnnotationInfoʸᴰ(required = {BãßBȍőnAuthorInfoʸᴰ.class})
public interface DefaultAuthorInfoʸᴰ {

	default String BãßAuthorNaam() {
		return getClass().getAnnotation(BãßBȍőnAuthorInfoʸᴰ.class).name();
	}
	
	default String BãßAuthorCopyright() {
		return getClass().getAnnotation(BãßBȍőnAuthorInfoʸᴰ.class).copyright();
	}
}
