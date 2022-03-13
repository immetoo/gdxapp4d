package love.distributedrebirth.numberxd.base2t;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.T02PartBinary;
import love.distributedrebirth.numberxd.base2t.type.V072Tong;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class Base2TerminatorTest {

	@Test
	public void testBytes() throws IOException {
		V072Tong tong = new V072Tong();
		tong.getValue(T02PartBinary.PART_1).setValueNumber(123456000);
		tong.getValue(T02PartBinary.PART_2).setValueNumber(234567000);
		
		List<V072Tong> tongs = new ArrayList<>();
		tongs.add(tong);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Base2Terminator.INSTANCE.Bãß2WriteTong(tongs, baos);
		byte[] data = baos.toByteArray();
		
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		List<V072Tong> result = new ArrayList<>();
		Base2Terminator.INSTANCE.Bãß2ReadTong(bais, result);
		
		V072Tong tong2 = result.get(0);
		Assertions.assertNotNull(tong2);
		
		Assertions.assertEquals(123456000L, tong.getValue(T02PartBinary.PART_1).getValueNumber());
		Assertions.assertEquals(234567000L, tong.getValue(T02PartBinary.PART_2).getValueNumber());
	}
	
}
