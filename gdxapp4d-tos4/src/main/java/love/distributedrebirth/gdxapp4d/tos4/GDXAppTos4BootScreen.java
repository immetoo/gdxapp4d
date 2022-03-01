package love.distributedrebirth.gdxapp4d.tos4;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class GDXAppTos4BootScreen extends ScreenAdapter implements GDXAppTos4BootListener {

	private BitmapFont font;
	private SpriteBatch batch;
	private Texture backgroundImage;
	private List<String> messages = new ArrayList<>();
	
	public GDXAppTos4BootScreen() {
		batch = new SpriteBatch();
		backgroundImage = new Texture(Gdx.files.internal("background/msx-boot.png"));
		font = new BitmapFont();
	}
	
	@Override
	public void render(float delta) {
		int textX = 100;
		int textY = 420;
		int textYStep = 20;
		batch.begin();
		batch.draw(backgroundImage, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		synchronized (messages) {
			for (String message:messages) { 
				font.draw(batch, message, textX, textY-=textYStep);
			}
		}
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		backgroundImage.dispose();
		font.dispose();
	}

	@Override
	public void bootLine(String message) {
		synchronized (messages) {
			messages.add(message);
		}
	}
}
