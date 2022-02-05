package love.distributedrebirth.numberxd.base2t.part.warp;

import java.util.ArrayList;
import java.util.List;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class WaterCipher {
	
	private String name;
	private String description;
	private List<WaterCipherHeart> cipherHearts;
	
	public WaterCipher() {
		cipherHearts = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<WaterCipherHeart> getCipherHearts() {
		return cipherHearts;
	}
	
	public void addCipherHeart(WaterCipherHeart cipherHeart) {
		this.cipherHearts.add(cipherHeart);
	}
	
	public void setCipherHearts(List<WaterCipherHeart> cipherHearts) {
		this.cipherHearts = cipherHearts;
	}
}
