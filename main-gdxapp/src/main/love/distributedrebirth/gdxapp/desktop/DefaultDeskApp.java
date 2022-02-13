package love.distributedrebirth.gdxapp.desktop;

public class DefaultDeskApp implements DeskApp {
	
	private final String name;
	private final String icon;
	private final DeskAppContour contours;

	public DefaultDeskApp(String name, String icon) {
		this.name = name;
		this.icon = icon;
		this.contours = new DeskAppContour();
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String getIcon() {
		return icon;
	}
	
	@Override
	public DeskAppContour getContours() {
		return contours;
	}
}
