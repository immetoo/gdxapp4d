package love.distributedrebirth.gdxapp4d.tos4;

import org.osgi.framework.launch.Framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationLogger;
import com.badlogic.gdx.Gdx;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class GDXAppTos4Startup {

	private static final Logger LOG = LoggerFactory.getLogger(GDXAppTos4Startup.class);
	
	public static Framework init(GDXAppTos4 tos4, GDXAppTos4Activator systemActivator) {
		LOG.info("init framework");
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		Gdx.app.setApplicationLogger(new GDXAppApplicationLogger());
		
		final Framework systemBundle = GDXAppTos4BootFactory.createFramework();
		final GDXAppTos4BootScreen bootScreen = new GDXAppTos4BootScreen();
		
		systemActivator.addBootListener(bootScreen);
		tos4.registrateScreen(bootScreen);
		tos4.selectScreen(GDXAppTos4BootScreen.class);
		
		Runnable run = () -> {
			try {
				systemBundle.init();
				systemBundle.start();
				systemActivator.start(systemBundle.getBundleContext());
				
				Gdx.app.postRunnable(() -> {
					LOG.debug("Release boot screen");
					systemActivator.removeBootListener(bootScreen);
					tos4.disposeScreen(bootScreen);
				});
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
		Thread framework = new Thread(run);
		framework.setName("boot");
		framework.start();
		
		return systemBundle;
	}
	
	static class GDXAppApplicationLogger implements ApplicationLogger {
		
		@Override
		public void log(String tag, String message) {
			LoggerFactory.getLogger(tag).info(message);
		}
		
		@Override
		public void log(String tag, String message, Throwable exception) {
			LoggerFactory.getLogger(tag).info(message, exception);
		}
		
		@Override
		public void error(String tag, String message) {
			LoggerFactory.getLogger(tag).error(message);
		}
		
		@Override
		public void error(String tag, String message, Throwable exception) {
			LoggerFactory.getLogger(tag).error(message, exception);
		}
		
		@Override
		public void debug(String tag, String message) {
			LoggerFactory.getLogger(tag).debug(message);
		}
		
		@Override
		public void debug(String tag, String message, Throwable exception) {
			LoggerFactory.getLogger(tag).debug(message, exception);
		}
	}
}
