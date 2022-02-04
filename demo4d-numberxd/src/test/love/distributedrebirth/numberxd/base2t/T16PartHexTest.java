package love.distributedrebirth.numberxd.base2t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.T16PartHex;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class T16PartHexTest {

	@Test
	public void testBasePart() {
		for (T16PartHex value:T16PartHex.values()) {
			Assertions.assertNotNull(value.BȍőnIdentifierTone());
			Assertions.assertNotNull(value.BȍőnChinaKey());
			Assertions.assertNotNull(value.BȍőnChinaValue());
		}
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T16PartHex.PART_1, T16PartHex.PART_1.BãßValueOfTone("˥"));
		Assertions.assertEquals(T16PartHex.PART_2, T16PartHex.PART_1.BãßValueOfTone("˦"));
		Assertions.assertEquals(T16PartHex.PART_15, T16PartHex.PART_1.BãßValueOfTone("꜐"));
		Assertions.assertEquals(T16PartHex.PART_16, T16PartHex.PART_1.BãßValueOfTone("꜑"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T16PartHex.PART_1, T16PartHex.PART_1.BãßValueOfChina("氫"));
		Assertions.assertEquals(T16PartHex.PART_2, T16PartHex.PART_1.BãßValueOfChina("氦"));
		Assertions.assertEquals(T16PartHex.PART_15, T16PartHex.PART_1.BãßValueOfChina("磷"));
		Assertions.assertEquals(T16PartHex.PART_16, T16PartHex.PART_1.BãßValueOfChina("硫"));
	}
}
