package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneAlt1Info;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneCoffin;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneName;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneStoreKey;

/**
 * The distribution by 12.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
@BassBoneName("T12PartUncial")
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
	
	public static int LENGTH() { return values().length; };
	private final BassBoneCoffin bbc = BassBoneCoffin.newInstance();
	
	private T12PartUncial(String idTone, String idLetter, String chinaKey, String chinaValue, String alt1Value) {
		getBBC().putInit(BassBoneStoreKey.ID_TONE, idTone);
		getBBC().putInit(BassBoneStoreKey.ID_LETTER, idLetter);
		getBBC().putInit(BassBoneStoreKey.CHINA_KEY, chinaKey);
		getBBC().putInit(BassBoneStoreKey.CHINA_VALUE, chinaValue);
		getBBC().putInit(BassBoneStoreKey.ALT_1_VALUE, alt1Value);
		getBBC().getMapObject(BassBoneStoreKey.MAP_TONE);
		getBBC().getMapObject(BassBoneStoreKey.MAP_CHINA);
	}
	
	@Override
	public BassBoneCoffin getBBC() {
		return bbc;
	}
}
