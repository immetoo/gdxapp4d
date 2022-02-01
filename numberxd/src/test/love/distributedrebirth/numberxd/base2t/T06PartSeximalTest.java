package love.distributedrebirth.numberxd.base2t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class T06PartSeximalTest {

	@Test
	public void testBasePart() {
		for (T06PartSeximal value:T06PartSeximal.values()) {
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
		Assertions.assertEquals(T06PartSeximal.PART_1, T06PartSeximal.valueOfTone("˦"));
		Assertions.assertEquals(T06PartSeximal.PART_2, T06PartSeximal.valueOfTone("˨"));
		Assertions.assertEquals(T06PartSeximal.PART_5, T06PartSeximal.valueOfTone("꜊"));
		Assertions.assertEquals(T06PartSeximal.PART_6, T06PartSeximal.valueOfTone("꜏"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T06PartSeximal.PART_1, T06PartSeximal.valueOfChina("四"));
		Assertions.assertEquals(T06PartSeximal.PART_2, T06PartSeximal.valueOfChina("五"));
		Assertions.assertEquals(T06PartSeximal.PART_5, T06PartSeximal.valueOfChina("八"));
		Assertions.assertEquals(T06PartSeximal.PART_6, T06PartSeximal.valueOfChina("九"));
	}
}
