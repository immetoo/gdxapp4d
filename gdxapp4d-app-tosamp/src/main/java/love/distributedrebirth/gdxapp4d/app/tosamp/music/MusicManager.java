package love.distributedrebirth.gdxapp4d.app.tosamp.music;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Music.OnCompletionListener;
import com.badlogic.gdx.files.FileHandle;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

/**
 * Manages the background and others songs.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class MusicManager {

//	private final MusicSong introSong;
//	private final MusicSong creditsSong;
	private final List<MusicSong> backgroundSongs;
	private final NextSongListener nextSongListener;
	private MusicSong currentSong = null;
	private boolean noMusic = false;
	
	public MusicManager() {
		backgroundSongs = new ArrayList<>();
	//	introSong = new MusicSong(Gdx.audio.newMusic(Gdx.files.internal("music/panoramacircle-waterfowl.mp3")),"panoramacircle-waterfowl");
	//	creditsSong = new MusicSong(Gdx.audio.newMusic(Gdx.files.internal("music/idtech-doom-sigil.mp3")), "idtech-doom-sigil");
		nextSongListener = new NextSongListener();
	}
	
	public void addBackgroundMusic(FileHandle file) {
		Music music = Gdx.audio.newMusic(file);
		music.setOnCompletionListener(nextSongListener);
		backgroundSongs.add(new MusicSong(music, file.name()));
	}
	
	public void init(boolean noMusic) {
		this.noMusic = noMusic;
		/*
		addBackgroundMusic(Gdx.files.internal("music/sanctumwave-risen.mp3"));
		addBackgroundMusic(Gdx.files.internal("music/sanctumwave-devine-intellect.mp3"));
		addBackgroundMusic(Gdx.files.internal("music/theselfhelpgroup-temple-os.mp3"));
		addBackgroundMusic(Gdx.files.internal("music/sanctumwave-nightwalk.mp3"));
		addBackgroundMusic(Gdx.files.internal("music/beeble-i-used-temple-os-to-write.mp3"));
		addBackgroundMusic(Gdx.files.internal("music/ryanfarran-risen-temple-os.mp3"));
		*/
	}
	
	public void dispose() {
	//	introSong.music.dispose();
	//	creditsSong.music.dispose();
		for (MusicSong song:backgroundSongs) {
			song.music.dispose();
		}
	}
	
	public List<MusicSong> getBackgroundSongs() {
		return backgroundSongs;
	}
	
	public MusicSong getCurrentSong() {
		return currentSong;
	}
	
	public void stop() {
		if (currentSong != null) {
			currentSong.music.stop();
		}
	}
	
	public void play(MusicSongType type) {
		MusicSong nextSong = null;
		if (MusicSongType.INTRO.equals(type)) {
//			nextSong = introSong;
//			play(nextSong);
		} else if (MusicSongType.CREDITS.equals(type)) {
//			nextSong = creditsSong;
//			play(nextSong);
		} else {
			int currentBackground = backgroundSongs.indexOf(currentSong);
			if (currentBackground == -1 && !backgroundSongs.isEmpty()) {
				nextSong = backgroundSongs.get(0);
			} else {
				nextSong = currentSong;
			}
			if (!noMusic && nextSong!=null) {
				play(nextSong);
			}
		}
	}
	
	public void play(MusicSong song) {
		if (song == null) {
			return;
		}
		stop();
		currentSong = song;
		currentSong.music.play();
	}
	
	class NextSongListener implements OnCompletionListener {

		@Override
		public void onCompletion(Music music) {
			next();
			play(currentSong);
		}
	}
	
	public void next() {
		int currentBackground = backgroundSongs.indexOf(currentSong);
		if (currentBackground == -1) {
			return; // some other
		}
		if (currentBackground == backgroundSongs.size()-1) {
			currentBackground = -1; // loop to start
		}
		boolean play = currentSong.music.isPlaying();
		currentSong.music.stop();
		currentSong = backgroundSongs.get(currentBackground+1);
		if (play) {
			currentSong.music.play();
		}
	}
	
	public void prev() {
		int currentBackground = backgroundSongs.indexOf(currentSong);
		if (currentBackground == -1) {
			return; // some other
		}
		if (currentBackground == 0) {
			currentBackground = backgroundSongs.size(); // loop to end
		}
		boolean play = currentSong.music.isPlaying();
		currentSong.music.stop();
		currentSong = backgroundSongs.get(currentBackground-1);
		if (play) {
			currentSong.music.play();
		}
	}
}