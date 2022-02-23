package love.distributedrebirth.warpme.hash;

import java.util.ArrayList;
import java.util.List;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class WaterShot {
	
	private List<WaterShotHash> shotHashes = new ArrayList<>();
	
	public List<WaterShotHash> getShotHashes() {
		return shotHashes;
	}
	
	public void setShotHashes(List<WaterShotHash> shotHashes) {
		for (WaterShotHash hash:shotHashes) {
			addShotHash(hash);
		}
	}
	
	public void addShotHash(WaterShotHash shotHash) {
		this.shotHashes.add(shotHash);
	}
}
