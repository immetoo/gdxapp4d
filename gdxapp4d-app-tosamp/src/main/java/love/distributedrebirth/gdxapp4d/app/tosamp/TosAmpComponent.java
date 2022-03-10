package love.distributedrebirth.gdxapp4d.app.tosamp;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxBootArgs;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxLog;
import love.distributedrebirth.gdxapp4d.vrgem4.service.VrGem4DeskAppService;
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
	
	private final DeskAppLauncher launcher;
	
	public TosAmpComponent() {
		launcher = new DeskAppLauncher("TosAmp", () -> new TosAmpDeskApp(bootArgs.getFileChooser()));
	}
	
	@Activate
	void open() {
		log.debug(this, SystemGdxLog.ACTIVATE);
		deskAppService.installDeskApp(DeskAppMenuSection.MULTIMEDIA, launcher);
	}
	
	@Deactivate
	void close() {
		log.debug(this, SystemGdxLog.DEACTIVATE);
		deskAppService.removeDeskApp(DeskAppMenuSection.MULTIMEDIA, launcher);
	}
}
