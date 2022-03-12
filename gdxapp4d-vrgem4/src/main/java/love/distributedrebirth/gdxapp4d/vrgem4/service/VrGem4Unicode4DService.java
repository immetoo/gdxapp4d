package love.distributedrebirth.gdxapp4d.vrgem4.service;

import love.distributedrebirth.unicode4d.atlas.FontAtlas;
import love.distributedrebirth.unicode4d.atlas.FontAtlasStoreGlyph;

public interface VrGem4Unicode4DService {
	
	FontAtlas getMasterFontAtlas();
	
	FontAtlasStoreGlyph getGlyphForUnicode(char unicode);
}
