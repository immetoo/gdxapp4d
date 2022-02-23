package love.distributedrebirth.warpme.sea;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.x4o.xml.io.X4OConnectionException;
import org.xml.sax.SAXException;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class WaterOceanDriverTest {
	
	@Test
	public void testWaterOcean() throws X4OConnectionException, SAXException, IOException {
		WaterOcean ocean = new WaterOcean();
		WaterSea sea = new WaterSea();
		sea.setName("MyFirstSea");
		
		ocean.fillWater(sea);

		sea.addSeaChain(new WaterSeaChain("2891738927138923"));
		sea.addSeaChain(new WaterSeaChain("2389473875891293"));

		sea.addSeaMagic(new WaterSeaMagic("audio/mpegurl", "album/test.m3u"));
		sea.addSeaMagic(new WaterSeaMagic("inode/directory", "album/"));
		
		Assertions.assertNotNull(ocean);
		WaterOceanDriver.newInstance().createWriter().writeFile(ocean, new java.io.File("build/out-sea.xml"));
	}
}