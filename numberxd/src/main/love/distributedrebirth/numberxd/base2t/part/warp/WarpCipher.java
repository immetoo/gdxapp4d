package love.distributedrebirth.numberxd.base2t.part.warp;

import java.util.ArrayList;
import java.util.List;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class WarpCipher {
	
	private String cipherName;
	private String cipherDescription;
	private List<WarpCipherHeart> cipherHearts;
	
	public WarpCipher() {
		cipherHearts = new ArrayList<>();
	}
	
	public String getCipherName() {
		return cipherName;
	}
	
	public void setCipherName(String cipherName) {
		this.cipherName = cipherName;
	}
	
	public String getCipherDescription() {
		return cipherDescription;
	}
	
	public void setCipherDescription(String cipherDescription) {
		this.cipherDescription = cipherDescription;
	}
	
	public List<WarpCipherHeart> getCipherHearts() {
		return cipherHearts;
	}
	
	public void setCipherHearts(List<WarpCipherHeart> cipherHearts) {
		this.cipherHearts = cipherHearts;
	}
}
