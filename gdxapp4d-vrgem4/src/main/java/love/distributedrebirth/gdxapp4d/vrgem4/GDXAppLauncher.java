package love.distributedrebirth.gdxapp4d.vrgem4;

import java.util.function.Supplier;

import love.distributedrebirth.gdxapp4d.vrgem4.desktop.DefaultDeskApp;

public final class GDXAppLauncher {

	private final String name;
	private final Supplier<DefaultDeskApp> launcher;
	
	public GDXAppLauncher(String name, Supplier<DefaultDeskApp> launcher) {
		this.name = name;
		this.launcher = launcher;
	}
	
	public String getName() {
		return name;
	}
	
	public Supplier<DefaultDeskApp> getLauncher() {
		return launcher;
	}
}
