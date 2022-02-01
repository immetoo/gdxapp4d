package love.distributedrebirth.numberxd.base2t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class T02PartBinaryTest {

	@Test
	public void testBasePart() {
		for (T02PartBinary value:T02PartBinary.values()) {
			Assertions.assertNotNull(value.getIdentifierTone());
			Assertions.assertNotNull(value.getIdentifierLetter());
			Assertions.assertNotNull(value.getChinaKey());
			Assertions.assertNotNull(value.getChinaValue());
		}
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T02PartBinary.PART_1, T02PartBinary.PART_1.staticValueOfTone("˧"));
		Assertions.assertEquals(T02PartBinary.PART_2, T02PartBinary.PART_1.staticValueOfTone("꜔"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T02PartBinary.PART_1, T02PartBinary.PART_1.staticValueOfChina("低"));
		Assertions.assertEquals(T02PartBinary.PART_2, T02PartBinary.PART_1.staticValueOfChina("高"));
	}
}
