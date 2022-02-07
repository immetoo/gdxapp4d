package love.distributedrebirth.numberxd.glyph;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnConstantsʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnPackageInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.T10PartDecimal;
import love.distributedrebirth.numberxd.base2t.part.T16PartHex;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnClassInfoʸᴰ(name = "BaseGlyphSet", purpose = "The encoded base scripts.")
@BãßBȍőnPackageInfoʸᴰ(name = "love.distributedrebirth.numberxd")
public enum BaseGlyphSet implements BãßBȍőnGlyphSetʸᴰ<BaseGlyphSet> {

	// TODO: ImGui add font for SINHALA
	// TODO: ImGui add font for ARABIC
	
	LATIN_DTMF(new BaseGlyphSetNumber(v -> T10PartDecimal.PART_1.BãßVoorElk(x -> v.add(x.BȍőnChinaValue()))).withSeperator(BãßBȍőnConstantsʸᴰ.STR_SPACE),
			new BaseGlyphSetNumber("1","2","3","A","4","5","6","B","7","8","9","C","*","0","#","D"),
			null),
	LATIN_BASIC(new BaseGlyphSetNumber(v -> T10PartDecimal.PART_1.BãßVoorElk(x -> v.add(Integer.toString(x.BȍőnRangTelNul())))),
			new BaseGlyphSetNumber(v -> T16PartHex.PART_1.BãßVoorElk(x -> v.add(x.BȍőnAlt1Value()))),
			new BaseGlyphSetNumber("1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R")),
	LATIN_TOP16(new BaseGlyphSetNumber("⁰","¹","²","³","⁴","⁵","⁶","⁷","⁸","⁹"),
			new BaseGlyphSetNumber("⁰","¹","²","³","⁴","⁵","⁶","⁷","⁸","⁹","ᵃ","ᵇ","ᶜ","ᵈ","ᵉ","ᶠ"),
			new BaseGlyphSetNumber("¹","²","³","⁴","⁵","⁶","⁷","⁸","⁹","ᵃ","ᵇ","ᶜ","ᵈ","ᵉ","ᶠ","ᴳ","ᴴ","ᴵ","ᴶ","ᴷ","ᴸ","ᴹ","ᴺ","ᴼ","ᴾ","Q","ᴿ")),
	LATIN_SUB16(new BaseGlyphSetNumber("₀","₁","₂","₃","₄","₅","₆","₇","₈","₉"),
			new BaseGlyphSetNumber("₀","₁","₂","₃","₄","₅","₆","₇","₈","₉","ₐ","₆","꜀","ₔ","ₑ","բ"),
			new BaseGlyphSetNumber("₁","₂","₃","₄","₅","₆","₇","₈","₉","ₐ","₆","꜀","ₔ","ₑ","բ","G","ₕ","ᵢ","ⱼ","ₖ","ₗ","ₘ","ₙ","ₒ","ₚ","Q","ᵣ")),
	TONE_LETTER(new BaseGlyphSetNumber(v -> T10PartDecimal.PART_1.BãßVoorElk(x -> v.add(x.BȍőnDialTone()))),
			new BaseGlyphSetNumber(v -> T16PartHex.PART_1.BãßVoorElk(x -> v.add(x.BȍőnDialTone()))),
			new BaseGlyphSetNumber("꜊꜈","꜊꜉","꜊꜋","꜊꜌","꜊꜍","꜊꜎","꜊꜏","꜊꜐","꜊꜑","˧˥","˧˦","˧˨","˧˩","˧꜒","˧꜓","˧꜔","˧꜕","˧꜖","꜏˥","꜏˦","꜏˧","꜏˨","꜏˩","꜏꜍","꜏꜎","꜏꜐","꜏꜑")),
	
	DIPAVALI_TONE_LR_TOP16(new BaseGlyphSetNumber(v -> T10PartDecimal.PART_1.BãßVoorElk(x -> v.add(x.BȍőnAlt1Value()))),
			new BaseGlyphSetNumber("˧˥˩","˧˩˥","˧˥˦","˧˩˨","˧˦˦","˧˨˨","˧˥˥","˧˩˩","˥˩˧","˩˥˧","˥˦˧","˩˨˧","˦˦˧","˨˨˧","˥˥˧","˩˩˧").withAltGlyphSet(BaseGlyphSet.LATIN_TOP16),
			null),
	DIPAVALI_TONE_LR_SUB16(new BaseGlyphSetNumber(v -> T10PartDecimal.PART_1.BãßVoorElk(x -> v.add(x.BȍőnAlt1Value()))),
			new BaseGlyphSetNumber("˧˥˩","˧˩˥","˧˥˦","˧˩˨","˧˦˦","˧˨˨","˧˥˥","˧˩˩","˥˩˧","˩˥˧","˥˦˧","˩˨˧","˦˦˧","˨˨˧","˥˥˧","˩˩˧").withAltGlyphSet(BaseGlyphSet.LATIN_SUB16),
			null),
	DIPAVALI_TONE_RL_TOP16(new BaseGlyphSetNumber(v -> T10PartDecimal.PART_1.BãßVoorElk(x -> v.add(x.BȍőnAlt2Value()))),
			new BaseGlyphSetNumber("꜔꜒꜖","꜔꜖꜒","꜔꜒꜓","꜔꜖꜕","꜔꜓꜓","꜔꜕꜕","꜔꜒꜒","꜔꜖꜖","꜒꜖꜔","꜖꜒꜔","꜒꜓꜔","꜖꜕꜔","꜓꜓꜔","꜕꜕꜔","꜒꜒꜔","꜖꜖꜔").withAltGlyphSet(BaseGlyphSet.LATIN_TOP16),
			null),
	DIPAVALI_TONE_RL_SUB16(new BaseGlyphSetNumber(v -> T10PartDecimal.PART_1.BãßVoorElk(x -> v.add(x.BȍőnAlt2Value()))),
			new BaseGlyphSetNumber("꜔꜒꜖","꜔꜖꜒","꜔꜒꜓","꜔꜖꜕","꜔꜓꜓","꜔꜕꜕","꜔꜒꜒","꜔꜖꜖","꜒꜖꜔","꜖꜒꜔","꜒꜓꜔","꜖꜕꜔","꜓꜓꜔","꜕꜕꜔","꜒꜒꜔","꜖꜖꜔").withAltGlyphSet(BaseGlyphSet.LATIN_SUB16),
			null),
	
	CYRILLIC(new BaseGlyphSetNumber("⃝","А","В","Г","Д","Є","Ѕ","З","И","Ѳ"),
			new BaseGlyphSetNumber("⃝","А","В","Г","Д","Є","Ѕ","З","И","Ѳ","҂"," ҈"," ҉"," ꙰"," ꙱"," ꙲"),
			new BaseGlyphSetNumber("А","В","Г","Д","Є","Ѕ","З","И","Ѳ","І","К","Л","М","Н","Ѯ","Ѻ","П","Ч","Р","С","Т","Ѵ","Ф","Х","Ѱ","Ѿ","Ц")),
	
	BENGALI(new BaseGlyphSetNumber("০","১","২","৩","৪","৫","৬","৭","৮","৯")),
	SINHALA(new BaseGlyphSetNumber("෦","෧","෨","෩","෪","෫","෬","෭","෮","෯")),
	CHINA_FINANCIAL_T(new BaseGlyphSetNumber(v -> T10PartDecimal.PART_1.BãßVoorElk(x -> v.add(x.BȍőnChinaKey()))),
			new BaseGlyphSetNumber(v -> T16PartHex.PART_1.BãßVoorElk(x -> v.add(x.BȍőnChinaKey()))),
			null),
	CHINA_FINANCIAL_S(new BaseGlyphSetNumber("零","壹","贰","叁","肆","伍","陆","柒","捌","玖")),
	CHINA_NORMAL_T(new BaseGlyphSetNumber("零","一","二","三","四","五","六","七","八","九")),
	CHINA_NORMAL_S(new BaseGlyphSetNumber("〇","一","二","三","四","五","六","七","八","九")),
	
	GREEK(new BaseGlyphSetNumber("ō","α","β","γ","δ","ε","ϝ","ζ","η","θ"),
			new BaseGlyphSetNumber("ō","α","β","γ","δ","ε","ϝ","ζ","η","θ","ι","κ","λ","μ","ν","ξ"),
			new BaseGlyphSetNumber("α","β","γ","δ","ε","ϝ","ζ","η","θ","ι","κ","λ","μ","ν","ξ","ο","π","ϟ","ρ","σ","τ","υ","φ","χ","ψ","ω","ϡ")),
	
	KOREAN(new BaseGlyphSetNumber("영","일","이","삼","사","오","육","칠","팔","구"),
			new BaseGlyphSetNumber("ㅏ","ㅐ","ㅑ","ㅒ","ㅓ","ㅔ","ㅕ","ㅖ","ㅗ","ㅘ","ㅙ","ㅚ","ㅛ","ㅜ","ㅝ","ㅞ"),
			new BaseGlyphSetNumber("ㄱ","ㄲ","ㄴ","ㄷ","ㄸ","ㄹ","ㅁ","ㅂ","ㅃ","ㅅ","ㅆ","ㅈ","ㅉ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ","ㄵ","ㄶ","ㄺ","ㄻ","ㄼ","ㄽ","ㄾ","ㄿ","ㅀ")),
	
	ARABIC(new BaseGlyphSetNumber("٠","١","٢","٣","٤","٥","٦","٧","٨","٩"),
			new BaseGlyphSetNumber("٠","١","٢","٣","٤","٥","٦","٧","٨","٩","ا","ب","ج","د","ه","و"),
			new BaseGlyphSetNumber("ا","ب","ج","د","ه","و","ز","ح","ط","ي","ك","ل","م","ن","س","ع","ف","ص","ق","ر","ش","ت","ث","خ","ذ","ض","ظ")),
	
	HEBREW(new BaseGlyphSetNumber("אֶפֶס","אֶחָד","שְׁתַּיִם","שְׁלֹשָׁה","אַרְבַּע‎","חֲמִשָּׁה‎","שֵׁשׁ‎","שִׁבְעָה","שְׁמוֹנֶה","תִּשְׁעָה‎").withSeperator(BãßBȍőnConstantsʸᴰ.STR_SPACE),
			new BaseGlyphSetNumber("אֶפֶס","אֶחָד","שְׁתַּיִם","שְׁלֹשָׁה","אַרְבַּע‎","חֲמִשָּׁה‎","שֵׁשׁ‎","שִׁבְעָה","שְׁמוֹנֶה","תִּשְׁעָה‎","א","ב","ג","ד","ה","ו"),
			new BaseGlyphSetNumber("א","ב","ג","ד","ה","ו","ז","ח","ט","י","כ","ל","מ","נ","ס ","ע","פ","צ","ק","ר","ש","ת","ך","ם","ן","ף","ץ")),
	;
	
	private final BãßBȍőnCoffinOpenʸᴰ<BãßBȍőnGlyphSetKeyʸᴰ> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<BãßBȍőnGlyphSetKeyʸᴰ> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };

	private BaseGlyphSet(BaseGlyphSetNumber numbers) {
		this(numbers, null, null);
	}
	
	private BaseGlyphSet(BaseGlyphSetNumber numbers, BaseGlyphSetNumber hex, BaseGlyphSetNumber gematria) {
		BBC.PUT_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.NUMBERS, numbers);
		BBC.PUT_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.HEXIMALS, hex);
		BBC.PUT_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.GEMATRIA, gematria);
		BBC.BOON_INIT(this);
		this.BȍőnJmxInit(BãßBȍőnGlyphSetKeyʸᴰ.JMX);
	}
}