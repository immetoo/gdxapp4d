package love.distributedrebirth.numberxd.base2t.part;

import love.distributedrebirth.bassboonyd.BãßBȍőnAnnotationInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnAnnotationInfoʸᴰ(required = {BãßBȍőnPartAlt1Infoʸᴰ.class})
public interface BãßBȍőnPartAlt1ʸᴰ<T extends BãßBȍőnPartʸᴰ<T>> extends BãßBȍőnPartʸᴰ<T> {

	default String BȍőnAlt1Value() {
		return GET_BBC().GET_STR(BãßBȍőnPartKeyʸᴰ.ALT_1_VALUE);
	}
	
	default String BãßAlt1Name() {
		return getClass().getAnnotation(BãßBȍőnPartAlt1Infoʸᴰ.class).name();
	}
	
	default String BãßAlt1Website() {
		return getClass().getAnnotation(BãßBȍőnPartAlt1Infoʸᴰ.class).website();
	}
}
