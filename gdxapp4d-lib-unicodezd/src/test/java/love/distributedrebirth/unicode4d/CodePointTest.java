package love.distributedrebirth.unicode4d;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.T02PartBinary;
import love.distributedrebirth.numberxd.base2t.type.V036Teger;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class CodePointTest {
	
	@Test
	public void testCommand() {
		V036Teger teger = new V036Teger();
		CodePointᶻᴰ.INSTANCE.setArgument(teger, T02PartBinary.PART_1, 0);
		CodePointᶻᴰ.INSTANCE.setArgument(teger, T02PartBinary.PART_2, 12345);
		for (CodePointCommandᶻᴰ cmd:CodePointCommandᶻᴰ.values()) {
			CodePointᶻᴰ.INSTANCE.setCommand(teger, cmd);
			int value1 = CodePointᶻᴰ.INSTANCE.getArgument(teger, T02PartBinary.PART_1);
			int value2 = CodePointᶻᴰ.INSTANCE.getArgument(teger, T02PartBinary.PART_2);
			Assertions.assertEquals(0, value1);
			Assertions.assertEquals(12345, value2);
		}
	}
	
	@Test
	public void testNegativeArguments() {
		V036Teger teger = new V036Teger();
		for (int i=-16384;i<16384;i++) {
			for (CodePointCommandᶻᴰ cmd:CodePointCommandᶻᴰ.values()) {
				CodePointᶻᴰ.INSTANCE.setArgument(teger, T02PartBinary.PART_1, i);
				CodePointᶻᴰ.INSTANCE.setArgument(teger, T02PartBinary.PART_2, i);
				CodePointᶻᴰ.INSTANCE.setCommand(teger, cmd);
				int value1 = CodePointᶻᴰ.INSTANCE.getArgument(teger, T02PartBinary.PART_1);
				int value2 = CodePointᶻᴰ.INSTANCE.getArgument(teger, T02PartBinary.PART_2);
				Assertions.assertEquals(i, value1);
				Assertions.assertEquals(i, value2);
			}
		}
	}
	
	@Test
	public void testUnicode() {
		V036Teger teger = new V036Teger();
		for (int i=0;i<244000;i++) {
			for (CodePointCommandᶻᴰ cmd:CodePointCommandᶻᴰ.values()) {
				CodePointᶻᴰ.INSTANCE.setArgumentUnicode(teger, i);
				CodePointᶻᴰ.INSTANCE.setCommand(teger, cmd);
				int value = CodePointᶻᴰ.INSTANCE.getArgumentUnicode(teger);
				Assertions.assertEquals(i, value);
			}
		}
	}
}
