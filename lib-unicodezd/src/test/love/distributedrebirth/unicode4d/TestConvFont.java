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
import love.distributedrebirth.unicode4d.atlas.FontAtlas;
import love.distributedrebirth.unicode4d.atlas.FontAtlasDriver;
import love.distributedrebirth.unicode4d.atlas.FontAtlasStore;
import love.distributedrebirth.unicode4d.atlas.FontAtlasStoreGlyph;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class TestConvFont {

	public static void main(String[] args) {
		TestConvFont tcf = new TestConvFont();
		tcf.run();
	}
	
	public void run() {
		try {
			// NOTE: Are in order like the FontAtlas of ImGui
			//conf("Code2000", new File("../conv-font/bin/code-2000.xml"), new File("../main-gdxapp/assets/font/code-2000.xml"));
			//conf("Code2001", new File("../conv-font/bin/code-2001.xml"), new File("../main-gdxapp/assets/font/code-2001.xml"));
			//conf("Code2002", new File("../conv-font/bin/code-2002.xml"), new File("../main-gdxapp/assets/font/code-2002.xml"));
			//conf("Free Sans", new File("../conv-font/bin/free-sans.xml"), new File("../main-gdxapp/assets/font/free-sans.xml"));
			conf("New Gardiner BMP", new File("../conv-font/bin/new-gardiner-bmp.xml"), new File("../main-gdxapp/assets/font/new-gardiner-bmp.xml"));
			conf("Font Awesome", new File("../conv-font/bin/fa-solid-900.xml"), new File("../main-gdxapp/assets/font/fa-solid-900.xml"));
			conf("Noto Sans Brahmi", new File("../conv-font/bin/noto-sans-brahmi.xml"), new File("../main-gdxapp/assets/font/noto-sans-brahmi.xml"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void conf(String fontName, File input, File output) throws Exception {
		System.out.println("START WITH: "+input);
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		XMLReader reader = parser.getXMLReader();
		
		FontAtlas fontAtlas = new FontAtlas();
		FontAtlasStore fontStore = new FontAtlasStore();
		fontStore.setName(fontName);
		fontAtlas.addStore(fontStore);
		FontContentHandler fontContentHandler = new FontContentHandler(fontStore, input.getName());
		reader.setContentHandler(fontContentHandler);

		InputSource inputSource = new InputSource(new FileInputStream(input));
		reader.parse(inputSource);
		
		FontAtlasDriver.newInstance().createWriter().writeFile(fontAtlas, output);
		
		System.out.println("END WITH: "+output+" wrote: "+fontContentHandler.getGlyphCounter());
	}
	
	class FontContentHandler implements ContentHandler {
		
		private FontAtlasStore fontStore;
		private int glyphCounter;
		private List<V072Tong> tongs;
		private boolean startPoint = false;
		private V072Tong point = null;
		private int unicode = -1;
		private UnicodePlaneᶻᴰ unicodePlane2;
		
		
		public FontContentHandler(FontAtlasStore fontStore, String inputName) {
			this.fontStore = fontStore;
		}
		
		public int getGlyphCounter() {
			return glyphCounter;
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
					tongs.add(point);
				}
				glyphCounter++;
				FontAtlasStoreGlyph baseGlyph = new FontAtlasStoreGlyph();
				baseGlyph.setTongs(tongs);
				fontStore.addGlyph(baseGlyph);
				
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
				tongs = new ArrayList<>();
				point = new V072Tong();
				CodePointᶻᴰ.INSTANCE.setCommand(point.getValue(T02PartBinary.PART_1), CodePointCommandᶻᴰ.NOP);
				CodePointᶻᴰ.INSTANCE.setCommand(point.getValue(T02PartBinary.PART_2), CodePointCommandᶻᴰ.NOP);
				
				unicode = Integer.parseInt(atts.getValue("unicode"), 16);
				unicodePlane2 = UnicodePlaneᶻᴰ.valueOfUnicode(unicode);
				int xMax = Integer.parseInt(atts.getValue("xMax"));
				int yMax = Integer.parseInt(atts.getValue("yMax"));
				int xMin = Integer.parseInt(atts.getValue("xMin"));
				int yMin = Integer.parseInt(atts.getValue("yMin"));
				int advanceWidth = Integer.parseInt(atts.getValue("advanceWidth"));
				int leftSideBearing = Integer.parseInt(atts.getValue("leftSideBearing"));
				
				V072Tong v0 = new V072Tong();
				V072Tong v1 = new V072Tong();
				V072Tong v2 = new V072Tong();
				
				if (unicodePlane2.isLeftToRight()) {
					CodePointᶻᴰ.INSTANCE.setCommand(v0.getValue(T02PartBinary.PART_1), CodePointCommandᶻᴰ.START_LR);
				} else {
					CodePointᶻᴰ.INSTANCE.setCommand(v0.getValue(T02PartBinary.PART_1), CodePointCommandᶻᴰ.START_RL);
				}
				
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
				
				tongs.add(v0);
				tongs.add(v1);
				tongs.add(v2);
				
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
					tongs.add(point);
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
