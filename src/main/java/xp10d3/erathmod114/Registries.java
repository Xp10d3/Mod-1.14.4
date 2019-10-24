package xp10d3.erathmod114;

import java.util.logging.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xp10d3.erathmod114.items.ItemCustomAxe;
import xp10d3.erathmod114.items.ItemCustomPickaxe;
import xp10d3.erathmod114.lists.ArmourMaterialList;
import xp10d3.erathmod114.lists.BlockList;
import xp10d3.erathmod114.lists.Entities;
import xp10d3.erathmod114.lists.ItemList;
import xp10d3.erathmod114.lists.ToolMaterialList;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class Registries {
	public static final ItemGroup CORELIA = CoreliaItemGroup.MISC;
	public static final Logger logger = (Logger) ErathMod114.logger;
	public static final String MODID = ErathMod114.modid;
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			event.getRegistry().registerAll
			(
					ItemList.ruby = new Item(new Item.Properties().group(CORELIA)).setRegistryName(location("ruby")),
						
					ItemList.flame_axe = new ItemCustomAxe(ToolMaterialList.flame_axe, -0.5f, 8.0f, new Item.Properties().group(CORELIA)).setRegistryName(location("flame_axe")),
					ItemList.shadow_pickaxe =  new ItemCustomPickaxe(ToolMaterialList.shadow_pickaxe, 3, 5.0f, new Item.Properties().group(CORELIA)).setRegistryName(location("shadow_pickaxe")),
					ItemList.shadow_sword = new SwordItem(ToolMaterialList.shadow_sword, 3, 3.0f, new Item.Properties().group(CORELIA)).setRegistryName(location("shadow_sword")),
					ItemList.solar_sword = new SwordItem(ToolMaterialList.solar_sword, 3, 3.0f, new Item.Properties().group(CORELIA)).setRegistryName(location("solar_sword")),		
					ItemList.energy_sword = new SwordItem(ToolMaterialList.energy_sword, 3, 3.0f, new Item.Properties().group(CORELIA)).setRegistryName(location("energy_sword")),		
					ItemList.sword_of_the_wind = new SwordItem(ToolMaterialList.sword_of_the_wind, 3, 3.0f, new Item.Properties().group(CORELIA)).setRegistryName(location("sword_of_the_wind")),				
					ItemList.water_bender = new SwordItem(ToolMaterialList.water_bender, 3, 3.0f, new Item.Properties().group(CORELIA)).setRegistryName(location("water_bender")),
					
					ItemList.ice_helmet = new ArmorItem(ArmourMaterialList.ice_armor, EquipmentSlotType.HEAD, new Item.Properties().group(CORELIA)).setRegistryName(location("ice_helmet")),
					ItemList.ice_chestplate = new ArmorItem(ArmourMaterialList.ice_armor, EquipmentSlotType.CHEST, new Item.Properties().group(CORELIA)).setRegistryName(location("ice_chestplate")),
					ItemList.ice_leggings = new ArmorItem(ArmourMaterialList.ice_armor, EquipmentSlotType.LEGS, new Item.Properties().group(CORELIA)).setRegistryName(location("ice_leggings")),
					ItemList.ice_boots = new ArmorItem(ArmourMaterialList.ice_armor, EquipmentSlotType.FEET, new Item.Properties().group(CORELIA)).setRegistryName(location("ice_boots")),						
					ItemList.shadow_helmet = new ArmorItem(ArmourMaterialList.shadow_armor, EquipmentSlotType.HEAD, new Item.Properties().group(CORELIA)).setRegistryName(location("shadow_helmet")),
					ItemList.shadow_chestplate = new ArmorItem(ArmourMaterialList.shadow_armor, EquipmentSlotType.CHEST, new Item.Properties().group(CORELIA)).setRegistryName(location("shadow_chestplate")),
					ItemList.shadow_leggings = new ArmorItem(ArmourMaterialList.shadow_armor, EquipmentSlotType.LEGS, new Item.Properties().group(CORELIA)).setRegistryName(location("shadow_leggings")),
					ItemList.shadow_boots = new ArmorItem(ArmourMaterialList.shadow_armor, EquipmentSlotType.FEET, new Item.Properties().group(CORELIA)).setRegistryName(location("shadow_boots")),
					
					ItemList.ruby_block = new BlockItem(BlockList.ruby_block, new Item.Properties().group(CORELIA)).setRegistryName(BlockList.ruby_block.getRegistryName()),
					ItemList.ruby_ore = new BlockItem(BlockList.ruby_ore, new Item.Properties().group(CORELIA)).setRegistryName(BlockList.ruby_ore.getRegistryName())
			);
			
			Entities.registerEntitySpawnEggs(event);
			
			logger.info("Items registered.");
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			event.getRegistry().registerAll(
					BlockList.ruby_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 7.0f).lightValue(1).sound(SoundType.METAL)).setRegistryName(location("ruby_block")),
					BlockList.ruby_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 5.0f).lightValue(1).sound(SoundType.METAL)).setRegistryName(location("ruby_ore"))
			);
			logger.info("Blocks registered.");
		}
		
		@SubscribeEvent
		public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
			event.getRegistry().registerAll(Entities.RUBY_GOLEM);
			Entities.registerEntityWorldSpawns();
		}
		
		public static ResourceLocation location(String name) {
			return new ResourceLocation(MODID, name);
		}
}
