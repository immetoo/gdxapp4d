package love.distributedrebirth.gdxapp4d.vrgem4.desktop.apps;

import java.util.function.Consumer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import imgui.ImGui;
import imgui.flag.ImGuiSelectableFlags;
import imgui.flag.ImGuiTableColumnFlags;
import imgui.flag.ImGuiTableFlags;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.tos4.GDXAppTos4;
import love.distributedrebirth.gdxapp4d.vrgem4.FontAwesomeIcons;
import love.distributedrebirth.gdxapp4d.vrgem4.GDXAppVrGem4;
import love.distributedrebirth.gdxapp4d.vrgem4.desktop.DefaultDeskApp;
import love.distributedrebirth.gdxapp4d.vrgem4.desktop.DeskAppContourSection;
import love.distributedrebirth.gdxapp4d.vrgem4.desktop.DeskAppRenderer;
import love.distributedrebirth.gdxapp4d.vrgem4.music.MusicSong;
import net.spookygames.gdx.nativefilechooser.NativeFileChooserCallback;
import net.spookygames.gdx.nativefilechooser.NativeFileChooserConfiguration;

/**
 * The music player ui.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class MusicPlayerApp extends DefaultDeskApp implements DeskAppRenderer {

	private final NativeFileChooserConfiguration fileChooserConfig;
	
	public MusicPlayerApp() {
		setTitle(FontAwesomeIcons.Music + " Music Player");
		getContours().registrateContour(DeskAppContourSection.MAIN, this);
		getContours().registrateContour(DeskAppContourSection.FILE_NEW, new DeskAppRenderer() {

			@Override
			public void render() {
				if (ImGui.menuItem(FontAwesomeIcons.Plus + " Add")) {
//					GDXAppVrGem4.INSTANCE.terminal.getFileChooser().chooseFile(fileChooserConfig,
//							NativeFileChooserCallbackAdapter.onFileChosen(v -> GDXAppVrGem4.INSTANCE.music.addBackgroundMusic(v)));
				}
			}
			
		});
		fileChooserConfig = new NativeFileChooserConfiguration();
		fileChooserConfig.directory = Gdx.files.absolute(System.getProperty("user.home"));
		fileChooserConfig.mimeFilter = "audio/*";
		fileChooserConfig.title = "Choose audio file";
	}
	
	@Override
	public void render() {
		ImGui.text("Current Song:");
		MusicSong currentSong = GDXAppVrGem4.INSTANCE.music.getCurrentSong();
		if (currentSong != null) {
			ImGui.sameLine();
			ImGui.text(currentSong.getName());
		}
		ImGui.separator();
		if (currentSong != null) {
			if (ImGui.button("Play")) {
				GDXAppVrGem4.INSTANCE.music.play(currentSong);
			}
		} else {
			ImGui.text("Play");
		}
		ImGui.sameLine();
		if (ImGui.button("<")) {
			GDXAppVrGem4.INSTANCE.music.prev();
		}
		ImGui.sameLine();
		if (ImGui.button(">")) {
			GDXAppVrGem4.INSTANCE.music.next();
		}
		ImGui.sameLine();
		if (ImGui.button("Stop")) {
			GDXAppVrGem4.INSTANCE.music.stop();
		}
		int flags = ImGuiTableFlags.ScrollX | ImGuiTableFlags.RowBg | ImGuiTableFlags.BordersOuter | ImGuiTableFlags.BordersV;
		ImGui.beginTable("playlist", 3, flags);
		ImGui.tableSetupColumn("#", ImGuiTableColumnFlags.NoHide);
		ImGui.tableSetupColumn("Play");
		ImGui.tableSetupColumn("Name");
		ImGui.tableHeadersRow();
		int i=1;
		for (MusicSong song:GDXAppVrGem4.INSTANCE.music.getBackgroundSongs()) {
			ImGui.pushID(i);
			ImGui.tableNextRow();
			ImGui.tableNextColumn();
			ImGui.selectable(""+i, song.isPlaying(), ImGuiSelectableFlags.None);
			ImGui.tableNextColumn();
			if (ImGui.smallButton(">")) {
				GDXAppVrGem4.INSTANCE.music.play(song);
			}
			ImGui.tableNextColumn();
			ImGui.selectable(song.getName(), song.isPlaying(), ImGuiSelectableFlags.None);
			ImGui.popID();
			i++;
		}
		ImGui.endTable();
	}
	
	static class NativeFileChooserCallbackAdapter implements NativeFileChooserCallback {

		@Override
		public void onFileChosen(FileHandle file) {
		}
		
		@Override
		public void onCancellation() {
		}
		
		@Override
		public void onError(Exception exception) {
		}
		
		static NativeFileChooserCallbackAdapter onFileChosen(Consumer<FileHandle> eater) {
			return new NativeFileChooserCallbackAdapter() {
				@Override
				public void onFileChosen(FileHandle file) {
					eater.accept(file);
				}
			};
		}
	}
}
