package love.distributedrebirth.gdxapp;

import java.util.function.Supplier;

import love.distributedrebirth.gdxapp.desktop.DefaultDeskApp;

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
