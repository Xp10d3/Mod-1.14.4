package xp10d3.erathmod114.lists;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum ToolMaterialList implements IItemTier {
	shadow_sword(17.0f, 7.0f, 2000, 2, 30, ItemList.ruby),
	solar_sword(15.0f, 3.0f, 3000, 2, 40, ItemList.ruby),
	energy_sword(17.0f, 9.0f, 1500, 2, 50, ItemList.ruby),
	flame_axe(30.0f, 8.0f, 4000, 4, 24, ItemList.ruby),
	shadow_pickaxe(8.0f, 20.0f, 2500, 3, 25, ItemList.ruby),
	sword_of_the_wind(7.5f, 11.0f, 2500, 4, 14, ItemList.ruby),
	water_bender(7.0f, 8.0f, 2500, 4, 30, ItemList.ruby);
	
	private float attackDamage, efficiency;
	private int durability, harvestLevel, enchantability;
	private Item repairMaterial;
	
	private ToolMaterialList(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Item repairMaterial) {
		this.attackDamage = attackDamage;
		this.efficiency = efficiency;
		this.durability = durability;
		this.harvestLevel = harvestLevel;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial;
	}

	@Override
	public int getMaxUses() {
		// TODO Auto-generated method stub
		return this.durability;
	}

	@Override
	public float getEfficiency() {
		// TODO Auto-generated method stub
		return this.efficiency;
	}

	@Override
	public float getAttackDamage() {
		// TODO Auto-generated method stub
		return this.attackDamage;
	}

	@Override
	public int getHarvestLevel() {
		// TODO Auto-generated method stub
		return this.harvestLevel;
	}

	@Override
	public int getEnchantability() {
		// TODO Auto-generated method stub
		return this.enchantability;
	}

	@Override
	public Ingredient getRepairMaterial() {
		// TODO Auto-generated method stub
		return Ingredient.fromItems(this.repairMaterial);
	}
	
}