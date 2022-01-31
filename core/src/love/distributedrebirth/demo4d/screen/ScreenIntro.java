package love.distributedrebirth.demo4d.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

import love.distributedrebirth.demo4d.Demo4DMain;
import love.distributedrebirth.demo4d.music.MusicSongType;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class ScreenIntro extends ScreenAdapter {
	private final Demo4DMain main;
	private Texture backgroundImage;
	private float colorDeltaTime = 0f;
	private boolean colorPositive = true;

	public ScreenIntro(final Demo4DMain main) {
		this.main = main;
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

		main.batch.begin();
		main.batch.draw(backgroundImage, 0, 0, main.viewWidth, main.viewHeight);
		main.font.draw(main.batch, "Tap anywhere to begin!", main.viewWidth/2 - 73, 33);
		main.batch.end();

		if (Gdx.input.isTouched() || Gdx.input.isKeyPressed(Keys.ENTER) || Gdx.input.isKeyPressed(Keys.SPACE)) {
			main.setScreen(new ScreenIntroMission(main));
			dispose();
		}
	}

	@Override
	public void show() {
		main.music.play(MusicSongType.INTRO);
	}

	@Override
	public void dispose() {
		backgroundImage.dispose();
	}
}
