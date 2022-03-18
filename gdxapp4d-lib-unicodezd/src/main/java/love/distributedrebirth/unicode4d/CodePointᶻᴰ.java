package love.distributedrebirth.unicode4d;

import java.util.List;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.T02PartBinary;
import love.distributedrebirth.numberxd.base2t.type.V036Teger;
import love.distributedrebirth.numberxd.base2t.type.V072Tong;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public enum CodePointᶻᴰ {
	
	INSTANCE;
	
	private static final int MASK_CMD     = 0b111000000000000000;
	private static final int MASK_SIGN    = 0b000100000000000000;
	private static final int MASK_ARGU    = 0b000011111111111111;
	
	public static final int MODIFIER_STRIKE_HIGH  = 0b000000000000000001;
	public static final int MODIFIER_STRIKE_MID   = 0b000000000000000010;
	public static final int MODIFIER_STRIKE_LOW   = 0b000000000000000100;
	public static final int MODIFIER_STRIKE_UNDER = 0b000000000000001000;
	public static final int MODIFIER_ITALIC_LR    = 0b000000000000010000;
	public static final int MODIFIER_ITALIC_RL    = 0b000000000000100000;
	public static final int MODIFIER_SCRIPT_TOP   = 0b000000000001000000;
	public static final int MODIFIER_SCRIPT_SUB   = 0b000000000010000000;
	public static final int MODIFIER_ENVELOP      = 0b000000000100000000;
	
	public int getArgument(V036Teger teger, T02PartBinary part) {
		int value = teger.getValue(part).getValueNumber();
		int result = value & MASK_ARGU;
		if ((value & MASK_SIGN) != 0) {
			result |= 0xFFFFC000;
		}
		return result;
	}
	
	public void setArgument(V036Teger teger, T02PartBinary part, int number) {
		int value = teger.getValue(part).getValueNumber();
		int result = (value & MASK_CMD) + ((number >> 17) & MASK_SIGN) + (number & MASK_ARGU);
		teger.getValue(part).setValueNumber(result);
	}
	
	public int getArgumentUnicode(V036Teger teger) {
		int unicode = 0;
		unicode += teger.getValue(T02PartBinary.PART_1).getValueNumber() & MASK_ARGU+MASK_SIGN;
		unicode += (teger.getValue(T02PartBinary.PART_2).getValueNumber() & MASK_ARGU+MASK_SIGN) << 15;
		return unicode;
	}
	
	public void setArgumentUnicode(V036Teger teger, int unicode) {
		int value1 = teger.getValue(T02PartBinary.PART_1).getValueNumber();
		int value2 = teger.getValue(T02PartBinary.PART_2).getValueNumber();
		value1 = (value1 & MASK_CMD) + (unicode & MASK_ARGU+MASK_SIGN);
		value2 = (value2 & MASK_CMD) + ((unicode >> 15) & MASK_ARGU+MASK_SIGN);
		teger.getValue(T02PartBinary.PART_1).setValueNumber(value1);
		teger.getValue(T02PartBinary.PART_2).setValueNumber(value2);
	}
	
	public CodePointCommandᶻᴰ getCommand(V036Teger teger) {
		int mode = 0;
		mode += (teger.getValue(T02PartBinary.PART_1).getValueNumber() >> 15) << 0;
		mode += (teger.getValue(T02PartBinary.PART_2).getValueNumber() >> 15) << 3;
		return CodePointCommandᶻᴰ.values()[mode];
	}
	
	public void setCommand(V036Teger teger, CodePointCommandᶻᴰ command) {
		int mode = command.ordinal();
		int value1 = teger.getValue(T02PartBinary.PART_1).getValueNumber();
		int value2 = teger.getValue(T02PartBinary.PART_2).getValueNumber();
		teger.getValue(T02PartBinary.PART_1).setValueNumber(value1 | (((mode >> 0) << 15)) & MASK_CMD);
		teger.getValue(T02PartBinary.PART_2).setValueNumber(value2 | (((mode >> 3) << 15)) & MASK_CMD);
	}
	
	public int searchUnicode(List<V072Tong> tongs) {
		for (V072Tong tong:tongs) {
			if (CodePointCommandᶻᴰ.UNICODE.equals(CodePointᶻᴰ.INSTANCE.getCommand(tong.getValue(T02PartBinary.PART_1)))) {
				return CodePointᶻᴰ.INSTANCE.getArgumentUnicode(tong.getValue(T02PartBinary.PART_1));
			}
			if (CodePointCommandᶻᴰ.UNICODE.equals(CodePointᶻᴰ.INSTANCE.getCommand(tong.getValue(T02PartBinary.PART_2)))) {
				return CodePointᶻᴰ.INSTANCE.getArgumentUnicode(tong.getValue(T02PartBinary.PART_2));
			}
		}
		return -1;
	}
	
	public int searchNumber(List<V072Tong> tongs) {
		for (V072Tong tong:tongs) {
			if (CodePointCommandᶻᴰ.NUMBER.equals(CodePointᶻᴰ.INSTANCE.getCommand(tong.getValue(T02PartBinary.PART_1)))) {
				return CodePointᶻᴰ.INSTANCE.getArgumentUnicode(tong.getValue(T02PartBinary.PART_1));
			}
			if (CodePointCommandᶻᴰ.NUMBER.equals(CodePointᶻᴰ.INSTANCE.getCommand(tong.getValue(T02PartBinary.PART_2)))) {
				return CodePointᶻᴰ.INSTANCE.getArgumentUnicode(tong.getValue(T02PartBinary.PART_2));
			}
		}
		return -1;
	}
}
