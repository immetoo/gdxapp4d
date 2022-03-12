package love.distributedrebirth.gdxapp4d.tos4;

import org.osgi.framework.launch.Framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badlogic.gdx.Gdx;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class GDXAppTos4Startup {

	private static final Logger LOG = LoggerFactory.getLogger(GDXAppTos4Startup.class);
	
	public static Framework init(GDXAppTos4 tos4, GDXAppTos4Activator systemActivator) {
		LOG.info("Startup framework");
		final Framework systemBundle = GDXAppTos4BootFactory.createFramework();
		final GDXAppTos4BootScreen bootScreen = new GDXAppTos4BootScreen();
		
		systemActivator.setBootListener(bootScreen);
		tos4.registrateScreen(bootScreen);
		tos4.selectScreen(GDXAppTos4BootScreen.class);
		
		Runnable run = () -> {
			try {
				systemBundle.init();
				systemBundle.start();
				LOG.debug("Startup system-activator");
				systemActivator.start(systemBundle.getBundleContext());
				
				if (!systemActivator.hasStartError()) {
					Gdx.app.postRunnable(() -> {
						LOG.debug("Release boot-screen");
						systemActivator.setBootListener(null);
						tos4.disposeScreen(bootScreen);
						systemActivator.fireBootCompleted();
					});
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
		Thread framework = new Thread(run);
		framework.setName("boot");
		framework.start();
		
		return systemBundle;
	}
}
