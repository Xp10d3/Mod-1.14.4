package xp10d3.erathmod114.client.render;

import javax.annotation.Nullable;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.util.HandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import xp10d3.erathmod114.client.models.RubyEntityModel;

@OnlyIn(Dist.CLIENT)
public class RenderRubyGolem extends MobRenderer<IronGolemEntity, RubyEntityModel> {

	private ResourceLocation mobTexture = new ResourceLocation("erathmod114:textures/entity/ruby_golem.png");
	
	public RenderRubyGolem(EntityRendererManager rendermanagerIn) {
		
		 super(rendermanagerIn, new RubyEntityModel(0.0f, 0.0f, 64, 64), 0.5f);
	        this.addLayer(new HeldItemLayer<IronGolemEntity, RubyEntityModel>(this) {
	            public void render(IronGolemEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
	            {
	                super.render(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale);
	            }
	            protected void translateToHand(HandSide p_191361_1_)
	            {
	                ((RubyEntityModel)this.getEntityModel()).getArm(p_191361_1_).postRender(0.0625F);
	            }
	        });
	        ((RubyEntityModel)this.getEntityModel()).head.showModel = true;
	}

	@Nullable
	@Override
	protected ResourceLocation getEntityTexture(IronGolemEntity entity) {
		return mobTexture;
	}
	
	public static class RenderFactory implements IRenderFactory<IronGolemEntity> {

        public EntityRenderer<? super IronGolemEntity> createRenderFor(EntityRendererManager manager) {
            return new RenderRubyGolem(manager);
        }
    }

    @Override
    protected void preRenderCallback(IronGolemEntity entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scalef(0.9375F, 0.9375F, 0.9375F);
    }
	
}