package love.distributedrebirth.gdxapp4d.tos4.service;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.x4o.xml.io.X4OConnectionException;
import org.xml.sax.SAXException;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.warpme.ship.WaterDevice;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public interface SystemWarpShip {

	WaterDevice getWarpShip();
	
	int loadWaterOcean(BundleContext context, List<SystemWarpSea> registratedSeas, String key, Consumer<String> logger) throws IOException, InterruptedException, X4OConnectionException, SAXException, BundleException;
	
	void loadBundles(BundleContext context, List<SystemWarpSea> registratedSeas) throws BundleException;
}
