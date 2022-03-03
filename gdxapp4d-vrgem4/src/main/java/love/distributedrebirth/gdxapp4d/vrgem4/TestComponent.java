package love.distributedrebirth.gdxapp4d.vrgem4;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxLog;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemWarpShip;
import love.distributedrebirth.gdxapp4d.vrgem4.service.VrGem4DeskAppService;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppLauncher;

@Component
public class TestComponent {
	
	@Reference
	private SystemGdxLog log;
	
	@Reference
	private SystemWarpShip warpShip;
	
	@Activate
	void open() {
		log.info(this, "Activated22222 warpEngine: {}", warpShip.getWarpShip().theShip().getEngine());
	}
	
	@Deactivate
	void close() {
	}
}
