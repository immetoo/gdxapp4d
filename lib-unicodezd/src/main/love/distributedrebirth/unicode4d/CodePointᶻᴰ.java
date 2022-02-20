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
	private static final int MASK_ARGU    = 0b000111111111111111;
	
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
		return teger.getValue(part).getValueNumber() & MASK_ARGU;
	}
	
	public void setArgument(V036Teger teger, T02PartBinary part, int number) {
		int value = teger.getValue(part).getValueNumber();
		teger.getValue(part).setValueNumber((value & MASK_CMD) + (number & MASK_ARGU));
	}
	
	public int getArgumentUnicode(V036Teger teger) {
		int unicode = 0;
		unicode += teger.getValue(T02PartBinary.PART_1).getValueNumber();
		unicode += teger.getValue(T02PartBinary.PART_2).getValueNumber() << 18;
		return unicode;
	}
	
	public void setArgumentUnicode(V036Teger teger, int unicode) {
		teger.getValue(T02PartBinary.PART_1).setValueNumber(unicode);
		teger.getValue(T02PartBinary.PART_2).setValueNumber(unicode >> 18);
	}
	
	public long getArgumentNumber(V036Teger teger) {
		return teger.getValueNumber();
	}
	
	public void setArgumentNumber(V036Teger teger, long number) {
		teger.setValueNumber(number);
	}
	
	public CodePointCommandᶻᴰ getCommand(V036Teger teger) {
		int mode = 0;
		mode += ((teger.getValue(T02PartBinary.PART_1).getValueNumber() >> 15) & 0b111) << 0;
		mode += ((teger.getValue(T02PartBinary.PART_2).getValueNumber() >> 15) & 0b111) << 3;
		return CodePointCommandᶻᴰ.values()[mode];
	}
	
	public void setCommand(V036Teger teger, CodePointCommandᶻᴰ command) {
		int mode = command.ordinal();
		int value1 = teger.getValue(T02PartBinary.PART_1).getValueNumber();
		int value2 = teger.getValue(T02PartBinary.PART_2).getValueNumber();
		teger.getValue(T02PartBinary.PART_1).setValueNumber((value1 & MASK_ARGU) + (((mode >> 0) & 0b111) << 15));
		teger.getValue(T02PartBinary.PART_2).setValueNumber((value2 & MASK_ARGU) + (((mode >> 3) & 0b111) << 15));
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
