package love.distributedrebirth.warpme.core;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.x4o.xml.io.X4OConnectionException;
import org.xml.sax.SAXException;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class WaterBucketDriverTest {
	

	@Test
	public void testWaterOcean() throws X4OConnectionException, SAXException, IOException {
		
		WaterBucket bucket = new WaterBucket();
		WaterCipher cipher = new WaterCipher();
		
		bucket.fillWater(cipher);
		cipher.setName("name");
		
		WaterCipherHeartTone tone = new WaterCipherHeartTone();
		tone.setChinaKey("cn");
		tone.setDialTone("T1");
		tone.setPart("PART_0");
		tone.setChinaValue("china");
		
		WaterCipherHeart heart = new WaterCipherHeart();
		heart.setBass(12345);
		heart.addHeartTone(tone);
		cipher.addCipherHeart(heart);
		
		Assertions.assertNotNull(bucket);
		WaterBucketDriver.newInstance().createWriter().writeFile(bucket, new java.io.File("build/out-core.xml"));
	}
}