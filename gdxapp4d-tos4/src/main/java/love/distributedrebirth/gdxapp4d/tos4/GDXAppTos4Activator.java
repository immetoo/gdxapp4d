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

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.x4o.xml.io.X4OConnectionException;
import org.xml.sax.SAXException;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemWarpBase;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemWarpBootArgs;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemWarpSea;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemWarpShip;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemWarpTerminal;
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
	
	private List<String> args;
	private int viewWidth;
	private int viewHeight;
	private NativeFileChooser fileChooser;
	private File hyperdriveHome;
	private File warpshipHome;
	private WaterDevice warpshipDevice;
	private SystemWarpTerminal systemWarpTerminal;
	private List<GDXAppTos4BootListener> listeners = new ArrayList<>();
	
	private static final String SYSTEM_USER_HOME = "user.home";
	private static final String HYPERDRIVE_HOME = "Hyperdrive";
	private static final String WARPSHIP_HOME = "Warpship";
	
	public GDXAppTos4Activator() {
	}
	
	public void BãßInit(List<String> args, int viewWidth, int viewHeight,NativeFileChooser fileChooser, SystemWarpTerminal systemWarpTerminal) {
		this.args = args;
		this.viewWidth = viewWidth;
		this.viewHeight = viewHeight;
		this.fileChooser = fileChooser;
		this.systemWarpTerminal = systemWarpTerminal;
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
		fireMessageEvent("hyper-home: "+hyperdriveHome);
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
		
		context.registerService(SystemWarpBase.class.getName(), new SystemWarpBaseImpl(), new Hashtable<String, String>());
		context.registerService(SystemWarpBootArgs.class.getName(), new SystemWarpBootArgsImpl(), new Hashtable<String, String>());
		context.registerService(SystemWarpShip.class.getName(), new SystemWarpShipImpl(), new Hashtable<String, String>());
		context.registerService(SystemWarpTerminal.class.getName(), systemWarpTerminal, new Hashtable<String, String>());
		
		try {
			warpshipDevice = WaterDeviceDriver.newInstance().createReader().readFile(warpShip);
		} catch (Exception e) {
			e.printStackTrace();
			fireMessageEvent("ERROR: "+e.getMessage());
			return;
		}
		fireMessageEvent("warp-engine: "+warpshipDevice.theShip().getName());
		
		Properties overrides = new Properties();
		if (useLocal) {
			File localOverride = new File("local-override.xml");
			if (localOverride.exists()) {
				try {
					overrides.loadFromXML(new FileInputStream(localOverride));
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				fireMessageEvent("use-local: local-override.xml loaded.");
			} else {
				fireMessageEvent("use-local: local-override.xml not found.");
			}
			
		}
		int result = 0;
		try {
			result = resolveWaterOcean(overrides, context, warpshipDevice.theShip().getEngine());
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
	}
	
	private int resolveWaterOcean(Properties overrides, BundleContext context, String key) throws IOException, InterruptedException, X4OConnectionException, SAXException, BundleException {
		File waterHome;
		String override = overrides.getProperty(key);
		if (override == null) {
			waterHome = new File(hyperdriveHome, key);
			if (!waterHome.exists()) {
				executeHyperdrive("hyperdrive", "mount", waterHome.getAbsolutePath(), key);
			}
			String infoResult = executeHyperdrive("hyperdrive", "info", waterHome.getAbsolutePath());
			if (!infoResult.startsWith("Drive Info")) {
				fireMessageEvent("ERROR: Couldn't get info on: "+waterHome);
				return 1;
			}
		} else {
			waterHome = new File(override);
		}
		File waterSea = new File(waterHome, Warpᵐᵉ.WARP_SEA);
		if (!waterSea.exists()) {
			fireMessageEvent("ERROR: No warp-sea.xml found.");
			return 1;
		}
		WaterOcean ocean = WaterOceanDriver.newInstance().createReader().readFile(waterSea);
		fireMessageEvent("water-ocean: "+key+" ("+ocean.theWater().getName()+")");
		
		Hashtable<String, String> props = new Hashtable<String, String>();
		props.put(SystemWarpSea.NAME_PROPERTY, ocean.theWater().getName());
		props.put(SystemWarpSea.PROVIDER_PROPERTY, ocean.theWater().getProvider());
		context.registerService(SystemWarpSea.class.getName(), new SystemWarpSeaImpl(ocean), props);
		
		for (WaterSeaMagic magic:ocean.theWater().getSeaMagics()) {
			if ("application/vnd.osgi.bundle".equals(magic.getMime())) {
				String overrideBundleKey = key + "." + magic.getFile();
				String overrideBundle = overrides.getProperty(overrideBundleKey);
				if (overrideBundle == null) {
					GDXAppTos4BootFactory.installAndStartBundles(context, "reference:file:"+waterHome.getAbsolutePath()+"/"+magic.getFile());
				} else {
					GDXAppTos4BootFactory.installAndStartBundles(context, "reference:file:"+overrideBundle);
				}
			}
		}
		int result = 0;
		for (WaterSeaChain chain: ocean.theWater().getSeaChains()) {
			result += resolveWaterOcean(overrides, context, chain.getKey());
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
	
	public class SystemWarpSeaImpl implements SystemWarpSea {
		
		private final WaterOcean warpSea;
		
		public SystemWarpSeaImpl(WaterOcean warpSea) {
			this.warpSea = warpSea;
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
	
	public class SystemWarpBootArgsImpl implements SystemWarpBootArgs {
		
		@Override
		public List<String> getBootArgs() {
			return args;
		}

		@Override
		public int getBootWindowWidth() {
			return viewWidth;
		}

		@Override
		public int getBootWindowHeight() {
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
	}
}
