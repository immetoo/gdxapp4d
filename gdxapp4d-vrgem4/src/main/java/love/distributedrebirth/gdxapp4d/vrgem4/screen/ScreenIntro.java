package love.distributedrebirth.gdxapp4d.vrgem4.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.tos4.GDXAppTos4;
import love.distributedrebirth.gdxapp4d.vrgem4.GDXAppVrGem4;
import love.distributedrebirth.gdxapp4d.vrgem4.music.MusicSongType;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class ScreenIntro extends ScreenAdapter {
	private Texture backgroundImage;
	private float colorDeltaTime = 0f;
	private boolean colorPositive = true;
	protected SpriteBatch batch;
	protected BitmapFont font;
	
	public ScreenIntro() {
		batch = new SpriteBatch();
		font = new BitmapFont();
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

		batch.begin();
		batch.draw(backgroundImage, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		font.draw(batch, "Tap anywhere to begin!", Gdx.graphics.getWidth()/2 - 73, 33);
		batch.end();

		if (Gdx.input.isTouched() || Gdx.input.isKeyPressed(Keys.ENTER) || Gdx.input.isKeyPressed(Keys.SPACE)) {
			GDXAppVrGem4.INSTANCE.terminal.selectScreen(ScreenIntroMission.class);
			dispose();
		}
	}

	@Override
	public void show() {
		GDXAppVrGem4.INSTANCE.music.play(MusicSongType.INTRO);
	}

	@Override
	public void dispose() {
		//batch.dispose();
		font.dispose();
		backgroundImage.dispose();
	}
}
