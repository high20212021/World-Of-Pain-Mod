package moe.yukatimeow.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.Entity;

import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityGroup;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.explosion.Explosion.DestructionType;

@Mixin(CreeperEntity.class)
public abstract class CreeperEntityMixin extends Entity {

  public CreeperEntityMixin(EntityType<?> type, World world) {
    super(type, world);
  }

  @Inject(at = @At("HEAD"), method = "explode")
  public void CreeperExplodeMixin(CallbackInfo ci) {
    if (!this.world.isClient()) {
      ci.cancel();
      this.world.createExplosion(this, this.getX(), this.getY(), this.getZ(), 1000f, Explosion.DestructionType.DESTROY);
      this.discard();
    }
  }

}
