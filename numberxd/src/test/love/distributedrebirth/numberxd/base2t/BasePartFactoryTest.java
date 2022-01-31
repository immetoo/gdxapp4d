package love.distributedrebirth.numberxd.base2t;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.numberxd.base2t.facet.BasePart;

public class BasePartFactoryTest {

	@Test
	public void testSupportedBases() {
		int[] bases = BasePartFactory.getSupportedBases();
		Assertions.assertNotNull(bases);
		Assertions.assertTrue(bases.length > 1);
		Assertions.assertTrue(bases.length < 100);
		for (int base:bases) {
			Assertions.assertNotNull(base);
		}
	}
	
	@Test
	public void testGlobalChinaMap() {
		Map<String,String> global = new HashMap<>();
		for (int base:BasePartFactory.getSupportedBases()) {
			for (BasePart part:BasePartFactory.buildBasePartsByBase(base)) {
				Assertions.assertFalse(global.containsKey(part.getChinaKey()));
				global.put(part.getChinaKey(), part.getChinaValue());
			}
		}
		Assertions.assertTrue(global.size() > 1);
	}
	
	@Test
	public void testGlobalToneMap() {
		boolean duplicate = false;
		Map<String,String> global = new HashMap<>();
		for (int base:BasePartFactory.getSupportedBases()) {
			for (BasePart part:BasePartFactory.buildBasePartsByBase(base)) {
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
			for (BasePart part:BasePartFactory.buildBasePartsByBase(base)) {
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
