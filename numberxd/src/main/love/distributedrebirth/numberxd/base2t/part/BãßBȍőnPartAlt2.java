package love.distributedrebirth.numberxd.base2t.part;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface BãßBȍőnPartAlt2<T extends BãßBȍőnPart<T>> extends BãßBȍőnPartAlt1<T> {

	default String getAlt2Value() {
		return GET_BBC().GET_STR(BãßBȍőnPartKey.ALT_2_VALUE);
	}
	
	default String staticAlt2Name() {
		return getClass().getAnnotation(BãßBȍőnPartAlt2Info.class).name();
	}
	
	default String staticAlt2Website() {
		return getClass().getAnnotation(BãßBȍőnPartAlt2Info.class).website();
	}
}
