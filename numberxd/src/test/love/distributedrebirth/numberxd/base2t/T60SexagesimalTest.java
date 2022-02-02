package love.distributedrebirth.numberxd.base2t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.T60PartSexagesimal;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class T60SexagesimalTest {

	@Test
	public void testBasePart() {
		for (T60PartSexagesimal value:T60PartSexagesimal.values()) {
			Assertions.assertNotNull(value.BȍőnIdentifierTone());
			Assertions.assertNotNull(value.BȍőnIdentifierLetter());
			Assertions.assertNotNull(value.BȍőnChinaKey());
			Assertions.assertNotNull(value.BȍőnChinaValue());
		}
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T60PartSexagesimal.PART_1, T60PartSexagesimal.PART_1.BãßValueOfTone("˧˩˥"));
		Assertions.assertEquals(T60PartSexagesimal.PART_2, T60PartSexagesimal.PART_1.BãßValueOfTone("˧˥˦"));
		Assertions.assertEquals(T60PartSexagesimal.PART_59, T60PartSexagesimal.PART_1.BãßValueOfTone("꜍꜍꜏"));
		Assertions.assertEquals(T60PartSexagesimal.PART_60, T60PartSexagesimal.PART_1.BãßValueOfTone("꜑꜑꜏"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T60PartSexagesimal.PART_1, T60PartSexagesimal.PART_1.BãßValueOfChina("牛"));
		Assertions.assertEquals(T60PartSexagesimal.PART_2, T60PartSexagesimal.PART_1.BãßValueOfChina("鸡"));
		Assertions.assertEquals(T60PartSexagesimal.PART_59, T60PartSexagesimal.PART_1.BãßValueOfChina("薯"));
		Assertions.assertEquals(T60PartSexagesimal.PART_60, T60PartSexagesimal.PART_1.BãßValueOfChina("蘋"));
	}
}
