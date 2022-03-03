package love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp;

import java.util.function.Supplier;

public final class DeskAppLauncher {

	private final String name;
	private final Supplier<DeskApp> launcher;
	
	public DeskAppLauncher(String name, Supplier<DeskApp> launcher) {
		this.name = name;
		this.launcher = launcher;
	}
	
	public String getName() {
		return name;
	}
	
	public Supplier<DeskApp> getLauncher() {
		return launcher;
	}
}
