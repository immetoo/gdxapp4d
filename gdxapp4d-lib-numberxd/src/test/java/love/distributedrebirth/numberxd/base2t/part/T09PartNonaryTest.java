package love.distributedrebirth.numberxd.base2t.part;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.T09PartNonary;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class T09PartNonaryTest {

	@Test
	public void testBasePart() {
		for (T09PartNonary value:T09PartNonary.values()) {
			Assertions.assertNotNull(value.BȍőnDialTone());
			Assertions.assertNotNull(value.BȍőnChinaKey());
			Assertions.assertNotNull(value.BȍőnChinaValue());
		}
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T09PartNonary.PART_1, T09PartNonary.PART_1.BãßValueOfDialTone("˦"));
		Assertions.assertEquals(T09PartNonary.PART_2, T09PartNonary.PART_1.BãßValueOfDialTone("˨"));
		Assertions.assertEquals(T09PartNonary.PART_8, T09PartNonary.PART_1.BãßValueOfDialTone("꜏"));
		Assertions.assertEquals(T09PartNonary.PART_9, T09PartNonary.PART_1.BãßValueOfDialTone("꜑"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T09PartNonary.PART_1, T09PartNonary.PART_1.BãßValueOfChinaKey("藍"));
		Assertions.assertEquals(T09PartNonary.PART_2, T09PartNonary.PART_1.BãßValueOfChinaKey("皓"));
		Assertions.assertEquals(T09PartNonary.PART_8, T09PartNonary.PART_1.BãßValueOfChinaKey("黑"));
		Assertions.assertEquals(T09PartNonary.PART_9, T09PartNonary.PART_1.BãßValueOfChinaKey("紺"));
	}
}
