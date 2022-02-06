package love.distributedrebirth.numberxd.base2t;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.jmx.DefaultEnumInstanceᴶᴹˣ;
import love.distributedrebirth.bassboonyd.jmx.GuageCounterᴶᴹˣ;
import love.distributedrebirth.bassboonyd.jmx.MBeanStoreKeyᴶᴹˣ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.T02PartBinary;
import love.distributedrebirth.numberxd.base2t.part.T03PartTrit;
import love.distributedrebirth.numberxd.base2t.part.T04PartQuad;
import love.distributedrebirth.numberxd.base2t.part.T05PartPental;
import love.distributedrebirth.numberxd.base2t.part.T06PartSeximal;
import love.distributedrebirth.numberxd.base2t.part.T07PartPlanIt;
import love.distributedrebirth.numberxd.base2t.part.T08PartOctal;
import love.distributedrebirth.numberxd.base2t.part.T09PartNonary;
import love.distributedrebirth.numberxd.base2t.part.T10PartDecimal;
import love.distributedrebirth.numberxd.base2t.part.T11PartUndecimal;
import love.distributedrebirth.numberxd.base2t.part.T12PartUncial;
import love.distributedrebirth.numberxd.base2t.part.T16PartHex;
import love.distributedrebirth.numberxd.base2t.part.T20PartScore;
import love.distributedrebirth.numberxd.base2t.part.T60PartSexagesimal;
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnPackageInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnClassInfoʸᴰ(name = "BasePartFactory", purpose = "Factory to access the bases.")
@BãßBȍőnPackageInfoʸᴰ(name = "love.distributedrebirth.numberxd")
public enum BasePartFactory implements DefaultEnumInstanceᴶᴹˣ<BasePartFactory, MBeanStoreKeyᴶᴹˣ> {

	INSTANCE;
	
	private final GuageCounterᴶᴹˣ baseT02Reads;
	private final GuageCounterᴶᴹˣ baseT03Reads;
	private final GuageCounterᴶᴹˣ baseT04Reads;
	private final GuageCounterᴶᴹˣ baseT05Reads;
	private final GuageCounterᴶᴹˣ baseT06Reads;
	private final GuageCounterᴶᴹˣ baseT07Reads;
	private final GuageCounterᴶᴹˣ baseT08Reads;
	private final GuageCounterᴶᴹˣ baseT09Reads;
	private final GuageCounterᴶᴹˣ baseT10Reads;
	private final GuageCounterᴶᴹˣ baseT11Reads;
	private final GuageCounterᴶᴹˣ baseT12Reads;
	private final GuageCounterᴶᴹˣ baseT16Reads;
	private final GuageCounterᴶᴹˣ baseT20Reads;
	private final GuageCounterᴶᴹˣ baseT60Reads;
	private static final int[] SUPPORTED_BASES = {2,3,4,5,6,7,8,9,10,11,12,16,20,60};
	private final BãßBȍőnCoffinOpenʸᴰ<MBeanStoreKeyᴶᴹˣ> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<MBeanStoreKeyᴶᴹˣ> GET_BBC() { return BBC; }
	
	private BasePartFactory() {
		BBC.BOON_INIT(this);
		BȍőnJmxInit(MBeanStoreKeyᴶᴹˣ.JMX);
		baseT02Reads = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "baseT02Reads");
		baseT03Reads = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "baseT03Reads");
		baseT04Reads = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "baseT04Reads");
		baseT05Reads = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "baseT05Reads");
		baseT06Reads = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "baseT06Reads");
		baseT07Reads = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "baseT07Reads");
		baseT08Reads = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "baseT08Reads");
		baseT09Reads = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "baseT09Reads");
		baseT10Reads = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "baseT10Reads");
		baseT11Reads = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "baseT11Reads");
		baseT12Reads = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "baseT12Reads");
		baseT16Reads = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "baseT16Reads");
		baseT20Reads = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "baseT20Reads");
		baseT60Reads = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "baseT60Reads");
	}
	
	public int[] BãßBases() {
		return SUPPORTED_BASES;
	}
	
	public BãßBȍőnPartʸᴰ<?>[] BãßBuildPartsByBase(int base) {
		switch (base) {
		case 2:
			baseT02Reads.increment();
			return T02PartBinary.values();
		case 3:
			baseT03Reads.increment();
			return T03PartTrit.values();
		case 4:
			baseT04Reads.increment();
			return T04PartQuad.values();
		case 5:
			baseT05Reads.increment();
			return T05PartPental.values();
		case 6:
			baseT06Reads.increment();
			return T06PartSeximal.values();
		case 7:
			baseT07Reads.increment();
			return T07PartPlanIt.values();
		case 8:
			baseT08Reads.increment();
			return T08PartOctal.values();
		case 9:
			baseT09Reads.increment();
			return T09PartNonary.values();
		case 10:
			baseT10Reads.increment();
			return T10PartDecimal.values();
		case 11:
			baseT11Reads.increment();
			return T11PartUndecimal.values();
		case 12:
			baseT12Reads.increment();
			return T12PartUncial.values();
		case 16:
			baseT16Reads.increment();
			return T16PartHex.values();
		case 20:
			baseT20Reads.increment();
			return T20PartScore.values();
		case 60:
			baseT60Reads.increment();
			return T60PartSexagesimal.values();
		default:
			throw new IllegalArgumentException("Unsupported base: "+base);
		}
	}
}
