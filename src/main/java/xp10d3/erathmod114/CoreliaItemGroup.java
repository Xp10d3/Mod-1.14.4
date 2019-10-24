package xp10d3.erathmod114;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import xp10d3.erathmod114.lists.ItemList;

public class CoreliaItemGroup extends ItemGroup {

	public CoreliaItemGroup() {
		super("coreliaitems");
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemList.ruby);
	}
	
}
