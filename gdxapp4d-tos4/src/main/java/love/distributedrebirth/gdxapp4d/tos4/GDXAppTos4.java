package love.distributedrebirth.gdxapp4d.tos4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.framework.BundleException;
import org.osgi.framework.launch.Framework;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnClassInfoʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinOpenʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnCoffinʸᴰ;
import love.distributedrebirth.bassboonyd.BãßBȍőnPackageInfoʸᴰ;
import love.distributedrebirth.bassboonyd.jmx.DefaultEnumInstanceᴶᴹˣ;
import love.distributedrebirth.bassboonyd.jmx.GuageCounterᴶᴹˣ;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxTerminal;
import net.spookygames.gdx.nativefilechooser.NativeFileChooser;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
@BãßBȍőnClassInfoʸᴰ(name = "GDXAppTos4", purpose = "Main loop render dispatcher and bootup.")
@BãßBȍőnPackageInfoʸᴰ(name = "love.distributedrebirth.gdxapp4d.tos4")
public enum GDXAppTos4 implements DefaultEnumInstanceᴶᴹˣ<GDXAppTos4,GDXAppTos4Keyʸᴰ>, ApplicationListener, SystemGdxTerminal {

	INSTANCE;

	private Screen screen;
	private Framework systemBundle;
	private GDXAppTos4Activator systemActivator;
	private Map<Class<? extends Screen>,Screen> screens;
	private final GuageCounterᴶᴹˣ selectScreenCounter;
	private final BãßBȍőnCoffinOpenʸᴰ<GDXAppTos4Keyʸᴰ> BBC = BãßBȍőnCoffinOpenʸᴰ.newInstance();
	public BãßBȍőnCoffinʸᴰ<GDXAppTos4Keyʸᴰ> GET_BBC() { return BBC; }
	
	private GDXAppTos4() {
		BBC.BOON_INIT(this);
		BȍőnJmxInit(GDXAppTos4Keyʸᴰ.JMX);
		selectScreenCounter = BȍőnJmxInitGuageCounter(GDXAppTos4Keyʸᴰ.JMX, "selectScreenCounter");
	}
	
	public void BãßInit(List<String> args, int viewWidth, int viewHeight, NativeFileChooser fileChooser) {
		screens = new HashMap<>();
		systemActivator = new GDXAppTos4Activator();
		systemActivator.BãßInit(args, viewWidth, viewHeight, fileChooser, this);
	}
	
	@Override
	public void create() {
		systemBundle = GDXAppTos4Startup.init(this, systemActivator);
	}
	
	@Override
	public void resize(int width, int height) {
		if (screen != null) {
			screen.resize(width, height);
		}
	}
	
	@Override
	public void render() {
		ScreenUtils.clear(0f, 0f, 0f, 1f, true);
		if (screen != null) {
			screen.render(Gdx.graphics.getDeltaTime());
		}
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
		this.screen = null;
		for (Screen screen:screens.values()) {
			screen.dispose();
		}
		try {
			systemBundle.stop();
		} catch (BundleException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void registrateScreen(Screen screen) {
		screens.put(screen.getClass(), screen);
	}

	@Override
	public void disposeScreen(Screen screen) {
		screens.remove(screen.getClass());
		screen.dispose();
	}

	@Override
	public void selectScreen(Class<? extends Screen> screenClass) {
		Screen screen = screens.get(screenClass);
		if (screen == null) {
			throw new NullPointerException("Unknow screen: "+screenClass);
		}
		if (this.screen != null) {
			this.screen.hide();
		}
		this.screen = screen;
		this.screen.show();
		this.screen.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		selectScreenCounter.increment();
	}
}
