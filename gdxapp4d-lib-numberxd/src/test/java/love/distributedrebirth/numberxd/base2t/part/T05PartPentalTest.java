package love.distributedrebirth.numberxd.base2t.part;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.T05PartPental;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class T05PartPentalTest {

	@Test
	public void testBasePart() {
		for (T05PartPental value:T05PartPental.values()) {
			Assertions.assertNotNull(value.BȍőnDialTone());
			Assertions.assertNotNull(value.BȍőnChinaKey());
			Assertions.assertNotNull(value.BȍőnChinaValue());
		}
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T05PartPental.PART_1, T05PartPental.PART_1.BãßValueOfDialTone("˥"));
		Assertions.assertEquals(T05PartPental.PART_2, T05PartPental.PART_1.BãßValueOfDialTone("˦"));
		Assertions.assertEquals(T05PartPental.PART_3, T05PartPental.PART_1.BãßValueOfDialTone("˧"));
		Assertions.assertEquals(T05PartPental.PART_4, T05PartPental.PART_1.BãßValueOfDialTone("˨"));
		Assertions.assertEquals(T05PartPental.PART_5, T05PartPental.PART_1.BãßValueOfDialTone("˩"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T05PartPental.PART_1, T05PartPental.PART_1.BãßValueOfChinaKey("火"));
		Assertions.assertEquals(T05PartPental.PART_2, T05PartPental.PART_1.BãßValueOfChinaKey("水"));
		Assertions.assertEquals(T05PartPental.PART_3, T05PartPental.PART_1.BãßValueOfChinaKey("木"));
		Assertions.assertEquals(T05PartPental.PART_4, T05PartPental.PART_1.BãßValueOfChinaKey("金"));
		Assertions.assertEquals(T05PartPental.PART_5, T05PartPental.PART_1.BãßValueOfChinaKey("土"));
	}
}
