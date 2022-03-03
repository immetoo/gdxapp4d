package love.distributedrebirth.gdxapp4d.app.tosamp.music;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class M3UParser {
	
	private static final String M3U_HEADER = "#EXTM3U";
	
	public class M3UPlaylist {
		
		private List<M3UTrack> tracks = new ArrayList<>();
	}
	
	public class M3UTrack {
		
	}
	
	public M3UPlaylist parse(InputStream stream) throws IOException {
		M3UPlaylist result = new M3UPlaylist();
	
		BufferedReader buffer = new BufferedReader(new InputStreamReader(stream));
		String line = buffer.readLine();
		if (!line.startsWith(M3U_HEADER)) {
			throw new IOException("Missing header");
		}
		
		while ((line = buffer.readLine()) != null) {
			
		}
		
		return result;
	}
}
