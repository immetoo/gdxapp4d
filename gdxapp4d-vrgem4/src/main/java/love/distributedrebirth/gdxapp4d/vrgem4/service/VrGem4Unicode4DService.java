package love.distributedrebirth.gdxapp4d.vrgem4.service;

import love.distributedrebirth.unicode4d.atlas.FontAtlas;
import love.distributedrebirth.unicode4d.atlas.FontAtlasStoreGlyph;
import love.distributedrebirth.unicode4d.draw.DrawCharacter;

public interface VrGem4Unicode4DService {
	
	FontAtlas getFontAtlas();
	
	FontAtlasStoreGlyph getGlyphForUnicode(int unicode);
	
	DrawCharacter getCharacterForUnicode(int unicode);
}
