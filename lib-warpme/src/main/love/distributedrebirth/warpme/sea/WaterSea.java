package love.distributedrebirth.warpme.sea;

import java.util.ArrayList;
import java.util.List;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class WaterSea {
	
	private String name;
	private String author;
	private String provider;
	private List<WaterSeaChain> seaChains = new ArrayList<>();
	private List<WaterSeaMagic> seaMagics = new ArrayList<>();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getProvider() {
		return provider;
	}
	
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	public List<WaterSeaChain> getSeaChains() {
		return seaChains;
	}
	
	public void setSeaChains(List<WaterSeaChain> seaChains) {
		for (WaterSeaChain seaChain:seaChains) {
			addSeaChain(seaChain);
		}
	}
	
	public void addSeaChain(WaterSeaChain seaChain) {
		seaChains.add(seaChain);
	}
	
	public List<WaterSeaMagic> getSeaMagics() {
		return seaMagics;
	}
	
	public void setSeaMagics(List<WaterSeaMagic> seaMagics) {
		for (WaterSeaMagic seaMagic: seaMagics) {
			addSeaMagic(seaMagic);
		}
	}
	
	public void addSeaMagic(WaterSeaMagic seaMagic) {
		seaMagics.add(seaMagic);
	}
}
