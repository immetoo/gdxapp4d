package love.distributedrebirth.numberxd.base2t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.T06PartSeximal;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class T06PartSeximalTest {

	@Test
	public void testBasePart() {
		for (T06PartSeximal value:T06PartSeximal.values()) {
			Assertions.assertNotNull(value.BȍőnIdentifierTone());
			Assertions.assertNotNull(value.BȍőnChinaKey());
			Assertions.assertNotNull(value.BȍőnChinaValue());
			Assertions.assertNotNull(value.BȍőnAlt1Value());
			Assertions.assertNotNull(value.BãßAlt1Name());
			Assertions.assertNotNull(value.BãßAlt1Website());
		}
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T06PartSeximal.PART_1, T06PartSeximal.PART_1.BãßValueOfTone("˦"));
		Assertions.assertEquals(T06PartSeximal.PART_2, T06PartSeximal.PART_1.BãßValueOfTone("˨"));
		Assertions.assertEquals(T06PartSeximal.PART_5, T06PartSeximal.PART_1.BãßValueOfTone("꜊"));
		Assertions.assertEquals(T06PartSeximal.PART_6, T06PartSeximal.PART_1.BãßValueOfTone("꜏"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T06PartSeximal.PART_1, T06PartSeximal.PART_1.BãßValueOfChina("四"));
		Assertions.assertEquals(T06PartSeximal.PART_2, T06PartSeximal.PART_1.BãßValueOfChina("五"));
		Assertions.assertEquals(T06PartSeximal.PART_5, T06PartSeximal.PART_1.BãßValueOfChina("八"));
		Assertions.assertEquals(T06PartSeximal.PART_6, T06PartSeximal.PART_1.BãßValueOfChina("九"));
	}
}
