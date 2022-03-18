package love.distributedrebirth.gdxapp4d.app.notepad;

import imgui.ImGui;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.vrgem4.service.VrGem4Unicode4DService;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.AbstractDeskApp;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppContourSection;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppRenderer;
import love.distributedrebirth.unicode4d.draw.ImCharacter;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class NotepadDeskApp extends AbstractDeskApp implements DeskAppRenderer {

	private final VrGem4Unicode4DService unicode4DService;
	private String value = "";
	
	public NotepadDeskApp(VrGem4Unicode4DService unicode4DService) {
		this.unicode4DService = unicode4DService;
	}
	
	public void create() {
		getContours().setTitle("Notepad");
		getContours().registrateContour(DeskAppContourSection.MAIN, this);
	}
	
	@Override
	public void render() {
		ImGui.text("Value:");
		ImGui.text(value);
		
		new ImCharacter(unicode4DService.getCharacterForUnicode(new Character('ﷲ').charValue())).render();
		ImGui.sameLine();
		new ImCharacter(unicode4DService.getCharacterForUnicode(new Character('v').charValue())).render();
		ImGui.sameLine();
		new ImCharacter(unicode4DService.getCharacterForUnicode(new Character('r').charValue())).render();
		//ImGui.sameLine();
		new ImCharacter(unicode4DService.getCharacterForUnicode(new Character('G').charValue())).render();
		ImGui.sameLine();
		new ImCharacter(unicode4DService.getCharacterForUnicode(new Character('E').charValue())).render();
		ImGui.sameLine();
		new ImCharacter(unicode4DService.getCharacterForUnicode(new Character('M').charValue())).render();
		ImGui.sameLine();
		new ImCharacter(unicode4DService.getCharacterForUnicode(new Character('⁴').charValue())).render();
		ImGui.sameLine();
		new ImCharacter(unicode4DService.getCharacterForUnicode(new Character('\'').charValue())).render();
		
		new ImCharacter(unicode4DService.getCharacterForUnicode(new Character('^').charValue())).render();
		ImGui.sameLine();
		new ImCharacter(unicode4DService.getCharacterForUnicode(new Character('ᵃ').charValue())).render();
		ImGui.sameLine();
		new ImCharacter(unicode4DService.getCharacterForUnicode(new Character('a').charValue())).render();
		ImGui.sameLine();
		new ImCharacter(unicode4DService.getCharacterForUnicode(new Character('A').charValue())).render();
		ImGui.sameLine();
		new ImCharacter(unicode4DService.getCharacterForUnicode(Integer.parseInt("27d6", 16))).render();
		ImGui.sameLine();
		new ImCharacter(unicode4DService.getCharacterForUnicode(new Character('仙').charValue())).render();
	}
}
