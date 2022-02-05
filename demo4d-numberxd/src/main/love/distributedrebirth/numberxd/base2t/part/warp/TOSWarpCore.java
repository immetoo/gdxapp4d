package love.distributedrebirth.numberxd.base2t.part.warp;

import java.util.HashMap;
import java.util.Map;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnEnumInstanceʸᴰ;
import love.distributedrebirth.numberxd.base2t.BasePartFactory;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartKeyʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.BãßBȍőnPartʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public enum TOSWarpCore implements BãßBȍőnEnumInstanceʸᴰ<TOSWarpCore> {
	
	INSTANCE;
	
	private String armedWarpCipherName;
	private String armedWarpCipherDescription;
	
	public void BãßLockWarpCipher() {
		for (int base:BasePartFactory.INSTANCE.BãßBases()) {
			for (BãßBȍőnPartʸᴰ<?> part:BasePartFactory.INSTANCE.BãßBuildPartsByBase(base)) {
				BãßBȍőnCoffinOpenʸᴰ.class.cast(part.GET_BBC()).LOCK_COFFIN();
			}
		}
	}
	
	public WaterBucket BãßCurrentWarpCore() {
		WaterCipher warpCipher = new WaterCipher();
		if (armedWarpCipherName == null) {
			warpCipher.setName("default");
		} else {
			warpCipher.setName(armedWarpCipherName);
		}
		if (armedWarpCipherDescription == null) {
			warpCipher.setName("Current active cipher.");
		} else {
			warpCipher.setDescription(armedWarpCipherDescription);
		}
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
		armedWarpCipherName = warpBucket.theWater().getName();
		armedWarpCipherDescription = warpBucket.theWater().getDescription();
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
