package love.distributedrebirth.gdxapp.music;

import com.badlogic.gdx.audio.Music;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

/**
 * The music with the (file) name.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
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