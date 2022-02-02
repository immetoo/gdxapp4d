package love.distributedrebirth.numberxd.base2t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class T11PartUndecimalTest {

	@Test
	public void testBasePart() {
		for (T11PartUndecimal value:T11PartUndecimal.values()) {
			Assertions.assertNotNull(value.getIdentifierTone());
			Assertions.assertNotNull(value.getIdentifierLetter());
			Assertions.assertNotNull(value.getChinaKey());
			Assertions.assertNotNull(value.getChinaValue());
		}
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T11PartUndecimal.PART_1, T11PartUndecimal.PART_1.staticValueOfTone("˥"));
		Assertions.assertEquals(T11PartUndecimal.PART_2, T11PartUndecimal.PART_1.staticValueOfTone("꜈"));
		Assertions.assertEquals(T11PartUndecimal.PART_10, T11PartUndecimal.PART_1.staticValueOfTone("꜐"));
		Assertions.assertEquals(T11PartUndecimal.PART_11, T11PartUndecimal.PART_1.staticValueOfTone("˩"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T11PartUndecimal.PART_1, T11PartUndecimal.PART_1.staticValueOfChina("走"));
		Assertions.assertEquals(T11PartUndecimal.PART_2, T11PartUndecimal.PART_1.staticValueOfChina("跑"));
		Assertions.assertEquals(T11PartUndecimal.PART_10, T11PartUndecimal.PART_1.staticValueOfChina("春"));
		Assertions.assertEquals(T11PartUndecimal.PART_11, T11PartUndecimal.PART_1.staticValueOfChina("耦"));
	}
}
