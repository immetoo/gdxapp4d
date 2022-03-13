package love.distributedrebirth.numberxd.base2t.part;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.T11PartUndecimal;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class T11PartUndecimalTest {

	@Test
	public void testBasePart() {
		for (T11PartUndecimal value:T11PartUndecimal.values()) {
			Assertions.assertNotNull(value.BȍőnDialTone());
			Assertions.assertNotNull(value.BȍőnChinaKey());
			Assertions.assertNotNull(value.BȍőnChinaValue());
		}
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T11PartUndecimal.PART_1, T11PartUndecimal.PART_1.BãßValueOfDialTone("˥"));
		Assertions.assertEquals(T11PartUndecimal.PART_2, T11PartUndecimal.PART_1.BãßValueOfDialTone("꜈"));
		Assertions.assertEquals(T11PartUndecimal.PART_10, T11PartUndecimal.PART_1.BãßValueOfDialTone("꜐"));
		Assertions.assertEquals(T11PartUndecimal.PART_11, T11PartUndecimal.PART_1.BãßValueOfDialTone("˩"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T11PartUndecimal.PART_1, T11PartUndecimal.PART_1.BãßValueOfChinaKey("走"));
		Assertions.assertEquals(T11PartUndecimal.PART_2, T11PartUndecimal.PART_1.BãßValueOfChinaKey("跑"));
		Assertions.assertEquals(T11PartUndecimal.PART_10, T11PartUndecimal.PART_1.BãßValueOfChinaKey("春"));
		Assertions.assertEquals(T11PartUndecimal.PART_11, T11PartUndecimal.PART_1.BãßValueOfChinaKey("耦"));
	}
}
