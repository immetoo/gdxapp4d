package love.distributedrebirth.gdxapp4d.app.tosamp.music;

import com.badlogic.gdx.files.FileHandle;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

/**
 * The music with the (file) name.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class MusicSong {
	private final FileHandle fileHandle;
	private final String name;
	private final String playlist;
	
	public MusicSong(FileHandle fileHandle, String name, String playlist) {
		this.fileHandle = fileHandle;
		this.name = name;
		this.playlist = playlist;
	}
	
	public FileHandle getFileHandle() {
		return fileHandle;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPlaylist() {
		return playlist;
	}
}