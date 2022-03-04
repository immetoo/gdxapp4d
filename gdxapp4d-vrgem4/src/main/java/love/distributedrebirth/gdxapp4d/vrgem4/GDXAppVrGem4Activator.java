package love.distributedrebirth.gdxapp4d.vrgem4;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.badlogic.gdx.Gdx;

import imgui.type.ImBoolean;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.jmx.DefaultEnumBaseᴶᴹˣ;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxBootFactory;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxBootArgs;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxFont;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemWarpShip;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxTerminal;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemWarpSea;
import love.distributedrebirth.gdxapp4d.vrgem4.screen.ScreenCredits;
import love.distributedrebirth.gdxapp4d.vrgem4.screen.ScreenDesktop1;
import love.distributedrebirth.gdxapp4d.vrgem4.screen.ScreenDesktop2;
import love.distributedrebirth.gdxapp4d.vrgem4.screen.ScreenDesktop3;
import love.distributedrebirth.gdxapp4d.vrgem4.screen.ScreenDesktop4;
import love.distributedrebirth.gdxapp4d.vrgem4.screen.ScreenHelp;
import love.distributedrebirth.gdxapp4d.vrgem4.screen.ScreenIntroMission;
import love.distributedrebirth.gdxapp4d.vrgem4.service.VrGem4DeskAppService;
import love.distributedrebirth.numberxd.base2t.Base2PartsFactory;
import love.distributedrebirth.numberxd.base2t.Base2Terminator;
import love.distributedrebirth.numberxd.base2t.part.warp.TOSWarpCore;
import love.distributedrebirth.numberxd.glyph.BaseGlyphSet;
import love.distributedrebirth.warpme.sea.WaterSeaMagic;
import love.distributedrebirth.warpme.ship.WaterShipOcean;

public class GDXAppVrGem4Activator implements BundleActivator {
	
	@Override
	public void stop(final BundleContext context) {
	}
	
	@Override
	public void start(final BundleContext context) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ignored) {
		}
		
		ServiceReference<SystemGdxTerminal> termRef = context.getServiceReference(SystemGdxTerminal.class);
		SystemGdxTerminal terminal = context.getService(termRef);
		
		ServiceReference<SystemGdxFont> gdxFontRef = context.getServiceReference(SystemGdxFont.class);
		SystemGdxFont gdxFont = context.getService(gdxFontRef);
		
		GDXAppVrGem4BootScreen bootScreen = new GDXAppVrGem4BootScreen(gdxFont.getFont());
		Gdx.app.postRunnable(new Runnable() {
			@Override
			public void run() {
				bootScreen.create();
				terminal.registrateScreen(bootScreen);
				terminal.selectScreen(GDXAppVrGem4BootScreen.class);
			}
		});
		try {
			Thread.sleep(100);
		} catch (InterruptedException ignored) {
		}
		
		bootScreen.bootLine("==========================");
		bootScreen.bootLine("     @Ω仙⁴ ˧꜏⋇꜊꜔ ⁴ﷲΩ@    ");
		bootScreen.bootLine("        ©Δ∞ 仙上主天       ");
		bootScreen.bootLine("בְּרֵאשִׁית :o: יְסוֺד :o: יִשְׂרָאֵל");
		bootScreen.bootLine("==========================");
		bootScreen.bootLine("Boot: vrGEM⁴ - TOS⁴ - MSX⁴");
		
		// ref to init
		for (DefaultEnumBaseᴶᴹˣ<?,?> coffin:coffinInstances()) {
			BãßBȍőnCoffinOpenʸᴰ.lockCoffin(coffin, v -> bootScreen.bootLine(v));
		}
		bootScreen.bootLine("BãßBȍőnCoffinʸᴰ init done.");
		
		bootScreen.bootLine("ImGui Setup");
		try {
			Thread.sleep(100);
		} catch (InterruptedException ignored) {
		}
		ImBoolean imLoaded = new ImBoolean(false);
		Gdx.app.postRunnable(new Runnable() {
			@Override
			public void run() {
				ImGuiSetup.init();
				imLoaded.set(true);
			}
		});
		while (!imLoaded.get()) { 
			try {
				Thread.sleep(100);
			} catch (InterruptedException ignored) {
			}
		}
		bootScreen.bootLine("ImGui Loaded");
		
		ServiceReference<SystemGdxBootArgs> bootArgsRef = context.getServiceReference(SystemGdxBootArgs.class);
		SystemGdxBootArgs bootArgs = context.getService(bootArgsRef);
		
		/*
		bootScreen.bootLine("warpcore: Check request");
		try {
			if (args.contains("warpcore-load")) {
				bootScreen.bootLine("warpcore-load: requested");
				WaterBucket bucket = WaterBucketDriver.newInstance().createReader().readFile("./warpcore.xml");
				TOSWarpCore.INSTANCE.BãßArmWarpCore(bucket);
			}
			if (args.contains("warpcore-save")) {
				bootScreen.bootLine("warpcore-save: requested");
				WaterBucket bucket = TOSWarpCore.INSTANCE.BãßCurrentWarpCore();
				WaterBucketDriver.newInstance().createWriter().writeFile(bucket, "./warpcore.xml");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		*/
		if (!bootArgs.isWarpCoreNoLock()) {
			bootScreen.bootLine("warpcore-lock: BãßLockWarpCipher");
			TOSWarpCore.INSTANCE.BãßLockWarpCipher(v -> {});
		} else {
			bootScreen.bootLine("warpcore-nolock: requested");
		}
		
		/*
		if (args.contains("full-screen")) {
			bootScreen.bootLine("full-screen: requested");
			Gdx.app.postRunnable(new Runnable() {
				@Override
				public void run() {
					Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
				}
			});
		}
		*/
		
		bootScreen.bootLine("vrGEM⁴: init");
		GDXAppVrGem4.INSTANCE.init(terminal);
		
		
		VrGem4DeskAppService deskAppService = new VrGem4DeskAppServiceImpl();
		context.registerService(VrGem4DeskAppService.class.getName(), deskAppService, new Hashtable<String, String>());
		
		bootScreen.bootLine("terminal: added screens");
		Gdx.app.postRunnable(new Runnable() {
			@Override
			public void run() {
				terminal.registrateScreen(new ScreenDesktop1(bootArgs, deskAppService));
				terminal.registrateScreen(new ScreenDesktop2(bootArgs, deskAppService));
				terminal.registrateScreen(new ScreenDesktop3(bootArgs, deskAppService));
				terminal.registrateScreen(new ScreenDesktop4(bootArgs, deskAppService));
				terminal.registrateScreen(new ScreenCredits());
				terminal.registrateScreen(new ScreenHelp());
				terminal.registrateScreen(new ScreenIntroMission());
			}
		});
		try {
			Thread.sleep(100);
		} catch (InterruptedException ignored) {
		}
		
		
		ServiceReference<SystemWarpShip> systemWarpShipRef = context.getServiceReference(SystemWarpShip.class);
		SystemWarpShip systemWarpShip = context.getService(systemWarpShipRef);
		
		List<SystemWarpSea> registratedSeas = new ArrayList<>();
		int result = 0;
		try {
			for (WaterShipOcean ocean:systemWarpShip.getWarpShip().theShip().getShipOceans()) {
				result = systemWarpShip.loadWaterOcean(context, ocean.getSea(), v -> bootScreen.bootLine(v), registratedSeas);
			}
		} catch (Exception e) {
			e.printStackTrace();
			bootScreen.bootLine("ERROR: "+e.getMessage());
			return;
		}
		if (result > 0) {
			bootScreen.bootLine("vrGEM4: FAILURE BOOT ABORTED");
			return;
		}
		bootScreen.bootLine("vrGEM4: chains resolved.");
		
		try {
			for (SystemWarpSea service: registratedSeas) {
				String key = service.getWarpKey();
				File waterHome = service.getWarpHome();
				for (WaterSeaMagic magic:service.getWarpSea().theWater().getSeaMagics()) {
					if ("application/vnd.osgi.bundle".equals(magic.getMime())) {
						magic.setMime("application/vnd.osgi.bundle.loaded"); // TODO: HACK for now to not load again
						String overrideBundleKey = key + "." + magic.getFile();
						String overrideBundle = bootArgs.getLocalOverrides().getProperty(overrideBundleKey);
						if (overrideBundle == null) {
							SystemGdxBootFactory.installAndStartBundles(context, "reference:file:"+waterHome.getAbsolutePath()+"/"+magic.getFile());
						} else {
							SystemGdxBootFactory.installAndStartBundles(context, "reference:file:"+overrideBundle);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			bootScreen.bootLine("ERROR: "+e.getMessage());
			return;
		}
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ignored) {
		}
		Gdx.app.postRunnable(new Runnable() {
			@Override
			public void run() {
				terminal.selectScreen(ScreenDesktop1.class);
				terminal.disposeScreen(bootScreen);
			}
		});
	}
	
	//TODO: add layer or ?? private <T extends BãßBȍőnCoffinStoreʸᴰ<?>,DefaultAuthorInfoʸᴰ> T[] storeInstances() {
	@SuppressWarnings("unchecked")
	private <T extends DefaultEnumBaseᴶᴹˣ<?,?>> T[] coffinInstances() {
		return (T[]) new DefaultEnumBaseᴶᴹˣ[] {
				GDXAppVrGem4.INSTANCE,
				BaseGlyphSet.values()[0],
				Base2Terminator.INSTANCE,
				Base2PartsFactory.INSTANCE,
				TOSWarpCore.INSTANCE
		};
	}
}
