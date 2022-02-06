package love.distributedrebirth.bassboonyd;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnAnnotationInfoʸᴰ(required = {BãßBȍőnPackageInfoʸᴰ.class})
public interface DefaultPackageInfoʸᴰ {

	default String BãßPackageNaam() {
		return getClass().getAnnotation(BãßBȍőnPackageInfoʸᴰ.class).name();
	}
}
