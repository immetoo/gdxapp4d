package love.distributedrebirth.numberxd.base2t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.T12PartUncial;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class T12PartUncialTest {

	@Test
	public void testBasePart() {
		for (T12PartUncial value:T12PartUncial.values()) {
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
		Assertions.assertEquals(T12PartUncial.PART_1, T12PartUncial.PART_1.BãßValueOfDialTone("˥"));
		Assertions.assertEquals(T12PartUncial.PART_2, T12PartUncial.PART_1.BãßValueOfDialTone("˧"));
		Assertions.assertEquals(T12PartUncial.PART_11, T12PartUncial.PART_1.BãßValueOfDialTone("꜏"));
		Assertions.assertEquals(T12PartUncial.PART_12, T12PartUncial.PART_1.BãßValueOfDialTone("꜑"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T12PartUncial.PART_1, T12PartUncial.PART_1.BãßValueOfChinaKey("日"));
		Assertions.assertEquals(T12PartUncial.PART_2, T12PartUncial.PART_1.BãßValueOfChinaKey("月"));
		Assertions.assertEquals(T12PartUncial.PART_11, T12PartUncial.PART_1.BãßValueOfChinaKey("黼"));
		Assertions.assertEquals(T12PartUncial.PART_12, T12PartUncial.PART_1.BãßValueOfChinaKey("亞"));
	}
}
