package love.distributedrebirth.gdxapp4d.app.tosamp;

import java.util.ResourceBundle;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxBootArgs;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxLog;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemWarpShip;
import love.distributedrebirth.gdxapp4d.vrgem4.service.VrGem4DeskAppService;
import love.distributedrebirth.gdxapp4d.vrgem4.service.VrGem4LocaleService;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppLauncher;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppMenuSection;

@Component
public class TosAmpComponent {
	
	@Reference
	private SystemGdxLog log;
	
	@Reference
	private VrGem4DeskAppService deskAppService;
	
	@Reference
	private SystemGdxBootArgs bootArgs;
	
	@Reference
	private SystemWarpShip warpShip;
	
	@Reference
	private VrGem4LocaleService localeService;
	
	private final static String I18N_BUNDLE = "love.distributedrebirth.gdxapp4d.app.tosamp.Messages";
	private DeskAppLauncher launcher;
	
	public TosAmpComponent() {
	}
	
	private ResourceBundle createBundle() {
		return ResourceBundle.getBundle(I18N_BUNDLE, localeService.getTextLocale());
	}
	
	@Activate
	void open(final BundleContext context) {
		log.debug(this, SystemGdxLog.ACTIVATE);
		launcher = new DeskAppLauncher(DeskAppMenuSection.MULTIMEDIA, "TosAmp", () -> new TosAmpDeskApp(createBundle(), bootArgs.getFileChooser(), context, warpShip));
		deskAppService.installDeskApp(launcher);
	}
	
	@Deactivate
	void close() {
		log.debug(this, SystemGdxLog.DEACTIVATE);
		deskAppService.removeDeskApp(launcher);
	}
}
