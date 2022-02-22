package love.distributedrebirth.warpme.core;

import org.x4o.xml.X4ODriver;
import org.x4o.xml.X4ODriverManager;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class WaterBucketDriver extends X4ODriver<WaterBucket> {

	static final public String LANGUAGE_NAME = "warp-core";
	static final public String[] LANGUAGE_VERSIONS = new String[]{X4ODriver.DEFAULT_LANGUAGE_VERSION};
	
	@Override
	public String getLanguageName() {
		return LANGUAGE_NAME;
	}

	@Override
	public String[] getLanguageVersions() {
		return LANGUAGE_VERSIONS;
	}
	
	static public WaterBucketDriver newInstance() {
		return (WaterBucketDriver)X4ODriverManager.getX4ODriver(LANGUAGE_NAME);
	}
}
