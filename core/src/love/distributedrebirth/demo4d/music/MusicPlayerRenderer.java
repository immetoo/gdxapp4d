package love.distributedrebirth.demo4d.music;

import java.util.function.Consumer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import imgui.ImGui;
import imgui.flag.ImGuiCond;
import imgui.flag.ImGuiSelectableFlags;
import imgui.flag.ImGuiTableColumnFlags;
import imgui.flag.ImGuiTableFlags;
import imgui.type.ImBoolean;
import love.distributedrebirth.demo4d.ImGuiRendererMain;
import love.distributedrebirth.demo4d.Demo4DMain;
import net.spookygames.gdx.nativefilechooser.NativeFileChooserCallback;
import net.spookygames.gdx.nativefilechooser.NativeFileChooserConfiguration;

/**
 * 
 * 
 * @author willemtsade ©Δ∞ 仙上主天
 */
public class MusicPlayerRenderer extends ImGuiRendererMain {

	private final NativeFileChooserConfiguration fileChooserConfig;
	
	public MusicPlayerRenderer(Demo4DMain main) {
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
		ImGui.begin("Music Player", widgetOpen);
		
		ImGui.text("Current Song:");
		MusicSong currentSong = main.music.getCurrentSong();
		if (currentSong != null) {
			ImGui.sameLine();
			ImGui.text(currentSong.getName());
		}
		ImGui.separator();
		if (ImGui.button("Play")) {
			main.music.play(currentSong);
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
