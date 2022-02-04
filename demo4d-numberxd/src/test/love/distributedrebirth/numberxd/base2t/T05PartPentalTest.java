package love.distributedrebirth.numberxd.base2t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.T05PartPental;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class T05PartPentalTest {

	@Test
	public void testBasePart() {
		for (T05PartPental value:T05PartPental.values()) {
			Assertions.assertNotNull(value.BȍőnIdentifierTone());
			Assertions.assertNotNull(value.BȍőnChinaKey());
			Assertions.assertNotNull(value.BȍőnChinaValue());
		}
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T05PartPental.PART_1, T05PartPental.PART_1.BãßValueOfTone("˥"));
		Assertions.assertEquals(T05PartPental.PART_2, T05PartPental.PART_1.BãßValueOfTone("˦"));
		Assertions.assertEquals(T05PartPental.PART_3, T05PartPental.PART_1.BãßValueOfTone("˧"));
		Assertions.assertEquals(T05PartPental.PART_4, T05PartPental.PART_1.BãßValueOfTone("˨"));
		Assertions.assertEquals(T05PartPental.PART_5, T05PartPental.PART_1.BãßValueOfTone("˩"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T05PartPental.PART_1, T05PartPental.PART_1.BãßValueOfChina("火"));
		Assertions.assertEquals(T05PartPental.PART_2, T05PartPental.PART_1.BãßValueOfChina("水"));
		Assertions.assertEquals(T05PartPental.PART_3, T05PartPental.PART_1.BãßValueOfChina("木"));
		Assertions.assertEquals(T05PartPental.PART_4, T05PartPental.PART_1.BãßValueOfChina("金"));
		Assertions.assertEquals(T05PartPental.PART_5, T05PartPental.PART_1.BãßValueOfChina("土"));
	}
}
