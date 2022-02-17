package love.distributedrebirth.gdxapp.desktop.apps;

import java.util.function.Consumer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import imgui.ImGui;
import imgui.flag.ImGuiSelectableFlags;
import imgui.flag.ImGuiTableColumnFlags;
import imgui.flag.ImGuiTableFlags;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp.GDXAppMain;
import love.distributedrebirth.gdxapp.desktop.DefaultDeskApp;
import love.distributedrebirth.gdxapp.desktop.DeskAppContourSection;
import love.distributedrebirth.gdxapp.desktop.DeskAppRenderer;
import love.distributedrebirth.gdxapp.music.MusicSong;
import net.spookygames.gdx.nativefilechooser.NativeFileChooserCallback;
import net.spookygames.gdx.nativefilechooser.NativeFileChooserConfiguration;

/**
 * The music player ui.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class MusicPlayerApp extends DefaultDeskApp implements DeskAppRenderer {

	private final NativeFileChooserConfiguration fileChooserConfig;
	
	public MusicPlayerApp() {
		setTitle("Music Player");
		getContours().registrateContour(DeskAppContourSection.MAIN, this);
		getContours().registrateContour(DeskAppContourSection.FILE_NEW, new DeskAppRenderer() {

			@Override
			public void render() {
				if (ImGui.menuItem("Add")) {
					GDXAppMain.INSTANCE.fileChooser.chooseFile(fileChooserConfig,
							NativeFileChooserCallbackAdapter.onFileChosen(v -> GDXAppMain.INSTANCE.music.addBackgroundMusic(v)));
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
		MusicSong currentSong = GDXAppMain.INSTANCE.music.getCurrentSong();
		if (currentSong != null) {
			ImGui.sameLine();
			ImGui.text(currentSong.getName());
		}
		ImGui.separator();
		if (currentSong != null) {
			if (ImGui.button("Play")) {
				GDXAppMain.INSTANCE.music.play(currentSong);
			}
		} else {
			ImGui.text("Play");
		}
		ImGui.sameLine();
		if (ImGui.button("<")) {
			GDXAppMain.INSTANCE.music.prev();
		}
		ImGui.sameLine();
		if (ImGui.button(">")) {
			GDXAppMain.INSTANCE.music.next();
		}
		ImGui.sameLine();
		if (ImGui.button("Stop")) {
			GDXAppMain.INSTANCE.music.stop();
		}
		int flags = ImGuiTableFlags.ScrollX | ImGuiTableFlags.RowBg | ImGuiTableFlags.BordersOuter | ImGuiTableFlags.BordersV;
		ImGui.beginTable("playlist", 3, flags);
		ImGui.tableSetupColumn("#", ImGuiTableColumnFlags.NoHide);
		ImGui.tableSetupColumn("Play");
		ImGui.tableSetupColumn("Name");
		ImGui.tableHeadersRow();
		int i=1;
		for (MusicSong song:GDXAppMain.INSTANCE.music.getBackgroundSongs()) {
			ImGui.pushID(i);
			ImGui.tableNextRow();
			ImGui.tableNextColumn();
			ImGui.selectable(""+i, song.isPlaying(), ImGuiSelectableFlags.None);
			ImGui.tableNextColumn();
			if (ImGui.smallButton(">")) {
				GDXAppMain.INSTANCE.music.play(song);
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
