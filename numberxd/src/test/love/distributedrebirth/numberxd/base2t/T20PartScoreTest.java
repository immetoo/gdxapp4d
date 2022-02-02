package love.distributedrebirth.numberxd.base2t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class T20PartScoreTest {

	@Test
	public void testBasePart() {
		for (T20PartScore value:T20PartScore.values()) {
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
		Assertions.assertEquals(T20PartScore.PART_1, T20PartScore.PART_1.BãßValueOfTone("˥"));
		Assertions.assertEquals(T20PartScore.PART_2, T20PartScore.PART_1.BãßValueOfTone("˦"));
		Assertions.assertEquals(T20PartScore.PART_19, T20PartScore.PART_1.BãßValueOfTone("꜐"));
		Assertions.assertEquals(T20PartScore.PART_20, T20PartScore.PART_1.BãßValueOfTone("꜑"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T20PartScore.PART_1, T20PartScore.PART_1.BãßValueOfChina("尧"));
		Assertions.assertEquals(T20PartScore.PART_2, T20PartScore.PART_1.BãßValueOfChina("泽"));
		Assertions.assertEquals(T20PartScore.PART_19, T20PartScore.PART_1.BãßValueOfChina("仄"));
		Assertions.assertEquals(T20PartScore.PART_20, T20PartScore.PART_1.BãßValueOfChina("幺"));
	}
	
	@Test
	public void testOpenLCMap() {
		Assertions.assertEquals(T20PartScore.PART_1, T20PartScore.PART_1.staticValueOfOpenLC("2"));
		Assertions.assertEquals(T20PartScore.PART_2, T20PartScore.PART_1.staticValueOfOpenLC("3"));
		Assertions.assertEquals(T20PartScore.PART_19, T20PartScore.PART_1.staticValueOfOpenLC("W"));
		Assertions.assertEquals(T20PartScore.PART_20, T20PartScore.PART_1.staticValueOfOpenLC("X"));
	}
}
