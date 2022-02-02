package love.distributedrebirth.numberxd.base2t.part;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface BãßBȍőnPartAlt4<T extends BãßBȍőnPart<T>> extends BãßBȍőnPartAlt3<T> {

	default String getAlt4Value() {
		return GET_BBC().GET_STR(BãßBȍőnPartKey.ALT_4_VALUE);
	}
	
	default String staticAlt4Name() {
		return getClass().getAnnotation(BãßBȍőnPartAlt4Info.class).name();
	}
	
	default String staticAlt4Website() {
		return getClass().getAnnotation(BãßBȍőnPartAlt4Info.class).website();
	}
}
