package love.distributedrebirth.numberxd.base2t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
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
		Assertions.assertEquals(T04PartQuad.PART_1, T04PartQuad.PART_4.volgende());
		Assertions.assertEquals(T04PartQuad.PART_2, T04PartQuad.PART_1.volgende());
		Assertions.assertEquals(T04PartQuad.PART_3, T04PartQuad.PART_2.volgende());
		Assertions.assertEquals(T04PartQuad.PART_4, T04PartQuad.PART_3.volgende());
	}
	
	@Test
	public void testVorige() {
		Assertions.assertEquals(T04PartQuad.PART_1, T04PartQuad.PART_2.vorige());
		Assertions.assertEquals(T04PartQuad.PART_2, T04PartQuad.PART_3.vorige());
		Assertions.assertEquals(T04PartQuad.PART_3, T04PartQuad.PART_4.vorige());
		Assertions.assertEquals(T04PartQuad.PART_4, T04PartQuad.PART_1.vorige());
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
