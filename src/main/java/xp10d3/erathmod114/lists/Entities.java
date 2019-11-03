package xp10d3.erathmod114.lists;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xp10d3.erathmod114.CoreliaItemGroup;
import xp10d3.erathmod114.ErathMod114;
import xp10d3.erathmod114.entities.RubyGolem;

@Mod.EventBusSubscriber(modid = ErathMod114.modid, bus = Mod.EventBusSubscriber.Bus.MOD)
@SuppressWarnings("rawtypes")
public class Entities {
	public static Item entity_egg_item;
	private static List<EntityType> ENTITIES = Lists.newArrayList();
	public static final EntityType<RubyGolem> RUBY_GOLEM = createEntity(RubyGolem.class, RubyGolem::new, EntityClassification.MONSTER, "ruby_golem", 0.6f, 1.95f, 9804699, 1973274);
	//public static EntityType<?> RUBY_GOLEM = EntityType.Builder.create(RubyGolem::new, EntityClassification.MONSTER).build(ErathMod114.modid + ":ruby_golem").setRegistryName(Registries.location("ruby_golem"));
	
	
	public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ItemList.ruby_entity_egg = registerEntitySpawnEgg(RUBY_GOLEM, "ruby_golem_egg", 0xa6a39f, 0xed0946));
	}
	
	public static final <T extends Entity> EntityType<T> createEntity(Class<T> entityClass, EntityType.IFactory<T> factory, EntityClassification entityClassification, String name, float width, float height, int eggPrimary, int eggSecondary) {
		ResourceLocation location = new ResourceLocation(ErathMod114.modid, name);
		
		EntityType<T> entity = EntityType.Builder.create(factory, entityClassification)
				.size(width, height).setTrackingRange(64)
				.setShouldReceiveVelocityUpdates(true)
				.setUpdateInterval(3)
				.build(location.toString());
		entity.setRegistryName(location);
		ENTITIES.add(entity);
		return entity;
	}
	
	@SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
        for (EntityType entity : ENTITIES) {
            event.getRegistry().register(entity);
        }
    }

	public static void registerEntityWorldSpawns() {
		registerEntityWorldSpawn(RUBY_GOLEM, Biomes.FOREST, Biomes.PLAINS, Biomes.DARK_FOREST, Biomes.DESERT, Biomes.JUNGLE);
	}
	
	public static Item registerEntitySpawnEgg(EntityType<?> entityType, String name, int primaryClr, int secondaryClr) {
		SpawnEggItem egg = new SpawnEggItem(entityType, primaryClr, secondaryClr, new Item.Properties().group(CoreliaItemGroup.MISC));
		egg.setRegistryName(ErathMod114.modid, name + "_egg");
		return egg;
	}
	
	public static void registerEntityWorldSpawn(EntityType<?> entity, Biome... biomes) {
		
		for(Biome biome : biomes) {
			if (biome != null) {
				biome.getSpawns(entity.getClassification()).add(new SpawnListEntry(entity, 1000, 1, 4));
			}
		}
		
	}
}
