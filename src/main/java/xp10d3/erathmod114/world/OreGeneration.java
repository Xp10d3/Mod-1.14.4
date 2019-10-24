package xp10d3.erathmod114.world;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import xp10d3.erathmod114.config.OregenConfig;
import xp10d3.erathmod114.lists.BlockList;

public class OreGeneration {
	public static void setupOreGeneration() {
		if(OregenConfig.generate_overworld.get()) {
			for(Biome biome : ForgeRegistries.BIOMES) {
				biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, BlockList.ruby_ore.getDefaultState(), OregenConfig.erath_chance.get()), Placement.COUNT_RANGE, new CountRangeConfig(10, 20, 0, 100)));
			}
		}
	}
}
