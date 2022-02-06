package love.distributedrebirth.numberxd.base2t.part.warp;

import java.util.HashMap;
import java.util.Map;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnEnumInstanceʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnPackageInfoʸᴰ;
import love.distributedrebirth.bassboonyd.jmx.BooleanAttributeᴶᴹˣ;
import love.distributedrebirth.bassboonyd.jmx.MBeanStoreKeyᴶᴹˣ;
import love.distributedrebirth.bassboonyd.jmx.BãßBȍőnEnumJmxʸᴰ;
import love.distributedrebirth.bassboonyd.jmx.GuageCounterᴶᴹˣ;
import love.distributedrebirth.bassboonyd.jmx.StringAttributeᴶᴹˣ;
import love.distributedrebirth.numberxd.base2t.BasePartFactory;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartKeyʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnClassInfoʸᴰ(name = "TOSWarpCore", purpose = "The warpcore writer and armor manager.")
@BãßBȍőnPackageInfoʸᴰ(name = "love.distributedrebirth.numberxd")
public enum TOSWarpCore implements BãßBȍőnEnumInstanceʸᴰ<TOSWarpCore>,BãßBȍőnEnumJmxʸᴰ<TOSWarpCore,MBeanStoreKeyᴶᴹˣ> {
	
	INSTANCE;
	
	private final BãßBȍőnCoffinOpenʸᴰ<MBeanStoreKeyᴶᴹˣ> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<MBeanStoreKeyᴶᴹˣ> GET_BBC() { return BBC; }
	
	private final BooleanAttributeᴶᴹˣ armedWarpCipherLock;
	private final StringAttributeᴶᴹˣ armedWarpWaterName;
	private final StringAttributeᴶᴹˣ armedWarpWaterDesc;
	private final GuageCounterᴶᴹˣ warpCoreReads;
	private final GuageCounterᴶᴹˣ warpCoreWrites;
	
	private TOSWarpCore() {
		BBC.BOON_INIT(this);
		BȍőnJmxInit(MBeanStoreKeyᴶᴹˣ.JMX);
		warpCoreReads = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "warpCoreReads", "The amount of warpcore reads.");
		warpCoreWrites = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "warpCoreWrites", "The amount of warpcore writes.");
		armedWarpWaterName = BȍőnJmxInitStringAttribute(MBeanStoreKeyᴶᴹˣ.JMX, "armedWarpWaterName", "The armed water cipher name.");
		armedWarpWaterName.setValueString("default");
		armedWarpWaterDesc = BȍőnJmxInitStringAttribute(MBeanStoreKeyᴶᴹˣ.JMX, "armedWarpWaterDesc", "The armed water cipher description.");
		armedWarpWaterDesc.setValueString("Current active cipher.");
		armedWarpCipherLock = BȍőnJmxInitBooleanAttribute(MBeanStoreKeyᴶᴹˣ.JMX, "armedWarpCipherLock", "Is the water cipher locked.");
		armedWarpCipherLock.setValueBoolean(false);
	}
	
	public void BãßLockWarpCipher() {
		armedWarpCipherLock.setValueBoolean(true);
		for (int base:BasePartFactory.INSTANCE.BãßBases()) {
			for (BãßBȍőnPartʸᴰ<?> part:BasePartFactory.INSTANCE.BãßBuildPartsByBase(base)) {
				BãßBȍőnCoffinOpenʸᴰ.class.cast(part.GET_BBC()).LOCK_COFFIN();
			}
		}
	}
	
	public WaterBucket BãßCurrentWarpCore() {
		warpCoreReads.increment();
		WaterCipher warpCipher = new WaterCipher();
		warpCipher.setName(armedWarpWaterName.getValueString());
		warpCipher.setDescription(armedWarpWaterDesc.getValueString());
		for (int base:BasePartFactory.INSTANCE.BãßBases()) {
			WaterCipherHeart heart = new WaterCipherHeart();
			BãßBȍőnPartʸᴰ<?>[] bases = BasePartFactory.INSTANCE.BãßBuildPartsByBase(base);
			heart.setBass(bases[0].BãßInstances().length);
			for (BãßBȍőnPartʸᴰ<?> part:bases) {
				WaterCipherHeartTone tone = new WaterCipherHeartTone();
				tone.setPart(part.BȍőnNaam());
				tone.setDialTone(part.BȍőnDialTone());
				tone.setChinaKey(part.BȍőnChinaKey());
				tone.setChinaValue(part.BȍőnChinaValue());
				heart.addHeartTone(tone);
			}
			warpCipher.getCipherHearts().add(heart);
		}
		WaterBucket bucket = new WaterBucket();
		bucket.fillWater(warpCipher);
		return bucket;
	}
	
	public void BãßArmWarpCore(WaterBucket warpBucket) {
		warpCoreWrites.increment();
		armedWarpWaterName.setValueString(warpBucket.theWater().getName());
		armedWarpWaterDesc.setValueString(warpBucket.theWater().getDescription());
		for (WaterCipherHeart heart:warpBucket.theWater().getCipherHearts()) {
			BãßBȍőnPartʸᴰ<?>[] bases = BasePartFactory.INSTANCE.BãßBuildPartsByBase(heart.getBass());
			Map<String, BãßBȍőnPartʸᴰ<?>> baseParts = new HashMap<>();
			for (BãßBȍőnPartʸᴰ<?> base:bases) {
				baseParts.put(base.BȍőnNaam(), base);
			}
			for (WaterCipherHeartTone tone:heart.getHeartTones()) {
				BãßBȍőnPartʸᴰ<?> bassTone = baseParts.get(tone.getPart());
				@SuppressWarnings("unchecked")
				BãßBȍőnCoffinOpenʸᴰ<BãßBȍőnPartKeyʸᴰ> coffin = BãßBȍőnCoffinOpenʸᴰ.class.cast(bassTone.GET_BBC());
				coffin.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.DIAL_TONE, tone.getDialTone());
				coffin.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_KEY, tone.getChinaKey());
				coffin.PUT_OBJ(BãßBȍőnPartKeyʸᴰ.CHINA_VALUE, tone.getChinaValue());
			}
		}
	}
}
