package love.distributedrebirth.numberxd.base2t;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnPackageInfoʸᴰ;
import love.distributedrebirth.bassboonyd.jmx.BooleanAttributeᴶᴹˣ;
import love.distributedrebirth.bassboonyd.jmx.MBeanStoreKeyᴶᴹˣ;
import love.distributedrebirth.bassboonyd.jmx.DefaultEnumInstanceᴶᴹˣ;
import love.distributedrebirth.bassboonyd.jmx.GuageCounterᴶᴹˣ;
import love.distributedrebirth.bassboonyd.jmx.StringAttributeᴶᴹˣ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartKeyʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartʸᴰ;
import love.distributedrebirth.warpme.core.WaterBucket;
import love.distributedrebirth.warpme.core.WaterCipher;
import love.distributedrebirth.warpme.core.WaterCipherHeart;
import love.distributedrebirth.warpme.core.WaterCipherHeartTone;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnClassInfoʸᴰ(name = "Base2WarpCore", purpose = "The warpcore writer and armor manager.")
@BãßBȍőnPackageInfoʸᴰ(name = "love.distributedrebirth.numberxd")
public enum Base2WarpCore implements DefaultEnumInstanceᴶᴹˣ<Base2WarpCore,MBeanStoreKeyᴶᴹˣ> {
	
	INSTANCE;
	
	private final BooleanAttributeᴶᴹˣ armedWarpCipherLock;
	private final StringAttributeᴶᴹˣ armedWarpWaterName;
	private final StringAttributeᴶᴹˣ armedWarpWaterDesc;
	private final GuageCounterᴶᴹˣ warpCoreValidates;
	private final GuageCounterᴶᴹˣ warpCoreReads;
	private final GuageCounterᴶᴹˣ warpCoreWrites;
	private final BãßBȍőnCoffinOpenʸᴰ<MBeanStoreKeyᴶᴹˣ> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<MBeanStoreKeyᴶᴹˣ> GET_BBC() { return BBC; }
	
	private Base2WarpCore() {
		BBC.BOON_INIT(this);
		BȍőnJmxInit(MBeanStoreKeyᴶᴹˣ.JMX);
		warpCoreReads = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "warpCoreReads", "The amount of warpcore reads.");
		warpCoreWrites = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "warpCoreWrites", "The amount of warpcore writes.");
		warpCoreValidates = BȍőnJmxInitGuageCounter(MBeanStoreKeyᴶᴹˣ.JMX, "warpCoreValidates", "The amount of warpcore validates.");
		armedWarpWaterName = BȍőnJmxInitStringAttribute(MBeanStoreKeyᴶᴹˣ.JMX, "armedWarpWaterName", "The armed water cipher name.");
		armedWarpWaterName.setValueString("default");
		armedWarpWaterDesc = BȍőnJmxInitStringAttribute(MBeanStoreKeyᴶᴹˣ.JMX, "armedWarpWaterDesc", "The armed water cipher description.");
		armedWarpWaterDesc.setValueString("Current active cipher.");
		armedWarpCipherLock = BȍőnJmxInitBooleanAttribute(MBeanStoreKeyᴶᴹˣ.JMX, "armedWarpCipherLock", "Is the water cipher locked.");
		armedWarpCipherLock.setValueBoolean(false);
	}
	
	public void BãßLockWarpCipher(Consumer<String> logHandler) {
		armedWarpCipherLock.setValueBoolean(true);
		for (int base:Base2PartsFactory.INSTANCE.BãßBases()) {
			BãßBȍőnPartʸᴰ<?>[] parts = Base2PartsFactory.INSTANCE.BãßBuildPartsByBase(base);
			BãßBȍőnCoffinOpenʸᴰ.lockCoffin(parts[0], logHandler);
		}
	}
	
	public WaterBucket BãßCurrentWarpCore() {
		warpCoreReads.increment();
		WaterCipher warpCipher = new WaterCipher();
		warpCipher.setName(armedWarpWaterName.getValueString());
		warpCipher.setDescription(armedWarpWaterDesc.getValueString());
		for (int base:Base2PartsFactory.INSTANCE.BãßBases()) {
			WaterCipherHeart heart = new WaterCipherHeart();
			BãßBȍőnPartʸᴰ<?>[] bases = Base2PartsFactory.INSTANCE.BãßBuildPartsByBase(base);
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
	
	public void BãßValidateWarpCore(WaterBucket warpBucket) {
		warpCoreValidates.increment();
		Map<String,String> chinaKey = new HashMap<>();
		Map<String,String> chinaValue = new HashMap<>();
		for (WaterCipherHeart heart:warpBucket.theWater().getCipherHearts()) {
			BãßBȍőnPartʸᴰ<?>[] bases = Base2PartsFactory.INSTANCE.BãßBuildPartsByBase(heart.getBass());
			Map<String, BãßBȍőnPartʸᴰ<?>> baseParts = new HashMap<>();
			for (BãßBȍőnPartʸᴰ<?> base:bases) {
				baseParts.put(base.BȍőnNaam(), base);
			}
			for (WaterCipherHeartTone tone:heart.getHeartTones()) {
				if(chinaKey.containsKey(tone.getChinaKey())) {
					throw new IllegalArgumentException("Duplicate chinaKey: "+tone.getChinaKey());
				}
				if(chinaValue.containsKey(tone.getChinaValue())) {
					throw new IllegalArgumentException("Duplicate chinaValue: "+tone.getChinaValue());
				}
				chinaKey.put(tone.getChinaKey(), tone.getDialTone());
				chinaValue.put(tone.getChinaValue(), tone.getDialTone());
			}
		}
	}
	
	public void BãßArmWarpCore(WaterBucket warpBucket) {
		BãßValidateWarpCore(warpBucket);
		warpCoreWrites.increment();
		armedWarpWaterName.setValueString(warpBucket.theWater().getName());
		armedWarpWaterDesc.setValueString(warpBucket.theWater().getDescription());
		for (WaterCipherHeart heart:warpBucket.theWater().getCipherHearts()) {
			BãßBȍőnPartʸᴰ<?>[] bases = Base2PartsFactory.INSTANCE.BãßBuildPartsByBase(heart.getBass());
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
