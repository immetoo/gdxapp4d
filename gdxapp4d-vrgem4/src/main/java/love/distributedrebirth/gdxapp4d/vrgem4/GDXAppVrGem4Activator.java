package love.distributedrebirth.gdxapp4d.vrgem4;

import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.badlogic.gdx.Gdx;

import imgui.type.ImBoolean;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.jmx.DefaultEnumBaseᴶᴹˣ;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemWarpBootArgs;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemWarpTerminal;
import love.distributedrebirth.gdxapp4d.vrgem4.screen.ScreenCredits;
import love.distributedrebirth.gdxapp4d.vrgem4.screen.ScreenDesktop1;
import love.distributedrebirth.gdxapp4d.vrgem4.screen.ScreenDesktop2;
import love.distributedrebirth.gdxapp4d.vrgem4.screen.ScreenDesktop3;
import love.distributedrebirth.gdxapp4d.vrgem4.screen.ScreenDesktop4;
import love.distributedrebirth.gdxapp4d.vrgem4.screen.ScreenHelp;
import love.distributedrebirth.gdxapp4d.vrgem4.screen.ScreenIntro;
import love.distributedrebirth.gdxapp4d.vrgem4.screen.ScreenIntroMission;
import love.distributedrebirth.numberxd.base2t.Base2PartsFactory;
import love.distributedrebirth.numberxd.base2t.Base2Terminator;
import love.distributedrebirth.numberxd.base2t.part.warp.TOSWarpCore;
import love.distributedrebirth.numberxd.glyph.BaseGlyphSet;
import love.distributedrebirth.warpme.core.WaterBucket;
import love.distributedrebirth.warpme.core.WaterBucketDriver;

public class GDXAppVrGem4Activator implements BundleActivator {
	
//	private static final Logger LOG = LoggerFactory.getLogger(GDXAppVrGem4Activator.class);
	
	@Override
	public void stop(final BundleContext context) {
	}
	
	@Override
	public void start(final BundleContext context) {
//		LOG.info("GDXAppVrGem4Activator started");
		
		ServiceReference<SystemWarpTerminal> termRef = context.getServiceReference(SystemWarpTerminal.class);
		SystemWarpTerminal terminal = context.getService(termRef);
		
		GDXAppVrGem4BootScreen bootScreen = new GDXAppVrGem4BootScreen();
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
		bootScreen.bootLine("vrGEM4 Booting...");
		
		// ref to init
//		LOG.debug("BãßBȍőnCoffinʸᴰ init......");
		for (DefaultEnumBaseᴶᴹˣ<?,?> coffin:coffinInstances()) {
			BãßBȍőnCoffinOpenʸᴰ.lockCoffin(coffin);
		}
		bootScreen.bootLine("BãßBȍőnCoffinʸᴰ init done.");
		
		bootScreen.bootLine("ImGui Setup");
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
		
		
		ServiceReference<SystemWarpBootArgs> bootArgsRef = context.getServiceReference(SystemWarpBootArgs.class);
		SystemWarpBootArgs bootArgs = context.getService(bootArgsRef);
		List<String> args = bootArgs.getBootArgs();
		
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
		if (!args.contains("warpcore-nolock")) {
			bootScreen.bootLine("warpcore-lock: BãßLockWarpCipher");
			TOSWarpCore.INSTANCE.BãßLockWarpCipher();
		} else {
			bootScreen.bootLine("warpcore-nolock: requested");
		}
		
		if (args.contains("full-screen")) {
			System.out.println("full-screen: requested");
			Gdx.app.postRunnable(new Runnable() {
				@Override
				public void run() {
					Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
				}
			});
		}
		
		GDXAppVrGem4.INSTANCE.init(args, terminal);
		
		Gdx.app.postRunnable(new Runnable() {
			@Override
			public void run() {
				terminal.registrateScreen(new ScreenIntro());
				terminal.registrateScreen(new ScreenIntroMission());
				terminal.registrateScreen(new ScreenDesktop1());
				terminal.registrateScreen(new ScreenDesktop2());
				terminal.registrateScreen(new ScreenDesktop3());
				terminal.registrateScreen(new ScreenDesktop4());
				terminal.registrateScreen(new ScreenCredits());
				terminal.registrateScreen(new ScreenHelp());
				
				if (args.contains("intro-skip")) {
					System.out.println("intro-skip: requested");
					terminal.selectScreen(ScreenDesktop1.class);
//					music.play(MusicSongType.BACKGROUND);
				} else {
					terminal.selectScreen(ScreenIntro.class);
				}
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
