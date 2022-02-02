package love.distributedrebirth.numberxd.base2t.part;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface BãßBȍőnPartAlt3ʸᴰ<T extends BãßBȍőnPartʸᴰ<T>> extends BãßBȍőnPartAlt2ʸᴰ<T> {

	default String getAlt3Value() {
		return GET_BBC().GET_STR(BãßBȍőnPartKeyʸᴰ.ALT_3_VALUE);
	}
	
	default String staticAlt3Name() {
		return getClass().getAnnotation(BãßBȍőnPartAlt3Infoʸᴰ.class).name();
	}
	
	default String staticAlt3Website() {
		return getClass().getAnnotation(BãßBȍőnPartAlt3Infoʸᴰ.class).website();
	}
}
