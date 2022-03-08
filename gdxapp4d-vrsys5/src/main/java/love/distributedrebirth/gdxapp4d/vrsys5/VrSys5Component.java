package love.distributedrebirth.gdxapp4d.vrsys5;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxLog;
import love.distributedrebirth.gdxapp4d.vrgem4.service.VrGem4DeskAppService;
import love.distributedrebirth.gdxapp4d.vrgem4.service.VrGem4LocaleService;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppLauncher;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppMenuSection;
import love.distributedrebirth.gdxapp4d.vrsys5.apps.BaseUnicodePlaneDeskApp;
import love.distributedrebirth.gdxapp4d.vrsys5.apps.BasicConsoleDeskApp;

@Component
public class VrSys5Component {
	
	@Reference
	private SystemGdxLog log;
	
	@Reference
	private VrGem4DeskAppService deskAppService;
	
	@Reference
	private VrGem4LocaleService localeService;
	
	private final DeskAppLauncher basicLauncher;
	private final DeskAppLauncher unicodeLauncher;
	
	public VrSys5Component() {
		basicLauncher = new DeskAppLauncher("Basic Console", () -> new BasicConsoleDeskApp());
		unicodeLauncher = new DeskAppLauncher("Base Unicode Plane", () -> new BaseUnicodePlaneDeskApp(localeService));
	}
	
	@Activate
	void open() {
		log.debug(this, SystemGdxLog.ACTIVATE);
		deskAppService.installDeskApp(DeskAppMenuSection.SYSTEM, basicLauncher);
		deskAppService.installDeskApp(DeskAppMenuSection.SYSTEM, unicodeLauncher);
	}
	
	@Deactivate
	void close() {
		log.debug(this, SystemGdxLog.DEACTIVATE);
		deskAppService.installDeskApp(DeskAppMenuSection.SYSTEM, basicLauncher);
		deskAppService.installDeskApp(DeskAppMenuSection.SYSTEM, unicodeLauncher);
	}
}
