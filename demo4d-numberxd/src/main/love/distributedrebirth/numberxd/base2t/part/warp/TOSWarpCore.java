package love.distributedrebirth.numberxd.base2t.part.warp;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnEnumInstanceʸᴰ;
import love.distributedrebirth.numberxd.base2t.BasePartFactory;
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
	
	public WarpCipher BãßSaveWarpCipher() {
		WarpCipher warpCore = new WarpCipher();
		if (armedWarpCipherName == null) {
			warpCore.setCipherName("default");
		} else {
			warpCore.setCipherName(armedWarpCipherName);
		}
		if (armedWarpCipherDescription == null) {
			warpCore.setCipherName("Current active cipher.");
		} else {
			warpCore.setCipherDescription(armedWarpCipherDescription);
		}
		for (int base:BasePartFactory.INSTANCE.BãßBases()) {
			WarpCipherHeart heart = new WarpCipherHeart();
			BãßBȍőnPartʸᴰ<?>[] bases = BasePartFactory.INSTANCE.BãßBuildPartsByBase(base);
			heart.setPartKey(bases[0].BȍőnNaamI18N());
			for (BãßBȍőnPartʸᴰ<?> part:bases) {
				WarpCipherHeartCore core = new WarpCipherHeartCore();
				core.setIdentifierTone(part.BȍőnIdentifierTone());
				core.setChinaKey(part.BȍőnChinaKey());
				core.setChinaValue(part.BȍőnChinaValue());
				heart.getHeartCores().add(core);
			}
			warpCore.getCipherHearts().add(heart);
		}
		return warpCore;
	}
	
	public void BãßLoadWarpCipher(WarpCipher warpCore) {
		armedWarpCipherName = warpCore.getCipherName();
		armedWarpCipherDescription = warpCore.getCipherDescription();
		// TODO: load warpcore
	}
}
