package love.distributedrebirth.gdxapp4d.tos4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.function.Consumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.x4o.xml.io.X4OConnectionException;
import org.xml.sax.SAXException;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationLogger;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemWarpBase;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxBootArgs;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxFont;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxLog;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemWarpSea;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemWarpShip;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxTerminal;
import love.distributedrebirth.warpme.Warpᵐᵉ;
import love.distributedrebirth.warpme.sea.WaterOcean;
import love.distributedrebirth.warpme.sea.WaterOceanDriver;
import love.distributedrebirth.warpme.sea.WaterSeaChain;
import love.distributedrebirth.warpme.sea.WaterSeaMagic;
import love.distributedrebirth.warpme.ship.WaterDevice;
import love.distributedrebirth.warpme.ship.WaterDeviceDriver;
import net.spookygames.gdx.nativefilechooser.NativeFileChooser;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class GDXAppTos4Activator implements BundleActivator {
	
	private static final Logger LOG = LoggerFactory.getLogger(GDXAppTos4Activator.class);
	private List<String> args;
	private int viewWidth;
	private int viewHeight;
	private NativeFileChooser fileChooser;
	private File hyperdriveHome;
	private File warpshipHome;
	private BitmapFont gdxFont;
	private Properties localOverrides;
	private WaterDevice warpshipDevice;
	private SystemGdxTerminal systemGdxTerminal;
	private List<GDXAppTos4BootListener> listeners = new ArrayList<>();
	
	private static final String SYSTEM_USER_HOME = "user.home";
	private static final String HYPERDRIVE_HOME = "Hyperdrive";
	private static final String WARPSHIP_HOME = "Warpship";
	
	public GDXAppTos4Activator() {
	}
	
	public void BãßInit(List<String> args, int viewWidth, int viewHeight,NativeFileChooser fileChooser, SystemGdxTerminal systemGdxTerminal) {
		this.args = args;
		this.viewWidth = viewWidth;
		this.viewHeight = viewHeight;
		this.fileChooser = fileChooser;
		this.systemGdxTerminal = systemGdxTerminal;
	}
	
	private void fireMessageEvent(String message) {
		for (GDXAppTos4BootListener listener:listeners) {
			listener.bootLine(message);
		}
	}
	
	public void addBootListener(GDXAppTos4BootListener listener) {
		listeners.add(listener);
	}
	
	public void removeBootListener(GDXAppTos4BootListener listener) {
		listeners.remove(listener);
	}
	
	@Override
	public void stop(final BundleContext context) {
		gdxFont.dispose();
	}
	
	@Override
	public void start(final BundleContext context) {
		fireMessageEvent("Mecca System eXtension superscript Four");
		fireMessageEvent("tos4: starting...");
		fireMessageEvent("init-cpus: "+Runtime.getRuntime().availableProcessors());
		fireMessageEvent("free-memory: 0x"+Long.toHexString(Runtime.getRuntime().freeMemory()));
		
		boolean useLocal = args.contains("use-local");
		
		File userHome = new File(System.getProperty(SYSTEM_USER_HOME));
		hyperdriveHome = new File(userHome, HYPERDRIVE_HOME);
		if (!hyperdriveHome.exists()) {
			fireMessageEvent("ERROR: No Hyperdrive home.");
			return;
		}
		warpshipHome = new File(hyperdriveHome, WARPSHIP_HOME);
		if (useLocal) {
			warpshipHome = new File(".");
		}
		if (!warpshipHome.exists()) {
			fireMessageEvent("ERROR: No Warpship home.");
			return;
		}
		File warpShip = new File(warpshipHome, Warpᵐᵉ.WARP_SHIP);
		if (useLocal) {
			warpShip = new File(warpshipHome, "local-ship.xml");
		}
		fireMessageEvent("warp-ship: "+warpShip);
		if (!warpShip.exists()) {
			fireMessageEvent("ERROR: No warp-ship.xml found.");
			return;
		}
		try {
			warpshipDevice = WaterDeviceDriver.newInstance().createReader().readFile(warpShip);
		} catch (Exception e) {
			e.printStackTrace();
			fireMessageEvent("ERROR: "+e.getMessage());
			return;
		}
		fireMessageEvent("warp-engine: "+warpshipDevice.theShip().getName());
		
		localOverrides = new Properties();
		if (useLocal) {
			File localOverride = new File("local-override.xml");
			if (localOverride.exists()) {
				try {
					localOverrides.loadFromXML(new FileInputStream(localOverride));
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				fireMessageEvent("use-local: local-override.xml loaded.");
			} else {
				fireMessageEvent("use-local: local-override.xml not found.");
			}
		}
		
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.characters = FreeTypeFontGenerator.DEFAULT_CHARS + getRangeUnicodeUsed();
		parameter.size = 14;
		Gdx.app.postRunnable(new Runnable() {
			@Override
			public void run() {
				FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font/code-2000.ttf"));
				gdxFont = generator.generateFont(parameter);
			}
		});
		while (gdxFont == null) { 
			try {
				Thread.sleep(100);
			} catch (InterruptedException ignored) {
			}
		}
		fireMessageEvent("gdx-font: "+parameter.characters.length()+" glyphs loaded.");
		
		
		SystemWarpShipImpl systemWarpShip = new SystemWarpShipImpl();
		
		context.registerService(SystemWarpBase.class.getName(), new SystemWarpBaseImpl(), new Hashtable<String, String>());
		context.registerService(SystemWarpShip.class.getName(), systemWarpShip, new Hashtable<String, String>());
		
		SystemGdxLogImpl systemGdxLog = new SystemGdxLogImpl();
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		Gdx.app.setApplicationLogger(systemGdxLog);
		
		context.registerService(SystemGdxFont.class.getName(), new SystemGdxFontImpl(gdxFont), new Hashtable<String, String>());
		context.registerService(SystemGdxLog.class.getName(), systemGdxLog, new Hashtable<String, String>());
		context.registerService(SystemGdxBootArgs.class.getName(), new SystemGdxBootArgsImpl(), new Hashtable<String, String>());
		context.registerService(SystemGdxTerminal.class.getName(), systemGdxTerminal, new Hashtable<String, String>());
		
		int result = 0;
		try {
			result = systemWarpShip.loadWaterOcean(context, warpshipDevice.theShip().getEngine(), v -> fireMessageEvent(v));
		} catch (Exception e) {
			e.printStackTrace();
			fireMessageEvent("ERROR: "+e.getMessage());
			return;
		}
		if (result > 0) {
			fireMessageEvent("tos4: FAILURE BOOT ABORTED");
		} else {
			fireMessageEvent("tos4: chains resolved.");
		}
		try {
			ServiceReference<?>[] refs = context.getServiceReferences( SystemWarpSea.class.getName(), "(warp.sea.name=*)" );
			for (int i=0;i<refs.length;i++) {
				SystemWarpSea service = (SystemWarpSea) context.getService( refs[i] );
				String key = service.getWarpKey();
				File waterHome = service.getWarpHome();
				for (WaterSeaMagic magic:service.getWarpSea().theWater().getSeaMagics()) {
					if ("application/vnd.osgi.bundle".equals(magic.getMime())) {
						String overrideBundleKey = key + "." + magic.getFile();
						String overrideBundle = localOverrides.getProperty(overrideBundleKey);
						if (overrideBundle == null) {
							GDXAppTos4BootFactory.installAndStartBundles(context, "reference:file:"+waterHome.getAbsolutePath()+"/"+magic.getFile());
						} else {
							GDXAppTos4BootFactory.installAndStartBundles(context, "reference:file:"+overrideBundle);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			fireMessageEvent("ERROR: "+e.getMessage());
		}
	}
	
	private static String getRangeUnicodeUsed() {
		StringBuilder buf = new StringBuilder();
		buf.append("©Δ∞ 仙上主天");
		buf.append("BãßBȍőnAuthorInfoʸᴰ");
		for (int c=0x0100;c<=0x0200;c++) {
			buf.append(""+(char)c);
		}
		return buf.toString();
	}
	
	public class SystemWarpSeaImpl implements SystemWarpSea {
		
		private final String warpKey;
		private final File warpHome;
		private final WaterOcean warpSea;
		
		public SystemWarpSeaImpl(String warpKey, File warpHome, WaterOcean warpSea) {
			this.warpKey = warpKey;
			this.warpHome = warpHome;
			this.warpSea = warpSea;
		}
		
		@Override
		public String getWarpKey() {
			return warpKey;
		}
		
		@Override
		public File getWarpHome() {
			return warpHome;
		}
		
		@Override
		public WaterOcean getWarpSea() {
			return warpSea;
		}
	}
	
	public class SystemWarpBaseImpl implements SystemWarpBase {
		
		@Override
		public File getHyperdriveHome() {
			return hyperdriveHome;
		}

		@Override
		public File getWarpshipHome() {
			return warpshipHome;
		}
		
	}
	
	public class SystemGdxBootArgsImpl implements SystemGdxBootArgs {
		
		@Override
		public boolean isWarpCoreNoLock() {
			return args.contains("warpcore-nolock");
		}
		
		@Override
		public int getWindowWidth() {
			return viewWidth;
		}

		@Override
		public int getWindowHeight() {
			return viewHeight;
		}
		
		@Override
		public NativeFileChooser getFileChooser() {
			return fileChooser;
		}
	}
	
	public class SystemWarpShipImpl implements SystemWarpShip {
		
		@Override
		public WaterDevice getWarpShip() {
			return warpshipDevice;
		}

		@Override
		public int loadWaterOcean(BundleContext context, String key, Consumer<String> logger)
				throws IOException, InterruptedException, X4OConnectionException, SAXException {
			File waterHome;
			String override = localOverrides.getProperty(key);
			if (override == null) {
				waterHome = new File(hyperdriveHome, key);
				if (!waterHome.exists()) {
					executeHyperdrive("hyperdrive", "mount", waterHome.getAbsolutePath(), key);
				}
				String infoResult = executeHyperdrive("hyperdrive", "info", waterHome.getAbsolutePath());
				if (!infoResult.startsWith("Drive Info")) {
					logger.accept("ERROR: Couldn't get info on: "+waterHome);
					return 1;
				}
			} else {
				waterHome = new File(override);
			}
			LOG.debug("loadWaterOcean key={} home={}",key, waterHome);
			File waterSea = new File(waterHome, Warpᵐᵉ.WARP_SEA);
			if (!waterSea.exists()) {
				logger.accept("ERROR: No warp-sea.xml found.");
				return 1;
			}
			WaterOcean ocean = WaterOceanDriver.newInstance().createReader().readFile(waterSea);
			logger.accept("water-ocean: "+key+" ("+ocean.theWater().getName()+")");
			
			Hashtable<String, String> props = new Hashtable<String, String>();
			props.put(SystemWarpSea.NAME_PROPERTY, ocean.theWater().getName());
			context.registerService(SystemWarpSea.class.getName(), new SystemWarpSeaImpl(key, waterHome, ocean), props);
			
			int result = 0;
			for (WaterSeaChain chain: ocean.theWater().getSeaChains()) {
				result += loadWaterOcean(context, chain.getKey(), logger);
			}
			return result;
		}
		
		private String executeHyperdrive(String...cmd) throws IOException, InterruptedException {
			ProcessBuilder builder = new ProcessBuilder();
			builder.command(cmd);
			builder.directory(new File(System.getProperty("user.home")));
			Process process = builder.start();
			StringBuilder buf = new StringBuilder();
			try(BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
				String line;
				while ((line = input.readLine()) != null) {
					buf.append(line);
				}
			}
			process.waitFor();
			return buf.toString();
		}
	}
	
	public static class SystemGdxLogImpl implements SystemGdxLog, ApplicationLogger {
		
		@Override
		public void infoTag(String tag, String message, Object...args) {
			LoggerFactory.getLogger(tag).info(message, args);
		}
		
		@Override
		public void infoTag(String tag, String message, Throwable exception) {
			LoggerFactory.getLogger(tag).info(message, exception);
		}
		
		@Override
		public void debugTag(String tag, String message, Object...args) {
			LoggerFactory.getLogger(tag).debug(message, args);
		}
		
		@Override
		public void debugTag(String tag, String message, Throwable exception) {
			LoggerFactory.getLogger(tag).debug(message, exception);
		}
		
		@Override
		public void errorTag(String tag, String message, Object...args) {
			LoggerFactory.getLogger(tag).error(message, args);
		}
		
		@Override
		public void errorTag(String tag, String message, Throwable exception) {
			LoggerFactory.getLogger(tag).error(message, exception);
		}
		
		@Override
		public void log(String tag, String message) {
			infoTag(tag, message);
		}
		
		@Override
		public void log(String tag, String message, Throwable exception) {
			infoTag(tag, message, exception);
		}
		
		@Override
		public void error(String tag, String message) {
			errorTag(tag, message);
		}
		
		@Override
		public void error(String tag, String message, Throwable exception) {
			errorTag(tag, message, exception);
		}
		
		@Override
		public void debug(String tag, String message) {
			debugTag(tag, message);
		}
		
		@Override
		public void debug(String tag, String message, Throwable exception) {
			debugTag(tag, message, exception);
		}
	}
	
	public static class SystemGdxFontImpl implements SystemGdxFont {
		
		private final BitmapFont font;
		
		public SystemGdxFontImpl(BitmapFont font) {
			this.font = font;
		}
		
		@Override
		public BitmapFont getFont() {
			return font;
		}
	}
}
