package xp10d3.erathmod114.client.render;

import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class ErathRenderRegistry {
	public static void registryEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(IronGolemEntity.class, new RenderRubyGolem.RenderFactory());
	}
}