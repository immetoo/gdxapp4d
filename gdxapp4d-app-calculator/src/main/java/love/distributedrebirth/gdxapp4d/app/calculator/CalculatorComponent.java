package love.distributedrebirth.gdxapp4d.app.calculator;

import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxLog;
import love.distributedrebirth.gdxapp4d.vrgem4.service.VrGem4DeskAppService;
import love.distributedrebirth.gdxapp4d.vrgem4.service.VrGem4LocaleService;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppLauncher;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppMenuSection;

@Component
public class CalculatorComponent {
	
	@Reference
	private SystemGdxLog log;
	
	@Reference
	private VrGem4DeskAppService deskAppService;
	
	@Reference
	private VrGem4LocaleService localeService;
	
	private final static String I18N_BUNDLE = "love.distributedrebirth.gdxapp4d.app.calculator.Main";
	private final DeskAppLauncher launcher;
	
	public CalculatorComponent() {
		launcher = new DeskAppLauncher(DeskAppMenuSection.PROGRAMMING, "Calculator", () -> new CalculatorDeskApp(createBundle()));
	}
	
	private ResourceBundle createBundle() {
		return ResourceBundle.getBundle(I18N_BUNDLE, localeService.getTextLocale());
	}
	
	@Activate
	void open() {
		log.debug(this, SystemGdxLog.ACTIVATE);
		deskAppService.installDeskApp(launcher);
	}
	
	@Deactivate
	void close() {
		log.debug(this, SystemGdxLog.DEACTIVATE);
		deskAppService.removeDeskApp(launcher);
	}
}
