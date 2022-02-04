package love.distributedrebirth.numberxd.base2t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.T08PartOctal;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class T08PartOctalTest {

	@Test
	public void testBasePart() {
		for (T08PartOctal value:T08PartOctal.values()) {
			Assertions.assertNotNull(value.BȍőnIdentifierTone());
			Assertions.assertNotNull(value.BȍőnChinaKey());
			Assertions.assertNotNull(value.BȍőnChinaValue());
		}
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T08PartOctal.PART_1, T08PartOctal.PART_1.BãßValueOfTone("˥"));
		Assertions.assertEquals(T08PartOctal.PART_2, T08PartOctal.PART_1.BãßValueOfTone("˩"));
		Assertions.assertEquals(T08PartOctal.PART_7, T08PartOctal.PART_1.BãßValueOfTone("꜍"));
		Assertions.assertEquals(T08PartOctal.PART_8, T08PartOctal.PART_1.BãßValueOfTone("꜑"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T08PartOctal.PART_1, T08PartOctal.PART_1.BãßValueOfChina("心"));
		Assertions.assertEquals(T08PartOctal.PART_2, T08PartOctal.PART_1.BãßValueOfChina("頭"));
		Assertions.assertEquals(T08PartOctal.PART_7, T08PartOctal.PART_1.BãßValueOfChina("肢"));
		Assertions.assertEquals(T08PartOctal.PART_8, T08PartOctal.PART_1.BãßValueOfChina("腳"));
	}
}
