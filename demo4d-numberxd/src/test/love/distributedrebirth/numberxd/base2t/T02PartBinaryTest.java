package love.distributedrebirth.numberxd.base2t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.T02PartBinary;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class T02PartBinaryTest {

	@Test
	public void testBasePart() {
		for (T02PartBinary value:T02PartBinary.values()) {
			Assertions.assertNotNull(value.BȍőnIdentifierTone());
			Assertions.assertNotNull(value.BȍőnChinaKey());
			Assertions.assertNotNull(value.BȍőnChinaValue());
		}
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T02PartBinary.PART_1, T02PartBinary.PART_1.BãßValueOfTone("˧"));
		Assertions.assertEquals(T02PartBinary.PART_2, T02PartBinary.PART_1.BãßValueOfTone("꜔"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T02PartBinary.PART_1, T02PartBinary.PART_1.BãßValueOfChina("低"));
		Assertions.assertEquals(T02PartBinary.PART_2, T02PartBinary.PART_1.BãßValueOfChina("高"));
	}
}
