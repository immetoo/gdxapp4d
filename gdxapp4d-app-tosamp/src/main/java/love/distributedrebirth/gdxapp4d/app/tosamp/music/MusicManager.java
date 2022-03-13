package love.distributedrebirth.gdxapp4d.app.tosamp.music;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.osgi.framework.BundleContext;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Music.OnCompletionListener;
import com.badlogic.gdx.files.FileHandle;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.app.tosamp.music.M3UParser.M3UPlaylist;
import love.distributedrebirth.gdxapp4d.app.tosamp.music.M3UParser.M3UTrack;
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
		musicSongs.add(new MusicSong(file, file.name(), ""));
	}
	
	public void init(BundleContext context, SystemWarpShip warpShip) {
		List<File> playlists = warpShip.searchMagic(context, "audio/mpegurl");
		for (File playlist:playlists) {
			try {
				M3UPlaylist play = M3UParser.parse(new FileInputStream(playlist));
				
				for (M3UTrack track:play.getTracks()) {
					FileHandle fileHandle = Gdx.files.absolute(playlist.getParent() + "/" + track.getFile());
					musicSongs.add(new MusicSong(fileHandle, track.getName(), play.getName()));
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
