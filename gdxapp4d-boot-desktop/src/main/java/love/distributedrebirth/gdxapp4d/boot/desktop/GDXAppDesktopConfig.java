package love.distributedrebirth.gdxapp4d.boot.desktop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

/**
 * Desktop game app base config.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public final class GDXAppDesktopConfig {

	private static final Logger LOG = LoggerFactory.getLogger(GDXAppDesktopConfig.class);
	public static int WINDOW_WIDTH = 1024;
	public static int WINDOW_HEIGHT = 768;
	public static String WINDOW_TITLE = "GDXApp⁴ᴰ";
	public static String[] WINDOW_ICONS = {
		"icon/window-128.png",
		"icon/window-32.png",
		"icon/window-16.png"
	};
	
	public static void printBootMessage() {
		LOG.info("==========================");
		LOG.info("     @Ω仙⁴ ˧꜏⋇꜊꜔ ⁴ﷲΩ@    ");
		LOG.info("        ©Δ∞ 仙上主天       ");
		LOG.info("בְּרֵאשִׁית :o: יְסוֺד :o: יִשְׂרָאֵל");
		LOG.info("==========================");
	}
}
