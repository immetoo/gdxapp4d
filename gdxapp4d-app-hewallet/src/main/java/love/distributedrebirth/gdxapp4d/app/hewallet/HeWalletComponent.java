package love.distributedrebirth.gdxapp4d.app.hewallet;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxLog;
import love.distributedrebirth.gdxapp4d.vrgem4.service.VrGem4DeskAppService;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppLauncher;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppMenuSection;

@Component
public class HeWalletComponent {
	
	@Reference
	private SystemGdxLog log;
	
	@Reference
	private VrGem4DeskAppService deskAppService;
	
	private final DeskAppLauncher launcher;
	
	public HeWalletComponent() {
		launcher = new DeskAppLauncher("Hebrew Wallet", () -> new HeWalletDeskApp());
	}
	
	@Activate
	void open() {
		log.debug(this, SystemGdxLog.ACTIVATE);
		deskAppService.installDeskApp(DeskAppMenuSection.INTERNET, launcher);
	}
	
	@Deactivate
	void close() {
		log.debug(this, SystemGdxLog.DEACTIVATE);
		deskAppService.removeDeskApp(DeskAppMenuSection.INTERNET, launcher);
	}
}
