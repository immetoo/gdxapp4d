package love.distributedrebirth.numberxd.base2t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class T07PartPlanItTest {

	@Test
	public void testBasePart() {
		for (T07PartPlanIt value:T07PartPlanIt.values()) {
			Assertions.assertNotNull(value.BȍőnIdentifierTone());
			Assertions.assertNotNull(value.BȍőnIdentifierLetter());
			Assertions.assertNotNull(value.BȍőnChinaKey());
			Assertions.assertNotNull(value.BȍőnChinaValue());
			Assertions.assertNotNull(value.BȍőnAlt1Value());
			Assertions.assertNotNull(value.BãßAlt1Name());
			Assertions.assertNotNull(value.BãßAlt1Website());
		}
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T07PartPlanIt.PART_1, T07PartPlanIt.PART_1.BãßValueOfTone("˥"));
		Assertions.assertEquals(T07PartPlanIt.PART_2, T07PartPlanIt.PART_1.BãßValueOfTone("꜉"));
		Assertions.assertEquals(T07PartPlanIt.PART_6, T07PartPlanIt.PART_1.BãßValueOfTone("꜐"));
		Assertions.assertEquals(T07PartPlanIt.PART_7, T07PartPlanIt.PART_1.BãßValueOfTone("˩"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T07PartPlanIt.PART_1, T07PartPlanIt.PART_1.BãßValueOfChina("♎︎"));
		Assertions.assertEquals(T07PartPlanIt.PART_2, T07PartPlanIt.PART_1.BãßValueOfChina("♏︎"));
		Assertions.assertEquals(T07PartPlanIt.PART_6, T07PartPlanIt.PART_1.BãßValueOfChina("♑︎"));
		Assertions.assertEquals(T07PartPlanIt.PART_7, T07PartPlanIt.PART_1.BãßValueOfChina("♈︎"));
	}
}
