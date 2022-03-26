package love.distributedrebirth.gdxapp4d.app.tosamp;

import java.util.ResourceBundle;
import java.util.function.Consumer;

import org.osgi.framework.BundleContext;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import imgui.ImGui;
import imgui.flag.ImGuiSelectableFlags;
import imgui.flag.ImGuiTableColumnFlags;
import imgui.flag.ImGuiTableFlags;
import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;
import love.distributedrebirth.gdxapp4d.app.tosamp.music.MusicManager;
import love.distributedrebirth.gdxapp4d.app.tosamp.music.MusicSong;
import love.distributedrebirth.gdxapp4d.tos4.service.SystemWarpShip;
import love.distributedrebirth.gdxapp4d.vrgem4.FontAwesomeIcons;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.AbstractDeskApp;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppContourSection;
import love.distributedrebirth.gdxapp4d.vrgem4.service.deskapp.DeskAppRenderer;
import net.spookygames.gdx.nativefilechooser.NativeFileChooser;
import net.spookygames.gdx.nativefilechooser.NativeFileChooserCallback;
import net.spookygames.gdx.nativefilechooser.NativeFileChooserConfiguration;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class TosAmpDeskApp extends AbstractDeskApp implements DeskAppRenderer {
	
	private final ResourceBundle bundle;
	private final MusicManager music;
	private final NativeFileChooser fileChooser;
	private NativeFileChooserConfiguration fileChooserConfig;
	
	public TosAmpDeskApp(ResourceBundle bundle, NativeFileChooser fileChooser, BundleContext context, SystemWarpShip warpShip) {
		this.bundle = bundle;
		this.fileChooser = fileChooser;
		this.music = new MusicManager();
		this.music.init(context, warpShip);
	}
	
	private String getTxt(String key) {
		return bundle.getString(TosAmpDeskApp.class.getSimpleName()+"."+key);
	}
	
	public void create() {
		getContours().setTitle(getTxt("title"));
		getContours().registrateContour(DeskAppContourSection.MAIN, this);
		getContours().registrateContour(DeskAppContourSection.FILE_NEW, new DeskAppRenderer() {
			@Override
			public void render() {
				if (ImGui.menuItem(getTxt("menuAdd"))) {
					fileChooser.chooseFile(fileChooserConfig,
							NativeFileChooserCallbackAdapter.onFileChosen(v -> music.addBackgroundMusic(v)));
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
		ImGui.text(getTxt("currentSong"));
		MusicSong currentSong = music.getCurrentSong();
		if (currentSong != null) {
			ImGui.sameLine();
			ImGui.text(currentSong.getName());
		}
		ImGui.separator();
		if (currentSong != null) {
			if (ImGui.button(getTxt("play"))) {
				music.play(currentSong);
			}
		} else {
			ImGui.text(getTxt("actionPlay"));
		}
		ImGui.sameLine();
		if (ImGui.button("<")) {
			music.prev();
		}
		ImGui.sameLine();
		if (ImGui.button(">")) {
			music.next();
		}
		ImGui.sameLine();
		if (ImGui.button(getTxt("actionStop"))) {
			music.stop();
		}
		int flags = ImGuiTableFlags.ScrollX | ImGuiTableFlags.RowBg | ImGuiTableFlags.BordersOuter | ImGuiTableFlags.BordersV;
		ImGui.beginTable("playlist", 4, flags);
		ImGui.tableSetupColumn("#", ImGuiTableColumnFlags.NoHide);
		ImGui.tableSetupColumn(getTxt("listPlay"));
		ImGui.tableSetupColumn(getTxt("listName"));
		ImGui.tableSetupColumn(getTxt("listSong"));
		ImGui.tableHeadersRow();
		int i=1;
		for (MusicSong song:music.getMusicSongs()) {
			ImGui.pushID(i);
			ImGui.tableNextRow();
			ImGui.tableNextColumn();
			ImGui.selectable(""+i, music.isPlaying(song), ImGuiSelectableFlags.None);
			ImGui.tableNextColumn();
			if (ImGui.smallButton(">")) {
				music.play(song);
			}
			ImGui.tableNextColumn();
			ImGui.selectable(song.getPlaylist(), music.isPlaying(song), ImGuiSelectableFlags.None);
			ImGui.tableNextColumn();
			ImGui.selectable(song.getName(), music.isPlaying(song), ImGuiSelectableFlags.None);
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
