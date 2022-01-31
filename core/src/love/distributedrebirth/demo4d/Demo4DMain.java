package love.distributedrebirth.demo4d;

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
import love.distributedrebirth.demo4d.matrix4d.ScreenMatrix4D;
import love.distributedrebirth.demo4d.music.MusicManager;
import love.distributedrebirth.demo4d.music.MusicPlayerRenderer;
import love.distributedrebirth.demo4d.screen.BasePartRenderer;
import love.distributedrebirth.demo4d.screen.BasicConsoleRenderer;
import love.distributedrebirth.demo4d.screen.HebrewWalletRenderer;
import love.distributedrebirth.demo4d.screen.ScreenCredits;
import love.distributedrebirth.demo4d.screen.ScreenDefault;
import love.distributedrebirth.demo4d.screen.ScreenHelp;
import love.distributedrebirth.demo4d.screen.ScreenIntro;
import love.distributedrebirth.demo4d.screen.ScreenIntroMission;
import love.distributedrebirth.demo4d.screen.ScreenUnicode4D;
import net.spookygames.gdx.nativefilechooser.NativeFileChooser;

/**
 * Main loop render dispatcher and event handling.
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class Demo4DMain extends Game {
	private List<String> args;
	public NativeFileChooser fileChooser;
	public SpriteBatch batch;
	public BitmapFont font;
	public OrthographicCamera camera;
	public final int viewWidth = 800;
	public final int viewHeight = 600;
	public MusicManager music;
	
	private Map<Class<? extends Screen>,Screen> screens;
	private Map<Class<? extends ImGuiRenderer>,ImGuiRenderer> widgets;
	private ImBoolean showImGuiDemo = new ImBoolean(false);
	private ImBoolean showMusicPlayer = new ImBoolean(false);
	private ImBoolean showHebrewWallet = new ImBoolean(false);
	private ImBoolean showBasePart = new ImBoolean(false);
	private ImBoolean showBasicConsole = new ImBoolean(false);
	
	public Demo4DMain(List<String> args, NativeFileChooser fileChooser) {
		this.args = args;
		this.fileChooser = fileChooser;
	}
	
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		camera = new OrthographicCamera();
		
		camera.setToOrtho(false, viewWidth, viewHeight);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		
		music = new MusicManager();
		music.init();
		
		ImGuiSetup.init();
		widgets = new HashMap<>();
		putWidget(new MusicPlayerRenderer(this));
		putWidget(new HebrewWalletRenderer(this));
		putWidget(new BasePartRenderer(this));
		putWidget(new BasicConsoleRenderer(this));
		
		screens = new HashMap<>();
		putScreen(new ScreenIntro(this));
		putScreen(new ScreenIntroMission(this));
		putScreen(new ScreenDefault(this));
		putScreen(new ScreenCredits(this));
		putScreen(new ScreenHelp(this));
		putScreen(new ScreenMatrix4D(this));
		putScreen(new ScreenUnicode4D(this));
		
		if (args.contains("default")) {
			selectScreen(ScreenDefault.class);
		} else {
			selectScreen(ScreenIntro.class);
		}
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
		if (showBasePart.get()) {
			widgets.get(BasePartRenderer.class).render(showBasePart);
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
			if (ImGui.menuItem("Base Part")) {
				showBasePart.set(true);
			}
			if (ImGui.menuItem("Basic Console")) {
				showBasicConsole.set(true);
			}
			ImGui.separator();
			if (ImGui.menuItem("Music Player")) {
				showMusicPlayer.set(true);
			}
			if (ImGui.menuItem("Stop Music")) {
				music.stop();
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
		return true;
	}
}
