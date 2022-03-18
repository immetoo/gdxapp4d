package love.distributedrebirth.gdxapp4d.app.glyphdemo;

import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import love.distributedrebirth.gdxapp4d.app.glyphdemo.apps.DemoUnicodePlaneDeskApp;
import love.distributedrebirth.gdxapp4d.app.glyphdemo.apps.DemoGlyphSetDeskApp;
import love.distributedrebirth.gdxapp4d.app.glyphdemo.apps.DemoNumberPartDeskApp;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxLog;
import love.distributedrebirth.gdxapp4d.vrgem4.service.VrGem4DeskAppService;
import love.distributedrebirth.gdxapp4d.vrgem4.service.VrGem4LocaleService;
import love.distributedrebirth.gdxapp4d.vrgem4.service.VrGem4Unicode4DService;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppLauncher;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppMenuSection;

@Component
public class GlyphDemoComponent {
	
	@Reference
	private SystemGdxLog log;
	
	@Reference
	private VrGem4DeskAppService deskAppService;
	
	@Reference
	private VrGem4LocaleService localeService;
	
	@Reference
	private VrGem4Unicode4DService unicode4DService;
	
	private final static String I18N_BUNDLE = "love.distributedrebirth.gdxapp4d.app.glyphdemo.Main";
	private final DeskAppLauncher unicodeLauncher;
	private final DeskAppLauncher baseGlyphLauncher;
	private final DeskAppLauncher basePartLauncher;
	
	public GlyphDemoComponent() {
		unicodeLauncher = new DeskAppLauncher(DeskAppMenuSection.PROGRAMMING, "Demo Unicode Plane", () -> new DemoUnicodePlaneDeskApp(createBundle(), unicode4DService));
		baseGlyphLauncher = new DeskAppLauncher(DeskAppMenuSection.PROGRAMMING, "Demo Glyph Set", () -> new DemoGlyphSetDeskApp(createBundle()));
		basePartLauncher = new DeskAppLauncher(DeskAppMenuSection.PROGRAMMING, "Demo Number Parts", () -> new DemoNumberPartDeskApp(createBundle()));
	}
	
	private ResourceBundle createBundle() {
		return ResourceBundle.getBundle(I18N_BUNDLE, localeService.getTextLocale());
	}
	
	@Activate
	void open() {
		log.debug(this, SystemGdxLog.ACTIVATE);
		deskAppService.installDeskApp(unicodeLauncher);
		deskAppService.installDeskApp(baseGlyphLauncher);
		deskAppService.installDeskApp(basePartLauncher);
	}
	
	@Deactivate
	void close() {
		log.debug(this, SystemGdxLog.DEACTIVATE);
		deskAppService.removeDeskApp(unicodeLauncher);
		deskAppService.removeDeskApp(baseGlyphLauncher);
		deskAppService.removeDeskApp(basePartLauncher);
	}
}
