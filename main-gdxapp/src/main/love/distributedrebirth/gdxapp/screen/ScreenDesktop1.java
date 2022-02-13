package love.distributedrebirth.gdxapp.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp.GDXAppMain;
import love.distributedrebirth.gdxapp.GDXAppScreen;
import love.distributedrebirth.gdxapp.desktop.DeskAppScreen;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class ScreenDesktop1 extends ScreenAdapter implements GDXAppScreen {
	private final GDXAppMain main;
	private DeskAppScreen deskAppScreen;
	private Texture backgroundImage;
	
	public ScreenDesktop1(final GDXAppMain main) {
		this.main = main;
		deskAppScreen = new DeskAppScreen("Desktop1");
		backgroundImage = new Texture(Gdx.files.internal("background/terrydavis-nose.png"));
	}
	
	@Override
	public void render(float delta) {
		main.batch.begin();
		main.batch.draw(backgroundImage, 0, 0, main.viewWidth, main.viewHeight);
		main.batch.end();
	}

	@Override
	public void dispose() {
		backgroundImage.dispose();
	}

	@Override
	public DeskAppScreen getDeskAppScreen() {
		return deskAppScreen;
	}
}
