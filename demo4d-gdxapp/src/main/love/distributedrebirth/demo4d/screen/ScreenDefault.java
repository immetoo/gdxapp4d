package love.distributedrebirth.demo4d.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.demo4d.Demo4DMain;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class ScreenDefault extends ScreenAdapter {
	private final Demo4DMain main;
	private Texture backgroundImage;
	
	public ScreenDefault(final Demo4DMain main) {
		this.main = main;
		backgroundImage = new Texture(Gdx.files.internal("background/terrydavis-front.png"));
	}
	
	@Override
	public void render(float delta) {
		ScreenUtils.clear(0f, 0f, 0f, 1f);
		main.batch.begin();
		main.batch.draw(backgroundImage, 0, 0, main.viewWidth, main.viewHeight);
		main.batch.end();
	}

	@Override
	public void dispose() {
		backgroundImage.dispose();
	}
}
