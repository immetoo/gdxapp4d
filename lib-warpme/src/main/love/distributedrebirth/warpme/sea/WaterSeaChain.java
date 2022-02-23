package love.distributedrebirth.warpme.sea;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class WaterSeaChain {

	private String key;
	private String tag;
	
	public WaterSeaChain() {
	}
	
	public WaterSeaChain(String key) {
		setKey(key);
	}
	
	public WaterSeaChain(String key, String tag) {
		setKey(key);
		setTag(tag);
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
}
