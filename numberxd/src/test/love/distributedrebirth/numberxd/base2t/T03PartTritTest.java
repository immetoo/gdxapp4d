package love.distributedrebirth.numberxd.base2t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class T03PartTritTest {

	@Test
	public void testBasePart() {
		for (T03PartTrit value:T03PartTrit.values()) {
			Assertions.assertNotNull(value.getIdentifierTone());
			Assertions.assertNotNull(value.getIdentifierLetter());
			Assertions.assertNotNull(value.getChinaKey());
			Assertions.assertNotNull(value.getChinaValue());
		}
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T03PartTrit.PART_1, T03PartTrit.PART_1.staticValueOfTone("˦"));
		Assertions.assertEquals(T03PartTrit.PART_2, T03PartTrit.PART_1.staticValueOfTone("˧"));
		Assertions.assertEquals(T03PartTrit.PART_3, T03PartTrit.PART_1.staticValueOfTone("˨"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T03PartTrit.PART_1, T03PartTrit.PART_1.staticValueOfChina("一"));
		Assertions.assertEquals(T03PartTrit.PART_2, T03PartTrit.PART_1.staticValueOfChina("二"));
		Assertions.assertEquals(T03PartTrit.PART_3, T03PartTrit.PART_1.staticValueOfChina("三"));
	}
}
