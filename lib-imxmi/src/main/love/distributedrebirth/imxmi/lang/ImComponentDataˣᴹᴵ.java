package love.distributedrebirth.imxmi.lang;

import java.util.function.Function;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface ImComponentDataˣᴹᴵ extends ImComponentˣᴹᴵ {

	void setDataExtractor(Function<Object, Object> dataExtractor);
	
	Function<Object, Object> getDataExtractor();
	
	void setData(Object value);
}
