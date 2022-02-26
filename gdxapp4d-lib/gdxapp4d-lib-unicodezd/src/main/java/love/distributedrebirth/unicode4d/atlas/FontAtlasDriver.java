package love.distributedrebirth.unicode4d.atlas;

import org.x4o.xml.X4ODriver;
import org.x4o.xml.X4ODriverManager;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class FontAtlasDriver extends X4ODriver<FontAtlas> {

	static final public String LANGUAGE_NAME = "unicode4d-atlas";
	static final public String[] LANGUAGE_VERSIONS = new String[]{X4ODriver.DEFAULT_LANGUAGE_VERSION};
	
	@Override
	public String getLanguageName() {
		return LANGUAGE_NAME;
	}

	@Override
	public String[] getLanguageVersions() {
		return LANGUAGE_VERSIONS;
	}
	
	static public FontAtlasDriver newInstance() {
		return (FontAtlasDriver)X4ODriverManager.getX4ODriver(LANGUAGE_NAME);
	}
}
