package love.distributedrebirth.gdxapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import imgui.ImGui;
import imgui.flag.ImGuiCond;
import imgui.flag.ImGuiWindowFlags;
import imgui.type.ImBoolean;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.jmx.DefaultEnumBaseᴶᴹˣ;
import love.distributedrebirth.gdxapp.desktop.DeskApp;
import love.distributedrebirth.gdxapp.desktop.DeskAppContourSection;
import love.distributedrebirth.gdxapp.desktop.DeskAppRenderer;
import love.distributedrebirth.gdxapp.desktop.apps.BasicConsoleApp;
import love.distributedrebirth.gdxapp.desktop.apps.HebrewWalletApp;
import love.distributedrebirth.gdxapp.desktop.apps.MusicPlayerApp;
import love.distributedrebirth.gdxapp.desktop.apps.SystemBaseGlyphApp;
import love.distributedrebirth.gdxapp.desktop.apps.SystemBasePartApp;
import love.distributedrebirth.gdxapp.desktop.apps.Unicode4DApp;
import love.distributedrebirth.gdxapp.music.MusicManager;
import love.distributedrebirth.gdxapp.music.MusicSongType;
import love.distributedrebirth.gdxapp.screen.ScreenCredits;
import love.distributedrebirth.gdxapp.screen.ScreenDesktop0;
import love.distributedrebirth.gdxapp.screen.ScreenDesktop1;
import love.distributedrebirth.gdxapp.screen.ScreenDesktop2;
import love.distributedrebirth.gdxapp.screen.ScreenDesktop3;
import love.distributedrebirth.gdxapp.screen.ScreenHelp;
import love.distributedrebirth.gdxapp.screen.ScreenIntro;
import love.distributedrebirth.gdxapp.screen.ScreenIntroMission;
import love.distributedrebirth.gdxapp.screen.ScreenLoading;
import love.distributedrebirth.numberxd.base2t.Base2PartsFactory;
import love.distributedrebirth.numberxd.base2t.Base2Terminator;
import love.distributedrebirth.numberxd.base2t.part.warp.TOSWarpCore;
import love.distributedrebirth.numberxd.base2t.part.warp.TOSWarpCoreDriver;
import love.distributedrebirth.numberxd.base2t.part.warp.WaterBucket;
import love.distributedrebirth.numberxd.glyph.BaseGlyphSet;
import net.spookygames.gdx.nativefilechooser.NativeFileChooser;

/**
 * Main loop render dispatcher and event handling.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class GDXAppMain extends Game {
	private int lazyIntCnt = 33;
	private List<String> args;
	public NativeFileChooser fileChooser;
	public SpriteBatch batch;
	public BitmapFont font;
	public OrthographicCamera camera;
	public final int viewWidth;
	public final int viewHeight;
	public MusicManager music;
	
	private Map<Class<? extends Screen>,Screen> screens;
	private List<GDXAppLauncher> apps;
	private GDXAppScreen desktop0;
	private GDXAppScreen desktop1;
	private GDXAppScreen desktop2;
	private GDXAppScreen desktop3;
	private ImBoolean openWindowFlag = new ImBoolean(true);
	private ImBoolean showImGuiDemo = new ImBoolean(false);
	
	public GDXAppMain(List<String> args, int viewWidth, int viewHeight, NativeFileChooser fileChooser) {
		this.args = args;
		this.viewWidth = viewWidth;
		this.viewHeight = viewHeight;
		this.fileChooser = fileChooser;
	}
	
	//TODO: add layer or ?? private <T extends BãßBȍőnCoffinStoreʸᴰ<?>,DefaultAuthorInfoʸᴰ> T[] storeInstances() {
	@SuppressWarnings("unchecked")
	private <T extends DefaultEnumBaseᴶᴹˣ<?,?>> T[] coffinInstances() {
		return (T[]) new DefaultEnumBaseᴶᴹˣ[] {
				BaseGlyphSet.values()[0],
				Base2Terminator.INSTANCE,
				Base2PartsFactory.INSTANCE,
				TOSWarpCore.INSTANCE
		};
	}
	
	private void lazyInit() {
		if (lazyIntCnt > 0) {
			lazyIntCnt--;
			return;
		}
		ImGuiSetup.init();
		
		// ref to init
		System.out.println("BãßBȍőnCoffinʸᴰ init......");
		for (DefaultEnumBaseᴶᴹˣ<?,?> coffin:coffinInstances()) {
			BãßBȍőnCoffinOpenʸᴰ.lockCoffin(coffin);
		}
		System.out.println("BãßBȍőnCoffinʸᴰ init done.");
		
		try {
			if (args.contains("warpcore-load")) {
				System.out.println("warpcore-load: requested");
				WaterBucket bucket = TOSWarpCoreDriver.newInstance().createReader().readFile("./warpcore.xml");
				TOSWarpCore.INSTANCE.BãßArmWarpCore(bucket);
			}
			if (args.contains("warpcore-save")) {
				System.out.println("warpcore-save: requested");
				WaterBucket bucket = TOSWarpCore.INSTANCE.BãßCurrentWarpCore();
				TOSWarpCoreDriver.newInstance().createWriter().writeFile(bucket, "./warpcore.xml");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		if (!args.contains("warpcore-nolock")) {
			System.out.println("warpcore-lock: BãßLockWarpCipher");
			TOSWarpCore.INSTANCE.BãßLockWarpCipher();
		} else {
			System.out.println("warpcore-nolock: requested");
		}
		if (args.contains("full-screen")) {
			System.out.println("full-screen: requested");
			Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
		}
		if (args.contains("intro-skip")) {
			System.out.println("intro-skip: requested");
			selectScreen(ScreenDesktop0.class);
			music.play(MusicSongType.BACKGROUND);
		} else {
			selectScreen(ScreenIntro.class);
		}

	}
	
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		camera = new OrthographicCamera();
		
		camera.setToOrtho(false, viewWidth, viewHeight);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		
		boolean musicStop = args.contains("music-stop");
		if (musicStop) {
			System.out.println("music-stop: requested");
		}
		music = new MusicManager();
		music.init(musicStop);
		
		screens = new HashMap<>();
		apps = new ArrayList<>();
		apps.add(new GDXAppLauncher("Basic Console", () -> new BasicConsoleApp()));
		apps.add(new GDXAppLauncher("Base Glyphs", () -> new SystemBaseGlyphApp()));
		apps.add(new GDXAppLauncher("Base Parts", () -> new SystemBasePartApp()));
		apps.add(new GDXAppLauncher("Hebrew Wallet", () -> new HebrewWalletApp()));
		apps.add(new GDXAppLauncher("Unicode4D", () -> new Unicode4DApp()));
		apps.add(new GDXAppLauncher("Music Player", () -> new MusicPlayerApp(this)));
		
		desktop0 = new ScreenDesktop0(this);
		desktop1 = new ScreenDesktop1(this);
		desktop2 = new ScreenDesktop2();
		desktop3 = new ScreenDesktop3();
		
		putScreen(new ScreenLoading(this));
		putScreen(new ScreenIntro(this));
		putScreen(new ScreenIntroMission(this));
		putScreen(desktop0);
		putScreen(desktop1);
		putScreen(desktop2);
		putScreen(desktop3);
		putScreen(new ScreenCredits(this));
		putScreen(new ScreenHelp(this));
		
		selectScreen(ScreenLoading.class);
	}
	
	@Override
	public void dispose() {
		ImGuiSetup.dispose();
		for (Screen screen:screens.values()) {
			screen.dispose();
		}
		music.dispose();
		batch.dispose();
		font.dispose();
	}
	
	private void putScreen(Screen screen) {
		screens.put(screen.getClass(), screen);
	}
	
	public void selectScreen(Class<? extends Screen> screenClass) {
		Screen screen = screens.get(screenClass);
		if (screen == null) {
			throw new NullPointerException("Unknow screen: "+screenClass);
		}
		setScreen(screen);
	}
	
	@Override
	public void render() {
		ScreenUtils.clear(0f, 0f, 0f, 1f, true);
		if (screen == null) {
			return;
		}
		if (screen instanceof ScreenLoading) {
			screen.render(Gdx.graphics.getDeltaTime());
			lazyInit();
			return;
		}
		ImGuiSetup.imGuiImp.newFrame();
		ImGui.newFrame();
		
		GDXAppScreen appScreen = null;
		if (screen instanceof GDXAppScreen) {
			appScreen = GDXAppScreen.class.cast(screen);
			renderMenu(appScreen);
		}
		if (showImGuiDemo.get()) {
			ImGui.showDemoWindow(showImGuiDemo);
		}
		if (appScreen != null && appScreen.getDeskAppScreen().getCurrentDeskApp() != null) {
			int sizeFlags = ImGuiCond.Always;
			ImGui.setNextWindowPos(5, 30, sizeFlags);
			ImGui.setNextWindowSize(Gdx.graphics.getWidth() - 10, Gdx.graphics.getHeight() - 35, sizeFlags);
			int windowFlags = ImGuiWindowFlags.NoMove | ImGuiWindowFlags.NoResize;
			if (ImGui.begin(appScreen.getDeskAppScreen().getCurrentDeskApp().getName(), openWindowFlag, windowFlags)) {
				DeskAppRenderer renderer = appScreen.getDeskAppScreen().getCurrentDeskApp().getContours().getContour(DeskAppContourSection.MAIN);
				if (renderer != null) {
					renderer.render();
				}
			}
			if (openWindowFlag.get() == false) {
				appScreen.getDeskAppScreen().setCurrentDeskApp(null);
				openWindowFlag.set(true);
			}
			ImGui.end();
		}
		if (screen != null) {
			screen.render(Gdx.graphics.getDeltaTime());
		}
		ImGui.render();
		ImGuiSetup.imGuiGlImp.renderDrawData(ImGui.getDrawData());
	}
	
	private ImBoolean fileMinimizeSelected = new ImBoolean(false);
	private ImBoolean fileCloseSelected = new ImBoolean(false);
	
	private void renderMenu(GDXAppScreen appScreen) {
		DeskApp deskApp = appScreen.getDeskAppScreen().getCurrentDeskApp();
		ImGui.beginMainMenuBar();
		if (ImGui.beginMenu("File")) {
			if (deskApp != null) {
				DeskAppRenderer fileNew = deskApp.getContours().getContour(DeskAppContourSection.FILE_NEW);
				DeskAppRenderer fileClose = deskApp.getContours().getContour(DeskAppContourSection.FILE_CLOSE);
				DeskAppRenderer fileSave = deskApp.getContours().getContour(DeskAppContourSection.FILE_SAVE);
				DeskAppRenderer fileOption = deskApp.getContours().getContour(DeskAppContourSection.FILE_OPTION);
				DeskAppRenderer filePrint = deskApp.getContours().getContour(DeskAppContourSection.FILE_PRINT);
				if (fileNew != null) {
					fileNew.render();
					ImGui.separator();
				}
				if (fileClose != null) {
					fileClose.render();
					ImGui.separator();
				}
				if (fileSave != null) {
					fileSave.render();
					ImGui.separator();
				}
				if (fileOption != null) {
					fileOption.render();
					ImGui.separator();
				}
				if (filePrint != null) {
					filePrint.render();
					ImGui.separator();
				}
			}
			if (ImGui.menuItem("Minimize", "", fileMinimizeSelected, deskApp != null )) {
				if (deskApp != null) {
					appScreen.getDeskAppScreen().setCurrentDeskApp(null);
				}
			}
			if (ImGui.menuItem("Exit", "", fileCloseSelected, deskApp != null)) {
				if (deskApp != null) {
					appScreen.getDeskAppScreen().removeDeskApp(deskApp);
					appScreen.getDeskAppScreen().setCurrentDeskApp(null);
				}
			}
			ImGui.endMenu();
		}
		
		if (deskApp != null) {
			renderEditMenu(deskApp);
		}
		if (ImGui.beginMenu("vrGEM⁴")) {
			if (ImGui.beginMenu("Start")) {
				for (GDXAppLauncher launcher: apps) {
					if (ImGui.menuItem(launcher.getName())) {
						appScreen.getDeskAppScreen().addDeskApp(launcher.getLauncher().get());
					}
				}
				ImGui.endMenu();
			}
			ImGui.separator();
			
			String infix0 = "";
			String infix1 = "";
			String infix2 = "";
			String infix3 = "";
			if (appScreen instanceof ScreenDesktop0) {
				infix0 = "=> ";
			}
			if (appScreen instanceof ScreenDesktop1) {
				infix1 = "=> ";
			}
			if (appScreen instanceof ScreenDesktop2) {
				infix2 = "=> ";
			}
			if (appScreen instanceof ScreenDesktop3) {
				infix3 = "=> ";
			}
			if (ImGui.beginMenu(infix0+"Desktop0")) {
				if (ImGui.menuItem("Main reality")) {
					selectScreen(ScreenDesktop0.class);
					desktop0.getDeskAppScreen().setCurrentDeskApp(null);
				}
				for (DeskApp app: desktop0.getDeskAppScreen().getDeskApps()) {
					if (ImGui.menuItem(app.getName())) {
						selectScreen(ScreenDesktop0.class);
						desktop0.getDeskAppScreen().setCurrentDeskApp(app);
					}
				}
				ImGui.endMenu();
			}
			if (ImGui.beginMenu(infix1+"Desktop1")) {
				if (ImGui.menuItem("Main reality")) {
					selectScreen(ScreenDesktop1.class);
					desktop1.getDeskAppScreen().setCurrentDeskApp(null);
				}
				for (DeskApp app: desktop1.getDeskAppScreen().getDeskApps()) {
					if (ImGui.menuItem(app.getName())) {
						selectScreen(ScreenDesktop1.class);
						desktop1.getDeskAppScreen().setCurrentDeskApp(app);
					}
				}
				ImGui.endMenu();
			}
			if (ImGui.beginMenu(infix2+"Desktop2")) {
				if (ImGui.menuItem("Main reality")) {
					selectScreen(ScreenDesktop2.class);
					desktop2.getDeskAppScreen().setCurrentDeskApp(null);
				}
				for (DeskApp app: desktop2.getDeskAppScreen().getDeskApps()) {
					if (ImGui.menuItem(app.getName())) {
						selectScreen(ScreenDesktop2.class);
						desktop2.getDeskAppScreen().setCurrentDeskApp(app);
					}
				}
				ImGui.endMenu();
			}
			if (ImGui.beginMenu(infix3+"Desktop3")) {
				if (ImGui.menuItem("Main reality")) {
					selectScreen(ScreenDesktop3.class);
					desktop3.getDeskAppScreen().setCurrentDeskApp(null);
				}
				for (DeskApp app: desktop3.getDeskAppScreen().getDeskApps()) {
					if (ImGui.menuItem(app.getName())) {
						selectScreen(ScreenDesktop3.class);
						desktop3.getDeskAppScreen().setCurrentDeskApp(app);
					}
				}
				ImGui.endMenu();
			}
			ImGui.separator();
			if (Gdx.graphics.isFullscreen()) {
				if (ImGui.menuItem("Window Mode")) {
					Gdx.graphics.setWindowedMode(viewWidth, viewHeight);
				}
			} else {
				if (ImGui.menuItem("Full Screen")) {
					Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
				}
			}
			ImGui.separator();
			if (ImGui.menuItem("Credits")) {
				selectScreen(ScreenCredits.class);
			}
			if (ImGui.menuItem("Help")) {
				selectScreen(ScreenHelp.class);
			}
			ImGui.separator();
			if (ImGui.menuItem("ImGui Demo")) {
				showImGuiDemo.set(true);
			}
			if (ImGui.menuItem("Exit")) {
				dispose();
				System.exit(0);
			}
			ImGui.endMenu();
		}
		ImGui.endMainMenuBar();
	}
	
	private void renderEditMenu(DeskApp deskApp) {
		DeskAppRenderer editUndo = deskApp.getContours().getContour(DeskAppContourSection.EDIT_UNDO);
		DeskAppRenderer editCopy = deskApp.getContours().getContour(DeskAppContourSection.EDIT_COPY);
		DeskAppRenderer editSelect = deskApp.getContours().getContour(DeskAppContourSection.EDIT_SELECT);
		DeskAppRenderer editFind = deskApp.getContours().getContour(DeskAppContourSection.EDIT_FIND);
		DeskAppRenderer editOption = deskApp.getContours().getContour(DeskAppContourSection.EDIT_OPTION);
		if (editUndo != null || editCopy != null || editSelect != null || editFind != null || editOption != null) {
			boolean first = false;
			if (ImGui.beginMenu("Edit")) {
				if (editUndo != null) {
					editUndo.render();
					first = true;
				} 
				if (editCopy != null) {
					if (first) {
						ImGui.separator();
					}
					editCopy.render();
					first = true;
				}
				if (editSelect != null) {
					if (first) {
						ImGui.separator();
					}
					editSelect.render();
					first = true;
				}
				if (editFind != null) {
					if (first) {
						ImGui.separator();
					}
					editFind.render();
					first = true;
				}
				if (editOption != null) {
					if (first) {
						ImGui.separator();
					}
					editOption.render();
					first = true;
				}
				ImGui.endMenu();
			}
		}
	}
}
