package love.distributedrebirth.numberxd.base2t.part;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface BãßBȍőnPartAlt4ʸᴰ<T extends BãßBȍőnPartʸᴰ<T>> extends BãßBȍőnPartAlt3ʸᴰ<T> {

	default String getAlt4Value() {
		return GET_BBC().GET_STR(BãßBȍőnPartKeyʸᴰ.ALT_4_VALUE);
	}
	
	default String staticAlt4Name() {
		return getClass().getAnnotation(BãßBȍőnPartAlt4Infoʸᴰ.class).name();
	}
	
	default String staticAlt4Website() {
		return getClass().getAnnotation(BãßBȍőnPartAlt4Infoʸᴰ.class).website();
	}
}
