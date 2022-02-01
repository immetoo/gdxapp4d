package love.distributedrebirth.numberxd.base2t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class T12PartUncialTest {

	@Test
	public void testBasePart() {
		for (T12PartUncial value:T12PartUncial.values()) {
			Assertions.assertNotNull(value.getIdentifierTone());
			Assertions.assertNotNull(value.getIdentifierLetter());
			Assertions.assertNotNull(value.getChinaKey());
			Assertions.assertNotNull(value.getChinaValue());
			Assertions.assertNotNull(value.getAlt1Value());
			Assertions.assertNotNull(value.staticAlt1Name());
			Assertions.assertNotNull(value.staticAlt1Website());
		}
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T12PartUncial.PART_1, T12PartUncial.PART_1.staticValueOfTone("˥"));
		Assertions.assertEquals(T12PartUncial.PART_2, T12PartUncial.PART_1.staticValueOfTone("˧"));
		Assertions.assertEquals(T12PartUncial.PART_11, T12PartUncial.PART_1.staticValueOfTone("꜏"));
		Assertions.assertEquals(T12PartUncial.PART_12, T12PartUncial.PART_1.staticValueOfTone("꜑"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T12PartUncial.PART_1, T12PartUncial.PART_1.staticValueOfChina("日"));
		Assertions.assertEquals(T12PartUncial.PART_2, T12PartUncial.PART_1.staticValueOfChina("月"));
		Assertions.assertEquals(T12PartUncial.PART_11, T12PartUncial.PART_1.staticValueOfChina("黼"));
		Assertions.assertEquals(T12PartUncial.PART_12, T12PartUncial.PART_1.staticValueOfChina("亞"));
	}
}
