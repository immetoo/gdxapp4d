package love.distributedrebirth.unicode4d;

import love.distributedrebirth.numberxd.base2t.type.V072Tong;

public class CodePointᶻᴰ {

	private final V072Tong value;
	
	public CodePointᶻᴰ(V072Tong value) {
		this.value = value;
	}
	
	/**
	 * 72 bits (8x tyte)
	 * 
	 * 
	 * point: x+y of 4 digits + sign + boolean 
	 * x=2xtyte=tord=18bit
	 * y=tord-3=14b + sign + boolean + seq/end + mode
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
