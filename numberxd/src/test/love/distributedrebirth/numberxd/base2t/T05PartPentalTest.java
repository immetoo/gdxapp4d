package love.distributedrebirth.numberxd.base2t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class T05PartPentalTest {

	@Test
	public void testBasePart() {
		for (T05PartPental value:T05PartPental.values()) {
			Assertions.assertNotNull(value.getIdentifierTone());
			Assertions.assertNotNull(value.getIdentifierLetter());
			Assertions.assertNotNull(value.getChinaKey());
			Assertions.assertNotNull(value.getChinaValue());
		}
	}
	
	@Test
	public void testToneMap() {
		Assertions.assertEquals(T05PartPental.PART_1, T05PartPental.PART_1.staticValueOfTone("˥"));
		Assertions.assertEquals(T05PartPental.PART_2, T05PartPental.PART_1.staticValueOfTone("˦"));
		Assertions.assertEquals(T05PartPental.PART_3, T05PartPental.PART_1.staticValueOfTone("˧"));
		Assertions.assertEquals(T05PartPental.PART_4, T05PartPental.PART_1.staticValueOfTone("˨"));
		Assertions.assertEquals(T05PartPental.PART_5, T05PartPental.PART_1.staticValueOfTone("˩"));
	}
	
	@Test
	public void testChinaMap() {
		Assertions.assertEquals(T05PartPental.PART_1, T05PartPental.PART_1.staticValueOfChina("火"));
		Assertions.assertEquals(T05PartPental.PART_2, T05PartPental.PART_1.staticValueOfChina("水"));
		Assertions.assertEquals(T05PartPental.PART_3, T05PartPental.PART_1.staticValueOfChina("木"));
		Assertions.assertEquals(T05PartPental.PART_4, T05PartPental.PART_1.staticValueOfChina("金"));
		Assertions.assertEquals(T05PartPental.PART_5, T05PartPental.PART_1.staticValueOfChina("土"));
	}
}
