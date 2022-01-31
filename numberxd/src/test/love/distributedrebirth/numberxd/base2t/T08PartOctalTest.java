package love.distributedrebirth.numberxd.base2t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class T08PartOctalTest {

	@Test
	public void testBasePart() {
		for (T08PartOctal value:T08PartOctal.values()) {
			Assertions.assertNotNull(value.getIdentifierTone());
			Assertions.assertNotNull(value.getIdentifierLetter());
			Assertions.assertNotNull(value.getChinaKey());
			Assertions.assertNotNull(value.getChinaValue());
			Assertions.assertNotNull(value.getAlt1Value());
			Assertions.assertNotNull(value.getAlt1Name());
			Assertions.assertNotNull(value.getAlt1Wiki());
			Assertions.assertNotNull(value.getAlt2Value());
			Assertions.assertNotNull(value.getAlt2Name());
			Assertions.assertNotNull(value.getAlt2Wiki());
		}
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T08PartOctal.PART_1, T08PartOctal.valueOfTone("˥"));
		Assertions.assertEquals(T08PartOctal.PART_2, T08PartOctal.valueOfTone("˩"));
		Assertions.assertEquals(T08PartOctal.PART_7, T08PartOctal.valueOfTone("꜍"));
		Assertions.assertEquals(T08PartOctal.PART_8, T08PartOctal.valueOfTone("꜑"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T08PartOctal.PART_1, T08PartOctal.valueOfChina("心"));
		Assertions.assertEquals(T08PartOctal.PART_2, T08PartOctal.valueOfChina("頭"));
		Assertions.assertEquals(T08PartOctal.PART_7, T08PartOctal.valueOfChina("肢"));
		Assertions.assertEquals(T08PartOctal.PART_8, T08PartOctal.valueOfChina("腳"));
	}
}
