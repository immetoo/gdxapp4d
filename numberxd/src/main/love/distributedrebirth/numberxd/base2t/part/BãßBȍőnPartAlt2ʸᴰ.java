package love.distributedrebirth.numberxd.base2t.part;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface BãßBȍőnPartAlt2ʸᴰ<T extends BãßBȍőnPartʸᴰ<T>> extends BãßBȍőnPartAlt1ʸᴰ<T> {

	default String BȍőnAlt2Value() {
		return GET_BBC().GET_STR(BãßBȍőnPartKeyʸᴰ.ALT_2_VALUE);
	}
	
	default String BãßAlt2Name() {
		return getClass().getAnnotation(BãßBȍőnPartAlt2Infoʸᴰ.class).name();
	}
	
	default String BãßAlt2Website() {
		return getClass().getAnnotation(BãßBȍőnPartAlt2Infoʸᴰ.class).website();
	}
}
