package love.distributedrebirth.unicode4d.atlas;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class FontAtlas {

	private Map<String, FontAtlasStore> stores = new HashMap<>();
	
	public FontAtlas() {
	}
	
	public FontAtlasStore getStoreByName(String name) {
		return stores.get(name);
	}
	
	public  Collection<FontAtlasStore> getStores() {
		return stores.values();
	}
	
	public void setStores(Collection<FontAtlasStore> planes) {
		for (FontAtlasStore plane:planes) {
			addStore(plane);
		}
	}
	
	public void addStore(FontAtlasStore plane) { 
		this.stores.put(plane.getName(), plane);
	}
}
