package love.distributedrebirth.numberxd.base2t.part.warp;

import java.util.ArrayList;
import java.util.List;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class WarpCipherHeart {
	
	private String partKey;
	private List<WarpCipherHeartCore> heartCores;
	
	public WarpCipherHeart() {
		heartCores = new ArrayList<>();
	}
	
	public String getPartKey() {
		return partKey;
	}
	
	public void setPartKey(String partKey) {
		this.partKey = partKey;
	}
	
	public List<WarpCipherHeartCore> getHeartCores() {
		return heartCores;
	}
	
	public void setHeartCores(List<WarpCipherHeartCore> heartCores) {
		this.heartCores = heartCores;
	}
}
