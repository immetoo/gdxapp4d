package love.distributedrebirth.warpme.hash;

import org.x4o.xml.X4ODriver;
import org.x4o.xml.X4ODriverManager;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class WaterDrugsDriver extends X4ODriver<WaterDrugs> {

	static final public String LANGUAGE_NAME = "warp-hash";
	static final public String[] LANGUAGE_VERSIONS = new String[]{X4ODriver.DEFAULT_LANGUAGE_VERSION};
	
	@Override
	public String getLanguageName() {
		return LANGUAGE_NAME;
	}

	@Override
	public String[] getLanguageVersions() {
		return LANGUAGE_VERSIONS;
	}
	
	static public WaterDrugsDriver newInstance() {
		return (WaterDrugsDriver)X4ODriverManager.getX4ODriver(LANGUAGE_NAME);
	}
}
