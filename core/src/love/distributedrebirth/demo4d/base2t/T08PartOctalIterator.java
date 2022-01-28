package love.distributedrebirth.demo4d.base2t;

import java.util.Iterator;

public final class T08PartOctalIterator implements Iterator<T08PartOctal> {

	private final Iterator<T08PartOctal> iterator;
	
	public T08PartOctalIterator(Iterator<T08PartOctal> iterator) {
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
