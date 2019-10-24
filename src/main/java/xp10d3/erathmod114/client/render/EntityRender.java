package xp10d3.erathmod114.client.render;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import xp10d3.erathmod114.Registries;
import xp10d3.erathmod114.client.models.RubyEntityModel;
import xp10d3.erathmod114.entities.RubyGolem;

@OnlyIn(Dist.CLIENT)
public class EntityRender extends LivingRenderer<RubyGolem, RubyEntityModel>{
	
	public EntityRender(EntityRendererManager manager) {
		super(manager, new RubyEntityModel(), 5f);
	}

	@Override
	protected ResourceLocation getEntityTexture(RubyGolem entity) {
		return Registries.location("textures/entity/ruby_golem.png");
	}
	
	public static class RenderFactory implements IRenderFactory<RubyGolem> {

		@Override
		public EntityRenderer<? super RubyGolem> createRenderFor(EntityRendererManager manager) {
			return new EntityRender(manager);
		}
		
	}

}