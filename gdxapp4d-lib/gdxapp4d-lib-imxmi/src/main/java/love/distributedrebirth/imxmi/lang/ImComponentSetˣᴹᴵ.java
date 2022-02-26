package love.distributedrebirth.imxmi.lang;

import java.util.List;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface ImComponentSetˣᴹᴵ extends ImComponentˣᴹᴵ {

	void addComponent(ImComponentˣᴹᴵ comp);
	void removeComponent(ImComponentˣᴹᴵ comp);
	List<ImComponentˣᴹᴵ> getComponents();
	
	default void renderComponents() {
		for (ImComponentˣᴹᴵ comp:getComponents()) {
			comp.renderBegin();
			comp.renderComponent();
			comp.renderEnd();
		}
	}
}
