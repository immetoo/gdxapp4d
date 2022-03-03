package love.distributedrebirth.gdxapp4d.app.hewallet;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxLog;
import love.distributedrebirth.gdxapp4d.vrgem4.service.VrGem4DeskAppService;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppLauncher;

@Component
public class HeWalletComponent {
	
	@Reference
	private SystemGdxLog log;
	
	@Reference
	private VrGem4DeskAppService deskAppService;
	
	@Activate
	void open() {
		log.info(this, "Activated HeWalletComponent");
		deskAppService.registrateDeskApp(new DeskAppLauncher("Hebrew Wallet", () -> new HeWalletDeskApp()));
	}
	
	@Deactivate
	void close() {
	}
}
