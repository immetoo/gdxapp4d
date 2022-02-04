package love.distributedrebirth.numberxd.base2t;

import java.util.Iterator;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.T08PartOctal;

/**
 * Iterator model for Octals.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public final class BaseIteratorOctal implements Iterator<T08PartOctal> {

	private final Iterator<T08PartOctal> iterator;
	
	public BaseIteratorOctal(Iterator<T08PartOctal> iterator) {
		this.iterator = iterator;
	}
	
	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	@Override
	public T08PartOctal next() {
		return iterator.next();
	}
}
