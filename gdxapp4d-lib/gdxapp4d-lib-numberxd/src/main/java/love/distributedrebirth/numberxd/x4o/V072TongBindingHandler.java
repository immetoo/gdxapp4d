package love.distributedrebirth.numberxd.x4o;

import org.x4o.xml.element.AbstractElementBindingHandler;
import org.x4o.xml.element.Element;
import org.x4o.xml.element.ElementBindingHandlerException;

import love.distributedrebirth.numberxd.base2t.part.T02PartBinary;
import love.distributedrebirth.numberxd.base2t.type.V072Tong;

public class V072TongBindingHandler extends AbstractElementBindingHandler<V072Tong> {

	@Override
	public Class<?>[] getBindChildClasses() {
		return new Class[] {V072TongP1.class, V072TongP2.class};
	}

	@Override
	public Class<?> getBindParentClass() {
		return V072Tong.class;
	}

	@Override
	public void bindChild(Element childElement, V072Tong parent, Object childObject) throws ElementBindingHandlerException {
		if (childObject instanceof V072TongP1) {
			V072TongP1 p1 = (V072TongP1)childObject;
			parent.setValue(T02PartBinary.PART_1, p1.theValue());
		}
		if (childObject instanceof V072TongP2) {
			V072TongP2 p2 = (V072TongP2)childObject;
			parent.setValue(T02PartBinary.PART_2, p2.theValue());
		}
	}

	@Override
	public void createChilderen(Element parentElement,V072Tong parent) throws ElementBindingHandlerException {
		V072TongP1 p1 = new V072TongP1();
		V072TongP2 p2 = new V072TongP2();
		p1.setValue(parent.getValue(T02PartBinary.PART_1));
		p2.setValue(parent.getValue(T02PartBinary.PART_2));
		createChild(parentElement, p1);
		createChild(parentElement, p2);
	}

}
