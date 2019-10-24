package xp10d3.erathmod114.client.render;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import xp10d3.erathmod114.entities.RubyGolem;

@OnlyIn(Dist.CLIENT)
public class ErathRenderRegistry {
	public static void registerEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(RubyGolem.class, new EntityRender.RenderFactory());
	}
}
