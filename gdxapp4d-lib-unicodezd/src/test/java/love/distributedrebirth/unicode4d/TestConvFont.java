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
	
	// manually run;
	// gdxapp4d-chain-font-unicode4d/src/main/nodejs$ npm install
	// gdxapp4d-chain-font-unicode4d/src/main/nodejs$ ./conv-font.sh ../chain/plane0/ ../../../target/chain2/plane0/
	// gdxapp4d-chain-font-unicode4d/src/main/nodejs$ ./conv-font.sh ../chain/plane1/ ../../../target/chain2/plane1/
	// gdxapp4d-chain-font-unicode4d/src/main/nodejs$ ./conv-font.sh ../chain/plane2/ ../../../target/chain2/plane2/
	
	public void run() {
		System.out.println("Starting conversion;");
		try {
			// NOTE: Are in order like the FontAtlas of ImGui
			String in = "../gdxapp4d-chain-font-unicode4d/target/chain2/";
			String out = "../gdxapp4d-chain-font-unicode4d/src/main/chain/";
			
			conf("code-2000", new File(in+"plane0/code-2000.ttf.xml"), new File(out+"plane0/code-2000.ttf4d"));
			conf("fa-solid-900", new File(in+"plane0/fa-solid-900.ttf.xml"), new File(out+"plane0/fa-solid-900.ttf4d"));
			conf("free-sans", new File(in+"plane0/free-sans.ttf.xml"), new File(out+"plane0/free-sans.ttf4d"));
			conf("new-gardiner-bmp", new File(in+"plane0/new-gardiner-bmp.ttf.xml"), new File(out+"plane0/new-gardiner-bmp.ttf4d"));
			conf("noto-sans-balinese", new File(in+"plane0/noto-sans-balinese.ttf.xml"), new File(out+"plane0/noto-sans-balinese.ttf4d"));
			conf("noto-sans-bamum", new File(in+"plane0/noto-sans-bamum.ttf.xml"), new File(out+"plane0/noto-sans-bamum.ttf4d"));
			conf("noto-sans-batak", new File(in+"plane0/noto-sans-batak.ttf.xml"), new File(out+"plane0/noto-sans-batak.ttf4d"));
			conf("noto-sans-glagolitic", new File(in+"plane0/noto-sans-glagolitic.ttf.xml"), new File(out+"plane0/noto-sans-glagolitic.ttf4d"));
			conf("noto-sans-javanese", new File(in+"plane0/noto-sans-javanese.ttf.xml"), new File(out+"plane0/noto-sans-javanese.ttf4d"));
			conf("noto-sans-lepcha", new File(in+"plane0/noto-sans-lepcha.ttf.xml"), new File(out+"plane0/noto-sans-lepcha.ttf4d"));
			conf("noto-sans-lisu", new File(in+"plane0/noto-sans-lisu.ttf.xml"), new File(out+"plane0/noto-sans-lisu.ttf4d"));
			conf("noto-sans-meetei-mayek", new File(in+"plane0/noto-sans-meetei-mayek.ttf.xml"), new File(out+"plane0/noto-sans-meetei-mayek.ttf4d"));
			conf("noto-sans-new-tai-lue", new File(in+"plane0/noto-sans-new-tai-lue.ttf.xml"), new File(out+"plane0/noto-sans-new-tai-lue.ttf4d"));
			conf("noto-sans-samaritan", new File(in+"plane0/noto-sans-samaritan.ttf.xml"), new File(out+"plane0/noto-sans-samaritan.ttf4d"));
			conf("noto-sans-sinhala", new File(in+"plane0/noto-sans-sinhala.ttf.xml"), new File(out+"plane0/noto-sans-sinhala.ttf4d"));
			conf("noto-sans-sundanese", new File(in+"plane0/noto-sans-sundanese.ttf.xml"), new File(out+"plane0/noto-sans-sundanese.ttf4d"));
			conf("noto-sans-syloti-nagri", new File(in+"plane0/noto-sans-syloti-nagri.ttf.xml"), new File(out+"plane0/noto-sans-syloti-nagri.ttf4d"));
			conf("noto-sans-tagalog", new File(in+"plane0/noto-sans-tagalog.ttf.xml"), new File(out+"plane0/noto-sans-tagalog.ttf4d"));
			conf("noto-sans-tagbanwa", new File(in+"plane0/noto-sans-tagbanwa.ttf.xml"), new File(out+"plane0/noto-sans-tagbanwa.ttf4d"));
			conf("noto-sans-tai-le", new File(in+"plane0/noto-sans-tai-le.ttf.xml"), new File(out+"plane0/noto-sans-tai-le.ttf4d"));
			conf("noto-sans-tai-tham", new File(in+"plane0/noto-sans-tai-tham.ttf.xml"), new File(out+"plane0/noto-sans-tai-tham.ttf4d"));
			conf("noto-sans-tai-viet", new File(in+"plane0/noto-sans-tai-viet.ttf.xml"), new File(out+"plane0/noto-sans-tai-viet.ttf4d"));
			conf("noto-serif-tibetan", new File(in+"plane0/noto-serif-tibetan.ttf.xml"), new File(out+"plane0/noto-serif-tibetan.ttf4d"));
			
			conf("code-2001", new File(in+"plane1/code-2001.ttf.xml"), new File(out+"plane1/code-2001.ttf4d"));
			conf("new-gardiner-smp", new File(in+"plane1/new-gardiner-smp.ttf.xml"), new File(out+"plane1/new-gardiner-smp.ttf4d"));
			conf("noto-sans-brahmi", new File(in+"plane1/noto-sans-brahmi.ttf.xml"), new File(out+"plane1/noto-sans-brahmi.ttf4d"));
			
			conf("code-2002", new File(in+"plane2/code-2002.ttf.xml"), new File(out+"plane2/code-2002.ttf4d"));
			
			System.out.println("Done conversion.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void conf(String fontName, File input, File output) throws Exception {
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
		
		System.out.println("Done: "+output+" wrote: "+fontContentHandler.getGlyphCounter());
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
				
				String unicodeStr = atts.getValue("unicode");
				if (unicodeStr.startsWith("0000, ")) {
					unicodeStr = unicodeStr.substring(7);
				}
				unicode = Integer.parseInt(unicodeStr, 16);
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
