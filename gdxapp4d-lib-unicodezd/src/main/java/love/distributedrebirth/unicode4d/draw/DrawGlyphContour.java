package love.distributedrebirth.unicode4d.draw;

import java.util.ArrayList;
import java.util.List;

public class DrawGlyphContour {
	private final List<ImGlyphPoint> points = new ArrayList<>();
	
	public class ImGlyphPoint {
		int x;
		int y;
		boolean onCurve;
		
		public ImGlyphPoint(int x, int y, boolean onCurve) {
			this.x = x;
			this.y = y;
			this.onCurve = onCurve;
		}
	}
	
	public void point(int x, int y, boolean onCurve) {
		points.add(new ImGlyphPoint(x,y, onCurve));
	}
	
	public List<ImGlyphPoint> getPoints() {
		return points;
	}
}
