package love.distributedrebirth.gdxapp4d.vrgem4;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import love.distributedrebirth.gdxapp4d.tos4.service.SystemGdxLog;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemWarpShip;
import love.distributedrebirth.gdxapp4d.vrgem4.service.VrGem4Unicode4DService;
import love.distributedrebirth.unicode4d.CodePointᶻᴰ;
import love.distributedrebirth.unicode4d.atlas.FontAtlas;
import love.distributedrebirth.unicode4d.atlas.FontAtlasDriver;
import love.distributedrebirth.unicode4d.atlas.FontAtlasStore;
import love.distributedrebirth.unicode4d.atlas.FontAtlasStoreGlyph;

@Component
public class VrGem4Unicode4DServiceImpl implements VrGem4Unicode4DService {
	
	private final FontAtlas masterFontAtlas;
	private final Map<Integer, FontAtlasStoreGlyph> unicodeMap;
	
	@Reference
	private SystemGdxLog log;
	
	@Reference
	private SystemWarpShip warpShip;
	
	
	public VrGem4Unicode4DServiceImpl() {
		masterFontAtlas = new FontAtlas();
		unicodeMap = new HashMap<>();
	}
	
	@Activate
	void open(final BundleContext context) {
		log.debug(this, SystemGdxLog.ACTIVATE);
		List<File> glyps = warpShip.searchMagic(context, "application/x-font-ttf4d");
		try {
			for (File glypSet:glyps) {
				log.debug(this, "Loading glypSet: {}", glypSet);
				FontAtlas atlas = FontAtlasDriver.newInstance().createReader().readFile(glypSet);
				masterFontAtlas.setStores(atlas.getStores());
			}
		} catch (Exception e) {
			log.error(this, e.getMessage(), e);
		}
		log.info(this, "Master font atlas size: {}", masterFontAtlas.getStores().size());
		
		for (FontAtlasStore fontStore:masterFontAtlas.getStores()) {
			log.info(this,"Map unicode: {} size: {}", fontStore.getName(), fontStore.getGlyphs().size());
			for (FontAtlasStoreGlyph glyph: fontStore.getGlyphs()) {
				int unicode = CodePointᶻᴰ.INSTANCE.searchUnicode(glyph.getTongs());
				if (unicode > 0) {
					unicodeMap.put(unicode, glyph);
				}
			}
		}
		log.info(this, "unicode map size: {}", unicodeMap.size());
	}
	
	@Deactivate
	void close() {
		log.debug(this, SystemGdxLog.DEACTIVATE);
	}
	
	@Override
	public FontAtlas getMasterFontAtlas() {
		return masterFontAtlas;
	}

	@Override
	public FontAtlasStoreGlyph getGlyphForUnicode(int unicode) {
		return unicodeMap.get(unicode);
	}
}
