package love.distributedrebirth.unicode4d.atlas;

import java.util.ArrayList;
import java.util.List;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class FontAtlasStore {

	private String name;
	private List<FontAtlasStoreGlyph> glyphs = new ArrayList<>();
	
	public FontAtlasStore() {
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public  List<FontAtlasStoreGlyph> getGlyphs() {
		return glyphs;
	}
	
	public void setGlyphs(List<FontAtlasStoreGlyph> glyphs) {
		for (FontAtlasStoreGlyph baseGlyph:glyphs) {
			addGlyph(baseGlyph);
		}
	}
	
	public void addGlyph(FontAtlasStoreGlyph baseGlyph) { 
		this.glyphs.add(baseGlyph);
	}
}
