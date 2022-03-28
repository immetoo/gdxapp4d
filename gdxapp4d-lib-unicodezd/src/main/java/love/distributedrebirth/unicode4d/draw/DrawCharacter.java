package love.distributedrebirth.unicode4d.draw;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import love.distributedrebirth.numberxd.base2t.part.T02PartBinary;
import love.distributedrebirth.numberxd.base2t.type.V036Teger;
import love.distributedrebirth.numberxd.base2t.type.V072Tong;
import love.distributedrebirth.unicode4d.CodePointCommandᶻᴰ;
import love.distributedrebirth.unicode4d.CodePointᶻᴰ;
import love.distributedrebirth.unicode4d.draw.DrawGlyphContour.ImGlyphPoint;

public class DrawCharacter {
	private final List<V072Tong> tongs;
	private final List<DrawGlyphContour> contours = new ArrayList<>();
	private final DrawGlyphPath glyphPath;
	private DrawGlyphContour currentContour;
	private int unicode;
	private int xMax;
	private int yMax;
	private int xMin;
	private int yMin;
	private int advanceWidth;
	private int leftSideBearing;
	private boolean leftToRight;
	
	public DrawCharacter(List<V072Tong> tongs) {
		this.tongs = tongs;
		for (V072Tong tong: tongs) {
			processCodePoint(tong.getValue(T02PartBinary.PART_1));
			processCodePoint(tong.getValue(T02PartBinary.PART_2));
		}
		if (currentContour != null) {
			contours.add(currentContour);
		}
		this.glyphPath = createGlyphPath();
	}
	
	private void processCodePoint(V036Teger codePoint) {
		CodePointCommandᶻᴰ cmd = CodePointᶻᴰ.INSTANCE.getCommand(codePoint);
		if (CodePointCommandᶻᴰ.NOP.equals(cmd)) {
			return;
		}
		if (CodePointCommandᶻᴰ.START_LR.equals(cmd)) {
			leftToRight = true;
			return;
		}
		if (CodePointCommandᶻᴰ.START_RL.equals(cmd)) {
			leftToRight = false;
			return;
		}
		if (CodePointCommandᶻᴰ.UNICODE.equals(cmd)) {
			unicode = CodePointᶻᴰ.INSTANCE.getArgumentUnicode(codePoint);
			return;
		}
		if (CodePointCommandᶻᴰ.XY_MAX.equals(cmd)) {
			xMax = CodePointᶻᴰ.INSTANCE.getArgument(codePoint, T02PartBinary.PART_1);
			yMax = CodePointᶻᴰ.INSTANCE.getArgument(codePoint, T02PartBinary.PART_2);
			return;
		}
		if (CodePointCommandᶻᴰ.XY_MIN.equals(cmd)) {
			xMin = CodePointᶻᴰ.INSTANCE.getArgument(codePoint, T02PartBinary.PART_1);
			yMin = CodePointᶻᴰ.INSTANCE.getArgument(codePoint, T02PartBinary.PART_2);
			return;
		}
		if (CodePointCommandᶻᴰ.ADVANCE.equals(cmd)) {
			advanceWidth = CodePointᶻᴰ.INSTANCE.getArgument(codePoint, T02PartBinary.PART_1);
			leftSideBearing = CodePointᶻᴰ.INSTANCE.getArgument(codePoint, T02PartBinary.PART_2);
			return;
		}
		if (CodePointCommandᶻᴰ.XY_ON_CURVE_START.equals(cmd)) {
			if (currentContour != null) {
				contours.add(currentContour);
			}
			int x =  CodePointᶻᴰ.INSTANCE.getArgument(codePoint, T02PartBinary.PART_1);
			int y =  CodePointᶻᴰ.INSTANCE.getArgument(codePoint, T02PartBinary.PART_2);
			currentContour = new DrawGlyphContour();
			currentContour.point(x, y, true);
			return;
		}
		if (CodePointCommandᶻᴰ.XY_OFF_CURVE_START.equals(cmd)) {
			if (currentContour != null) {
				contours.add(currentContour);
			}
			int x =  CodePointᶻᴰ.INSTANCE.getArgument(codePoint, T02PartBinary.PART_1);
			int y =  CodePointᶻᴰ.INSTANCE.getArgument(codePoint, T02PartBinary.PART_2);
			currentContour = new DrawGlyphContour();
			currentContour.point(x, y, true);
			return;
		}
		if (CodePointCommandᶻᴰ.XY_ON_CURVE.equals(cmd)) {
			int x =  CodePointᶻᴰ.INSTANCE.getArgument(codePoint, T02PartBinary.PART_1);
			int y =  CodePointᶻᴰ.INSTANCE.getArgument(codePoint, T02PartBinary.PART_2);
			currentContour.point(x, y, true);
			return;
		}
		if (CodePointCommandᶻᴰ.XY_OFF_CURVE.equals(cmd)) {
			int x =  CodePointᶻᴰ.INSTANCE.getArgument(codePoint, T02PartBinary.PART_1);
			int y =  CodePointᶻᴰ.INSTANCE.getArgument(codePoint, T02PartBinary.PART_2);
			currentContour.point(x, y, false);
			return;
		}
	}
	
	private DrawGlyphPath createGlyphPath() {
		// source function getPath(points): opentype.js/src/tables/glyf.js
		DrawGlyphPath p = new DrawGlyphPath();
		
		for (DrawGlyphContour contour: contours) {
			//ImGlyphPoint prev = null;
			ImGlyphPoint curr = contour.getPoints().get(contour.getPoints().size() - 1);
			ImGlyphPoint next = contour.getPoints().get(0);
			
			if (curr.onCurve) {
				p.moveTo(curr.x, curr.y);
			} else {
				if (next.onCurve) {
					p.moveTo(next.x, next.y);
				} else {
					int x = (curr.x + next.x) / 2;
					int y = (curr.y + next.y) / 2;
					p.moveTo(x, y);
				}
			}
			
			Iterator<ImGlyphPoint> pointIt = contour.getPoints().iterator();
			pointIt.next(); // Remove first as that is 'next'
			while (pointIt.hasNext()) {
				//prev = curr;
				curr = next;
				next = pointIt.next();
				
				if (curr.onCurve) {
					p.lineTo(curr.x, curr.y);
				} else {
					int x = next.x;
					int y = next.y;
					if (next.onCurve) {
						x = (curr.x + next.x) / 2;
						y = (curr.y + next.y) / 2;
					}
					p.quadCurveTo(curr.x, curr.y, x, y);
				}
			}
			
			p.closePath();
		}
		
		return p;
	}
	
	public List<DrawGlyphContour> getContours() {
		return contours;
	}
	
	public DrawGlyphPath getGlyphPath() {
		return glyphPath;
	}
	
	public int getUnicode() {
		return unicode;
	}
	
	public int getxMax() {
		return xMax;
	}
	
	public int getyMax() {
		return yMax;
	}
	
	public int getxMin() {
		return xMin;
	}
	
	public int getyMin() {
		return yMin;
	}
	
	public int getAdvanceWidth() {
		return advanceWidth;
	}
	
	public int getLeftSideBearing() {
		return leftSideBearing;
	}
	
	public boolean isLeftToRight() {
		return leftToRight;
	}
}
