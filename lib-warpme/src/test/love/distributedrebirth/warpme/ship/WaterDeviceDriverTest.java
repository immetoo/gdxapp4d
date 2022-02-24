package love.distributedrebirth.warpme.ship;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.x4o.xml.io.X4OConnectionException;
import org.xml.sax.SAXException;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class WaterDeviceDriverTest {
	
	@Test
	public void testWaterDevice() throws X4OConnectionException, SAXException, IOException {
		WaterDevice device = new WaterDevice();
		
		WaterShip ship = new WaterShip();
		ship.setName("tos4-mark1");
		ship.setEngine("123349858934");
		ship.addShipOcean(new WaterShipOcean("2349058490584"));
		ship.addShipOcean(new WaterShipOcean("7867834823244"));
		ship.addShipOcean(new WaterShipOcean("3948758927389"));
		
		device.buildShip(ship);
		
		Assertions.assertNotNull(device);
		WaterDeviceDriver.newInstance().createWriter().writeFile(device, new java.io.File("build/out-ship.xml"));
	}
}