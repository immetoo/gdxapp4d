package love.distributedrebirth.warpme.sea;

import java.util.List;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class WaterSeaMagic {
	
	private String magicMime;
	private List<WaterSeaMagicResource> resources;
	
	public String getMagicMime() {
		return magicMime;
	}
	
	public void setMagicMime(String magicMime) {
		this.magicMime = magicMime;
	}
	
	public List<WaterSeaMagicResource> getResources() {
		return resources;
	}
	
	public void setResources(List<WaterSeaMagicResource> resources) {
		for (WaterSeaMagicResource resource: resources) {
			addResource(resource);
		}
	}
	
	public void addResource(WaterSeaMagicResource resource) {
		resources.add(resource);
	}
}
