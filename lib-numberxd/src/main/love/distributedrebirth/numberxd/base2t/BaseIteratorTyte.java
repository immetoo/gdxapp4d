package love.distributedrebirth.numberxd.base2t;

import java.util.Iterator;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.type.V009Tyte;

/**
 * Iterator model for Tytes.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public final class BaseIteratorTyte implements Iterator<V009Tyte> {

	private final Iterator<V009Tyte> iterator;
	
	public BaseIteratorTyte(Iterator<V009Tyte> iterator) {
		this.iterator = iterator;
	}
	
	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	@Override
	public V009Tyte next() {
		return iterator.next();
	}
}
