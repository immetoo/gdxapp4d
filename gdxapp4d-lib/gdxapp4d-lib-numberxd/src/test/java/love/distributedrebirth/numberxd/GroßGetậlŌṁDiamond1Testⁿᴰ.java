package love.distributedrebirth.numberxd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class GroßGetậlŌṁDiamond1Testⁿᴰ {

	@Test
	public void testClone() {
		
		GroßGetậlŌṁDiamond1ⁿᴰ getal = new GroßGetậlŌṁDiamond1ⁿᴰ(1);
		GroßGetậlŌṁDiamond1ⁿᴰ getalClone = getal.toClone();
		
		Assertions.assertNotNull(getal);
		Assertions.assertNotNull(getalClone);
		
		System.out.println("getal: "+getal);
		System.out.println("getal.m0L: "+getal.getMatrix1Length());
		System.out.println("getal.m1L: "+getal.getMatrix2Length());
		
		GroßGetậlŌṁDiamond1ⁿᴰ getal2 = new GroßGetậlŌṁDiamond1ⁿᴰ(2);
		GroßGetậlŌṁDiamond1ⁿᴰ getal3 = new GroßGetậlŌṁDiamond1ⁿᴰ(3);
		GroßGetậlŌṁDiamond1ⁿᴰ getal4 = new GroßGetậlŌṁDiamond1ⁿᴰ(4);
		GroßGetậlŌṁDiamond1ⁿᴰ getal5 = new GroßGetậlŌṁDiamond1ⁿᴰ(5).toClone();
		
		System.out.println("getal5: "+getal5);
		System.out.println("getal5.m0L: "+getal5.getMatrix1Length());
		System.out.println("getal5.m1L: "+getal5.getMatrix2Length());
	}
}
