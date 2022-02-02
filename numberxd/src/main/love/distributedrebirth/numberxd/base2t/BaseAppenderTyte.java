package love.distributedrebirth.numberxd.base2t;

import java.util.Collection;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

/**
 * Appender model for Tytes.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public final class BaseAppenderTyte implements BaseAppender<V009Tyte> {

	private final Collection<V009Tyte> collection;
	
	public BaseAppenderTyte(Collection<V009Tyte> collection) {
		this.collection = collection;
	}
	
	@Override
	public void add(V009Tyte value) {
		collection.add(value);
	}
}
