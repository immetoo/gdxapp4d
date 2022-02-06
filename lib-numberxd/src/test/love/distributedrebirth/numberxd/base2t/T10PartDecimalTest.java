package love.distributedrebirth.numberxd.base2t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.T10PartDecimal;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class T10PartDecimalTest {

	@Test
	public void testBasePart() {
		for (T10PartDecimal value:T10PartDecimal.values()) {
			Assertions.assertNotNull(value.BȍőnDialTone());
			Assertions.assertNotNull(value.BȍőnChinaKey());
			Assertions.assertNotNull(value.BȍőnChinaValue());
		}
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T10PartDecimal.PART_1, T10PartDecimal.PART_1.BãßValueOfDialTone("˥"));
		Assertions.assertEquals(T10PartDecimal.PART_2, T10PartDecimal.PART_1.BãßValueOfDialTone("˦"));
		Assertions.assertEquals(T10PartDecimal.PART_9, T10PartDecimal.PART_1.BãßValueOfDialTone("꜕"));
		Assertions.assertEquals(T10PartDecimal.PART_10, T10PartDecimal.PART_1.BãßValueOfDialTone("꜖"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T10PartDecimal.PART_1, T10PartDecimal.PART_1.BãßValueOfChinaKey("零"));
		Assertions.assertEquals(T10PartDecimal.PART_2, T10PartDecimal.PART_1.BãßValueOfChinaKey("壹"));
		Assertions.assertEquals(T10PartDecimal.PART_9, T10PartDecimal.PART_1.BãßValueOfChinaKey("捌"));
		Assertions.assertEquals(T10PartDecimal.PART_10, T10PartDecimal.PART_1.BãßValueOfChinaKey("玖"));
	}
}
