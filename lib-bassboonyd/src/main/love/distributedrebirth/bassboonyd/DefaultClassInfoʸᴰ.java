package love.distributedrebirth.bassboonyd;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnAnnotationInfoʸᴰ(required = {BãßBȍőnClassInfoʸᴰ.class})
public interface DefaultClassInfoʸᴰ {

	default String BãßClassNaam() {
		return getClass().getAnnotation(BãßBȍőnClassInfoʸᴰ.class).name();
	}
	
	default String BãßClassPurpose() {
		return getClass().getAnnotation(BãßBȍőnClassInfoʸᴰ.class).purpose();
	}
}
