package love.distributedrebirth.gdxapp.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp.GDXAppMain;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class ScreenLoading extends ScreenAdapter {
	private Texture backgroundImage;
	
	public ScreenLoading() {
		backgroundImage = new Texture(Gdx.files.internal("background/gdxapp-loading.png"));
	}
	
	@Override
	public void render(float delta) {
		GDXAppMain.INSTANCE.batch.begin();
		GDXAppMain.INSTANCE.batch.draw(backgroundImage, 0, 0, GDXAppMain.INSTANCE.viewWidth, GDXAppMain.INSTANCE.viewHeight);
		GDXAppMain.INSTANCE.batch.end();
	}

	@Override
	public void dispose() {
		backgroundImage.dispose();
	}
}
