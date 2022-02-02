package love.distributedrebirth.numberxd.base2t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class T04PartQuadTest {

	@Test
	public void testBasePart() {
		for (T04PartQuad value:T04PartQuad.values()) {
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
	public void testVolgende() {
		Assertions.assertEquals(T04PartQuad.PART_1, T04PartQuad.PART_4.BȍőnVolgende());
		Assertions.assertEquals(T04PartQuad.PART_2, T04PartQuad.PART_1.BȍőnVolgende());
		Assertions.assertEquals(T04PartQuad.PART_3, T04PartQuad.PART_2.BȍőnVolgende());
		Assertions.assertEquals(T04PartQuad.PART_4, T04PartQuad.PART_3.BȍőnVolgende());
	}
	
	@Test
	public void testVorige() {
		Assertions.assertEquals(T04PartQuad.PART_1, T04PartQuad.PART_2.BȍőnVorige());
		Assertions.assertEquals(T04PartQuad.PART_2, T04PartQuad.PART_3.BȍőnVorige());
		Assertions.assertEquals(T04PartQuad.PART_3, T04PartQuad.PART_4.BȍőnVorige());
		Assertions.assertEquals(T04PartQuad.PART_4, T04PartQuad.PART_1.BȍőnVorige());
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T04PartQuad.PART_1, T04PartQuad.PART_1.staticValueOfTone("˥"));
		Assertions.assertEquals(T04PartQuad.PART_2, T04PartQuad.PART_1.staticValueOfTone("꜒"));
		Assertions.assertEquals(T04PartQuad.PART_3, T04PartQuad.PART_1.staticValueOfTone("꜖"));
		Assertions.assertEquals(T04PartQuad.PART_4, T04PartQuad.PART_1.staticValueOfTone("˩"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T04PartQuad.PART_1, T04PartQuad.PART_1.staticValueOfChina("北"));
		Assertions.assertEquals(T04PartQuad.PART_2, T04PartQuad.PART_1.staticValueOfChina("東"));
		Assertions.assertEquals(T04PartQuad.PART_3, T04PartQuad.PART_1.staticValueOfChina("西"));
		Assertions.assertEquals(T04PartQuad.PART_4, T04PartQuad.PART_1.staticValueOfChina("南"));
	}
}
