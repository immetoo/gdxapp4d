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
			Assertions.assertNotNull(value.getAlt1Name());
			Assertions.assertNotNull(value.getAlt1Wiki());
		}
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T12PartUncial.PART_1, T12PartUncial.valueOfTone("˥"));
		Assertions.assertEquals(T12PartUncial.PART_2, T12PartUncial.valueOfTone("˧"));
		Assertions.assertEquals(T12PartUncial.PART_11, T12PartUncial.valueOfTone("꜏"));
		Assertions.assertEquals(T12PartUncial.PART_12, T12PartUncial.valueOfTone("꜑"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T12PartUncial.PART_1, T12PartUncial.valueOfChina("日"));
		Assertions.assertEquals(T12PartUncial.PART_2, T12PartUncial.valueOfChina("月"));
		Assertions.assertEquals(T12PartUncial.PART_11, T12PartUncial.valueOfChina("黼"));
		Assertions.assertEquals(T12PartUncial.PART_12, T12PartUncial.valueOfChina("亞"));
	}
}
