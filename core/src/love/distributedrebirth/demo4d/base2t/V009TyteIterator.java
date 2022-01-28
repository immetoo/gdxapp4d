package love.distributedrebirth.demo4d.base2t;

import java.util.Iterator;

public final class V009TyteIterator implements Iterator<V009Tyte> {

	private final Iterator<V009Tyte> iterator;
	
	public V009TyteIterator(Iterator<V009Tyte> iterator) {
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
