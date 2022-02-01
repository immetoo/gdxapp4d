package love.distributedrebirth.numberxd.base2t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class T20PartScoreTest {

	@Test
	public void testBasePart() {
		for (T20PartScore value:T20PartScore.values()) {
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
		Assertions.assertEquals(T20PartScore.PART_1, T20PartScore.valueOfTone("˥"));
		Assertions.assertEquals(T20PartScore.PART_2, T20PartScore.valueOfTone("˦"));
		Assertions.assertEquals(T20PartScore.PART_19, T20PartScore.valueOfTone("꜐"));
		Assertions.assertEquals(T20PartScore.PART_20, T20PartScore.valueOfTone("꜑"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T20PartScore.PART_1, T20PartScore.valueOfChina("尧"));
		Assertions.assertEquals(T20PartScore.PART_2, T20PartScore.valueOfChina("泽"));
		Assertions.assertEquals(T20PartScore.PART_19, T20PartScore.valueOfChina("仄"));
		Assertions.assertEquals(T20PartScore.PART_20, T20PartScore.valueOfChina("幺"));
	}
	
	@Test
	public void testOpenLCMap() {
		Assertions.assertEquals(T20PartScore.PART_1, T20PartScore.valueOfOpenLC("2"));
		Assertions.assertEquals(T20PartScore.PART_2, T20PartScore.valueOfOpenLC("3"));
		Assertions.assertEquals(T20PartScore.PART_19, T20PartScore.valueOfOpenLC("W"));
		Assertions.assertEquals(T20PartScore.PART_20, T20PartScore.valueOfOpenLC("X"));
	}
}
