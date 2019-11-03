  
package xp10d3.erathmod114.client.models;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.IHasArm;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.util.HandSide;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RubyEntityModel extends EntityModel<IronGolemEntity> implements IHasArm {
    
	public RendererModel leftleg;
    public RendererModel rightleg;
    public RendererModel torso;
    public RendererModel bottomtorso;
    public RendererModel leftarm;
    public RendererModel rightarm;
    public RendererModel head;
    public RendererModel nose;
    
    public RubyEntityModel(float scaleFactor, float f, int textureWidthIn, int textureHeightIn) {
        this.textureWidth = 128;
        this.textureHeight = 128;    	
    	
    	this.leftleg = (new RendererModel(this, 60, 0));
    	this.leftleg.setRotationPoint(5.0f, 11.0f, 0.0f);
        this.leftleg.addBox(-3.5f, -3.0f, -3.0f, 6, 16, 5, 1.1f);
        this.leftleg.mirror = true;
        
        this.torso = (new RendererModel(this, 0, 40));
        this.torso.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.torso.addBox(-9.0f, -2.0f, -6.0f, 18, 12, 11, 0.0f);
        
        this.rightleg = (new RendererModel(this, 37, 0));
        this.rightleg.setRotationPoint(-4.0f, 11.0f, 0.0f);
        this.rightleg.addBox(-3.5f, -3.0f, -3.0f, 6, 16, 5, 0.0f);
        
        this.bottomtorso = (new RendererModel(this, 0, 70));
        this.bottomtorso.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.bottomtorso.addBox(-4.5f, 10.0f, -3.0f, 9, 5, 6, 0.5f);
        
        this.leftarm = (new RendererModel(this, 60, 58));
        this.leftarm.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.leftarm.addBox(9.0f, -2.5f, -3.0f, 4, 30, 6, 0.0f);
        
        this.rightarm = (new RendererModel(this, 60, 21));
        this.rightarm.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.rightarm.addBox(-13.0f, -2.5f, -3.0f, 4, 30, 6, 0.0f);
        
        this.head = (new RendererModel(this, 0, 0));
        this.head.setRotationPoint(0.0f, -7.0f, -2.0f);
        this.head.addBox(-4.0f, -12.0f, -5.5f, 8, 10, 8, 0.0f);
        
        this.nose = (new RendererModel(this, 24, 0));
        this.nose.setRotationPoint(0.0f, -7.0f, -2.0f);
        this.nose.addBox(-1.0f, -5.0f, -7.5f, 2, 4, 2, 0.0f);
    }

	public void render(IronGolemEntity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.leftarm.render(f5);
        this.rightarm.render(f5);
        this.bottomtorso.render(f5);
        this.nose.render(f5);
        this.rightleg.render(f5);
        this.leftleg.render(f5);
        this.torso.render(f5);
        this.head.render(f5);
    }
    
    public void setRotateAngle(RendererModel modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

	public RendererModel getArm(HandSide p_191361_1_) {
		return p_191361_1_ == HandSide.LEFT ? this.leftarm : this.rightarm;
	}
	
    public void postRenderArm(float scale, HandSide side) {
        this.getArm(side).postRender(0.0625F);
    }
}