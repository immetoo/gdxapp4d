package love.distributedrebirth.demo4d.base2t;

import java.util.Collection;

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
