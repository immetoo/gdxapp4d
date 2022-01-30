package love.distributedrebirth.numberxd.base2t;

import java.util.Iterator;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public final class T08PartOctalBaseIterator implements Iterator<T08PartOctal> {

	private final Iterator<T08PartOctal> iterator;
	
	public T08PartOctalBaseIterator(Iterator<T08PartOctal> iterator) {
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
