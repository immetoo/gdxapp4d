package love.distributedrebirth.numberxd.base2t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class T12PartUncialTest {

	@Test
	public void testBasePart() {
		for (T12PartUncial value:T12PartUncial.values()) {
			Assertions.assertNotNull(value.BȍőnIdentifierTone());
			Assertions.assertNotNull(value.BȍőnIdentifierLetter());
			Assertions.assertNotNull(value.BȍőnChinaKey());
			Assertions.assertNotNull(value.BȍőnChinaValue());
			Assertions.assertNotNull(value.BȍőnAlt1Value());
			Assertions.assertNotNull(value.BãßAlt1Name());
			Assertions.assertNotNull(value.BãßAlt1Website());
		}
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T12PartUncial.PART_1, T12PartUncial.PART_1.BãßValueOfTone("˥"));
		Assertions.assertEquals(T12PartUncial.PART_2, T12PartUncial.PART_1.BãßValueOfTone("˧"));
		Assertions.assertEquals(T12PartUncial.PART_11, T12PartUncial.PART_1.BãßValueOfTone("꜏"));
		Assertions.assertEquals(T12PartUncial.PART_12, T12PartUncial.PART_1.BãßValueOfTone("꜑"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T12PartUncial.PART_1, T12PartUncial.PART_1.BãßValueOfChina("日"));
		Assertions.assertEquals(T12PartUncial.PART_2, T12PartUncial.PART_1.BãßValueOfChina("月"));
		Assertions.assertEquals(T12PartUncial.PART_11, T12PartUncial.PART_1.BãßValueOfChina("黼"));
		Assertions.assertEquals(T12PartUncial.PART_12, T12PartUncial.PART_1.BãßValueOfChina("亞"));
	}
}
