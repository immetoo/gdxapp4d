package love.distributedrebirth.gdxapp4d.boot.desktop;

import java.util.Arrays;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.tos4.GDXAppTos4;
import net.spookygames.gdx.nativefilechooser.desktop.DesktopFileChooser;

/**
 * Desktop game app launcher.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class GDXAppDesktopLauncher {
	
	public static void main(String[] arg) {
		GDXAppDesktopConfig.printBootMessage();
		
		int width = GDXAppDesktopConfig.WINDOW_WIDTH;
		int height = GDXAppDesktopConfig.WINDOW_HEIGHT;
		GDXAppTos4.INSTANCE.BãßInit(Arrays.asList(arg), width, height, new DesktopFileChooser());
		
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setMaxNetThreads(Runtime.getRuntime().availableProcessors());
		config.setTitle(GDXAppDesktopConfig.WINDOW_TITLE);
		config.setWindowIcon(FileType.Internal, GDXAppDesktopConfig.WINDOW_ICONS);
		config.setWindowedMode(width, height);
		
		Lwjgl3Application launcher = new Lwjgl3Application(GDXAppTos4.INSTANCE, config);
		launcher.exit();
	}
}
