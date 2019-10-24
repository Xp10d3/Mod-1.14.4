package xp10d3.erathmod114.lists;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.RegistryEvent;
import xp10d3.erathmod114.CoreliaItemGroup;
import xp10d3.erathmod114.ErathMod114;
import xp10d3.erathmod114.Registries;
import xp10d3.erathmod114.entities.RubyGolem;

public class Entities {
	public static EntityType<?> RUBY_GOLEM = EntityType.Builder.create(RubyGolem::new, EntityClassification.MONSTER).build(ErathMod114.modid + ":ruby_golem").setRegistryName(Registries.location("ruby_golem"));
	
	public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ItemList.ruby_entity_egg = registerEntitySpawnEgg(RUBY_GOLEM, 0xed0946, 0xa6a39f, "ruby_golem_egg"));
	}
	
	public static void registerEntityWorldSpawns() {
		registerEntityWorldSpawn(RUBY_GOLEM, Biomes.FOREST, Biomes.PLAINS, Biomes.DARK_FOREST, Biomes.DESERT, Biomes.JUNGLE);
	}
	
	public static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, String name) {
		SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(CoreliaItemGroup.MISC));
		item.setRegistryName(Registries.location(name));
		return item;
	}
	
	public static void registerEntityWorldSpawn(EntityType<?> entity, Biome... biomes) {
		
		for(Biome biome : biomes) {
			if (biome != null) {
				biome.getSpawns(entity.getClassification()).add(new SpawnListEntry(entity, 1000, 1, 4));
			}
		}
		
	}
}
