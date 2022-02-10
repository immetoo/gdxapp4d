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
	
	LATIN_BASIC(new BaseGlyphSetNumber(v -> T10PartDecimal.PART_1.BãßVoorElk(x -> v.add(Integer.toString(x.BȍőnRangTelNul())))),
			new BaseGlyphSetNumber(v -> T16PartHex.PART_1.BãßVoorElk(x -> v.add(x.BȍőnAlt1Value()))),
			new BaseGlyphSetNumber("1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R")),
	LATIN_DTMF(new BaseGlyphSetNumber(v -> T10PartDecimal.PART_1.BãßVoorElk(x -> v.add(x.BȍőnChinaValue()))).withSeperator(BãßBȍőnConstantsʸᴰ.STR_SPACE),
			new BaseGlyphSetNumber("1","2","3","A","4","5","6","B","7","8","9","C","*","0","#","D"),
			LATIN_BASIC.BȍőnGlyphSetNumber36()),
	LATIN_TOP(new BaseGlyphSetNumber("⁰","¹","²","³","⁴","⁵","⁶","⁷","⁸","⁹"),
			new BaseGlyphSetNumber("⁰","¹","²","³","⁴","⁵","⁶","⁷","⁸","⁹","ᵃ","ᵇ","ᶜ","ᵈ","ᵉ","ᶠ"),
			new BaseGlyphSetNumber("¹","²","³","⁴","⁵","⁶","⁷","⁸","⁹","ᵃ","ᵇ","ᶜ","ᵈ","ᵉ","ᶠ","ᴳ","ᴴ","ᴵ","ᴶ","ᴷ","ᴸ","ᴹ","ᴺ","ᴼ","ᴾ","Q","ᴿ")),
	LATIN_SUB(new BaseGlyphSetNumber("₀","₁","₂","₃","₄","₅","₆","₇","₈","₉"),
			new BaseGlyphSetNumber("₀","₁","₂","₃","₄","₅","₆","₇","₈","₉","ₐ","₆","꜀","ₔ","ₑ","բ"),
			new BaseGlyphSetNumber("₁","₂","₃","₄","₅","₆","₇","₈","₉","ₐ","₆","꜀","ₔ","ₑ","բ","G","ₕ","ᵢ","ⱼ","ₖ","ₗ","ₘ","ₙ","ₒ","ₚ","Q","ᵣ")),
	LATIN_TOPHEX(LATIN_BASIC.BȍőnGlyphSetNumber10(),
			LATIN_BASIC.BȍőnGlyphSetNumber16().withAltGlyphSet(LATIN_TOP),
			LATIN_BASIC.BȍőnGlyphSetNumber36()),
	
	TONE_SCRIPT(new BaseGlyphSetNumber(v -> T10PartDecimal.PART_1.BãßVoorElk(x -> v.add(x.BȍőnDialTone()))),
			new BaseGlyphSetNumber(v -> T16PartHex.PART_1.BãßVoorElk(x -> v.add(x.BȍőnDialTone()))),
			new BaseGlyphSetNumber("꜊꜈","꜊꜉","꜊꜋","꜊꜌","꜊꜍","꜊꜎","꜊꜏","꜊꜐","꜊꜑","˧˥","˧˦","˧˨","˧˩","˧꜒","˧꜓","˧꜔","˧꜕","˧꜖","꜏˥","꜏˦","꜏˧","꜏˨","꜏˩","꜏꜍","꜏꜎","꜏꜐","꜏꜑")),
	DIPAVALI_LRPATH_TOPHEX(new BaseGlyphSetNumber(v -> T10PartDecimal.PART_1.BãßVoorElk(x -> v.add(x.BȍőnAlt1Value()))),
			new BaseGlyphSetNumber("˧˥˩","˧˩˥","˧˥˦","˧˩˨","˧˦˦","˧˨˨","˧˥˥","˧˩˩","˥˩˧","˩˥˧","˥˦˧","˩˨˧","˦˦˧","˨˨˧","˥˥˧","˩˩˧").withAltGlyphSet(BaseGlyphSet.LATIN_TOP),
			TONE_SCRIPT.BȍőnGlyphSetNumber36()),
	DIPAVALI_LRPATH_SUBHEX(new BaseGlyphSetNumber(v -> T10PartDecimal.PART_1.BãßVoorElk(x -> v.add(x.BȍőnAlt1Value()))),
			new BaseGlyphSetNumber("˧˥˩","˧˩˥","˧˥˦","˧˩˨","˧˦˦","˧˨˨","˧˥˥","˧˩˩","˥˩˧","˩˥˧","˥˦˧","˩˨˧","˦˦˧","˨˨˧","˥˥˧","˩˩˧").withAltGlyphSet(BaseGlyphSet.LATIN_SUB),
			TONE_SCRIPT.BȍőnGlyphSetNumber36()),
	DIPAVALI_RLPATH_TOPHEX(new BaseGlyphSetNumber(v -> T10PartDecimal.PART_1.BãßVoorElk(x -> v.add(x.BȍőnAlt2Value()))),
			new BaseGlyphSetNumber("꜔꜒꜖","꜔꜖꜒","꜔꜒꜓","꜔꜖꜕","꜔꜓꜓","꜔꜕꜕","꜔꜒꜒","꜔꜖꜖","꜒꜖꜔","꜖꜒꜔","꜒꜓꜔","꜖꜕꜔","꜓꜓꜔","꜕꜕꜔","꜒꜒꜔","꜖꜖꜔").withAltGlyphSet(BaseGlyphSet.LATIN_TOP),
			TONE_SCRIPT.BȍőnGlyphSetNumber36()),
	DIPAVALI_RLPATH_SUBHEX(new BaseGlyphSetNumber(v -> T10PartDecimal.PART_1.BãßVoorElk(x -> v.add(x.BȍőnAlt2Value()))),
			new BaseGlyphSetNumber("꜔꜒꜖","꜔꜖꜒","꜔꜒꜓","꜔꜖꜕","꜔꜓꜓","꜔꜕꜕","꜔꜒꜒","꜔꜖꜖","꜒꜖꜔","꜖꜒꜔","꜒꜓꜔","꜖꜕꜔","꜓꜓꜔","꜕꜕꜔","꜒꜒꜔","꜖꜖꜔").withAltGlyphSet(BaseGlyphSet.LATIN_SUB),
			TONE_SCRIPT.BȍőnGlyphSetNumber36()),

	GREEK(new BaseGlyphSetNumber("ō","α","β","γ","δ","ε","ϝ","ζ","η","θ"),
			LATIN_BASIC.BȍőnGlyphSetNumber16(),
			new BaseGlyphSetNumber("α","β","γ","δ","ε","ϝ","ζ","η","θ","ι","κ","λ","μ","ν","ξ","ο","π","ϟ","ρ","σ","τ","υ","φ","χ","ψ","ω","ϡ")),
	GREEK_HEX(GREEK.BȍőnGlyphSetNumber10(),
			new BaseGlyphSetNumber("ō","α","β","γ","δ","ε","ϝ","ζ","η","θ","ι","κ","λ","μ","ν","ξ"),
			GREEK.BȍőnGlyphSetNumber36()),
	CYRILLIC(new BaseGlyphSetNumber("⃝","А","В","Г","Д","Є","Ѕ","З","И","Ѳ"),
			LATIN_BASIC.BȍőnGlyphSetNumber16(),
			new BaseGlyphSetNumber("А","В","Г","Д","Є","Ѕ","З","И","Ѳ","І","К","Л","М","Н","Ѯ","Ѻ","П","Ч","Р","С","Т","Ѵ","Ф","Х","Ѱ","Ѿ","Ц")),
	CYRILLIC_HEX(CYRILLIC.BȍőnGlyphSetNumber10(),
			new BaseGlyphSetNumber("⃝","А","В","Г","Д","Є","Ѕ","З","И","Ѳ","҂"," ҈"," ҉"," ꙰"," ꙱"," ꙲"),
			CYRILLIC.BȍőnGlyphSetNumber36()),
	BENGALI(new BaseGlyphSetNumber("০","১","২","৩","৪","৫","৬","৭","৮","৯"),
			LATIN_BASIC.BȍőnGlyphSetNumber16(),
			new BaseGlyphSetNumber("ক","খ","গ","ঘ","ঙ","চ","ছ","জ","ঝ","ঞ","ট","ঠ","ড","ঢ","ণ","ত","থ","দ","ধ","ন","প","ফ","ব","ভ","ম","য","র")),
	BENGALI_HEX(BENGALI.BȍőnGlyphSetNumber10(),
			new BaseGlyphSetNumber("০","১","২","৩","৪","৫","৬","৭","৮","৯","জ্ঞ","ক্ষ","হ","স","ষ","শ"),
			BENGALI.BȍőnGlyphSetNumber36()),
	
	RUNIC(new BaseGlyphSetNumber("ᛰ","ᚠ","ᚢ","ᚦ","ᚬ","ᚱ","ᚴ","ᚼ","ᚾ","ᛁ"),
			LATIN_BASIC.BȍőnGlyphSetNumber16(),
			new BaseGlyphSetNumber("ᚠ","ᚢ","ᚦ","ᚨ","ᚱ","ᚲ","ᚷ","ᚹ","ᚺ","ᚾ","ᛁ","ᛃ","ᛇ","ᛈ","ᛉ","ᛊ","ᛏ","ᛒ","ᛖ","ᛗ","ᛚ","ᛜ","ᛟ","ᛞ","ᚡ","ᚤ","ᚧ")),
	RUNIC_HEX(RUNIC.BȍőnGlyphSetNumber10(),
			new BaseGlyphSetNumber("ᛰ","ᚠ","ᚢ","ᚦ","ᚬ","ᚱ","ᚴ","ᚼ","ᚾ","ᛁ","ᛅ","ᛋ","ᛏ","ᛒ","ᛚ","ᛘ"),
			RUNIC.BȍőnGlyphSetNumber36()),
	RUNIC_TOPHEX(RUNIC_HEX.BȍőnGlyphSetNumber10(),
			RUNIC_HEX.BȍőnGlyphSetNumber16().withAltGlyphSet(LATIN_TOP),
			RUNIC_HEX.BȍőnGlyphSetNumber36()),
	KOREAN(new BaseGlyphSetNumber("영","일","이","삼","사","오","육","칠","팔","구"),
			LATIN_BASIC.BȍőnGlyphSetNumber16(),
			new BaseGlyphSetNumber("ㄱ","ㄲ","ㄴ","ㄷ","ㄸ","ㄹ","ㅁ","ㅂ","ㅃ","ㅅ","ㅆ","ㅈ","ㅉ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ","ㄵ","ㄶ","ㄺ","ㄻ","ㄼ","ㄽ","ㄾ","ㄿ","ㅀ")),
	KOREAN_HEX(KOREAN.BȍőnGlyphSetNumber10(),
			new BaseGlyphSetNumber("ㅏ","ㅐ","ㅑ","ㅒ","ㅓ","ㅔ","ㅕ","ㅖ","ㅗ","ㅘ","ㅙ","ㅚ","ㅛ","ㅜ","ㅝ","ㅞ"),
			KOREAN.BȍőnGlyphSetNumber36()),
	KOREAN_TOPHEX(KOREAN_HEX.BȍőnGlyphSetNumber10(),
			KOREAN_HEX.BȍőnGlyphSetNumber16().withAltGlyphSet(LATIN_TOP),
			KOREAN_HEX.BȍőnGlyphSetNumber36()),
	
	CHINA_FINANCIAL_T(new BaseGlyphSetNumber(v -> T10PartDecimal.PART_1.BãßVoorElk(x -> v.add(x.BȍőnChinaKey()))), LATIN_BASIC.BȍőnGlyphSetNumber16(), null),
	CHINA_FINANCIAL_S(new BaseGlyphSetNumber("零","壹","贰","叁","肆","伍","陆","柒","捌","玖"), LATIN_BASIC.BȍőnGlyphSetNumber16(), null),
	CHINA_NORMAL_T(new BaseGlyphSetNumber("零","一","二","三","四","五","六","七","八","九"), LATIN_BASIC.BȍőnGlyphSetNumber16(), null),
	CHINA_NORMAL_S(new BaseGlyphSetNumber("〇","一","二","三","四","五","六","七","八","九"), LATIN_BASIC.BȍőnGlyphSetNumber16(), null),
	
	ARABIC(new BaseGlyphSetNumber("٠","١","٢","٣","٤","٥","٦","٧","٨","٩"),
			LATIN_BASIC.BȍőnGlyphSetNumber16(),
			new BaseGlyphSetNumber("ا","ب","ج","د","ه","و","ز","ح","ط","ي","ك","ل","م","ن","س","ع","ف","ص","ق","ر","ش","ت","ث","خ","ذ","ض","ظ")),
	HEBREW(new BaseGlyphSetNumber("אֶפֶס","אֶחָד","שְׁתַּיִם","שְׁלֹשָׁה","אַרְבַּע‎","חֲמִשָּׁה‎","שֵׁשׁ‎","שִׁבְעָה","שְׁמוֹנֶה","תִּשְׁעָה‎").withSeperator(BãßBȍőnConstantsʸᴰ.STR_SPACE),
			LATIN_BASIC.BȍőnGlyphSetNumber16(),
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
	
	public String BȍőnConvertTo(String numbers) {
		StringBuilder buf = new StringBuilder();
		for (char c:numbers.toCharArray()) {
			for (BaseGlyphSet set:values()) {
				int loc = set.BȍőnGlyphSetNumber10().BȍőnIndexOf(""+c);
				if (loc != -1) {
					buf.append(set.BȍőnGlyphSetNumber10().BȍőnCharFor(loc));
				}
			}
		}
		return buf.toString();
	}
}
