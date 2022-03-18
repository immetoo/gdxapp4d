package love.distributedrebirth.numberxd.base2t.type;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class V018TordTest {

	@Test
	public void testSetValue() {
		V018Tord tord = new V018Tord();
		for (int i=0;i<262144;i++) {
			tord.setValueNumber(i);
			int value = tord.getValueNumber();
			Assertions.assertEquals(i, value);
		}
	}
}
