package love.distributedrebirth.gdxapp4d.vrgem4;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxLog;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemWarpShip;

@Component
public class TestComponent {
	
	@Reference
	private SystemGdxLog log;
	
	@Reference
	private SystemWarpShip warpShip;
	
	@Activate
	void open() {
		log.info(this, "Activated warpEngine: {}", warpShip.getWarpShip().theShip().getEngine());
	}
	
	@Deactivate
	void close() {
	}
}
