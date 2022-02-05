package love.distributedrebirth.numberxd.base2t.part;

import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnClassInfoʸᴰ(name = "T60Sexagesimal", purpose = "The distribution by 60 (human food).")
public enum T60PartSexagesimal implements BãßBȍőnPartʸᴰ<T60PartSexagesimal> {

	PART_1 ("˥˥","牛","cow"),
	PART_2 ("˥˦","鸡","chicken"),
	PART_3 ("˥˧","羊","sheep"),
	PART_4 ("˥˨","狼","wolf"),
	PART_5 ("˥˩","鼠","rat"),
	PART_6 ("˥꜒","貓","cat"),
	PART_7 ("˥꜓","兔","rabbit"),
	PART_8 ("˥꜔","猿","ape"),
	PART_9 ("˥꜕","蛇","snake"),
	PART_10("˥꜖","马","horse"),
	PART_11("˦˥","象","elepant"),
	PART_12("˦˦","豹","leopard"),
	PART_13("˦˧","鴉","crow"),
	PART_14("˦˨","豬","pig"),
	PART_15("˦˩","狗","dog"),
	PART_16("˦꜒","魚","fish"),
	PART_17("˦꜓","虾","shrimp"),
	PART_18("˦꜔","鲸","whale"),
	PART_19("˦꜕","熊","bear"),
	PART_20("˦꜖","鹿","deer"),
	PART_21("˧˥","驴","donkey"),
	PART_22("˧˦","貘","tapir"),
	PART_23("˧˧","鸟","bird"),
	PART_24("˧˨","鹤","crane"),
	PART_25("˧˩","鹰","eagle"),
	PART_26("˧꜒","隼","falcon"),
	PART_27("˧꜓","鹅","goose"),
	PART_28("˧꜔","蝾","salamander"),
	PART_29("˧꜕","龟","turtle"),
	PART_30("˧꜖","蜈","centipede"),
	PART_31("˨˥","蝇","fly"),
	PART_32("˨˦","蝎","scorpion"),
	PART_33("˨˧","虫","worm"),
	PART_34("˨˨","虎","tiger"),
	PART_35("˨˩","駝","camel"),
	PART_36("˨꜒","猴","monkey"),
	PART_37("˨꜓","鯊","shark"),
	PART_38("˨꜔","鴨","duck"),
	PART_39("˨꜕","芥","mustard"),
	PART_40("˨꜖","鹽","salt"),
	PART_41("˩˥","椒","pepper"),
	PART_42("˩˦","薑","ginger"),
	PART_43("˩˧","穀","corn"),
	PART_44("˩˨","豆","beans"),
	PART_45("˩˩","柚","pomelos"),
	PART_46("˩꜒","棗","jujube"),
	PART_47("˩꜓","瓜","melon"),
	PART_48("˩꜔","葡","grape"),
	PART_49("˩꜕","梅","plum"),
	PART_50("˩꜖","灰","lime"),
	PART_51("꜒˥","梨","pear"),
	PART_52("꜒˦","蕉","banana"),
	PART_53("꜒˧","檸","lemon"),
	PART_54("꜒˨","柿","persimmon"),
	PART_55("꜒˩","餅","cake"),
	PART_56("꜒꜒","桃","peach"),
	PART_57("꜒꜓","杏","apricot"),
	PART_58("꜒꜔","莓","strawberry"),
	PART_59("꜒꜕","薯","patato"),
	PART_60("꜒꜖","蘋","apple"),
	;
	
	private final BãßBȍőnCoffinOpenʸᴰ<BãßBȍőnPartKeyʸᴰ> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<BãßBȍőnPartKeyʸᴰ> GET_BBC() { return BBC; }
	public static int LENGTH() { return values().length; };
	
	private T60PartSexagesimal(String dialTone, String chinaKey, String chinaValue) {
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.DIAL_TONE, dialTone);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_KEY, chinaKey);
		BBC.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_VALUE, chinaValue);
		BBC.INIT_BOON(this);
	}
}
