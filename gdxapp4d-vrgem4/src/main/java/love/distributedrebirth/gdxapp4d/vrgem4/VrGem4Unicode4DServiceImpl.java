package love.distributedrebirth.gdxapp4d.vrgem4;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.osgi.framework.BundleContext;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemWarpShip;
import love.distributedrebirth.gdxapp4d.vrgem4.service.VrGem4Unicode4DService;
import love.distributedrebirth.unicode4d.CodePointᶻᴰ;
import love.distributedrebirth.unicode4d.atlas.FontAtlas;
import love.distributedrebirth.unicode4d.atlas.FontAtlasDriver;
import love.distributedrebirth.unicode4d.atlas.FontAtlasStore;
import love.distributedrebirth.unicode4d.atlas.FontAtlasStoreGlyph;
import love.distributedrebirth.unicode4d.draw.DrawCharacter;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class VrGem4Unicode4DServiceImpl implements VrGem4Unicode4DService {
	
	private final FontAtlas masterFontAtlas;
	private final Map<Integer, FontAtlasStoreGlyph> unicodeMap;
	private final Map<Integer, DrawCharacter> unicodeCharMap;
	
	public VrGem4Unicode4DServiceImpl() {
		masterFontAtlas = new FontAtlas();
		unicodeMap = new HashMap<>();
		unicodeCharMap = new HashMap<>();
	}
	
	public void init(final BundleContext context, SystemWarpShip warpShip, Consumer<String> log) {
		List<File> glyps = warpShip.searchMagic(context, "application/x-font-ttf4d");
		try {
			for (File glypSet:glyps) {
				log.accept("Loading glypSet: "+glypSet);
				FontAtlas atlas = FontAtlasDriver.newInstance().createReader().readFile(glypSet);
				masterFontAtlas.setStores(atlas.getStores());
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.accept("ERROR: "+e.getMessage());
		}
		log.accept("Master font atlas size: "+masterFontAtlas.getStores().size());
		
		int dup = 0;
		for (FontAtlasStore fontStore:masterFontAtlas.getStores()) {
			log.accept("Map unicode: "+fontStore.getName()+" size: "+fontStore.getGlyphs().size());
			for (FontAtlasStoreGlyph glyph: fontStore.getGlyphs()) {
				int unicode = CodePointᶻᴰ.INSTANCE.searchUnicode(glyph.getTongs());
				if (unicodeMap.containsKey(unicode)) {
					dup++;
					continue;
				}
				if (unicode > 0) {
					unicodeMap.put(unicode, glyph);
					try {
						unicodeCharMap.put(unicode, new DrawCharacter(glyph));
					} catch (Exception e) {
						e.printStackTrace();
						log.accept("ERROR: "+e.getMessage());
					}
				}
			}
		}
		log.accept("unicode map size: "+unicodeMap.size()+" dups: "+dup);
	}
	
	@Override
	public FontAtlas getFontAtlas() {
		return masterFontAtlas;
	}
	
	@Override
	public FontAtlasStoreGlyph getGlyphForUnicode(int unicode) {
		return unicodeMap.get(unicode);
	}
	
	@Override
	public DrawCharacter getCharacterForUnicode(int unicode) {
		return unicodeCharMap.get(unicode);
	}
}
