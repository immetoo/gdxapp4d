package love.distributedrebirth.gdxapp4d.app.tosamp.music;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.osgi.framework.BundleContext;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Music.OnCompletionListener;
import com.badlogic.gdx.files.FileHandle;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemWarpShip;

/**
 * Manages the background and others songs.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class MusicManager {

	private final List<MusicSong> musicSongs;
	private final NextSongListener nextSongListener;
	private MusicSong currentSong = null;
	private Music currentMusic = null;
	
	public MusicManager() {
		musicSongs = new ArrayList<>();
		nextSongListener = new NextSongListener();
	}
	
	public void addBackgroundMusic(FileHandle file) {
		musicSongs.add(new MusicSong(file, file.name()));
	}
	
	public void init(BundleContext context, SystemWarpShip warpShip) {
		
		List<File> playlists = warpShip.searchMagic(context, "audio/mpegurl");
		for (File playlist:playlists) {
			System.out.println("Playlist: "+playlist);
		}
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
		if (currentMusic != null) {
			currentMusic.dispose();
		}
	}
	
	public List<MusicSong> getMusicSongs() {
		return musicSongs;
	}
	
	public MusicSong getCurrentSong() {
		return currentSong;
	}
	
	public void stop() {
		if (currentMusic != null) {
			currentMusic.stop();
		}
	}
	
	public void play() {
		MusicSong nextSong = null;
		int currentBackground = musicSongs.indexOf(currentSong);
		if (currentBackground == -1 && !musicSongs.isEmpty()) {
			nextSong = musicSongs.get(0);
		} else {
			nextSong = currentSong;
		}
		if (nextSong!=null) {
			play(nextSong);
		}
	}
	
	public void play(MusicSong song) {
		if (song == null) {
			return;
		}
		stop();
		currentSong = song;
		if (currentMusic != null) {
			currentMusic.dispose();
		}
		currentMusic = Gdx.audio.newMusic(currentSong.getFileHandle());
		currentMusic.setOnCompletionListener(nextSongListener);
		currentMusic.play();
	}
	
	class NextSongListener implements OnCompletionListener {
		
		@Override
		public void onCompletion(Music music) {
			next();
			play(currentSong);
		}
	}
	
	public void next() {
		int currentBackground = musicSongs.indexOf(currentSong);
		if (currentBackground == -1) {
			return; // some other
		}
		if (currentBackground == musicSongs.size()-1) {
			currentBackground = -1; // loop to start
		}
		boolean play = currentMusic!=null && currentMusic.isPlaying();
		stop();
		currentSong = musicSongs.get(currentBackground+1);
		if (play) {
			play(currentSong);
		}
	}
	
	public void prev() {
		int currentBackground = musicSongs.indexOf(currentSong);
		if (currentBackground == -1) {
			return; // some other
		}
		if (currentBackground == 0) {
			currentBackground = musicSongs.size(); // loop to end
		}
		boolean play = currentMusic!=null && currentMusic.isPlaying();
		stop();
		currentSong = musicSongs.get(currentBackground-1);
		if (play) {
			play(currentSong);
		}
	}
	
	public boolean isPlaying(MusicSong song) {
		if (currentSong != null && currentSong.equals(song)) {
			return currentMusic.isPlaying();
		}
		return false;
	}
}
