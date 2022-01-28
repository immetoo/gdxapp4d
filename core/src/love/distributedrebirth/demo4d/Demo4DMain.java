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
import love.distributedrebirth.demo4d.music.MusicManager;
import net.spookygames.gdx.nativefilechooser.NativeFileChooser;

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
	private ImBoolean showImGuiDemo = new ImBoolean(false);
	private ImBoolean showMusicPlayer = new ImBoolean(false);
	private ImBoolean showHebrewWallet = new ImBoolean(false);
	private MainScreenRender render;
	
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
		
		render = new MainScreenRender(this);
		
		ImGuiSetup.init();
		
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
			//render.renderMusicPlayer(showMusicPlayer);
		}
		if (showHebrewWallet.get()) {
			render.renderHebrewWallet(showHebrewWallet);
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
			if (ImGui.menuItem("Hebrew Wallet")) {
				showHebrewWallet.set(true);
			}
			ImGui.separator();
			if (ImGui.menuItem("ImGui")) {
				showImGuiDemo.set(true);
			}
			ImGui.separator();
			if (ImGui.menuItem("Stop Music")) {
				music.stop();
			}
			if (ImGui.menuItem("Music Player")) {
				showMusicPlayer.set(true);
			}
			ImGui.separator();
			if (ImGui.menuItem("Exit")) {
				dispose();
				System.exit(0);
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
