package love.distributedrebirth.demo4d.music;

import com.badlogic.gdx.audio.Music;

public class MusicSong {
	protected final Music music;
	private final String name;
	
	public MusicSong(Music music, String name) {
		this.music = music;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isPlaying() {
		return music.isPlaying();
	}
}