package love.distributedrebirth.numberxd.base2t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class T16PartHexTest {

	@Test
	public void testBasePart() {
		for (T16PartHex value:T16PartHex.values()) {
			Assertions.assertNotNull(value.getIdentifierTone());
			Assertions.assertNotNull(value.getIdentifierLetter());
			Assertions.assertNotNull(value.getChinaKey());
			Assertions.assertNotNull(value.getChinaValue());
			Assertions.assertNotNull(value.getAlt1Value());
			Assertions.assertNotNull(value.getAlt1Name());
			Assertions.assertNotNull(value.getAlt1Wiki());
		}
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T16PartHex.PART_1, T16PartHex.valueOfTone("˥"));
		Assertions.assertEquals(T16PartHex.PART_2, T16PartHex.valueOfTone("˦"));
		Assertions.assertEquals(T16PartHex.PART_15, T16PartHex.valueOfTone("꜐"));
		Assertions.assertEquals(T16PartHex.PART_16, T16PartHex.valueOfTone("꜑"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T16PartHex.PART_1, T16PartHex.valueOfChina("氫"));
		Assertions.assertEquals(T16PartHex.PART_2, T16PartHex.valueOfChina("氦"));
		Assertions.assertEquals(T16PartHex.PART_15, T16PartHex.valueOfChina("磷"));
		Assertions.assertEquals(T16PartHex.PART_16, T16PartHex.valueOfChina("硫"));
	}
}
