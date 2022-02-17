package love.distributedrebirth.warpme;

import org.x4o.xml.X4ODriver;
import org.x4o.xml.X4ODriverManager;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.warpme.core.WaterBucket;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class TOSWarpCoreDriver extends X4ODriver<WaterBucket> {

	static final public String LANGUAGE_NAME = "warpcore";
	static final public String[] LANGUAGE_VERSIONS = new String[]{X4ODriver.DEFAULT_LANGUAGE_VERSION};
	
	@Override
	public String getLanguageName() {
		return LANGUAGE_NAME;
	}

	@Override
	public String[] getLanguageVersions() {
		return LANGUAGE_VERSIONS;
	}
	
	static public TOSWarpCoreDriver newInstance() {
		return (TOSWarpCoreDriver)X4ODriverManager.getX4ODriver(LANGUAGE_NAME);
	}
}
