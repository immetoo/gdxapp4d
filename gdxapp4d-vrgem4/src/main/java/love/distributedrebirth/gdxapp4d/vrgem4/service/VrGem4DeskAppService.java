package love.distributedrebirth.gdxapp4d.vrgem4.service;

import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppLauncher;

public interface VrGem4DeskAppService {
	
	void installDeskApp(DeskAppLauncher launcher);
	
	void removeDeskApp(DeskAppLauncher launcher);
}
