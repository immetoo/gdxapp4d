package love.distributedrebirth.gdxapp4d.vrgem4.service;

import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppLauncher;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppMenuSection;

public interface VrGem4DeskAppService {
	
	void installDeskApp(DeskAppMenuSection section, DeskAppLauncher launcher);
	
	void removeDeskApp(DeskAppMenuSection section, DeskAppLauncher launcher);
}
