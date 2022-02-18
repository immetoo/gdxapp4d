package love.distributedrebirth.unicode4d;

import love.distributedrebirth.numberxd.base2t.type.V072Tong;

public class CodePointᶻᴰ {

	private final V072Tong value;
	
	public CodePointᶻᴰ(V072Tong value) {
		this.value = value;
	}
	
	enum TegerSplitMode {
		NOP,
		UNICODE, // + direction
		ADVANCE,
		XY_SET,
		
		XY_MIN,
		XY_MAX,
		NUMBER,
		MOD_COLOR, // color = 4b+2b + mod 2x2b darker
		// MODIFIER;
		// STRIKE_HIGH,
		// STRIKE_MID,
		// STRIKE_LOW,
		// STRIKE_UNDER,
		// ITALIC_LR,
		// ITALIC_RL,
		// SCRIPT_TOP,
		// SCRIPT_SUB,
		// INVISIBLE
		
		FREE_B4, // envelop
		FREE_B3,
		FREE_B2,
		FREE_B1,
		
		FREE_A4,
		FREE_A3,
		FREE_A2,
		FREE_A1,
	}
	
	/**
	 * 72 bits (8x tyte)
	 * 
	 * 
	 * V036Teger is point: x+y of 4 digits + sign + boolean 
	 * x=2xtyte=tord=18bit
	 * y=tord-3=15b + mode
	 * 
	 * V072Tong - 0
	 * cmd0 unicode="011000"
	 * cmd1 advanceWidth="183" leftSideBearing="10"
	 * 
	 * V072Tong - 1
	 * cmd0 xMin="10"  yMin="480"
	 * cmd1 xMax="134" yMax="616"
	 * 
	 * V072Tong - 2
	 * cmd0 x="10" y="548" onCurve="true" start
	 * cmd1 color select
	 * 
	 * V072Tong - 3
	 * cmd0 x="10" y="548" onCurve="true" end
	 * cmd1 nop padding.
	 */
}
