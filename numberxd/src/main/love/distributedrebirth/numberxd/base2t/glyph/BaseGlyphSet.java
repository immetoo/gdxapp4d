package love.distributedrebirth.numberxd.base2t.glyph;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnClassInfoʸᴰ(name = "BaseGlyphSet", purpose = "The encoded base scripts.")
public enum BaseGlyphSet implements BãßBȍőnGlyphSetʸᴰ<BaseGlyphSet> {

	// TODO: ImGui add font for SINHALA
	// TODO: ImGui add font for TONE_LETTER missing plane 1,2,3
	// TODO: ImGui add font for BURMESE
	// TODO: ImGui add font for ARABIC
	
	BURMESE(new BaseGlyphSetNumber10("\u1040","\u1041","\u1042","\u1043","\u1044","\u1045","\u1046","\u1047","\u1048","\u1049")),
	BENGALI(new BaseGlyphSetNumber10("০","১","২","৩","৪","৫","৬","৭","৮","৯")),
	SINHALA(new BaseGlyphSetNumber10("෦","෧","෨","෩","෪","෫","෬","෭","෮","෯")),
	
	CHINA_FINANCIAL_T(new BaseGlyphSetNumber10("零","壹","貳","參","肆","伍","陸","柒","捌","玖")),
	CHINA_FINANCIAL_S(new BaseGlyphSetNumber10("零","壹","贰","叁","肆","伍","陆","柒","捌","玖")),
	CHINA_NORMAL_T(new BaseGlyphSetNumber10("零","一","二","三","四","五","六","七","八","九")),
	CHINA_NORMAL_S(new BaseGlyphSetNumber10("〇","一","二","三","四","五","六","七","八","九"),
			new BaseGlyphSetNumber16("氫","氦","鋰","鈹","硼","碳","氮","氧","氟","氖","鈉","鎂","鋁","矽","磷","硫")),
	
	LATIN_DTMF(new BaseGlyphSetNumber10("zero","one","two","three","four","five","six","seven","eight","nine").withSeperator(" "),
			new BaseGlyphSetNumber16("1","2","3","A","4","5","6","B","7","8","9","C","*","0","#","D")),
	LATIN_SUPER(new BaseGlyphSetNumber10("⁰","¹","²","³","⁴","⁵","⁶","⁷","⁸","⁹"),
			new BaseGlyphSetNumber16("⁰","¹","²","³","⁴","⁵","⁶","⁷","⁸","⁹","ᵃ","ᵇ","ᶜ","ᵈ","ᵉ","ᶠ")),
	LATIN_SUB(new BaseGlyphSetNumber10("₀","₁","₂","₃","₄","₅","₆","₇","₈","₉"),
			new BaseGlyphSetNumber16("₀","₁","₂","₃","₄","₅","₆","₇","₈","₉","ₐ","₆","꜀","ₔ","ₑ","բ")),
	LATIN_BASIC(new BaseGlyphSetNumber10("0","1","2","3","4","5","6","7","8","9"),
			new BaseGlyphSetNumber16("0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"),
			new BaseGlyphSetNumber36("1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R")),
	
	TONE_LETTER(new BaseGlyphSetNumber10("˥","˦","˧","˨","˩","꜒","꜓","꜔","꜕","꜖"),
			new BaseGlyphSetNumber16("˧˥˩","˧˩˥","˧˥˦","˧˩˨","˧˦˦","˧˨˨","˧˥˥","˧˩˩","˥˩˧","˩˥˧","˥˦˧","˩˨˧","˦˦˧","˨˨˧","˥˥˧","˩˩˧").withSecondCharGlyphSet(BaseGlyphSet.LATIN_SUPER),
			new BaseGlyphSetNumber36("꜊꜈","꜊꜉","꜊꜋","꜊꜌","꜊꜍","꜊꜎","꜊꜏","꜊꜐","꜊꜑","˧˥","˧˦","˧˨","˧˩","˧꜒","˧꜓","˧꜔","˧꜕","˧꜖","꜏˥","꜏˦","꜏˧","꜏˨","꜏˩","꜏꜍","꜏꜎","꜏꜐","꜏꜑")),
	
	GREEK(new BaseGlyphSetNumber10("ō","α","β","γ","δ","ε","ϝ","ζ","η","θ"),
			new BaseGlyphSetNumber16("ō","α","β","γ","δ","ε","ϝ","ζ","η","θ","ι","κ","λ","μ","ν","ξ"),
			new BaseGlyphSetNumber36("α","β","γ","δ","ε","ϝ","ζ","η","θ","ι","κ","λ","μ","ν","ξ","ο","π","ϟ","ρ","σ","τ","υ","φ","χ","ψ","ω","ϡ")),
	
	KOREAN(new BaseGlyphSetNumber10("영","일","이","삼","사","오","육","칠","팔","구"),
			new BaseGlyphSetNumber16("ㅏ","ㅐ","ㅑ","ㅒ","ㅓ","ㅔ","ㅕ","ㅖ","ㅗ","ㅘ","ㅙ","ㅚ","ㅛ","ㅜ","ㅝ","ㅞ"),
			new BaseGlyphSetNumber36("ㄱ","ㄲ","ㄴ","ㄷ","ㄸ","ㄹ","ㅁ","ㅂ","ㅃ","ㅅ","ㅆ","ㅈ","ㅉ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ","ㄵ","ㄶ","ㄺ","ㄻ","ㄼ","ㄽ","ㄾ","ㄿ","ㅀ")),
	
	HEBREW(new BaseGlyphSetNumber10("אֶפֶס","אֶחָד","שְׁתַּיִם","שְׁלֹשָׁה","אַרְבַּע‎","חֲמִשָּׁה‎","שֵׁשׁ‎","שִׁבְעָה","שְׁמוֹנֶה","תִּשְׁעָה‎").withSeperator(" "),
			new BaseGlyphSetNumber36("א","ב","ג","ד","ה","ו","ז","ח","ט","י","כ","ל","מ","נ","ס ","ע","פ","צ","ק","ר","ש","ת","ך","ם","ן","ף","ץ")),
	ARABIC(new BaseGlyphSetNumber10("٠","١","٢","٣","٤","٥","٦","٧","٨","٩"),
			new BaseGlyphSetNumber36("ا","ب","ج","د","ه","و","ز","ح","ط","ي","ك","ل","م","ن","س","ع","ف","ص","ق","ر","ش","ت","ث","خ","ذ","ض","ظ")),
	;
	
	private final BãßBȍőnCoffinOpenʸᴰ<BãßBȍőnGlyphSetKeyʸᴰ> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<BãßBȍőnGlyphSetKeyʸᴰ> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };

	private BaseGlyphSet(BaseGlyphSetNumber10 numbers) {
		BBC.PUT_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.NUMBERS, numbers);
	}
	
	private BaseGlyphSet(BaseGlyphSetNumber10 numbers, BaseGlyphSetNumber36 gematria) {
		BBC.PUT_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.NUMBERS, numbers);
		BBC.PUT_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.GEMATRIA, gematria);
	}

	private BaseGlyphSet(BaseGlyphSetNumber10 numbers, BaseGlyphSetNumber16 hex) {
		BBC.PUT_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.NUMBERS, numbers);
		BBC.PUT_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.HEXIMALS, hex);
	}
	
	private BaseGlyphSet(BaseGlyphSetNumber10 numbers, BaseGlyphSetNumber16 hex, BaseGlyphSetNumber36 gematria) {
		BBC.PUT_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.NUMBERS, numbers);
		BBC.PUT_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.HEXIMALS, hex);
		BBC.PUT_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.GEMATRIA, gematria);
	}
}
