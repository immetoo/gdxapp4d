package love.distributedrebirth.gdxapp4d.tos4.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;

import love.distributedrebirth.bassboonyd.BãßBȍőnAuthorInfoʸᴰ;

@BãßBȍőnAuthorInfoʸᴰ(name = "willemtsade", copyright = "©Δ∞ 仙上主天")
public class SystemGdxBootFactory {

	public static void installAndStartBundles(BundleContext bundleContext, String... bundleLocations) throws BundleException {
		for (String location : bundleLocations) {
			Bundle addition = bundleContext.installBundle(location);
			addition.start();
		}
	}
	
	public static Framework createFramework() {
		return createFramework(buildConfig());
	}
	
	public static Framework createFramework(Map<String, String> config) {
		ServiceLoader<FrameworkFactory> factoryLoader = ServiceLoader.load(FrameworkFactory.class);
		for (FrameworkFactory factory : factoryLoader) {
			return factory.newFramework(config);
		}
		throw new IllegalStateException("Unable to load FrameworkFactory service.");
	}
	
	public static Map<String, String> buildConfig() {
		final File cachedir = createCacheDir();
		
		Map<String, String> configMap = new HashMap<String, String>();
		configMap.put(Constants.FRAMEWORK_SYSTEMPACKAGES_EXTRA,
				"love.distributedrebirth.gdxapp4d.tos4.service,"+
				"com.badlogic.gdx,"+
				"com.badlogic.gdx.assets,"+
				"com.badlogic.gdx.assets.loaders,"+
				"com.badlogic.gdx.assets.loaders.resolvers,"+
				"com.badlogic.gdx.audio,"+
				"com.badlogic.gdx.files,"+
				"com.badlogic.gdx.graphics,"+
				"com.badlogic.gdx.graphics.g2d,"+
				"com.badlogic.gdx.graphics.g2d.freetype,"+
				"com.badlogic.gdx.graphics.g3d,"+
				"com.badlogic.gdx.graphics.g3d.attributes,"+
				"com.badlogic.gdx.graphics.g3d.decals,"+
				"com.badlogic.gdx.graphics.g3d.environment,"+
				"com.badlogic.gdx.graphics.g3d.loader,"+
				"com.badlogic.gdx.graphics.g3d.model,"+
				"com.badlogic.gdx.graphics.g3d.model.data,"+
				"com.badlogic.gdx.graphics.g3d.particles,"+
				"com.badlogic.gdx.graphics.g3d.particles.bactches,"+
				"com.badlogic.gdx.graphics.g3d.particles.emitters,"+
				"com.badlogic.gdx.graphics.g3d.particles.influencers,"+
				"com.badlogic.gdx.graphics.g3d.particles.renderers,"+
				"com.badlogic.gdx.graphics.g3d.particles.values,"+
				"com.badlogic.gdx.graphics.g3d.shaders,"+
				"com.badlogic.gdx.graphics.g3d.utils,"+
				"com.badlogic.gdx.graphics.g3d.utils.shapebuilders,"+
				"com.badlogic.gdx.graphics.glutils,"+
				"com.badlogic.gdx.graphics.profiling,"+
				"com.badlogic.gdx.input,"+
				"com.badlogic.gdx.maps,"+
				"com.badlogic.gdx.maps.objects,"+
				"com.badlogic.gdx.maps.tiled,"+
				"com.badlogic.gdx.maps.tiled.objects,"+
				"com.badlogic.gdx.maps.tiled.renderers,"+
				"com.badlogic.gdx.maps.tiled.tiles,"+
				"com.badlogic.gdx.math,"+
				"com.badlogic.gdx.math.collision,"+
				"com.badlogic.gdx.net,"+
				"com.badlogic.gdx.scenes.scene2d,"+
				"com.badlogic.gdx.scenes.scene2d.actions,"+
				"com.badlogic.gdx.scenes.scene2d.ui,"+
				"com.badlogic.gdx.scenes.scene2d.utils,"+
				"com.badlogic.gdx.utils,"+
				"com.badlogic.gdx.utils.async,"+
				"com.badlogic.gdx.utils.compression,"+
				"com.badlogic.gdx.utils.compression.lz,"+
				"com.badlogic.gdx.utils.compression.lzma,"+
				"com.badlogic.gdx.utils.compression.rangecoder,"+
				"com.badlogic.gdx.utils.reflect,"+
				"com.badlogic.gdx.utils.viewport,"+
				"imgui,"+
				"imgui.flag,"+
				"imgui.glfw,"+
				"imgui.gl3,"+
				"imgui.type,"+
				"net.spookygames.gdx.nativefilechooser,"+
				"love.distributedrebirth.bassboonyd,"+
				"love.distributedrebirth.bassboonyd.jmx,"+
				"love.distributedrebirth.numberxd,"+
				"love.distributedrebirth.numberxd.base2t,"+
				"love.distributedrebirth.numberxd.base2t.part,"+
				"love.distributedrebirth.numberxd.base2t.part.warp,"+
				"love.distributedrebirth.numberxd.base2t.type,"+
				"love.distributedrebirth.numberxd.base2t.typexl,"+
				"love.distributedrebirth.numberxd.glyph,"+
				"love.distributedrebirth.numberxd.x4o,"+
				"love.distributedrebirth.warpme,"+
				"love.distributedrebirth.warpme.core,"+
				"love.distributedrebirth.warpme.hash,"+
				"love.distributedrebirth.warpme.sea,"+
				"love.distributedrebirth.warpme.ship,"+
				"love.distributedrebirth.unicode4d,"+
				"love.distributedrebirth.unicode4d.atlas"
				); // ; version=1.0.0
		
		if (cachedir != null) {
			configMap.put(Constants.FRAMEWORK_STORAGE, cachedir.getAbsolutePath());
		}
		return configMap;
	}
	
	private static File createCacheDir() {
		final File cachedir;
		try {
			cachedir = File.createTempFile("gdxapp4d.tos4.cache", null);
			cachedir.delete();
			createShutdownHook(cachedir);
			return cachedir;
		} catch (IOException e) {
			// temp dir creation failed, return null
			return null;
		}
	}
	
	private static void createShutdownHook(final File cachedir) {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				deleteFileOrDir(cachedir);
			}
		});
	}
	
	private static void deleteFileOrDir(File file) {
		if (file.isDirectory()) {
			File[] childs = file.listFiles();
			for (File child : childs) {
				deleteFileOrDir(child);
			}
		}
		file.delete();
	}
}
