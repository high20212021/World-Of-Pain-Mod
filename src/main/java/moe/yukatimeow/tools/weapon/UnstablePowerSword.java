package moe.yukatimeow.worldofpain.tools.weapon;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class UnstablePowerSword extends SwordItem {
  public UnstablePowerSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
	  super(toolMaterial, attackDamage, attackSpeed, settings);
  }
  
  @Override
  public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker){
    World world = attacker.getWorld();
    world.createExplosion(attacker, attacker.getX(), attacker.getY(), attacker.getZ(), 5, false, Explosion.DestructionType.NONE);
    return super.postHit(stack, target, attacker);
  }
}
