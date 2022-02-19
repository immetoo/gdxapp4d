package love.distributedrebirth.unicode4d;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.numberxd.base2t.part.T02PartBinary;
import love.distributedrebirth.numberxd.base2t.type.V072Tong;
import love.distributedrebirth.unicode4d.base.UnicodePlane;
import love.distributedrebirth.unicode4d.base.UnicodePlaneBase;
import love.distributedrebirth.unicode4d.base.UnicodePlaneBaseGlyph;
import love.distributedrebirth.unicode4d.base.UnicodePlaneDriver;
import love.distributedrebirth.unicode4d.base.UnicodePlaneᶻᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class TestConvFont {

	public static void main(String[] args) {
		TestConvFont tcf = new TestConvFont();
		tcf.run();
	}
	
	public void run() {
		UnicodePlane unicodePlane = new UnicodePlane();
		
		try {
			List<FontContentResult> results = new ArrayList<>();
			
			// NOTE: Are in order like the FontAtlas of ImGui
			results.add(conf(unicodePlane, new File("../conv-font/bin/code-2000.xml")));
			results.add(conf(unicodePlane, new File("../conv-font/bin/code-2001.xml")));
			results.add(conf(unicodePlane, new File("../conv-font/bin/code-2002.xml")));
			results.add(conf(unicodePlane, new File("../conv-font/bin/free-sans.xml")));
			results.add(conf(unicodePlane, new File("../conv-font/bin/new-gardiner-bmp.xml")));
			results.add(conf(unicodePlane, new File("../conv-font/bin/fa-solid-900.xml")));
			results.add(conf(unicodePlane, new File("../conv-font/bin/noto-sans-brahmi.xml")));
			
			int totalChars = 0;
			for (FontContentResult result:results) {
				totalChars += result.getGlyphCounter();
			}
			System.out.println("Writing export unicode4d with characters: "+totalChars);
			
			UnicodePlaneDriver.newInstance().createWriter().writeFile(unicodePlane, "../main-gdxapp/assets/font/unicode4d.xml");
			
			for (FontContentResult result:results) {
				System.out.println("Glyphs import: "+result.getGlyphCounter()+" dropped: "+result.getGlyphDropped()+" from: "+result.getInputName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public FontContentResult conf(UnicodePlane unicodePlane, File input) throws Exception {
		System.out.println("START WITH: "+input);
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		XMLReader reader = parser.getXMLReader();
		FontContentHandler fontContentHandler = new FontContentHandler(unicodePlane, input.getName());
		reader.setContentHandler(fontContentHandler);

		InputSource inputSource = new InputSource(new FileInputStream(input));
		reader.parse(inputSource);
		return fontContentHandler.getResult();
	}
	
	class FontContentResult {
		private final String inputName;
		private int glyphCounter  = 0;
		private int glyphDropped  = 0;
		
		public FontContentResult(String inputName) {
			this.inputName = inputName;
		}
		
		public String getInputName() {
			return inputName;
		}
		
		public int getGlyphCounter() {
			return glyphCounter;
		}
		
		public void incGlyphCounter() {
			this.glyphCounter++;
		}
		
		public int getGlyphDropped() {
			return glyphDropped;
		}
		
		public void incGlyphDropped() {
			this.glyphDropped++;
		}
	}
	
	class FontContentHandler implements ContentHandler {
		
		private final UnicodePlane unicodePlane;
		private final FontContentResult result;
		private List<V072Tong> glyph;
		private boolean startPoint = false;
		private V072Tong point = null;
		private int unicode = -1;
		
		
		public FontContentHandler(UnicodePlane unicodePlane, String inputName) {
			this.unicodePlane = unicodePlane;
			this.result = new FontContentResult(inputName);
		}
		
		public FontContentResult getResult() {
			return result;
		}
		
		@Override
		public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
		}

		@Override
		public void endDocument() throws SAXException {
		}

		@Override
		public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
			if ("opentype".equals(qName)) {
				
			} else if ("glyph".equals(qName)) {
				
				if (CodePointCommandᶻᴰ.NOP != CodePointᶻᴰ.INSTANCE.getCommand(point.getValue(T02PartBinary.PART_1))) {
					glyph.add(point);
				}
				UnicodePlaneᶻᴰ plane = UnicodePlaneᶻᴰ.valueOfUnicode(unicode);
				
				UnicodePlaneBase planeBase = unicodePlane.getPlaneByName(plane.name());
				if (planeBase == null) {
					planeBase = new UnicodePlaneBase();
					planeBase.setName(plane.name());
					unicodePlane.addPlane(planeBase);
				}
				String unicodeHex = Integer.toHexString(unicode);
				UnicodePlaneBaseGlyph baseGlyph = planeBase.getBaseGlyphByUnicode(unicodeHex);
				if (baseGlyph !=  null) {
					//System.out.println("============== DUP unicode: "+unicodeHex);
					result.incGlyphDropped();
					return;
				}
				result.incGlyphCounter();
				baseGlyph = new UnicodePlaneBaseGlyph();
				baseGlyph.setUnicode(unicodeHex);
				baseGlyph.setGlyph(glyph);
				planeBase.addBaseGlyph(baseGlyph);
				
				//try {
					//FileOutputStream out = new FileOutputStream("../conv-font/bin/test/"+unicode+".u4d");
					//Base2Terminator.INSTANCE.Bãß2WriteTong(glyph, out);
				//} catch (Exception e) {
				//	throw new SAXException(e);
				//}
				
			} else if ("contour".equals(qName)) {
				
			}
		}

		@Override
		public void endPrefixMapping(String arg0) throws SAXException {
		}

		@Override
		public void ignorableWhitespace(char[] arg0, int arg1, int arg2) throws SAXException {
		}

		@Override
		public void processingInstruction(String arg0, String arg1) throws SAXException {
		}

		@Override
		public void setDocumentLocator(Locator arg0) {
		}

		@Override
		public void skippedEntity(String arg0) throws SAXException {
		}

		@Override
		public void startDocument() throws SAXException {
		}

		@Override
		public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
			
			if ("opentype".equals(qName)) {
				
			} else if ("glyph".equals(qName)) {
				glyph = new ArrayList<>();
				point = new V072Tong();
				CodePointᶻᴰ.INSTANCE.setCommand(point.getValue(T02PartBinary.PART_1), CodePointCommandᶻᴰ.NOP);
				CodePointᶻᴰ.INSTANCE.setCommand(point.getValue(T02PartBinary.PART_2), CodePointCommandᶻᴰ.NOP);
				
				unicode = Integer.parseInt(atts.getValue("unicode"), 16);
				int xMax = Integer.parseInt(atts.getValue("xMax"));
				int yMax = Integer.parseInt(atts.getValue("yMax"));
				int xMin = Integer.parseInt(atts.getValue("xMin"));
				int yMin = Integer.parseInt(atts.getValue("yMin"));
				int advanceWidth = Integer.parseInt(atts.getValue("advanceWidth"));
				int leftSideBearing = Integer.parseInt(atts.getValue("leftSideBearing"));
				
				V072Tong v0 = new V072Tong();
				V072Tong v1 = new V072Tong();
				V072Tong v2 = new V072Tong();
				
				CodePointᶻᴰ.INSTANCE.setCommand(v0.getValue(T02PartBinary.PART_1), CodePointCommandᶻᴰ.START);
				
				CodePointᶻᴰ.INSTANCE.setCommand(v0.getValue(T02PartBinary.PART_2), CodePointCommandᶻᴰ.UNICODE);
				CodePointᶻᴰ.INSTANCE.setArgumentUnicode(v0.getValue(T02PartBinary.PART_2), unicode);
				
				CodePointᶻᴰ.INSTANCE.setCommand(v1.getValue(T02PartBinary.PART_1), CodePointCommandᶻᴰ.XY_MAX);
				CodePointᶻᴰ.INSTANCE.setArgument(v1.getValue(T02PartBinary.PART_1), T02PartBinary.PART_1, xMax);
				CodePointᶻᴰ.INSTANCE.setArgument(v1.getValue(T02PartBinary.PART_1), T02PartBinary.PART_2, yMax);
				
				CodePointᶻᴰ.INSTANCE.setCommand(v1.getValue(T02PartBinary.PART_2), CodePointCommandᶻᴰ.XY_MIN);
				CodePointᶻᴰ.INSTANCE.setArgument(v1.getValue(T02PartBinary.PART_2), T02PartBinary.PART_1, xMin);
				CodePointᶻᴰ.INSTANCE.setArgument(v1.getValue(T02PartBinary.PART_2), T02PartBinary.PART_2, yMin);
				
				CodePointᶻᴰ.INSTANCE.setCommand(v2.getValue(T02PartBinary.PART_1), CodePointCommandᶻᴰ.ADVANCE);
				CodePointᶻᴰ.INSTANCE.setArgument(v2.getValue(T02PartBinary.PART_1), T02PartBinary.PART_1, advanceWidth);
				CodePointᶻᴰ.INSTANCE.setArgument(v2.getValue(T02PartBinary.PART_1), T02PartBinary.PART_2, leftSideBearing);
				
				CodePointᶻᴰ.INSTANCE.setCommand(v2.getValue(T02PartBinary.PART_2), CodePointCommandᶻᴰ.NOP);
				
				glyph.add(v0);
				glyph.add(v1);
				glyph.add(v2);
				
			} else if ("contour".equals(qName)) {
				startPoint = true;
				
			} else if ("point".equals(qName)) {
				boolean onCurve = Boolean.parseBoolean(atts.getValue("onCurve"));
				int x = (int) Float.parseFloat(atts.getValue("x"));
				int y = (int) Float.parseFloat(atts.getValue("y"));
				
				T02PartBinary part = T02PartBinary.PART_1;
				if (CodePointCommandᶻᴰ.NOP != CodePointᶻᴰ.INSTANCE.getCommand(point.getValue(T02PartBinary.PART_1))) {
					part = T02PartBinary.PART_2;
				}
				if (onCurve) {
					if (startPoint) {
						CodePointᶻᴰ.INSTANCE.setCommand(point.getValue(part), CodePointCommandᶻᴰ.XY_ON_CURVE_START);
					} else {
						CodePointᶻᴰ.INSTANCE.setCommand(point.getValue(part), CodePointCommandᶻᴰ.XY_ON_CURVE);
					}
				} else {
					if (startPoint) {
						CodePointᶻᴰ.INSTANCE.setCommand(point.getValue(part), CodePointCommandᶻᴰ.XY_OFF_CURVE_START);
					} else {
						CodePointᶻᴰ.INSTANCE.setCommand(point.getValue(part), CodePointCommandᶻᴰ.XY_OFF_CURVE);
					}
				}
				CodePointᶻᴰ.INSTANCE.setArgument(point.getValue(part), T02PartBinary.PART_1, x);
				CodePointᶻᴰ.INSTANCE.setArgument(point.getValue(part), T02PartBinary.PART_2, y);
				if (part == T02PartBinary.PART_2) {
					glyph.add(point);
					point = new V072Tong();
					CodePointᶻᴰ.INSTANCE.setCommand(point.getValue(T02PartBinary.PART_1), CodePointCommandᶻᴰ.NOP);
					CodePointᶻᴰ.INSTANCE.setCommand(point.getValue(T02PartBinary.PART_2), CodePointCommandᶻᴰ.NOP);
				}
				if (startPoint) {
					startPoint = false;
				}
			}
		}
		
		@Override
		public void startPrefixMapping(String arg0, String arg1) throws SAXException {
		}
	}
}
