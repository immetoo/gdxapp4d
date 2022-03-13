package love.distributedrebirth.gdxapp4d.app.tosamp.music;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M3UParser {
	
	private static final String M3U_HEADER = "#EXTM3U";
	private static final String M3U_EXTINF = "#EXTINF:";
	private static final String M3U_PLAYLIST = "#PLAYLIST:";
	private static final String M3U_EXTALB = "#EXTALB:";
	private static final String M3U_EXTART = "#EXTART:";
	private static final String M3U_EXTGENRE = "#EXTGENRE:";
	private static final String M3U_EXTIMG = "#EXTIMG:";
	
	public static class M3UPlaylist {
		private String name;
		private String albumTitle;
		private String albumArtist;
		private String albumGenre;
		private List<M3UTrack> tracks = new ArrayList<>();
		private Map<String, String> images = new HashMap<>();
		
		public M3UPlaylist() {
		}
		
		public String getName() {
			return name;
		}
		
		public String getAlbumTitle() {
			return albumTitle;
		}
		
		public String getAlbumArtist() {
			return albumArtist;
		}
		
		public String getAlbumGenre() {
			return albumGenre;
		}
		
		public List<M3UTrack> getTracks() {
			return tracks;
		}
		
		public Map<String, String> getImages() {
			return images;
		}
	}
	
	public static class M3UTrack {
		private int time;
		private String name;
		private String file;
		
		public M3UTrack() {
		}
		
		public int getTime() {
			return time;
		}
		
		public String getName() {
			return name;
		}
		
		public String getFile() {
			return file;
		}
	}
	
	enum M3UExtLine {
		NONE,
		EXTINF,
		EXTIMG,
	}
	
	public static M3UPlaylist parse(InputStream stream) throws IOException {
		M3UPlaylist result = new M3UPlaylist();
		M3UExtLine extLine = M3UExtLine.NONE;
		M3UTrack track = null;
		String imageType = null;
	
		BufferedReader buffer = new BufferedReader(new InputStreamReader(stream));
		String line = buffer.readLine();
		if (!line.startsWith(M3U_HEADER)) {
			throw new IOException("Missing header");
		}
		
		while ((line = buffer.readLine()) != null) {
			if (line.isEmpty()) {
				continue;
			}
			if (extLine == M3UExtLine.EXTINF) {
				extLine = M3UExtLine.NONE;
				track.file = line;
				result.tracks.add(track);
				continue;
			}
			if (extLine == M3UExtLine.EXTIMG) {
				extLine = M3UExtLine.NONE;
				result.images.put(imageType, line);
				continue;
			}
			int arguIndex = line.indexOf(":");
			if (arguIndex == -1) {
				continue;
			}
			String lineArgu = line.substring(arguIndex + 1);
			if (line.startsWith(M3U_PLAYLIST)) {
				result.name = lineArgu;
			} else if (line.startsWith(M3U_EXTALB)) {
				result.albumTitle = lineArgu;
			} else if (line.startsWith(M3U_EXTART)) {
				result.albumArtist = lineArgu;
			} else if (line.startsWith(M3U_EXTGENRE)) {
				result.albumGenre = lineArgu;
			} else if (line.startsWith(M3U_EXTIMG)) {
				imageType = lineArgu;
				extLine = M3UExtLine.EXTIMG;
			} else if (line.startsWith(M3U_EXTINF)) {
				track = new M3UTrack();
				extLine = M3UExtLine.EXTINF;
				int commaIndex = lineArgu.indexOf(",");
				String timeStr = lineArgu.substring(0, commaIndex);
				String trackName = lineArgu.substring(commaIndex + 1);
				track.time = Integer.parseInt(timeStr);
				track.name = trackName;
			}
		}
		
		return result;
	}
}
