package love.distributedrebirth.numberxd.base2t.part;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.T02PartBinary;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class T02PartBinaryTest {

	@Test
	public void testBasePart() {
		for (T02PartBinary value:T02PartBinary.values()) {
			Assertions.assertNotNull(value.BȍőnDialTone());
			Assertions.assertNotNull(value.BȍőnChinaKey());
			Assertions.assertNotNull(value.BȍőnChinaValue());
		}
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T02PartBinary.PART_1, T02PartBinary.PART_1.BãßValueOfDialTone("˧"));
		Assertions.assertEquals(T02PartBinary.PART_2, T02PartBinary.PART_1.BãßValueOfDialTone("꜔"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T02PartBinary.PART_1, T02PartBinary.PART_1.BãßValueOfChinaKey("低"));
		Assertions.assertEquals(T02PartBinary.PART_2, T02PartBinary.PART_1.BãßValueOfChinaKey("高"));
	}
}
