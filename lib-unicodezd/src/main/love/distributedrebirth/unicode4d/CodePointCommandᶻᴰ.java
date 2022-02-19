package love.distributedrebirth.unicode4d;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public enum CodePointCommandᶻᴰ {
	NOP,
	START, // PART_1 = modifier, PART_2 = direction
	UNICODE,
	NUMBER,
	ADVANCE,
	XY_MIN,
	XY_MAX,
	XY_COLOR, // PART_1 = 64 colors, PART_2 = 5 contrast levels
	XY_ON_CURVE_START, 
	XY_OFF_CURVE_START,
	XY_ON_CURVE,
	XY_OFF_CURVE,
	XY_SPACE
}
