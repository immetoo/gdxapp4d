package love.distributedrebirth.numberxd.base2t.part;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface BãßBȍőnPartAlt1ʸᴰ<T extends BãßBȍőnPartʸᴰ<T>> extends BãßBȍőnPartʸᴰ<T> {

	default String getAlt1Value() {
		return GET_BBC().GET_STR(BãßBȍőnPartKeyʸᴰ.ALT_1_VALUE);
	}
	
	default String staticAlt1Name() {
		return getClass().getAnnotation(BãßBȍőnPartAlt1Infoʸᴰ.class).name();
	}
	
	default String staticAlt1Website() {
		return getClass().getAnnotation(BãßBȍőnPartAlt1Infoʸᴰ.class).website();
	}
}
