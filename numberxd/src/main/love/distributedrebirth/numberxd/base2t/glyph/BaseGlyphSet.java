package love.distributedrebirth.numberxd.base2t.glyph;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnClassInfoʸᴰ(name = "BaseScript", purpose = "The encoded base scripts.")
public enum BaseGlyphSet implements BãßBȍőnGlyphSetʸᴰ<BaseGlyphSet> {

	BURMESE(new BaseGlyphSetDecimals("\u1040","\u1041","\u1042","\u1043","\u1044","\u1045","\u1046","\u1047","\u1048","\u1049")),
	BENGALI(new BaseGlyphSetDecimals("০","১","২","৩","৪","৫","৬","৭","৮","৯")),
	SINHALA(new BaseGlyphSetDecimals("෦","෧","෨","෩","෪","෫","෬","෭","෮","෯")),

	GREEK(new BaseGlyphSetDecimals("ō","α","β","γ","δ","ε","ϝ","ζ","η","θ"),
			new BaseGlyphSetHeximals("ō","α","β","γ","δ","ε","ϝ","ζ","η","θ","ι","κ","λ","μ","ν","ξ"),
			new BaseGlyphSetGematria("α","β","γ","δ","ε","ϝ","ζ","η","θ","ι","κ","λ","μ","ν","ξ","ο","π","ϟ","ρ","σ","τ","υ","φ","χ","ψ","ω","ϡ")),
	
	LATIN_BASIC(new BaseGlyphSetDecimals("0","1","2","3","4","5","6","7","8","9"),
			new BaseGlyphSetHeximals("0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"),
			new BaseGlyphSetGematria("1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R")),
	LATIN_DTMF(new BaseGlyphSetDecimals("zero","one","two","three","four","five","six","seven","eight","nine"),
			new BaseGlyphSetHeximals("1","2","3","A","4","5","6","B","7","8","9","C","*","0","#","D")),
	LATIN_SUPER(new BaseGlyphSetDecimals("⁰","¹","²","³","⁴","⁵","⁶","⁷","⁸","⁹"),
			new BaseGlyphSetHeximals("⁰","¹","²","³","⁴","⁵","⁶","⁷","⁸","⁹","ᵃ","ᵇ","ᶜ","ᵈ","ᵉ","ᶠ")),
	LATIN_SUB(new BaseGlyphSetDecimals("₀","₁","₂","₃","₄","₅","₆","₇","₈","₉"),
			new BaseGlyphSetHeximals("₀","₁","₂","₃","₄","₅","₆","₇","₈","₉","ₐ","₆","꜀","ₔ","ₑ","բ")),
	
	KOREAN(new BaseGlyphSetDecimals("영","일","이","삼","사","오","육","칠","팔","구"),
			new BaseGlyphSetHeximals("ㅏ","ㅐ","ㅑ","ㅒ","ㅓ","ㅔ","ㅕ","ㅖ","ㅗ","ㅘ","ㅙ","ㅚ","ㅛ","ㅜ","ㅝ","ㅞ")),
	
	HEBREW(new BaseGlyphSetDecimals("אֶפֶס","אֶחָד","שְׁתַּיִם","שְׁלֹשָׁה","אַרְבַּע‎","חֲמִשָּׁה‎","שֵׁשׁ‎","שִׁבְעָה","שְׁמוֹנֶה","תִּשְׁעָה‎"),
			new BaseGlyphSetGematria("א","ב","ג","ד","ה","ו","ז","ח","ט","י","כ","ל","מ","נ","ס ","ע","פ","צ","ק","ר","ש","ת","ך","ם","ן","ף","ץ")),
	
	ARABIC(new BaseGlyphSetDecimals("٠","١","٢","٣","٤","٥","٦","٧","٨","٩"),
			new BaseGlyphSetGematria("ا","ب","ج","د","ه","و","ز","ح","ط","ي","ك","ل","م","ن","س","ع","ف","ص","ق","ر","ش","ت","ث","خ","ذ","ض","ظ")),
	;
	
	private final BãßBȍőnCoffinOpenʸᴰ<BãßBȍőnGlyphSetKeyʸᴰ> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<BãßBȍőnGlyphSetKeyʸᴰ> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };

	private BaseGlyphSet(BaseGlyphSetDecimals numbers) {
		BBC.PUT_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.NUMBERS, numbers);
	}
	
	private BaseGlyphSet(BaseGlyphSetDecimals numbers, BaseGlyphSetGematria gematria) {
		BBC.PUT_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.NUMBERS, numbers);
		BBC.PUT_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.GEMATRIA, gematria);
	}

	private BaseGlyphSet(BaseGlyphSetDecimals numbers, BaseGlyphSetHeximals hex) {
		BBC.PUT_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.NUMBERS, numbers);
		BBC.PUT_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.HEXIMALS, hex);
	}
	
	private BaseGlyphSet(BaseGlyphSetDecimals numbers, BaseGlyphSetHeximals hex, BaseGlyphSetGematria gematria) {
		BBC.PUT_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.NUMBERS, numbers);
		BBC.PUT_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.HEXIMALS, hex);
		BBC.PUT_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.GEMATRIA, gematria);
	}
}
