package love.distributedrebirth.gdxapp.desktop;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class DefaultDeskApp implements DeskApp {
	
	private String title;
	private String icon;
	private final DeskAppContour contours;

	public DefaultDeskApp() {
		this.contours = new DeskAppContour();
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String getTitle() {
		return title;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
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
