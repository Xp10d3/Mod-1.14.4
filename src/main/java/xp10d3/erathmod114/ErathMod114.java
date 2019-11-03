package xp10d3.erathmod114;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import xp10d3.erathmod114.client.render.ErathRenderRegistry;
import xp10d3.erathmod114.world.OreGeneration;

@Mod("erathmod114")
public class ErathMod114 {
	
	public static ErathMod114 instance;
	public static final String modid = "erathmod114";
	public static final Logger LOGGER = LogManager.getLogger(modid);
	
	public static final ItemGroup coreliaitems = new CoreliaItemGroup();
	
	public ErathMod114() {
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event) {
		OreGeneration.setupOreGeneration();
		LOGGER.info("Setup method registered.");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event) {
		ErathRenderRegistry.registryEntityRenders();
		LOGGER.info("clientRegistries method registered.");
	}
}
