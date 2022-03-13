package love.distributedrebirth.numberxd.base2t.part;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.T16PartHex;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class T16PartHexTest {

	@Test
	public void testBasePart() {
		for (T16PartHex value:T16PartHex.values()) {
			Assertions.assertNotNull(value.BȍőnDialTone());
			Assertions.assertNotNull(value.BȍőnChinaKey());
			Assertions.assertNotNull(value.BȍőnChinaValue());
		}
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T16PartHex.PART_1, T16PartHex.PART_1.BãßValueOfDialTone("˥"));
		Assertions.assertEquals(T16PartHex.PART_2, T16PartHex.PART_1.BãßValueOfDialTone("˦"));
		Assertions.assertEquals(T16PartHex.PART_15, T16PartHex.PART_1.BãßValueOfDialTone("꜐"));
		Assertions.assertEquals(T16PartHex.PART_16, T16PartHex.PART_1.BãßValueOfDialTone("꜑"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T16PartHex.PART_1, T16PartHex.PART_1.BãßValueOfChinaKey("氫"));
		Assertions.assertEquals(T16PartHex.PART_2, T16PartHex.PART_1.BãßValueOfChinaKey("氦"));
		Assertions.assertEquals(T16PartHex.PART_15, T16PartHex.PART_1.BãßValueOfChinaKey("磷"));
		Assertions.assertEquals(T16PartHex.PART_16, T16PartHex.PART_1.BãßValueOfChinaKey("硫"));
	}
}
