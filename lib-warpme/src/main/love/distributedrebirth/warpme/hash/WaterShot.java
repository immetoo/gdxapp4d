package love.distributedrebirth.warpme.hash;

import java.util.ArrayList;
import java.util.List;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class WaterShot {
	
	private List<WaterSoftHash> softHashes = new ArrayList<>();
	
	public List<WaterSoftHash> getSoftHashes() {
		return softHashes;
	}
	
	public void setSoftHashes(List<WaterSoftHash> shotHashes) {
		for (WaterSoftHash hash:shotHashes) {
			addSoftHash(hash);
		}
	}
	
	public void addSoftHash(WaterSoftHash softHash) {
		this.softHashes.add(softHash);
	}
}
