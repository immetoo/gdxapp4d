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
			Assertions.assertNotNull(value.getAlt1Name());
			Assertions.assertNotNull(value.getAlt1Wiki());
		}
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T04PartQuad.PART_1, T04PartQuad.valueOfTone("˥"));
		Assertions.assertEquals(T04PartQuad.PART_2, T04PartQuad.valueOfTone("꜒"));
		Assertions.assertEquals(T04PartQuad.PART_3, T04PartQuad.valueOfTone("꜖"));
		Assertions.assertEquals(T04PartQuad.PART_4, T04PartQuad.valueOfTone("˩"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T04PartQuad.PART_1, T04PartQuad.valueOfChina("北"));
		Assertions.assertEquals(T04PartQuad.PART_2, T04PartQuad.valueOfChina("東"));
		Assertions.assertEquals(T04PartQuad.PART_3, T04PartQuad.valueOfChina("西"));
		Assertions.assertEquals(T04PartQuad.PART_4, T04PartQuad.valueOfChina("南"));
	}
}
