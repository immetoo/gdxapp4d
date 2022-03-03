package love.distributedrebirth.gdxapp4d.app.tosamp;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxBootArgs;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxLog;
import love.distributedrebirth.gdxapp4d.vrgem4.service.VrGem4DeskAppService;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppLauncher;

@Component
public class TosAmpComponent {
	
	@Reference
	private SystemGdxLog log;
	
	@Reference
	private VrGem4DeskAppService deskAppService;
	
	@Reference
	private SystemGdxBootArgs bootArgs;
	
	@Activate
	void open() {
		log.info(this, "Activated TosAmpComponent");
		deskAppService.registrateDeskApp(new DeskAppLauncher("TosAmp", () -> new TosAmpDeskApp(bootArgs.getFileChooser())));
	}
	
	@Deactivate
	void close() {
	}
}
