package xp10d3.erathmod114.config;

import java.io.File;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import xp10d3.erathmod114.ErathMod114;

@Mod.EventBusSubscriber
public class Config 
{
	private static final ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SERVER;
	
	private static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec CLIENT;
	
	static
	{
		OregenConfig.init(SERVER_BUILDER, CLIENT_BUILDER);
		
		SERVER = SERVER_BUILDER.build();
		CLIENT = CLIENT_BUILDER.build();
	}
	
	public static void loadConfig(ForgeConfigSpec config, String path)
	{
		ErathMod114.logger.info("Loading config: " + path);
		final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
		ErathMod114.logger.info("Built config: " + path);
		file.load();
		ErathMod114.logger.info("Loaded config: " + path);
		config.setConfig(file);
	}
}
