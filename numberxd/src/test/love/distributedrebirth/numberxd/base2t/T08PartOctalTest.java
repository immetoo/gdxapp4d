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
			Assertions.assertNotNull(value.staticAlt1Name());
			Assertions.assertNotNull(value.staticAlt1Website());
			Assertions.assertNotNull(value.getAlt2Value());
			Assertions.assertNotNull(value.staticAlt2Name());
			Assertions.assertNotNull(value.staticAlt2Website());
		}
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T08PartOctal.PART_1, T08PartOctal.PART_1.staticValueOfTone("˥"));
		Assertions.assertEquals(T08PartOctal.PART_2, T08PartOctal.PART_1.staticValueOfTone("˩"));
		Assertions.assertEquals(T08PartOctal.PART_7, T08PartOctal.PART_1.staticValueOfTone("꜍"));
		Assertions.assertEquals(T08PartOctal.PART_8, T08PartOctal.PART_1.staticValueOfTone("꜑"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T08PartOctal.PART_1, T08PartOctal.PART_1.staticValueOfChina("心"));
		Assertions.assertEquals(T08PartOctal.PART_2, T08PartOctal.PART_1.staticValueOfChina("頭"));
		Assertions.assertEquals(T08PartOctal.PART_7, T08PartOctal.PART_1.staticValueOfChina("肢"));
		Assertions.assertEquals(T08PartOctal.PART_8, T08PartOctal.PART_1.staticValueOfChina("腳"));
	}
}
