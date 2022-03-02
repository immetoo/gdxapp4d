package love.distributedrebirth.imxmi.lang;

import java.util.function.Function;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
abstract public class AbstractImComponentDataˣᴹᴵ implements ImComponentDataˣᴹᴵ {
	
	private Function<Object, Object> dataExtractor;
	
	@Override
	public void setDataExtractor(Function<Object, Object> dataExtractor) {
		this.dataExtractor = dataExtractor;
	}
	
	@Override
	public Function<Object, Object> getDataExtractor() {
		return dataExtractor;
	}
	
	@Override
	public void renderBegin() {
	}
	
	@Override
	public void renderEnd() {
	}
}
