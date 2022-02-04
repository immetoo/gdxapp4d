package love.distributedrebirth.demo4d.desktop;

import java.util.Arrays;
import java.util.List;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.demo4d.Demo4DMain;
import net.spookygames.gdx.nativefilechooser.desktop.DesktopFileChooser;

/**
 * Desktop game app launcher.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class DesktopLauncher {
	
	public static void main(String[] arg) {
		DesktopConfig.printBootMessage();
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setMaxNetThreads(Runtime.getRuntime().availableProcessors());
		config.setTitle(DesktopConfig.WINDOW_TITLE);
		config.setWindowIcon(FileType.Internal, DesktopConfig.WINDOW_ICONS);
		config.setWindowedMode(DesktopConfig.WINDOW_WIDTH, DesktopConfig.WINDOW_HEIGHT);
		List<String> args = Arrays.asList(arg);
		DesktopFileChooser aop0 = new DesktopFileChooser();
		Game app = new Demo4DMain(args, DesktopConfig.WINDOW_WIDTH, DesktopConfig.WINDOW_HEIGHT, aop0);
		Lwjgl3Application launcher = new Lwjgl3Application(app, config);
		launcher.exit();
	}
}
