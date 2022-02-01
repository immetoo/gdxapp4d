package love.distributedrebirth.numberxd.base2t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class T10PartDecimalTest {

	@Test
	public void testBasePart() {
		for (T10PartDecimal value:T10PartDecimal.values()) {
			Assertions.assertNotNull(value.getIdentifierTone());
			Assertions.assertNotNull(value.getIdentifierLetter());
			Assertions.assertNotNull(value.getChinaKey());
			Assertions.assertNotNull(value.getChinaValue());
		}
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T10PartDecimal.PART_1, T10PartDecimal.PART_1.staticValueOfTone("˥"));
		Assertions.assertEquals(T10PartDecimal.PART_2, T10PartDecimal.PART_1.staticValueOfTone("˦"));
		Assertions.assertEquals(T10PartDecimal.PART_9, T10PartDecimal.PART_1.staticValueOfTone("꜕"));
		Assertions.assertEquals(T10PartDecimal.PART_10, T10PartDecimal.PART_1.staticValueOfTone("꜖"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T10PartDecimal.PART_1, T10PartDecimal.PART_1.staticValueOfChina("零"));
		Assertions.assertEquals(T10PartDecimal.PART_2, T10PartDecimal.PART_1.staticValueOfChina("壹"));
		Assertions.assertEquals(T10PartDecimal.PART_9, T10PartDecimal.PART_1.staticValueOfChina("捌"));
		Assertions.assertEquals(T10PartDecimal.PART_10, T10PartDecimal.PART_1.staticValueOfChina("玖"));
	}
}
