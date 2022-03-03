package love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
abstract public class AbstractDeskApp implements DeskApp {
	
	private final DeskAppContour contours;

	public AbstractDeskApp() {
		this.contours = new DeskAppContour();
	}
	
	@Override
	public DeskAppContour getContours() {
		return contours;
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}
}
