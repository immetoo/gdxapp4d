package love.distributedrebirth.gdxapp.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp.GDXAppMain;
import love.distributedrebirth.gdxapp.music.MusicSongType;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class ScreenIntro extends ScreenAdapter {
	private Texture backgroundImage;
	private float colorDeltaTime = 0f;
	private boolean colorPositive = true;

	public ScreenIntro() {
		backgroundImage = new Texture(Gdx.files.internal("background/temple-os.png"));
	}
	
	@Override
	public void render(float delta) {
		if (colorPositive) {
			colorDeltaTime += Gdx.graphics.getDeltaTime()/2;
		} else {
			colorDeltaTime -= Gdx.graphics.getDeltaTime()/2;
		}
		if (colorDeltaTime > 1f) {
			colorPositive = false;
		} else if (colorDeltaTime < 0f) {
			colorPositive = true;
		}
		ScreenUtils.clear(0.333f, colorDeltaTime, colorDeltaTime, 1);

		GDXAppMain.INSTANCE.batch.begin();
		GDXAppMain.INSTANCE.batch.draw(backgroundImage, 0, 0, GDXAppMain.INSTANCE.viewWidth, GDXAppMain.INSTANCE.viewHeight);
		GDXAppMain.INSTANCE.font.draw(GDXAppMain.INSTANCE.batch, "Tap anywhere to begin!", GDXAppMain.INSTANCE.viewWidth/2 - 73, 33);
		GDXAppMain.INSTANCE.batch.end();

		if (Gdx.input.isTouched() || Gdx.input.isKeyPressed(Keys.ENTER) || Gdx.input.isKeyPressed(Keys.SPACE)) {
			GDXAppMain.INSTANCE.selectScreen(ScreenIntroMission.class);
			dispose();
		}
	}

	@Override
	public void show() {
		GDXAppMain.INSTANCE.music.play(MusicSongType.INTRO);
	}

	@Override
	public void dispose() {
		backgroundImage.dispose();
	}
}
