package love.distributedrebirth.unicode4d.base;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class UnicodePlaneBase {

	private String name;
	private Map<String, UnicodePlaneBaseGlyph> baseGlyphs = new HashMap<>();
	
	public UnicodePlaneBase() {
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public UnicodePlaneBaseGlyph getBaseGlyphByUnicode(String unicode) {
		return baseGlyphs.get(unicode);
	}
	
	public  Collection<UnicodePlaneBaseGlyph> getBaseGlyphs() {
		return baseGlyphs.values();
	}
	
	public void setBaseGlyphs(List<UnicodePlaneBaseGlyph> baseGlyphs) {
		for (UnicodePlaneBaseGlyph baseGlyph:baseGlyphs) {
			addBaseGlyph(baseGlyph);
		}
	}
	
	public void addBaseGlyph(UnicodePlaneBaseGlyph baseGlyph) { 
		this.baseGlyphs.put(baseGlyph.getUnicode(),baseGlyph);
	}
}
