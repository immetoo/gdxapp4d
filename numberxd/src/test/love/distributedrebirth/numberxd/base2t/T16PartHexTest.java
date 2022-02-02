package love.distributedrebirth.numberxd.base2t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class T16PartHexTest {

	@Test
	public void testBasePart() {
		for (T16PartHex value:T16PartHex.values()) {
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
	public void testToneMap() {
		Assertions.assertEquals(T16PartHex.PART_1, T16PartHex.PART_1.staticValueOfTone("˥"));
		Assertions.assertEquals(T16PartHex.PART_2, T16PartHex.PART_1.staticValueOfTone("˦"));
		Assertions.assertEquals(T16PartHex.PART_15, T16PartHex.PART_1.staticValueOfTone("꜐"));
		Assertions.assertEquals(T16PartHex.PART_16, T16PartHex.PART_1.staticValueOfTone("꜑"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T16PartHex.PART_1, T16PartHex.PART_1.staticValueOfChina("氫"));
		Assertions.assertEquals(T16PartHex.PART_2, T16PartHex.PART_1.staticValueOfChina("氦"));
		Assertions.assertEquals(T16PartHex.PART_15, T16PartHex.PART_1.staticValueOfChina("磷"));
		Assertions.assertEquals(T16PartHex.PART_16, T16PartHex.PART_1.staticValueOfChina("硫"));
	}
}
