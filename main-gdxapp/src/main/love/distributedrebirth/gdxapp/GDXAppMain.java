package love.distributedrebirth.gdxapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badlogic.gdx.ApplicationListener;
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
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnPackageInfoʸᴰ;
import love.distributedrebirth.bassboonyd.jmx.DefaultEnumBaseᴶᴹˣ;
import love.distributedrebirth.bassboonyd.jmx.DefaultEnumInstanceᴶᴹˣ;
import love.distributedrebirth.bassboonyd.jmx.GuageCounterᴶᴹˣ;
import love.distributedrebirth.gdxapp.desktop.DeskAppContourSection;
import love.distributedrebirth.gdxapp.desktop.DeskAppRenderer;
import love.distributedrebirth.gdxapp.desktop.DeskTopScreen;
import love.distributedrebirth.gdxapp.desktop.DeskTopScreenMenu;
import love.distributedrebirth.gdxapp.music.MusicManager;
import love.distributedrebirth.gdxapp.music.MusicSongType;
import love.distributedrebirth.gdxapp.screen.ScreenCredits;
import love.distributedrebirth.gdxapp.screen.ScreenDesktop1;
import love.distributedrebirth.gdxapp.screen.ScreenDesktop2;
import love.distributedrebirth.gdxapp.screen.ScreenDesktop3;
import love.distributedrebirth.gdxapp.screen.ScreenDesktop4;
import love.distributedrebirth.gdxapp.screen.ScreenHelp;
import love.distributedrebirth.gdxapp.screen.ScreenIntro;
import love.distributedrebirth.gdxapp.screen.ScreenIntroMission;
import love.distributedrebirth.gdxapp.screen.ScreenLoading;
import love.distributedrebirth.numberxd.base2t.Base2PartsFactory;
import love.distributedrebirth.numberxd.base2t.Base2Terminator;
import love.distributedrebirth.numberxd.base2t.part.warp.TOSWarpCore;
import love.distributedrebirth.numberxd.glyph.BaseGlyphSet;
import love.distributedrebirth.warpme.TOSWarpCoreDriver;
import love.distributedrebirth.warpme.core.WaterBucket;
import net.spookygames.gdx.nativefilechooser.NativeFileChooser;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnClassInfoʸᴰ(name = "GDXAppMain", purpose = "Main loop render dispatcher and bootup.")
@BãßBȍőnPackageInfoʸᴰ(name = "love.distributedrebirth.gdxapp")
public enum GDXAppMain implements DefaultEnumInstanceᴶᴹˣ<GDXAppMain,GDXAppMainKeyʸᴰ>,ApplicationListener {
	
	INSTANCE;
	
	protected Screen screen;
	private int lazyIntCnt = 33;
	private List<String> args;
	public NativeFileChooser fileChooser;
	public SpriteBatch batch;
	public BitmapFont font;
	public OrthographicCamera camera;
	public int viewWidth;
	public int viewHeight;
	public MusicManager music;
	public ImBoolean showImGuiDemo = new ImBoolean(false);
	private Map<Class<? extends Screen>,Screen> screens;
	private DeskTopScreenMenu screenMenu;
	private final GuageCounterᴶᴹˣ selectScreenCounter;
	private final BãßBȍőnCoffinOpenʸᴰ<GDXAppMainKeyʸᴰ> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<GDXAppMainKeyʸᴰ> GET_BBC() { return BBC; }
	
	private GDXAppMain() {
		BBC.BOON_INIT(this);
		BȍőnJmxInit(GDXAppMainKeyʸᴰ.JMX);
		selectScreenCounter = BȍőnJmxInitGuageCounter(GDXAppMainKeyʸᴰ.JMX, "selectScreenCounter");
	}
	
	public void BãßInit(List<String> args, int viewWidth, int viewHeight, NativeFileChooser fileChooser) {
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
		BãßBȍőnCoffinOpenʸᴰ.lockCoffin(this);
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
			selectScreen(ScreenDesktop1.class);
			music.play(MusicSongType.BACKGROUND);
		} else {
			selectScreen(ScreenIntro.class);
		}
	}
	
	private void putScreen(Screen screen) {
		screens.put(screen.getClass(), screen);
	}
	
	public void selectScreen(Class<? extends Screen> screenClass) {
		Screen screen = screens.get(screenClass);
		if (screen == null) {
			throw new NullPointerException("Unknow screen: "+screenClass);
		}
		selectScreenCounter.increment();
		if (this.screen != null) this.screen.hide();
		this.screen = screen;
		if (this.screen != null) {
			this.screen.show();
			this.screen.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		}
	}
	
	@Override
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
		
		DeskTopScreen desktop1 = new ScreenDesktop1(this);
		DeskTopScreen desktop2 = new ScreenDesktop2(this);
		DeskTopScreen desktop3 = new ScreenDesktop3();
		DeskTopScreen desktop4 = new ScreenDesktop4();
		screenMenu = new DeskTopScreenMenu(this, desktop1, desktop2, desktop3, desktop4);
		
		putScreen(new ScreenLoading());
		putScreen(new ScreenIntro());
		putScreen(new ScreenIntroMission());
		putScreen(desktop1);
		putScreen(desktop2);
		putScreen(desktop3);
		putScreen(desktop4);
		putScreen(new ScreenCredits());
		putScreen(new ScreenHelp());
		
		selectScreen(ScreenLoading.class);
	}
	
	@Override
	public void resize(int width, int height) {
		if (screen != null) screen.resize(width, height);
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
		
		DeskTopScreen appScreen = null;
		if (screen instanceof DeskTopScreen) {
			appScreen = DeskTopScreen.class.cast(screen);
			screenMenu.renderMenu(appScreen);
		}
		if (showImGuiDemo.get()) {
			ImGui.showDemoWindow(showImGuiDemo);
		}
		if (appScreen != null && appScreen.getDeskAppScreen().getCurrentDeskApp() != null) {
			int sizeFlags = ImGuiCond.Always;
			ImGui.setNextWindowPos(0, 28, sizeFlags);
			ImGui.setNextWindowSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight() - 28, sizeFlags);
			int windowFlags = ImGuiWindowFlags.NoMove | ImGuiWindowFlags.NoResize | ImGuiWindowFlags.NoTitleBar;
			if (ImGui.begin(appScreen.getDeskAppScreen().getCurrentDeskApp().getTitle(), windowFlags)) {
				DeskAppRenderer renderer = appScreen.getDeskAppScreen().getCurrentDeskApp().getContours().getContour(DeskAppContourSection.MAIN);
				if (renderer != null) {
					renderer.render();
				}
			}
			ImGui.end();
		}
		if (screen != null) {
			screen.render(Gdx.graphics.getDeltaTime());
		}
		ImGui.render();
		ImGuiSetup.imGuiGlImp.renderDrawData(ImGui.getDrawData());
	}
	
	@Override
	public void pause() {
		if (screen != null) {
			screen.pause();
		}
	}
	
	@Override
	public void resume() {
		if (screen != null) {
			screen.resume();
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
}
