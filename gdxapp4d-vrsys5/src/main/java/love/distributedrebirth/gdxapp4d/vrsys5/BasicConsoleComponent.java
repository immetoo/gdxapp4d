package love.distributedrebirth.gdxapp4d.vrsys5;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxLog;
import love.distributedrebirth.gdxapp4d.vrgem4.service.VrGem4DeskAppService;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppLauncher;

@Component
public class BasicConsoleComponent {
	
	@Reference
	private SystemGdxLog log;
	
	@Reference
	private VrGem4DeskAppService deskAppService;
	
	@Activate
	void open() {
		log.info(this, "Activate BasicConsoleComponent");
		deskAppService.registrateDeskApp(new DeskAppLauncher("Basic Console", () -> new BasicConsoleDeskApp()));
	}
	
	@Deactivate
	void close() {
	}
}
