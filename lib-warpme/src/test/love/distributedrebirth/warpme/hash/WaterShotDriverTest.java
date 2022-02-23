package love.distributedrebirth.warpme.hash;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.x4o.xml.io.X4OConnectionException;
import org.xml.sax.SAXException;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class WaterShotDriverTest {
	

	@Test
	public void testWaterShot() throws X4OConnectionException, SAXException, IOException {
		
		WaterShot drugs = new WaterShot();
		drugs.addSoftHash(new WaterSoftHash("test.txt", "234SDFSDF234234SDFSDF234"));
		drugs.addSoftHash(new WaterSoftHash("test2.txt", "ASDFYYF234234SDFSDFASDFS"));
		
		Assertions.assertNotNull(drugs);
		WaterShotDriver.newInstance().createWriter().writeFile(drugs, new java.io.File("build/output.xml"));
	}
}