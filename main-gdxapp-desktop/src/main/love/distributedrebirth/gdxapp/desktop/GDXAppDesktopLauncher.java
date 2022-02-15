package love.distributedrebirth.gdxapp.desktop;

import java.util.Arrays;
import java.util.List;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp.GDXAppMain;
import net.spookygames.gdx.nativefilechooser.desktop.DesktopFileChooser;

/**
 * Desktop game app launcher.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class GDXAppDesktopLauncher {
	
	public static void main(String[] arg) {
		GDXAppDesktopConfig.printBootMessage();
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setMaxNetThreads(Runtime.getRuntime().availableProcessors());
		config.setTitle(GDXAppDesktopConfig.WINDOW_TITLE);
		config.setWindowIcon(FileType.Internal, GDXAppDesktopConfig.WINDOW_ICONS);
		config.setWindowedMode(GDXAppDesktopConfig.WINDOW_WIDTH, GDXAppDesktopConfig.WINDOW_HEIGHT);
		List<String> args = Arrays.asList(arg);
		DesktopFileChooser aop0 = new DesktopFileChooser();
		GDXAppMain.INSTANCE.BãßInit(args, GDXAppDesktopConfig.WINDOW_WIDTH, GDXAppDesktopConfig.WINDOW_HEIGHT, aop0);
		Lwjgl3Application launcher = new Lwjgl3Application(GDXAppMain.INSTANCE, config);
		launcher.exit();
	}
}
