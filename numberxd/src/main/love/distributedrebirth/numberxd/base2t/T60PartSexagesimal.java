package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.bassboonyd.BãßBȍőnCoffin;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpen;
import love.distributedrebirth.bassboonyd.BãßBȍőnInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.bone.BassBone;
import love.distributedrebirth.numberxd.base2t.bone.BassBoneStoreKey;

/**
 * The distribution by 60.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
@BãßBȍőnInfoʸᴰ(name = "T60Sexagesimal", purpose = "The distribution by 60.")
public enum T60PartSexagesimal implements BassBone<T60PartSexagesimal> {

	PART_1 ("˧˩˥","ια","牛","cow"),
	PART_2 ("˧˥˦","ιβ","鸡","chicken"),
	PART_3 ("˧˩˨","ιγ","羊","sheep"),
	PART_4 ("˧˦˦","ιδ","狼","wolf"),
	PART_5 ("˧˨˨","ιε","鼠","rat"),
	PART_6 ("˧˥˥","ιϚ","貓","cat"),
	PART_7 ("˧˩˩","ιζ","兔","rabbit"),
	PART_8 ("˥˩˧","ιη","猿","ape"),
	PART_9 ("˩˥˧","ιθ","蛇","snake"),
	PART_10("˥˦˧","κα","马","horse"),
	PART_11("˩˨˧","κβ","象","elepant"),
	PART_12("˦˦˧","κγ","豹","leopard"),
	PART_13("˨˨˧","κδ","鴉","crow"),
	PART_14("˥˥˧","κε","豬","pig"),
	PART_15("˩˩˧","κϚ","狗","dog"),
	
	PART_16("꜔꜒꜖","κζ","魚","fish"),
	PART_17("꜔꜒꜓","κη","虾","shrimp"),
	PART_18("꜔꜖꜕","κθ","鲸","whale"),
	PART_19("꜔꜓꜓","λα","熊","bear"),
	PART_20("꜔꜕꜕","λβ","鹿","deer"),
	PART_21("꜔꜒꜒","λγ","驴","donkey"),
	PART_22("꜔꜖꜖","λδ","貘","tapir"),
	PART_23("꜒꜖꜔","λε","鸟","bird"),
	PART_24("꜖꜒꜔","λϚ","鹤","crane"),
	PART_25("꜒꜓꜔","λζ","鹰","eagle"),
	PART_26("꜖꜕꜔","λη","隼","falcon"),
	PART_27("꜓꜓꜔","λθ","鹅","goose"),
	PART_28("꜕꜕꜔","μα","蝾","salamander"),
	PART_29("꜒꜒꜔","μβ","龟","turtle"),
	PART_30("꜖꜖꜔","μγ","蜈","centipede"),
	
	PART_31("꜊꜌꜈","μδ","蝇","fly"),
	PART_32("꜊꜈꜉","με","蝎","scorpion"),
	PART_33("꜊꜌꜋","μϚ","虫","worm"),
	PART_34("꜊꜉꜉","μζ","虎","tiger"),
	PART_35("꜊꜋꜋","μη","駝","camel"),
	PART_36("꜊꜈꜈","μθ","猴","monkey"),
	PART_37("꜊꜌꜌","να","鯊","shark"),
	PART_38("꜈꜌꜊","νβ","鴨","duck"),
	PART_39("꜌꜈꜊","νγ","芥","mustard"),
	PART_40("꜈꜉꜊","νδ","鹽","salt"),
	PART_41("꜌꜋꜊","νε","椒","pepper"),
	PART_42("꜉꜉꜊","νϚ","薑","ginger"),
	PART_43("꜋꜋꜊","νζ","穀","corn"),
	PART_44("꜈꜈꜊","νη","豆","beans"),
	PART_45("꜌꜌꜊","νθ","柚","pomelos"),
	
	PART_46("꜏꜍꜑","ξα","棗","jujube"),
	PART_47("꜏꜍꜎","ξβ","瓜","melon"),
	PART_48("꜏꜑꜐","ξγ","葡","grape"),
	PART_49("꜏꜎꜎","ξδ","梅","plum"),
	PART_50("꜏꜐꜐","ξε","灰","lime"),
	PART_51("꜏꜍꜍","ξϚ","梨","pear"),
	PART_52("꜏꜑꜑","ξζ","蕉","banana"),
	PART_53("꜍꜑꜏","ξη","檸","lemon"),
	PART_54("꜑꜍꜏","ξθ","柿","persimmon"),
	PART_55("꜍꜎꜏","οα","橙","orange"),
	PART_56("꜑꜐꜏","οβ","桃","peach"),
	PART_57("꜎꜎꜏","ογ","杏","apricot"),
	PART_58("꜐꜐꜏","οδ","莓","strawberry"),
	PART_59("꜍꜍꜏","οε","薯","patato"),
	PART_60("꜑꜑꜏","οϚ","蘋","apple"),
	;
	
	private final BãßBȍőnCoffinOpen<BassBoneStoreKey> BBC = BãßBȍőnCoffinOpen.newInstance();
	public BãßBȍőnCoffin<BassBoneStoreKey> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };
	
	private T60PartSexagesimal(String idTone, String idLetter, String chinaKey, String chinaValue) {
		BBC.PUT_OBJ(BassBoneStoreKey.ID_TONE, idTone);
		BBC.PUT_OBJ(BassBoneStoreKey.ID_LETTER, idLetter);
		BBC.PUT_OBJ(BassBoneStoreKey.CHINA_KEY, chinaKey);
		BBC.PUT_OBJ(BassBoneStoreKey.CHINA_VALUE, chinaValue);
		BBC.PUT_MAP(BassBoneStoreKey.MAP_TONE);
		BBC.PUT_MAP(BassBoneStoreKey.MAP_CHINA);
	}
}
