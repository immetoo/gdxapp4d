package love.distributedrebirth.numberxd.base2t;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class BasePartFactoryTest {

	@Test
	public void testSupportedBases() {
		int[] bases = BasePartFactory.INSTANCE.BãßBases();
		Assertions.assertNotNull(bases);
		Assertions.assertTrue(bases.length > 1);
		Assertions.assertTrue(bases.length < 100);
	}
	
	@Test
	public void testGlobalChinaKeyMap() {
		Map<String,String> global = new HashMap<>();
		for (int base:BasePartFactory.INSTANCE.BãßBases()) {
			for (BãßBȍőnPartʸᴰ<?> part:BasePartFactory.INSTANCE.BãßBuildPartsByBase(base)) {
				Assertions.assertFalse(global.containsKey(part.BȍőnChinaKey()));
				global.put(part.BȍőnChinaKey(), part.BȍőnChinaValue());
			}
		}
		Assertions.assertTrue(global.size() > 1);
	}
	
	@Test
	public void testGlobalChinaValueMap() {
		Map<String,String> global = new HashMap<>();
		for (int base:BasePartFactory.INSTANCE.BãßBases()) {
			for (BãßBȍőnPartʸᴰ<?> part:BasePartFactory.INSTANCE.BãßBuildPartsByBase(base)) {
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
		for (int base:BasePartFactory.INSTANCE.BãßBases()) {
			for (BãßBȍőnPartʸᴰ<?> part:BasePartFactory.INSTANCE.BãßBuildPartsByBase(base)) {
				if (global.containsKey(part.BȍőnIdentifierTone())) {
					duplicate = true;
					break;
				}
				global.put(part.BȍőnIdentifierTone(), part.BȍőnChinaValue());
			}
		}
		Assertions.assertTrue(global.size() > 1);
		Assertions.assertTrue(duplicate);
	}
	
	@Test
	public void testGlobalLetterMap() {
		boolean duplicate = false;
		Map<String,String> global = new HashMap<>();
		for (int base:BasePartFactory.INSTANCE.BãßBases()) {
			for (BãßBȍőnPartʸᴰ<?> part:BasePartFactory.INSTANCE.BãßBuildPartsByBase(base)) {
				if (global.containsKey(part.BȍőnIdentifierLetter())) {
					duplicate = true;
					break;
				}
				global.put(part.BȍőnIdentifierLetter(), part.BȍőnChinaValue());
			}
		}
		Assertions.assertTrue(global.size() > 1);
		Assertions.assertTrue(duplicate);
	}
}
