package love.distributedrebirth.gdxapp;

import com.badlogic.gdx.Screen;

import love.distributedrebirth.gdxapp.desktop.DeskAppScreen;

public interface GDXAppScreen extends Screen {

	DeskAppScreen getDeskAppScreen();
}
