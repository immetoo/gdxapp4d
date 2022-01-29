package love.distributedrebirth.demo4d.base2t;

import java.util.Iterator;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public final class V009TyteBaseIterator implements Iterator<V009Tyte> {

	private final Iterator<V009Tyte> iterator;
	
	public V009TyteBaseIterator(Iterator<V009Tyte> iterator) {
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
