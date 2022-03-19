package love.distributedrebirth.numberxd.base2t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.Base2WarpCore;
import love.distributedrebirth.warpme.core.WaterBucket;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class Base2WarpCoreTest {

	@Test
	public void testCurrentWarpCore() {
		WaterBucket warpCore = Base2WarpCore.INSTANCE.BãßCurrentWarpCore();
		Assertions.assertNotNull(warpCore);
		Assertions.assertNotNull(warpCore.theWater());
		Assertions.assertNotNull(warpCore.theWater().getName());
		Assertions.assertNotNull(warpCore.theWater().getDescription());
		Assertions.assertNotNull(warpCore.theWater().getCipherHearts());
		Assertions.assertTrue(warpCore.theWater().getCipherHearts().size() > 1);
		Assertions.assertTrue(warpCore.theWater().getCipherHearts().size() < 100);
	}
	
	@Test
	public void testValidateWarpCore() {
		WaterBucket warpCore = Base2WarpCore.INSTANCE.BãßCurrentWarpCore();
		
		warpCore.theWater().getCipherHearts().get(5).getHeartTones().get(0).setChinaKey("零");
		warpCore.theWater().getCipherHearts().get(5).getHeartTones().get(1).setChinaKey("零");
		IllegalArgumentException thrownKey = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Base2WarpCore.INSTANCE.BãßValidateWarpCore(warpCore);
		});
		Assertions.assertEquals("Duplicate chinaKey: 零", thrownKey.getMessage());
		
		warpCore.theWater().getCipherHearts().get(4).getHeartTones().get(0).setChinaValue("pink");
		warpCore.theWater().getCipherHearts().get(4).getHeartTones().get(1).setChinaValue("pink");
		IllegalArgumentException thrownValue = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Base2WarpCore.INSTANCE.BãßValidateWarpCore(warpCore);
		});
		Assertions.assertEquals("Duplicate chinaValue: pink", thrownValue.getMessage());
	}
}
