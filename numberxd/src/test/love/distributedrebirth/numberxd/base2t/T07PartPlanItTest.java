package love.distributedrebirth.numberxd.base2t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class T07PartPlanItTest {

	@Test
	public void testBasePart() {
		for (T07PartPlanIt value:T07PartPlanIt.values()) {
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
		Assertions.assertEquals(T07PartPlanIt.PART_1, T07PartPlanIt.valueOfTone("˥"));
		Assertions.assertEquals(T07PartPlanIt.PART_2, T07PartPlanIt.valueOfTone("꜉"));
		Assertions.assertEquals(T07PartPlanIt.PART_6, T07PartPlanIt.valueOfTone("꜐"));
		Assertions.assertEquals(T07PartPlanIt.PART_7, T07PartPlanIt.valueOfTone("˩"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T07PartPlanIt.PART_1, T07PartPlanIt.valueOfChina("♎︎"));
		Assertions.assertEquals(T07PartPlanIt.PART_2, T07PartPlanIt.valueOfChina("♏︎"));
		Assertions.assertEquals(T07PartPlanIt.PART_6, T07PartPlanIt.valueOfChina("♑︎"));
		Assertions.assertEquals(T07PartPlanIt.PART_7, T07PartPlanIt.valueOfChina("♈︎"));
	}
}
