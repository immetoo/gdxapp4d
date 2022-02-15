package love.distributedrebirth.numberxd.glyph;

import java.text.DecimalFormat;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnConstantsʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnPackageInfoʸᴰ;
import love.distributedrebirth.bassboonyd.jmx.DefaultEnumSetᴶᴹˣ;
import love.distributedrebirth.bassboonyd.jmx.GuageCounterᴶᴹˣ;
import love.distributedrebirth.numberxd.base2t.part.T10PartDecimal;
import love.distributedrebirth.numberxd.base2t.part.T16PartHex;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnClassInfoʸᴰ(name = "BaseGlyphSet", purpose = "The encoded base scripts.")
@BãßBȍőnPackageInfoʸᴰ(name = "love.distributedrebirth.numberxd")
public enum BaseGlyphSet implements DefaultEnumSetᴶᴹˣ<BaseGlyphSet,BãßBȍőnGlyphSetKeyʸᴰ> {
	
	LATIN_BASIC(
			new BaseGlyphSetNumber(v -> T10PartDecimal.PART_1.BãßVoorElk(x -> v.add(Integer.toString(x.BȍőnRangTelNul())))),
			new BaseGlyphSetNumber(v -> T16PartHex.PART_1.BãßVoorElk(x -> v.add(x.BȍőnAlt1Value()))),
			new BaseGlyphSetNumber("1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R")),
	LATIN_DTMF(
			new BaseGlyphSetNumber(v -> T10PartDecimal.PART_1.BãßVoorElk(x -> v.add(x.BȍőnChinaValue()))).withSeperator(BãßBȍőnConstantsʸᴰ.STR_SPACE),
			new BaseGlyphSetNumber("1","2","3","A","4","5","6","B","7","8","9","C","*","0","#","D"),
			null),
	LATIN_TOP(
			new BaseGlyphSetNumber("⁰","¹","²","³","⁴","⁵","⁶","⁷","⁸","⁹"),
			new BaseGlyphSetNumber("⁰","¹","²","³","⁴","⁵","⁶","⁷","⁸","⁹","ᵃ","ᵇ","ᶜ","ᵈ","ᵉ","ᶠ"),
			new BaseGlyphSetNumber("¹","²","³","⁴","⁵","⁶","⁷","⁸","⁹","ᵃ","ᵇ","ᶜ","ᵈ","ᵉ","ᶠ","ᴳ","ᴴ","ᴵ","ᴶ","ᴷ","ᴸ","ᴹ","ᴺ","ᴼ","ᴾ","Q","ᴿ")),
	LATIN_SUB(
			new BaseGlyphSetNumber("₀","₁","₂","₃","₄","₅","₆","₇","₈","₉"),
			new BaseGlyphSetNumber("₀","₁","₂","₃","₄","₅","₆","₇","₈","₉","ₐ","₆","꜀","ₔ","ₑ","բ"),
			new BaseGlyphSetNumber("₁","₂","₃","₄","₅","₆","₇","₈","₉","ₐ","₆","꜀","ₔ","ₑ","բ","G","ₕ","ᵢ","ⱼ","ₖ","ₗ","ₘ","ₙ","ₒ","ₚ","Q","ᵣ")),
	LATIN_TOPHEX(
			LATIN_BASIC.BȍőnNumber10(),
			LATIN_BASIC.BȍőnNumber16().withAltGlyphSet(LATIN_TOP),
			null),
	LATIN_SUBHEX(
			LATIN_BASIC.BȍőnNumber10(),
			LATIN_BASIC.BȍőnNumber16().withAltGlyphSet(LATIN_SUB),
			null),
	
	TONE_SCRIPT(
			new BaseGlyphSetNumber(v -> T10PartDecimal.PART_1.BãßVoorElk(x -> v.add(x.BȍőnDialTone()))),
			new BaseGlyphSetNumber(v -> T16PartHex.PART_1.BãßVoorElk(x -> v.add(x.BȍőnDialTone()))),
			new BaseGlyphSetNumber("꜊꜈","꜊꜉","꜊꜋","꜊꜌","꜊꜍","꜊꜎","꜊꜏","꜊꜐","꜊꜑","˧˥","˧˦","˧˨","˧˩","˧꜒","˧꜓","˧꜔","˧꜕","˧꜖","꜏˥","꜏˦","꜏˧","꜏˨","꜏˩","꜏꜍","꜏꜎","꜏꜐","꜏꜑")),
	DIPAVALI_LRPATH_TOPHEX(
			new BaseGlyphSetNumber(v -> T10PartDecimal.PART_1.BãßVoorElk(x -> v.add(x.BȍőnAlt1Value()))),
			new BaseGlyphSetNumber("˧˥˩","˧˩˥","˧˥˦","˧˩˨","˧˦˦","˧˨˨","˧˥˥","˧˩˩","˥˩˧","˩˥˧","˥˦˧","˩˨˧","˦˦˧","˨˨˧","˥˥˧","˩˩˧").withAltGlyphSet(BaseGlyphSet.LATIN_TOP),
			TONE_SCRIPT.BȍőnNumber27()),
	DIPAVALI_LRPATH_SUBHEX(
			new BaseGlyphSetNumber(v -> T10PartDecimal.PART_1.BãßVoorElk(x -> v.add(x.BȍőnAlt1Value()))),
			new BaseGlyphSetNumber("˧˥˩","˧˩˥","˧˥˦","˧˩˨","˧˦˦","˧˨˨","˧˥˥","˧˩˩","˥˩˧","˩˥˧","˥˦˧","˩˨˧","˦˦˧","˨˨˧","˥˥˧","˩˩˧").withAltGlyphSet(BaseGlyphSet.LATIN_SUB),
			TONE_SCRIPT.BȍőnNumber27()),
	DIPAVALI_RLPATH_TOPHEX(
			new BaseGlyphSetNumber(v -> T10PartDecimal.PART_1.BãßVoorElk(x -> v.add(x.BȍőnAlt2Value()))),
			new BaseGlyphSetNumber("꜔꜒꜖","꜔꜖꜒","꜔꜒꜓","꜔꜖꜕","꜔꜓꜓","꜔꜕꜕","꜔꜒꜒","꜔꜖꜖","꜒꜖꜔","꜖꜒꜔","꜒꜓꜔","꜖꜕꜔","꜓꜓꜔","꜕꜕꜔","꜒꜒꜔","꜖꜖꜔").withAltGlyphSet(BaseGlyphSet.LATIN_TOP),
			TONE_SCRIPT.BȍőnNumber27()),
	DIPAVALI_RLPATH_SUBHEX(
			new BaseGlyphSetNumber(v -> T10PartDecimal.PART_1.BãßVoorElk(x -> v.add(x.BȍőnAlt2Value()))),
			new BaseGlyphSetNumber("꜔꜒꜖","꜔꜖꜒","꜔꜒꜓","꜔꜖꜕","꜔꜓꜓","꜔꜕꜕","꜔꜒꜒","꜔꜖꜖","꜒꜖꜔","꜖꜒꜔","꜒꜓꜔","꜖꜕꜔","꜓꜓꜔","꜕꜕꜔","꜒꜒꜔","꜖꜖꜔").withAltGlyphSet(BaseGlyphSet.LATIN_SUB),
			TONE_SCRIPT.BȍőnNumber27()),
	
	GREEK(
			new BaseGlyphSetNumber("ō","α","β","γ","δ","ε","ϝ","ζ","η","θ"),
			new BaseGlyphSetNumber("ō","α","β","γ","δ","ε","ϝ","ζ","η","θ","ι","κ","λ","μ","ν","ξ"),
			new BaseGlyphSetNumber("α","β","γ","δ","ε","ϝ","ζ","η","θ","ι","κ","λ","μ","ν","ξ","ο","π","ϟ","ρ","σ","τ","υ","φ","χ","ψ","ω","ϡ")),
	BENGALI(
			new BaseGlyphSetNumber("০","১","২","৩","৪","৫","৬","৭","৮","৯"),
			new BaseGlyphSetNumber("০","১","২","৩","৪","৫","৬","৭","৮","৯","জ্ঞ","ক্ষ","হ","স","ষ","শ"),
			new BaseGlyphSetNumber("ক","খ","গ","ঘ","ঙ","চ","ছ","জ","ঝ","ঞ","ট","ঠ","ড","ঢ","ণ","ত","থ","দ","ধ","ন","প","ফ","ব","ভ","ম","য","র")),
	KANNADA(
			new BaseGlyphSetNumber("೦","೧","೨","೩","೪","೫","೬","೭","೮","೯"),
			new BaseGlyphSetNumber("೦","೧","೨","೩","೪","೫","೬","೭","೮","೯","ಕ","ಖ","ಗ","ಘ","ಙ","ಚ"),
			new BaseGlyphSetNumber("ಕ","ಖ","ಗ","ಘ","ಙ","ಚ","ಛ","ಜ","ಝ","ಞ","ಟ","ಠ","ಡ","ಢ","ಣ","ತ","ಥ","ದ","ಧ","ನ","ಪ","ಫ","ಬ","ಭ","ಮ","ಯ","ರ")),
	MALAYALAM(
			new BaseGlyphSetNumber("൦","൧","൨","൩","൪","൫","൬","൭","൮","൯"),
			new BaseGlyphSetNumber("൦","൧","൨","൩","൪","൫","൬","൭","൮","൯","൰","൱","൲","൳","൴","൵"),
			new BaseGlyphSetNumber("ക","ഖ","ഗ","ഘ","ങ","ച","ഛ","ജ","ഝ","ഞ","ട","ഠ","ഡ","ഢ","ണ","ത","ഥ","ദ","ധ","ന","പ","ഫ","ബ","ഭ","മ","ർ","ൿ")),
	THAI(
			new BaseGlyphSetNumber("๐","๑","๒","๓","๔","๕","๖","๗","๘","๙"),
			new BaseGlyphSetNumber("๐","๑","๒","๓","๔","๕","๖","๗","๘","๙","ก","ข","ค","ฆ","ง","จ"),
			new BaseGlyphSetNumber("๑","๒","๓","๔","๕","๖","๗","๘","๙","ก","ข","ค","ฆ","ง","จ","ฉ","ช","ฌ","ญ","ฎ","ฐ","ฑ","ฒ","ณ","ด","ท","ธ")),
	/* TODO: Brahmi is U+11000–U+1107F and thus unsupported by ImGui 
	BRAHMI(
			new BaseGlyphSetNumber("𑁦","𑁧","𑁨","𑁩","𑁪","𑁫","𑁬","𑁭","𑁮","𑁯"), 
			new BaseGlyphSetNumber("𑀮","𑀯","𑀰","𑀱","𑀮𑀺","𑀯𑀺","𑀰𑀺","𑀱𑀺","𑀮𑀽","𑀯𑀽","𑀰𑀽","𑀱𑀽","𑀮𑁄","𑀯𑁄","𑀰𑁄","𑀱𑁄"),
			new BaseGlyphSetNumber("𑀓𑁆","𑀔𑁆","𑀕𑁆","𑀖𑁆","𑀗𑁆","𑀘𑁆","𑀙𑁆","𑀚𑁆","𑀛𑁆","𑀜𑁆","𑀝𑁆","𑀞𑁆","𑀟𑁆","𑀠𑁆","𑀡𑁆","𑀢𑁆","𑀣𑁆","𑀤𑁆","𑀥𑁆","𑀦𑁆","𑀧𑁆","𑀨𑁆","𑀩𑁆","𑀪𑁆","𑀫𑁆","𑀬𑁆","𑀭𑁆")),
	*/
	/* TODO: Egyptian hieroglyphs should be mapped 0x13000 to 0x1342E but for now on 0xE000 to 0xE42E (BMP) */
	HIERO(
			new BaseGlyphSetNumber("\ue429","\ue3fa","\ue3fb","\ue3fc","\ue3fd","\ue3fe","\ue3ff","\ue400","\ue401","\ue401").withSeperator(BãßBȍőnConstantsʸᴰ.STR_SPACE),
			new BaseGlyphSetNumber("\ue254","\ue255","\ue256","\ue257","\ue258","\ue259","\ue25a","\ue25b","\ue25c","\ue25d","\ue25e","\ue25f","\ue260","\ue261","\ue262","\ue263").withSeperator(BãßBȍőnConstantsʸᴰ.STR_SPACE),
			new BaseGlyphSetNumber(
					"\ue3fa","\ue3fb","\ue3fc","\ue3fd","\ue3fe","\ue3ff","\ue400","\ue401","\ue401",
					"\ue386","\ue387","\ue388","\ue389","\ue38a","\ue38b","\ue38c","\ue38d","\ue38e",
					"\ue362","\ue363","\ue364","\ue365","\ue366","\ue367","\ue368","\ue369","\ue36a").withSeperator(BãßBȍőnConstantsʸᴰ.STR_SPACE)
			),
	RUNIC(
			new BaseGlyphSetNumber("ᛰ","ᚠ","ᚢ","ᚦ","ᚬ","ᚱ","ᚴ","ᚼ","ᚾ","ᛁ"),
			new BaseGlyphSetNumber("ᛰ","ᚠ","ᚢ","ᚦ","ᚬ","ᚱ","ᚴ","ᚼ","ᚾ","ᛁ","ᛅ","ᛋ","ᛏ","ᛒ","ᛚ","ᛘ"),
			new BaseGlyphSetNumber("ᚠ","ᚢ","ᚦ","ᚨ","ᚱ","ᚲ","ᚷ","ᚹ","ᚺ","ᚾ","ᛁ","ᛃ","ᛇ","ᛈ","ᛉ","ᛊ","ᛏ","ᛒ","ᛖ","ᛗ","ᛚ","ᛜ","ᛟ","ᛞ","ᚡ","ᚤ","ᚧ")),
	KOREAN(
			new BaseGlyphSetNumber("영","일","이","삼","사","오","육","칠","팔","구"),
			new BaseGlyphSetNumber("ㅏ","ㅐ","ㅑ","ㅒ","ㅓ","ㅔ","ㅕ","ㅖ","ㅗ","ㅘ","ㅙ","ㅚ","ㅛ","ㅜ","ㅝ","ㅞ"),
			new BaseGlyphSetNumber("ㄱ","ㄲ","ㄴ","ㄷ","ㄸ","ㄹ","ㅁ","ㅂ","ㅃ","ㅅ","ㅆ","ㅈ","ㅉ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ","ㄵ","ㄶ","ㄺ","ㄻ","ㄼ","ㄽ","ㄾ","ㄿ","ㅀ")),
	
	CHINA(
			new BaseGlyphSetNumber("零","一","二","三","四","五","六","七","八","九"),
			null,
			null),
	CHINA_FORMAL(
			new BaseGlyphSetNumber(v -> T10PartDecimal.PART_1.BãßVoorElk(x -> v.add(x.BȍőnChinaKey()))),
			null,
			null),
	CHINA_FORMAL_OLD(
			new BaseGlyphSetNumber("零","壹","貳","參","肆","伍","陸","柒","捌","玖"),
			null,
			null),
	JAPAN(
			CHINA.BȍőnNumber10(),
			null,
			null),
	JAPAN_FORMAL(
			new BaseGlyphSetNumber("零","壱","弐","参","四","五","六","七","八","九"),
			null,
			null),
	
	CYRILLIC(
			new BaseGlyphSetNumber("Ф","А","В","Г","Д","Є","Ѕ","З","И","Ѳ"),
			new BaseGlyphSetNumber("Ф","А","В","Г","Д","Є","Ѕ","З","И","Ѳ","І","К","Л","М","Н","Ѯ"),
			new BaseGlyphSetNumber("А","В","Г","Д","Є","Ѕ","З","И","Ѳ","І","К","Л","М","Н","Ѯ","Ѻ","П","Ч","Р","С","Т","Ѵ","Ф","Х","Ѱ","Ѿ","Ц")),
	ARABIC(
			new BaseGlyphSetNumber("٠","١","٢","٣","٤","٥","٦","٧","٨","٩"),
			null,
			new BaseGlyphSetNumber("ا","ب","ج","د","ه","و","ز","ح","ط","ي","ك","ل","م","ن","س","ع","ف","ص","ق","ر","ش","ت","ث","خ","ذ","ض","ظ"),
			true),
	HEBREW(
			new BaseGlyphSetNumber("אֶפֶס","אֶחָד","שְׁתַּיִם","שְׁלֹשָׁה","אַרְבַּע‎","חֲמִשָּׁה‎","שֵׁשׁ‎","שִׁבְעָה","שְׁמוֹנֶה","תִּשְׁעָה‎").withSeperator(BãßBȍőnConstantsʸᴰ.STR_SPACE),
			null,
			new BaseGlyphSetNumber("א","ב","ג","ד","ה","ו","ז","ח","ט","י","כ","ל","מ","נ","ס","ע","פ","צ","ק","ר","ש","ת","ך","ם","ן","ף","ץ"),
			true),
	;
	
	private final GuageCounterᴶᴹˣ printNumber10Count;
	private final GuageCounterᴶᴹˣ printNumber16Count;
	private final GuageCounterᴶᴹˣ printNumber27Count;
	private final BãßBȍőnCoffinOpenʸᴰ<BãßBȍőnGlyphSetKeyʸᴰ> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<BãßBȍőnGlyphSetKeyʸᴰ> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };

	private BaseGlyphSet(BaseGlyphSetNumber numbers) {
		this(numbers, null, null);
	}
	
	private BaseGlyphSet(BaseGlyphSetNumber numbers, BaseGlyphSetNumber hex, BaseGlyphSetNumber gematria) {
		this(numbers, hex, gematria, false);
	}
	
	private BaseGlyphSet(BaseGlyphSetNumber numbers, BaseGlyphSetNumber hex, BaseGlyphSetNumber gematria, Boolean reverseScript) {
		BBC.PUT_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.NUMBERS, numbers);
		BBC.PUT_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.HEXIMALS, hex);
		BBC.PUT_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.GEMATRIA, gematria);
		BBC.PUT_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.REVERSE_SCRIPT, reverseScript); // TODO: ImGui workaround
		BBC.BOON_INIT(this);
		this.BȍőnJmxInit(BãßBȍőnGlyphSetKeyʸᴰ.JMX);
		printNumber10Count = BȍőnJmxInitGuageCounter(BãßBȍőnGlyphSetKeyʸᴰ.JMX, "printNumber10Count");
		printNumber16Count = BȍőnJmxInitGuageCounter(BãßBȍőnGlyphSetKeyʸᴰ.JMX, "printNumber16Count");
		printNumber27Count = BȍőnJmxInitGuageCounter(BãßBȍőnGlyphSetKeyʸᴰ.JMX, "printNumber27Count");
	}
	
	public BaseGlyphSetNumber BȍőnNumber10() {
		return GET_BBC().GET_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.NUMBERS, BaseGlyphSetNumber.class);
	}
	
	public BaseGlyphSetNumber BȍőnNumber16() {
		return GET_BBC().GET_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.HEXIMALS, BaseGlyphSetNumber.class);
	}
	
	public BaseGlyphSetNumber BȍőnNumber27() {
		return GET_BBC().GET_OBJ(BãßBȍőnGlyphSetKeyʸᴰ.GEMATRIA, BaseGlyphSetNumber.class);
	}
	
	public Boolean BȍőnReverseScript() {
		return GET_BBC().GET_BOOL(BãßBȍőnGlyphSetKeyʸᴰ.REVERSE_SCRIPT);
	}
	
	public String BȍőnConvertTo(String numbers) {
		StringBuilder buf = new StringBuilder();
		for (char c:numbers.toCharArray()) {
			for (BaseGlyphSet set:values()) {
				int loc = set.BȍőnNumber10().BȍőnIndexOf(""+c);
				if (loc != -1) {
					buf.append(set.BȍőnNumber10().BȍőnCharFor(loc));
				}
			}
		}
		return buf.toString();
	}
	
	public String BȍőnPrintNumber10(int number, int numberMax) {
		printNumber10Count.increment();
		String maxDigitNumber = Integer.toString(numberMax);
		StringBuilder maxDigitFormat = new StringBuilder();
		for (int i=0;i<maxDigitNumber.length();i++) {
			maxDigitFormat.append("0");
		}
		String numberStr = new DecimalFormat(maxDigitFormat.toString()).format(number);
		StringBuilder buf = new StringBuilder();
		for (int i=0;i<numberStr.length();i++) {
			char c = numberStr.charAt(i);
			int numberDigit = c - '0';
			buf.append(BȍőnNumber10().BȍőnCharFor(numberDigit));
			if (i<numberStr.length() - 1) {
				buf.append(BȍőnNumber10().BȍőnCharSeperator());
			}
		}
		if (BȍőnReverseScript()) {
			return buf.reverse().toString();
		}
		return buf.toString();
	}
	
	public String BȍőnPrintNumber16(int number, int numberMax) {
		printNumber16Count.increment();
		String maxDigitNumber = Integer.toHexString(numberMax);
		String numberStr = Integer.toHexString(number);
		StringBuilder buf = new StringBuilder();
		BaseGlyphSet printSet = this;
		for (int i=numberStr.length();i<maxDigitNumber.length();i++) {
			buf.append(printSet.BȍőnNumber16().BȍőnCharFor(0));
			if (i==numberStr.length() && BȍőnNumber16().BȍőnAltGlyphSet() != null) {
				printSet = BȍőnNumber16().BȍőnAltGlyphSet();
			}
		}
		for (int i=0;i<numberStr.length();i++) {
			char c = numberStr.charAt(i);
			int numberDigit = 0;
			if (c >= 'a') {
				numberDigit = c - 'a' + 10;
			} else {
				numberDigit = c - '0';
			}
			buf.append(printSet.BȍőnNumber16().BȍőnCharFor(numberDigit));
			if (i<numberStr.length() - 1) {
				buf.append(printSet.BȍőnNumber16().BȍőnCharSeperator());
			}
			if (i==0 && BȍőnNumber16().BȍőnAltGlyphSet() != null) {
				printSet = BȍőnNumber16().BȍőnAltGlyphSet();
			}
		}
		if (BȍőnReverseScript()) {
			return buf.reverse().toString();
		}
		return buf.toString();
	}
	
	public String BȍőnPrintNumber27(int number, int numberMax) {
		printNumber27Count.increment();
		String maxDigitNumber = Integer.toString(numberMax, 27);
		String numberStr = Integer.toString(number, 27);
		StringBuilder buf = new StringBuilder();
		BaseGlyphSet printSet = this;
		for (int i=numberStr.length();i<maxDigitNumber.length();i++) {
			buf.append(printSet.BȍőnNumber27().BȍőnCharFor(0));
			if (i==numberStr.length() && BȍőnNumber27().BȍőnAltGlyphSet() != null) {
				printSet = BȍőnNumber27().BȍőnAltGlyphSet();
			}
		}
		for (int i=0;i<numberStr.length();i++) {
			char c = numberStr.charAt(i);
			int numberDigit = 0;
			if (c >= 'a') {
				numberDigit = c - 'a' + 10;
			} else {
				numberDigit = c - '0';
			}
			buf.append(printSet.BȍőnNumber27().BȍőnCharFor(numberDigit));
			if (i<numberStr.length() - 1) {
				buf.append(printSet.BȍőnNumber27().BȍőnCharSeperator());
			}
			if (i==0 && BȍőnNumber27().BȍőnAltGlyphSet() != null) {
				printSet = BȍőnNumber27().BȍőnAltGlyphSet();
			}
		}
		if (BȍőnReverseScript()) {
			return buf.reverse().toString();
		}
		return buf.toString();
	}
}
