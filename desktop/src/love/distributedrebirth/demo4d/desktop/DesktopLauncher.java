package love.distributedrebirth.demo4d.desktop;

import java.util.Arrays;
import java.util.List;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import love.distributedrebirth.demo4d.MainScreen;
import net.spookygames.gdx.nativefilechooser.desktop.DesktopFileChooser;

public class DesktopLauncher {
	
	private static String WINDOW_TITLE = "demo⁴ᴰ";
	private static String[] WINDOW_ICONS = {
		"icon/window-128.png",
		"icon/window-32.png",
		"icon/window-16.png"
	};
	
	public static void main (String[] arg) {
		printMessage();
		List<String> args = Arrays.asList(arg);
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setMaxNetThreads(Runtime.getRuntime().availableProcessors());
		config.setTitle(WINDOW_TITLE);
		config.setWindowedMode(800, 600);
		config.setWindowIcon(FileType.Internal, WINDOW_ICONS);
		new Lwjgl3Application(new MainScreen(args, new DesktopFileChooser()), config);
	}
	
	private static void printMessage() {
		System.out.println("==========================");
		System.out.println("     @Ω\u4ed9⁴ ˧꜏⋇꜊꜔ ⁴ﷲΩ@    ");
		System.out.println("        ©Δ∞ \u4ed9\u4e0a\u4e3b\u5929       ");
		System.out.println("בְּרֵאשִׁית :o: יְסוֺד :o: יִשְׂרָאֵל");
		System.out.println("==========================");
		System.out.println("Welcome to the matrix;");
		System.out.println("Starting demo⁴ᴰ now...");
	}
}
