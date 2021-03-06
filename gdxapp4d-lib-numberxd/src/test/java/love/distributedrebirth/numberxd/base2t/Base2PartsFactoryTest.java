package love.distributedrebirth.numberxd.base2t;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class Base2PartsFactoryTest {

	@Test
	public void testSupportedBases() {
		int[] bases = Base2PartsFactory.INSTANCE.BãßBases();
		Assertions.assertNotNull(bases);
		Assertions.assertTrue(bases.length > 1);
		Assertions.assertTrue(bases.length < 100);
	}
	
	@Test
	public void testGlobalChinaKeyMap() {
		Map<String,String> global = new HashMap<>();
		for (int base:Base2PartsFactory.INSTANCE.BãßBases()) {
			for (BãßBȍőnPartʸᴰ<?> part:Base2PartsFactory.INSTANCE.BãßBuildPartsByBase(base)) {
				Assertions.assertFalse(global.containsKey(part.BȍőnChinaKey()), "key: "+part.BȍőnChinaKey());
				global.put(part.BȍőnChinaKey(), part.BȍőnChinaValue());
			}
		}
		Assertions.assertTrue(global.size() > 1);
	}
	
	@Test
	public void testGlobalChinaValueMap() {
		Map<String,String> global = new HashMap<>();
		for (int base:Base2PartsFactory.INSTANCE.BãßBases()) {
			for (BãßBȍőnPartʸᴰ<?> part:Base2PartsFactory.INSTANCE.BãßBuildPartsByBase(base)) {
				Assertions.assertFalse(global.containsKey(part.BȍőnChinaValue()));
				global.put(part.BȍőnChinaValue(), part.BȍőnChinaValue());
			}
		}
		Assertions.assertTrue(global.size() > 1);
	}
	
	@Test
	public void testGlobalToneMap() {
		boolean duplicate = false;
		Map<String,String> global = new HashMap<>();
		for (int base:Base2PartsFactory.INSTANCE.BãßBases()) {
			for (BãßBȍőnPartʸᴰ<?> part:Base2PartsFactory.INSTANCE.BãßBuildPartsByBase(base)) {
				if (global.containsKey(part.BȍőnDialTone())) {
					duplicate = true;
					break;
				}
				global.put(part.BȍőnDialTone(), part.BȍőnChinaValue());
			}
		}
		Assertions.assertTrue(global.size() > 1);
		Assertions.assertTrue(duplicate);
	}
}
