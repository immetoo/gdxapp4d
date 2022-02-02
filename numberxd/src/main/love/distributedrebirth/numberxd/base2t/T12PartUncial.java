package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1Info;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneStoreKey;

/**
 * The distribution by 12.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
@BãßBȍőnInfoʸᴰ(name = "T12PartUncial", purpose = "The distribution by 12.")
@BassBoneAlt1Info(name="Transdecimal symbols", website="https://en.wikipedia.org/wiki/Duodecimal#Transdecimal_symbols")
public enum T12PartUncial implements BassBoneAlt1<T12PartUncial> {

	PART_1 ("˥","0","日","sun",     "0"),
	PART_2 ("˧","1","月","moon",    "1"),
	PART_3 ("˩","2","星","star",    "2"),
	PART_4 ("꜒","3","山","mountain","3"),
	PART_5 ("꜔","4","龍","dragon",  "4"),
	PART_6 ("꜖","5","鳳","phoenix", "5"),
	PART_7 ("꜈","6","杯","cup",     "6"),
	PART_8 ("꜊","7","藻","pondweed","7"),
	PART_9 ("꜌","8","爐","furnace", "8"),
	PART_10("꜍","9","種","seed",    "9"),
	PART_11("꜏","A","黼","axe",     "\u218a"), // TURNED DIGIT TWO
	PART_12("꜑","B","亞","nozero",  "\u218b"), // TURNED DIGIT THREE
	;
	
	private final BãßBȍőnCoffinOpenʸᴰ<BassBoneStoreKey> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<BassBoneStoreKey> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };
	
	private T12PartUncial(String idTone, String idLetter, String chinaKey, String chinaValue, String alt1Value) {
		BBC.PUT_OBJ(BassBoneStoreKey.ID_TONE, idTone);
		BBC.PUT_OBJ(BassBoneStoreKey.ID_LETTER, idLetter);
		BBC.PUT_OBJ(BassBoneStoreKey.CHINA_KEY, chinaKey);
		BBC.PUT_OBJ(BassBoneStoreKey.CHINA_VALUE, chinaValue);
		BBC.PUT_OBJ(BassBoneStoreKey.ALT_1_VALUE, alt1Value);
		BBC.PUT_MAP(BassBoneStoreKey.MAP_TONE);
		BBC.PUT_MAP(BassBoneStoreKey.MAP_CHINA);
	}
}
