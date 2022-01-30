package love.distributedrebirth.numberxd.base2t;

import java.util.Collection;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public final class T08PartOctalBaseAppender implements BaseAppender<T08PartOctal> {

	private final Collection<T08PartOctal> collection;
	
	public T08PartOctalBaseAppender(Collection<T08PartOctal> collection) {
		this.collection = collection;
	}
	
	@Override
	public void add(T08PartOctal value) {
		collection.add(value);
	}
}
