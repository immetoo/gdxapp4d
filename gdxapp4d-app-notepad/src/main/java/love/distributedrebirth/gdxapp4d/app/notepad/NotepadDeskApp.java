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
		
		ImCharacter.render(unicode4DService.getCharacterForUnicode('ﷲ'));
		ImGui.sameLine();
		ImCharacter.render(unicode4DService.getCharacterForUnicode('v'));
		ImGui.sameLine();
		ImCharacter.render(unicode4DService.getCharacterForUnicode('r'));
		ImGui.sameLine();
		ImCharacter.render(unicode4DService.getCharacterForUnicode('G'));
		ImGui.sameLine();
		ImCharacter.render(unicode4DService.getCharacterForUnicode('E'));
		ImGui.sameLine();
		ImCharacter.render(unicode4DService.getCharacterForUnicode('M'));
		ImGui.sameLine();
		ImCharacter.render(unicode4DService.getCharacterForUnicode('⁴'));
		
		ImCharacter.render(unicode4DService.getCharacterForUnicode('M'));
		ImGui.sameLine();
		ImCharacter.render(unicode4DService.getCharacterForUnicode(Integer.parseInt("27d6", 16)));
		ImGui.sameLine();
		ImCharacter.render(unicode4DService.getCharacterForUnicode('仙'));
	}
}
