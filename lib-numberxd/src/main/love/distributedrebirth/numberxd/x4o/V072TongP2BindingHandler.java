package love.distributedrebirth.numberxd.x4o;

import org.x4o.xml.element.AbstractElementBindingHandler;
import org.x4o.xml.element.Element;
import org.x4o.xml.element.ElementBindingHandlerException;

import love.distributedrebirth.numberxd.base2t.type.V036Teger;

public class V072TongP2BindingHandler extends AbstractElementBindingHandler<V072TongP2> {

	@Override
	public Class<?>[] getBindChildClasses() {
		return new Class[] {V036Teger.class};
	}

	@Override
	public Class<?> getBindParentClass() {
		return V072TongP2.class;
	}

	@Override
	public void bindChild(Element childElement, V072TongP2 parent, Object childObject) throws ElementBindingHandlerException {
		V036Teger child = (V036Teger)childObject;
		parent.setValue(child);
	}

	@Override
	public void createChilderen(Element parentElement,V072TongP2 parent) throws ElementBindingHandlerException {
		createChild(parentElement, parent.theValue());
	}
}
