package love.distributedrebirth.numberxd.base2t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.T03PartTrit;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class T03PartTritTest {

	@Test
	public void testBasePart() {
		for (T03PartTrit value:T03PartTrit.values()) {
			Assertions.assertNotNull(value.BȍőnIdentifierTone());
			Assertions.assertNotNull(value.BȍőnChinaKey());
			Assertions.assertNotNull(value.BȍőnChinaValue());
		}
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T03PartTrit.PART_1, T03PartTrit.PART_1.BãßValueOfTone("˦"));
		Assertions.assertEquals(T03PartTrit.PART_2, T03PartTrit.PART_1.BãßValueOfTone("˧"));
		Assertions.assertEquals(T03PartTrit.PART_3, T03PartTrit.PART_1.BãßValueOfTone("˨"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T03PartTrit.PART_1, T03PartTrit.PART_1.BãßValueOfChina("一"));
		Assertions.assertEquals(T03PartTrit.PART_2, T03PartTrit.PART_1.BãßValueOfChina("二"));
		Assertions.assertEquals(T03PartTrit.PART_3, T03PartTrit.PART_1.BãßValueOfChina("三"));
	}
}