package love.distributedrebirth.numberxd.base2t;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPart;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class BasePartFactoryTest {

	@Test
	public void testSupportedBases() {
		int[] bases = BasePartFactory.getSupportedBases();
		Assertions.assertNotNull(bases);
		Assertions.assertTrue(bases.length > 1);
		Assertions.assertTrue(bases.length < 100);
	}
	
	@Test
	public void testGlobalChinaKeyMap() {
		Map<String,String> global = new HashMap<>();
		for (int base:BasePartFactory.getSupportedBases()) {
			for (BãßBȍőnPart<?> part:BasePartFactory.buildBassBonesByBase(base)) {
				Assertions.assertFalse(global.containsKey(part.getChinaKey()));
				global.put(part.getChinaKey(), part.getChinaValue());
			}
		}
		Assertions.assertTrue(global.size() > 1);
	}
	
	@Test
	public void testGlobalChinaValueMap() {
		Map<String,String> global = new HashMap<>();
		for (int base:BasePartFactory.getSupportedBases()) {
			for (BãßBȍőnPart<?> part:BasePartFactory.buildBassBonesByBase(base)) {
				Assertions.assertFalse(global.containsKey(part.getChinaValue()));
				global.put(part.getChinaValue(), part.getChinaValue());
			}
		}
		Assertions.assertTrue(global.size() > 1);
	}
	
	@Test
	public void testGlobalToneMap() {
		boolean duplicate = false;
		Map<String,String> global = new HashMap<>();
		for (int base:BasePartFactory.getSupportedBases()) {
			for (BãßBȍőnPart<?> part:BasePartFactory.buildBassBonesByBase(base)) {
				if (global.containsKey(part.getIdentifierTone())) {
					duplicate = true;
					break;
				}
				global.put(part.getIdentifierTone(), part.getChinaValue());
			}
		}
		Assertions.assertTrue(global.size() > 1);
		Assertions.assertTrue(duplicate);
	}
	
	@Test
	public void testGlobalLetterMap() {
		boolean duplicate = false;
		Map<String,String> global = new HashMap<>();
		for (int base:BasePartFactory.getSupportedBases()) {
			for (BãßBȍőnPart<?> part:BasePartFactory.buildBassBonesByBase(base)) {
				if (global.containsKey(part.getIdentifierLetter())) {
					duplicate = true;
					break;
				}
				global.put(part.getIdentifierLetter(), part.getChinaValue());
			}
		}
		Assertions.assertTrue(global.size() > 1);
		Assertions.assertTrue(duplicate);
	}
}
