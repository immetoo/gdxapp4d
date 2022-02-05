package love.distributedrebirth.numberxd.base2t.part;

import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnClassInfoʸᴰ(name = "T09PartNonary", purpose = "The distribution by 9 (colors).")
public enum T09PartNonary implements BãßBȍőnPartʸᴰ<T09PartNonary> {
 
	PART_1 ("˦","藍","blue"),
	PART_2 ("˨","皓","white"),
	PART_3 ("꜓","紅","red"),
	PART_4 ("꜕","橙","orange"),
	PART_5 ("꜉","綠","green"),
	PART_6 ("꜋","黃","yellow"),
	PART_7 ("꜍","褐","brown"),
	PART_8 ("꜏","黑","black"),
	PART_9 ("꜑","紺","purple"),
	;
	
	private final BãßBȍőnCoffinOpenʸᴰ<BãßBȍőnPartKeyʸᴰ> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<BãßBȍőnPartKeyʸᴰ> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };
	
	private T09PartNonary(String dialTone, String chinaKey, String chinaValue) {
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.DIAL_TONE, dialTone);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_KEY, chinaKey);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_VALUE, chinaValue);
		BBC.INIT_BOON(this);
	}
}
