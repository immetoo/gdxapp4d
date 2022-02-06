package love.distributedrebirth.gdxapp.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp.GDXAppMain;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class ScreenLoading extends ScreenAdapter {
	private final GDXAppMain main;
	private Texture backgroundImage;
	
	public ScreenLoading(final GDXAppMain main) {
		this.main = main;
		backgroundImage = new Texture(Gdx.files.internal("background/gdxapp-loading.png"));
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
}
