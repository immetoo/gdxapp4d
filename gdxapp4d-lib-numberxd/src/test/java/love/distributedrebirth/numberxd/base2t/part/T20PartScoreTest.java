package love.distributedrebirth.numberxd.base2t.part;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.T20PartScore;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class T20PartScoreTest {

	@Test
	public void testBasePart() {
		for (T20PartScore value:T20PartScore.values()) {
			Assertions.assertNotNull(value.BȍőnDialTone());
			Assertions.assertNotNull(value.BȍőnChinaKey());
			Assertions.assertNotNull(value.BȍőnChinaValue());
			Assertions.assertNotNull(value.BȍőnAlt1Value());
			Assertions.assertNotNull(value.BãßAlt1Name());
			Assertions.assertNotNull(value.BãßAlt1Website());
		}
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T20PartScore.PART_1, T20PartScore.PART_1.BãßValueOfDialTone("˥"));
		Assertions.assertEquals(T20PartScore.PART_2, T20PartScore.PART_1.BãßValueOfDialTone("˦"));
		Assertions.assertEquals(T20PartScore.PART_19, T20PartScore.PART_1.BãßValueOfDialTone("꜐"));
		Assertions.assertEquals(T20PartScore.PART_20, T20PartScore.PART_1.BãßValueOfDialTone("꜑"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T20PartScore.PART_1, T20PartScore.PART_1.BãßValueOfChinaKey("尧"));
		Assertions.assertEquals(T20PartScore.PART_2, T20PartScore.PART_1.BãßValueOfChinaKey("泽"));
		Assertions.assertEquals(T20PartScore.PART_19, T20PartScore.PART_1.BãßValueOfChinaKey("仄"));
		Assertions.assertEquals(T20PartScore.PART_20, T20PartScore.PART_1.BãßValueOfChinaKey("幺"));
	}
	
	@Test
	public void testOpenLCMap() {
		Assertions.assertEquals(T20PartScore.PART_1, T20PartScore.PART_1.BãßValueOfOpenLC("2"));
		Assertions.assertEquals(T20PartScore.PART_2, T20PartScore.PART_1.BãßValueOfOpenLC("3"));
		Assertions.assertEquals(T20PartScore.PART_19, T20PartScore.PART_1.BãßValueOfOpenLC("W"));
		Assertions.assertEquals(T20PartScore.PART_20, T20PartScore.PART_1.BãßValueOfOpenLC("X"));
	}
}
