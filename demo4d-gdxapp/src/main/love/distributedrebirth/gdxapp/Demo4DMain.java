package love.distributedrebirth.gdxapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import imgui.ImGui;
import imgui.type.ImBoolean;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp.matrix4d.ScreenMatrix4D;
import love.distributedrebirth.gdxapp.music.MusicManager;
import love.distributedrebirth.gdxapp.music.MusicPlayerRenderer;
import love.distributedrebirth.gdxapp.music.MusicSongType;
import love.distributedrebirth.gdxapp.screen.SystemBasePartRenderer;
import love.distributedrebirth.gdxapp.screen.BasicConsoleRenderer;
import love.distributedrebirth.gdxapp.screen.HebrewWalletRenderer;
import love.distributedrebirth.gdxapp.screen.ScreenCredits;
import love.distributedrebirth.gdxapp.screen.ScreenDefault;
import love.distributedrebirth.gdxapp.screen.ScreenHelp;
import love.distributedrebirth.gdxapp.screen.ScreenIntro;
import love.distributedrebirth.gdxapp.screen.ScreenIntroMission;
import love.distributedrebirth.gdxapp.screen.ScreenLoading;
import love.distributedrebirth.gdxapp.screen.ScreenUnicode4D;
import love.distributedrebirth.gdxapp.screen.SystemBaseGlyphRenderer;
import love.distributedrebirth.numberxd.base2t.part.warp.TOSWarpCore;
import love.distributedrebirth.numberxd.base2t.part.warp.TOSWarpCoreDriver;
import love.distributedrebirth.numberxd.base2t.part.warp.WaterBucket;
import net.spookygames.gdx.nativefilechooser.NativeFileChooser;

/**
 * Main loop render dispatcher and event handling.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class Demo4DMain extends Game {
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
	private Map<Class<? extends ImGuiRenderer>,ImGuiRenderer> widgets;
	private ImBoolean showImGuiDemo = new ImBoolean(false);
	private ImBoolean showMusicPlayer = new ImBoolean(false);
	private ImBoolean showHebrewWallet = new ImBoolean(false);
	private ImBoolean showSystemBasePart = new ImBoolean(false);
	private ImBoolean showSystemGlyphPart = new ImBoolean(false);
	private ImBoolean showBasicConsole = new ImBoolean(false);
	
	public Demo4DMain(List<String> args, int viewWidth, int viewHeight, NativeFileChooser fileChooser) {
		this.args = args;
		this.viewWidth = viewWidth;
		this.viewHeight = viewHeight;
		this.fileChooser = fileChooser;
	}
	
	private void lazyInit() {
		if (lazyIntCnt > 0) {
			lazyIntCnt--;
			return;
		}
		ImGuiSetup.init();
		
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
			selectScreen(ScreenDefault.class);
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
		widgets = new HashMap<>();
		
		putWidget(new MusicPlayerRenderer(this));
		putWidget(new HebrewWalletRenderer(this));
		putWidget(new SystemBasePartRenderer(this));
		putWidget(new SystemBaseGlyphRenderer(this));
		putWidget(new BasicConsoleRenderer(this));
		
		putScreen(new ScreenLoading(this));
		putScreen(new ScreenIntro(this));
		putScreen(new ScreenIntroMission(this));
		putScreen(new ScreenDefault(this));
		putScreen(new ScreenCredits(this));
		putScreen(new ScreenHelp(this));
		putScreen(new ScreenMatrix4D(this));
		putScreen(new ScreenUnicode4D(this));
		
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
	
	private void putWidget(ImGuiRenderer widget) {
		widgets.put(widget.getClass(), widget);
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
		if (screen instanceof ScreenLoading) {
			screen.render(Gdx.graphics.getDeltaTime());
			lazyInit();
			return;
		}
		ImGuiSetup.imGuiImp.newFrame();
		ImGui.newFrame();
		if (hasMainMenu()) {
			renderMenu();
		}
		if (showImGuiDemo.get()) {
			ImGui.showDemoWindow(showImGuiDemo);
		}
		if (showMusicPlayer.get()) {
			widgets.get(MusicPlayerRenderer.class).render(showMusicPlayer);
		}
		if (showHebrewWallet.get()) {
			widgets.get(HebrewWalletRenderer.class).render(showHebrewWallet);
		}
		if (showSystemBasePart.get()) {
			widgets.get(SystemBasePartRenderer.class).render(showSystemBasePart);
		}
		if (showSystemGlyphPart.get()) {
			widgets.get(SystemBaseGlyphRenderer.class).render(showSystemGlyphPart);
		}
		if (showBasicConsole.get()) {
			widgets.get(BasicConsoleRenderer.class).render(showBasicConsole);
		}
		if (screen != null) {
			screen.render(Gdx.graphics.getDeltaTime());
		}
		if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
			selectScreen(ScreenDefault.class);
		}
		ImGui.render();
		ImGuiSetup.imGuiGlImp.renderDrawData(ImGui.getDrawData());
	}
	
	private void renderMenu() {
		ImGui.beginMainMenuBar();
		if (ImGui.beginMenu("Demo")) {
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
			if (ImGui.menuItem("Matrix4D")) {
				selectScreen(ScreenMatrix4D.class);
			}
			if (ImGui.menuItem("Unicode4D")) {
				selectScreen(ScreenUnicode4D.class);
			}
			ImGui.separator();
			if (ImGui.menuItem("Exit")) {
				dispose();
				System.exit(0);
			}
			ImGui.endMenu();
		}
		if (ImGui.beginMenu("Widgets")) {
			if (ImGui.menuItem("ImGui Demo")) {
				showImGuiDemo.set(true);
			}
			ImGui.separator();
			if (ImGui.menuItem("Hebrew Wallet")) {
				showHebrewWallet.set(true);
			}
			ImGui.separator();
			if (ImGui.menuItem("Base Part")) {
				showSystemBasePart.set(true);
			}
			if (ImGui.menuItem("Base Glyph")) {
				showSystemGlyphPart.set(true);
			}
			ImGui.separator();
			if (ImGui.menuItem("Basic Console")) {
				showBasicConsole.set(true);
			}
			if (ImGui.menuItem("Music Player")) {
				showMusicPlayer.set(true);
			}
			ImGui.endMenu();
		}
		if (ImGui.beginMenu("Help")) {
			if (ImGui.menuItem("Credits")) {
				selectScreen(ScreenCredits.class);
			}
			ImGui.separator();
			if (ImGui.menuItem("Help")) {
				selectScreen(ScreenHelp.class);
			}
			ImGui.endMenu();
		}
		ImGui.endMainMenuBar();
	}
	
	private boolean hasMainMenu() {
		Screen screen = getScreen();
		if (screen == null) {
			return false;
		}
		if (ScreenIntro.class.equals(screen.getClass())) {
			return false;
		}
		if (ScreenIntroMission.class.equals(screen.getClass())) {
			return false;
		}
		if (ScreenCredits.class.equals(screen.getClass())) {
			return false;
		}
		if (ScreenHelp.class.equals(screen.getClass())) {
			return false;
		}
		return true;
	}
}
