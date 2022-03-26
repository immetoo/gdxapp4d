package love.distributedrebirth.gdxapp4d.vrgem4;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceReference;

import com.badlogic.gdx.Gdx;

import imgui.type.ImBoolean;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.jmx.DefaultEnumBaseᴶᴹˣ;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxBootArgs;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxBootReadyListener;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxFont;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxLog;
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
import love.distributedrebirth.gdxapp4d.vrgem4.service.VrGem4Unicode4DService;
import love.distributedrebirth.numberxd.base2t.Base2PartsFactory;
import love.distributedrebirth.numberxd.base2t.Base2Terminator;
import love.distributedrebirth.numberxd.base2t.Base2WarpCore;
import love.distributedrebirth.unicode4d.BaseGlyphSet;
import love.distributedrebirth.warpme.ship.WaterShipOcean;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class GDXAppVrGem4Activator implements BundleActivator {
	
	private static final int VIEW_SLEEP_TIME = 1234;
	
	private ImGuiSetup imguiSetup = new ImGuiSetup();
	
	@Override
	public void stop(final BundleContext context) {
		Gdx.app.postRunnable(new Runnable() {
			@Override
			public void run() {
				imguiSetup.dispose();
			}
		});
	}
	
	@Override
	public void start(final BundleContext context) {
		try {
			Thread.sleep(VIEW_SLEEP_TIME);
		} catch (InterruptedException ignored) {
		}
		
		ServiceReference<SystemGdxLog> loggerRef = context.getServiceReference(SystemGdxLog.class);
		SystemGdxLog logger = context.getService(loggerRef);
		
		ServiceReference<SystemGdxTerminal> termRef = context.getServiceReference(SystemGdxTerminal.class);
		SystemGdxTerminal terminal = context.getService(termRef);
		
		ServiceReference<SystemGdxFont> gdxFontRef = context.getServiceReference(SystemGdxFont.class);
		SystemGdxFont gdxFont = context.getService(gdxFontRef);
		
		ServiceReference<SystemWarpShip> systemWarpShipRef = context.getServiceReference(SystemWarpShip.class);
		SystemWarpShip systemWarpShip = context.getService(systemWarpShipRef);
		
		ServiceReference<SystemGdxBootArgs> bootArgsRef = context.getServiceReference(SystemGdxBootArgs.class);
		SystemGdxBootArgs bootArgs = context.getService(bootArgsRef);
		
		logger.info(this, "Booting");
		GDXAppVrGem4BootScreen bootScreen = createBootScreen(terminal, gdxFont);
		
		printBootLogo(bootScreen);
		lockCoffins(bootScreen);
		startImGui(bootScreen, context, systemWarpShip);
		startWarpCore(bootScreen, bootArgs);
		
		VrGem4DeskAppServiceImpl deskAppService = new VrGem4DeskAppServiceImpl();
		context.registerService(VrGem4DeskAppService.class.getName(), deskAppService, new Hashtable<String, String>());
		
		startTerminalScreens(bootScreen, bootArgs, terminal, deskAppService);
		
		List<SystemWarpSea> registratedSeas = new ArrayList<>();
		int result = 0;
		try {
			for (WaterShipOcean ocean:systemWarpShip.getWarpShip().theShip().getShipOceans()) {
				result = systemWarpShip.loadWaterOcean(context, registratedSeas, ocean.getSea(), v -> bootScreen.bootLine(v));
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
			systemWarpShip.loadBundles(context, registratedSeas);
		} catch (BundleException e) {
			e.printStackTrace();
			bootScreen.bootLine("ERROR: "+e.getMessage());
			return;
		}
		bootArgs.addBootReadyListener(new SystemGdxBootReadyListener() {
			@Override
			public void bootCompleted() {
				Gdx.app.postRunnable(new Runnable() {
					@Override
					public void run() {
						terminal.selectScreen(ScreenDesktop1.class);
						terminal.disposeScreen(bootScreen);
					}
				});
				logger.info(this, "Boot done");
			}
		});
		
		VrGem4Unicode4DServiceImpl unicodeService = new VrGem4Unicode4DServiceImpl();
		unicodeService.init(context, systemWarpShip, (v) -> bootScreen.bootLine(v));
		context.registerService(VrGem4Unicode4DService.class.getName(), unicodeService, new Hashtable<String, String>());
		
		startBundles(bootScreen);
	}
	
	private GDXAppVrGem4BootScreen createBootScreen(SystemGdxTerminal terminal, SystemGdxFont gdxFont) {
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
		return bootScreen;
	}
	
	private void printBootLogo(GDXAppVrGem4BootScreen bootScreen) {
		bootScreen.bootLine("==========================");
		bootScreen.bootLine("     @Ω仙⁴ ˧꜏⋇꜊꜔ ⁴ﷲΩ@    ");
		bootScreen.bootLine("        ©Δ∞ 仙上主天       ");
		bootScreen.bootLine("בְּרֵאשִׁית :o: יְסוֺד :o: יִשְׂרָאֵל");
		bootScreen.bootLine("==========================");
		bootScreen.bootLine("Boot: MSX⁴ - TOS⁴ - vrGEM⁴");
	}
	
	private void lockCoffins(GDXAppVrGem4BootScreen bootScreen) {
		// ref to init
		for (DefaultEnumBaseᴶᴹˣ<?,?> coffin:coffinInstances()) {
			BãßBȍőnCoffinOpenʸᴰ.lockCoffin(coffin, v -> bootScreen.bootLine(v));
		}
		bootScreen.bootLine("BãßBȍőnCoffinʸᴰ init done.");
	}
	
	private void startImGui(GDXAppVrGem4BootScreen bootScreen, BundleContext context, SystemWarpShip systemWarpShip) {
		List<File> fonts = systemWarpShip.searchMagic(context, "application/x-font-ttf-plane0");
		bootScreen.bootLine("ImGui Setup");
		ImBoolean imLoaded = new ImBoolean(false);
		Gdx.app.postRunnable(new Runnable() {
			@Override
			public void run() {
				imguiSetup.init(fonts, v -> bootScreen.bootLine(v));
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
	}
	
	private void startWarpCore(GDXAppVrGem4BootScreen bootScreen, SystemGdxBootArgs bootArgs) {
		if (!bootArgs.isWarpCoreNoLock()) {
			bootScreen.bootLine("warpcore-lock: BãßLockWarpCipher");
			Base2WarpCore.INSTANCE.BãßLockWarpCipher(v -> {});
		} else {
			bootScreen.bootLine("warpcore-nolock: requested");
		}
	}
	
	private void startTerminalScreens(GDXAppVrGem4BootScreen bootScreen, SystemGdxBootArgs bootArgs, SystemGdxTerminal terminal, VrGem4DeskAppServiceImpl deskAppService) {
		bootScreen.bootLine("vrGEM⁴: add terminal screens");
		Gdx.app.postRunnable(new Runnable() {
			@Override
			public void run() {
				terminal.registrateScreen(new ScreenDesktop1(bootArgs, terminal, deskAppService));
				terminal.registrateScreen(new ScreenDesktop2(bootArgs, terminal, deskAppService));
				terminal.registrateScreen(new ScreenDesktop3(bootArgs, terminal, deskAppService));
				terminal.registrateScreen(new ScreenDesktop4(bootArgs, terminal, deskAppService));
				terminal.registrateScreen(new ScreenCredits(terminal));
				terminal.registrateScreen(new ScreenHelp(terminal));
				terminal.registrateScreen(new ScreenIntroMission(terminal));
			}
		});
		try {
			Thread.sleep(100);
		} catch (InterruptedException ignored) {
		}
	}
	
	private void startBundles(GDXAppVrGem4BootScreen bootScreen) {
		try {
			Thread.sleep(VIEW_SLEEP_TIME);
		} catch (InterruptedException ignored) {
		}
		bootScreen.bootLine("vrGEM4: Init bundles...");
	}
	
	//TODO: add layer or ?? private <T extends BãßBȍőnCoffinStoreʸᴰ<?>,DefaultAuthorInfoʸᴰ> T[] storeInstances() {
	@SuppressWarnings("unchecked")
	private <T extends DefaultEnumBaseᴶᴹˣ<?,?>> T[] coffinInstances() {
		return (T[]) new DefaultEnumBaseᴶᴹˣ[] {
				BaseGlyphSet.values()[0],
				Base2Terminator.INSTANCE,
				Base2PartsFactory.INSTANCE,
				Base2WarpCore.INSTANCE
		};
	}
}
