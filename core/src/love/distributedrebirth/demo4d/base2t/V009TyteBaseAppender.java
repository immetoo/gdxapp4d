package love.distributedrebirth.demo4d.base2t;

import java.util.Collection;

/**
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 * 
 */
public final class V009TyteBaseAppender implements BaseAppender<V009Tyte> {

	private final Collection<V009Tyte> collection;
	
	public V009TyteBaseAppender(Collection<V009Tyte> collection) {
		this.collection = collection;
	}
	
	@Override
	public void add(V009Tyte value) {
		collection.add(value);
	}
}
