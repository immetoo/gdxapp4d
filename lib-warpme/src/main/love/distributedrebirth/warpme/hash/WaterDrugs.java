package love.distributedrebirth.warpme.hash;

import java.util.ArrayList;
import java.util.List;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class WaterDrugs {
	
	private List<WaterFileHash> fileHashes = new ArrayList<>();
	
	public List<WaterFileHash> getFileHashes() {
		return fileHashes;
	}
	
	public void setFileHashes(List<WaterFileHash> fileHashes) {
		for (WaterFileHash hash:fileHashes) {
			addFileHash(hash);
		}
	}
	
	public void addFileHash(WaterFileHash fileHash) {
		this.fileHashes.add(fileHash);
	}
}
