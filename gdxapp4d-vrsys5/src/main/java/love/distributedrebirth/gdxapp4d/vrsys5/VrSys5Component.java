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
import love.distributedrebirth.gdxapp4d.vrsys5.apps.BasicConsoleDeskApp;
import love.distributedrebirth.gdxapp4d.vrsys5.apps.ImGuiDeskApp;
import love.distributedrebirth.gdxapp4d.vrsys5.apps.SettingLocaleDeskApp;

@Component
public class VrSys5Component {
	
	@Reference
	private SystemGdxLog log;
	
	@Reference
	private VrGem4DeskAppService deskAppService;
	
	@Reference
	private VrGem4LocaleService localeService;
	
	private final DeskAppLauncher basicLauncher;
	private final DeskAppLauncher imguiLauncher;
	private final DeskAppLauncher localeLauncher;
	
	public VrSys5Component() {
		basicLauncher = new DeskAppLauncher(DeskAppMenuSection.SYSTEM, "Basic Console", () -> new BasicConsoleDeskApp());
		imguiLauncher = new DeskAppLauncher(DeskAppMenuSection.PROGRAMMING, "ImGui Demo", () -> new ImGuiDeskApp());
		localeLauncher = new DeskAppLauncher(DeskAppMenuSection.SYSTEM, "Locale", () -> new SettingLocaleDeskApp(localeService));
	}
	
	@Activate
	void open() {
		log.debug(this, SystemGdxLog.ACTIVATE);
		deskAppService.installDeskApp(basicLauncher);
		deskAppService.installDeskApp(imguiLauncher);
		deskAppService.installDeskApp(localeLauncher);
	}
	
	@Deactivate
	void close() {
		log.debug(this, SystemGdxLog.DEACTIVATE);
		deskAppService.removeDeskApp(basicLauncher);
		deskAppService.removeDeskApp(imguiLauncher);
		deskAppService.removeDeskApp(localeLauncher);
	}
}
