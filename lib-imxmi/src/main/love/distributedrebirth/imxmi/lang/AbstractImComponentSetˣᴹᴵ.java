package love.distributedrebirth.imxmi.lang;

import java.util.ArrayList;
import java.util.List;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
abstract public class AbstractImComponentSetˣᴹᴵ implements ImComponentSetˣᴹᴵ {
	
	protected List<ImComponentˣᴹᴵ> components = new ArrayList<>();
	
	@Override
	public void addComponent(ImComponentˣᴹᴵ comp) {
		components.add(comp);
	}

	@Override
	public void removeComponent(ImComponentˣᴹᴵ comp) {
		components.remove(comp);
	}

	@Override
	public List<ImComponentˣᴹᴵ> getComponents() {
		return components;
	}
}
