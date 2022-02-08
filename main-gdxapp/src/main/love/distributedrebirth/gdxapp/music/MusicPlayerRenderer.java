package love.distributedrebirth.gdxapp.music;

import java.util.function.Consumer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import imgui.ImGui;
import imgui.flag.ImGuiCond;
import imgui.flag.ImGuiSelectableFlags;
import imgui.flag.ImGuiTableColumnFlags;
import imgui.flag.ImGuiTableFlags;
import imgui.type.ImBoolean;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp.GDXAppMain;
import love.distributedrebirth.gdxapp.ImGuiRendererMain;
import net.spookygames.gdx.nativefilechooser.NativeFileChooserCallback;
import net.spookygames.gdx.nativefilechooser.NativeFileChooserConfiguration;

/**
 * The music player ui.
 */
@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class MusicPlayerRenderer extends ImGuiRendererMain {

	private final NativeFileChooserConfiguration fileChooserConfig;
	
	public MusicPlayerRenderer(GDXAppMain main) {
		super(main);
		fileChooserConfig = new NativeFileChooserConfiguration();
		fileChooserConfig.directory = Gdx.files.absolute(System.getProperty("user.home"));
		fileChooserConfig.mimeFilter = "audio/*";
		fileChooserConfig.title = "Choose audio file";
	}
	
	@Override
	public void render(ImBoolean widgetOpen) {
		ImGui.setNextWindowPos(100, 100, ImGuiCond.FirstUseEver);
		ImGui.setNextWindowSize(320, 240, ImGuiCond.FirstUseEver);
		if (ImGui.begin("Music Player", widgetOpen)) {
			ImGui.text("Current Song:");
			MusicSong currentSong = main.music.getCurrentSong();
			if (currentSong != null) {
				ImGui.sameLine();
				ImGui.text(currentSong.getName());
			}
			ImGui.separator();
			if (currentSong != null) {
				if (ImGui.button("Play")) {
					main.music.play(currentSong);
				}
			} else {
				ImGui.text("Play");
			}
			ImGui.sameLine();
			if (ImGui.button("<")) {
				main.music.prev();
			}
			ImGui.sameLine();
			if (ImGui.button(">")) {
				main.music.next();
			}
			ImGui.sameLine();
			if (ImGui.button("Stop")) {
				main.music.stop();
			}
			ImGui.sameLine();
			if (ImGui.button("Add")) {
				main.fileChooser.chooseFile(fileChooserConfig, NativeFileChooserCallbackAdapter.onFileChosen(v -> main.music.addBackgroundMusic(v)));
			}
			int flags = ImGuiTableFlags.ScrollX | ImGuiTableFlags.RowBg | ImGuiTableFlags.BordersOuter | ImGuiTableFlags.BordersV;
			ImGui.beginTable("playlist", 3, flags);
			ImGui.tableSetupColumn("#", ImGuiTableColumnFlags.NoHide);
			ImGui.tableSetupColumn("Play");
			ImGui.tableSetupColumn("Name");
			ImGui.tableHeadersRow();
			int i=1;
			for (MusicSong song:main.music.getBackgroundSongs()) {
				ImGui.pushID(i);
				ImGui.tableNextRow();
				ImGui.tableNextColumn();
				ImGui.selectable(""+i, song.isPlaying(), ImGuiSelectableFlags.None);
				ImGui.tableNextColumn();
				if (ImGui.smallButton(">")) {
					main.music.play(song);
				}
				ImGui.tableNextColumn();
				ImGui.selectable(song.getName(), song.isPlaying(), ImGuiSelectableFlags.None);
				ImGui.popID();
				i++;
			}
			ImGui.endTable();
		}
		ImGui.end();
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
