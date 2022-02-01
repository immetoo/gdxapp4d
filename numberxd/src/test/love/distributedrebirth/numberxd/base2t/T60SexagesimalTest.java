package love.distributedrebirth.numberxd.base2t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class T60SexagesimalTest {

	@Test
	public void testBasePart() {
		for (T60Sexagesimal value:T60Sexagesimal.values()) {
			Assertions.assertNotNull(value.getIdentifierTone());
			Assertions.assertNotNull(value.getIdentifierLetter());
			Assertions.assertNotNull(value.getChinaKey());
			Assertions.assertNotNull(value.getChinaValue());
		}
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T60Sexagesimal.PART_1, T60Sexagesimal.PART_1.staticValueOfTone("˧˩˥"));
		Assertions.assertEquals(T60Sexagesimal.PART_2, T60Sexagesimal.PART_1.staticValueOfTone("˧˥˦"));
		Assertions.assertEquals(T60Sexagesimal.PART_59, T60Sexagesimal.PART_1.staticValueOfTone("꜍꜍꜏"));
		Assertions.assertEquals(T60Sexagesimal.PART_60, T60Sexagesimal.PART_1.staticValueOfTone("꜑꜑꜏"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T60Sexagesimal.PART_1, T60Sexagesimal.PART_1.staticValueOfChina("牛"));
		Assertions.assertEquals(T60Sexagesimal.PART_2, T60Sexagesimal.PART_1.staticValueOfChina("鸡"));
		Assertions.assertEquals(T60Sexagesimal.PART_59, T60Sexagesimal.PART_1.staticValueOfChina("薯"));
		Assertions.assertEquals(T60Sexagesimal.PART_60, T60Sexagesimal.PART_1.staticValueOfChina("蘋"));
	}
}
