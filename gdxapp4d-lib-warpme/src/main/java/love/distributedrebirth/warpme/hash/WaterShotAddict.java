package love.distributedrebirth.warpme.hash;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.x4o.xml.io.X4OConnectionException;
import org.xml.sax.SAXException;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.warpme.Warpᵐᵉ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class WaterShotAddict {
	
	public static void main(String[] args) {
		try {
			WaterShotAddict addict = new WaterShotAddict();
			addict.updateWarpHashes(new File(args[0]));
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public boolean validateWarpChainLink(File folder) throws FileNotFoundException, X4OConnectionException, SAXException, IOException, NoSuchAlgorithmException {
		File fileWarpHash = new File(folder, Warpᵐᵉ.WARP_HASH);
		if (!fileWarpHash.exists()) {
			return false;
		}
		WaterShot waterShot = WaterShotDriver.newInstance().createReader().readFile(fileWarpHash);
		for (WaterSoftHash hash:waterShot.getSoftHashes()) {
			File checkFile = new File(folder, hash.getFile());
			if (!checkFile.exists()) {
				return false;
			}
			String fileHex = calcHashInHex(checkFile);
			if (!fileHex.equals(hash.getHex())) {
				return false;
			}
		}
		return true;
	}
	
	public void updateWarpHashes(File folder) throws FileNotFoundException, X4OConnectionException, SAXException, IOException, NoSuchAlgorithmException {
		File fileWarpHash = new File(folder, Warpᵐᵉ.WARP_HASH);
		WaterShot waterShot = WaterShotDriver.newInstance().createReader().readFile(fileWarpHash);
		for (WaterSoftHash hash:waterShot.getSoftHashes()) {
			hash.setHex(calcHashInHex(new File(folder, hash.getFile())));
		}
		WaterShotDriver.newInstance().createWriter().writeFile(waterShot, fileWarpHash);
	}
	
	private String calcHashInHex(File file) throws IOException, NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] bytes = Files.readAllBytes(file.toPath());
		byte[] encodedhash = digest.digest(bytes);
		return bytesToHex(encodedhash);
	}
	
	private String bytesToHex(byte[] hash) {
		StringBuilder hexString = new StringBuilder(2 * hash.length);
		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if(hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}
}
