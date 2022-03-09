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
	private BitmapFont fontError;
	private SpriteBatch batch;
	private Texture backgroundImage;
	private List<BootMessage> messages = new ArrayList<>();
	
	class BootMessage {
		String bootLine;
		String bootLineError;
		public BootMessage(String bootLine, String bootLineError) {
			this.bootLine = bootLine;
			this.bootLineError = bootLineError;
		}
	}
	
	public GDXAppTos4BootScreen() {
		batch = new SpriteBatch();
		backgroundImage = new Texture(Gdx.files.internal("background/msx-boot.png"));
		font = new BitmapFont();
		fontError = new BitmapFont();
		fontError.setColor(1f, 0f, 0f, 1f);
	}
	
	@Override
	public void render(float delta) {
		int textX = 100;
		int textY = 420;
		int textYStep = 20;
		batch.begin();
		batch.draw(backgroundImage, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		synchronized (messages) {
			for (BootMessage message:messages) {
				if (message.bootLine != null) {
					font.draw(batch, message.bootLine, textX, textY-=textYStep);
				} else if (message.bootLineError != null) {
					fontError.draw(batch, message.bootLineError, textX, textY-=textYStep);
				}
			}
		}
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		backgroundImage.dispose();
		font.dispose();
		fontError.dispose();
	}

	@Override
	public void bootLine(String message) {
		synchronized (messages) {
			messages.add(new BootMessage(message, null));
		}
	}
	
	@Override
	public void bootLineError(String message) {
		synchronized (messages) {
			messages.add(new BootMessage(null, message));
		}
	}
}
