package love.distributedrebirth.gdxapp4d.vrgem4.view;

import com.badlogic.gdx.InputProcessor;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.unicode4d.draw.ImCharacter;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class DeskAppInputProcessor implements InputProcessor {
	
	private final InputProcessor input;
	private boolean filtering = false;
	
	public DeskAppInputProcessor(InputProcessor input) {
		this.input = input;
	}
	
	public void setFiltering(boolean filtering) {
		this.filtering = filtering;
	}
	
	public boolean isFiltering() {
		return filtering;
	}
	
	private boolean isFilterMenu(int screenY) {
		// font + margin top-bottom = 4px
		if (screenY <= ImCharacter.HEIGHT+ImCharacter.MARGIN_MENUBAR) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if (filtering) {
			return false;
		} else {
			return input.keyDown(keycode);
		}
	}

	@Override
	public boolean keyUp(int keycode) {
		if (filtering) {
			return false;
		} else {
			return input.keyUp(keycode);
		}
	}

	@Override
	public boolean keyTyped(char character) {
		if (filtering) {
			return false;
		} else {
			return input.keyTyped(character);
		}
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if (isFilterMenu(screenY)) {
			return false;
		}
		if (filtering) {
			return false;
		} else {
			return input.touchDown(screenX, screenY, pointer, button);
		}
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if (isFilterMenu(screenY)) {
			return false;
		}
		if (filtering) {
			return false;
		} else {
			return input.touchUp(screenX, screenY, pointer, button);
		}
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		if (isFilterMenu(screenY)) {
			return false;
		}
		if (filtering) {
			return false;
		} else {
			return input.touchDragged(screenX, screenY, pointer);
		}
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		if (isFilterMenu(screenY)) {
			return false;
		}
		if (filtering) {
			return false;
		} else {
			return input.mouseMoved(screenX, screenY);
		}
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		if (filtering) {
			return false;
		} else {
			return input.scrolled(amountX, amountY);
		}
	}
}
