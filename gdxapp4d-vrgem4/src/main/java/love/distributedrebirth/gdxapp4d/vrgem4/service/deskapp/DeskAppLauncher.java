package love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp;

import java.util.function.Supplier;

public final class DeskAppLauncher {

	private final DeskAppMenuSection menuSection;
	private final String name;
	private final Supplier<DeskApp> launcher;
	
	public DeskAppLauncher(DeskAppMenuSection menuSection, String name, Supplier<DeskApp> launcher) {
		this.menuSection = menuSection;
		this.name = name;
		this.launcher = launcher;
	}
	
	public DeskAppMenuSection getMenuSection() {
		return menuSection;
	}
	
	public String getName() {
		return name;
	}
	
	public Supplier<DeskApp> getLauncher() {
		return launcher;
	}
}
