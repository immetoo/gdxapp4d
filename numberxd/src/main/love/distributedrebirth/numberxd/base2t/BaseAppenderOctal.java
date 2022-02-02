package love.distributedrebirth.numberxd.base2t;

import java.util.Collection;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

/**
 * Appender model for Octals.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public final class BaseAppenderOctal implements BaseAppender<T08PartOctal> {

	private final Collection<T08PartOctal> collection;
	
	public BaseAppenderOctal(Collection<T08PartOctal> collection) {
		this.collection = collection;
	}
	
	@Override
	public void add(T08PartOctal value) {
		collection.add(value);
	}
}
