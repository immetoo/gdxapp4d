package love.distributedrebirth.warpme.hash;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class WaterSoftHash {
	
	private String file;
	private String hex;
	
	public WaterSoftHash() {
	}
	
	public WaterSoftHash(String file, String hex) {
		setFile(file);
		setHex(hex);
	}
	
	public String getFile() {
		return file;
	}
	
	public void setFile(String file) {
		this.file = file;
	}
	
	public String getHex() {
		return hex;
	}
	
	public void setHex(String hex) {
		this.hex = hex;
	}
}
