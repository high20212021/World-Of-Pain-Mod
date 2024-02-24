package moe.yukatimeow.worldofpain.tools;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import moe.yukatimeow.WorldOfPain;
import moe.yukatimeow.worldofpain.items.UnstablePower;

public class UnstablePowerToolMaterial implements ToolMaterial{
  @Override
  public int getDurability() {
	  return 2405;
  }

  @Override
  public float getMiningSpeedMultiplier() {
    return 60;
  }

  @Override
  public float getAttackDamage() {
	  return -1;
  }

  @Override
  public int getMiningLevel() {
	  return 4;
  }

  @Override
  public int getEnchantability() {
	  return 10;
  }

  @Override
  public Ingredient getRepairIngredient() {
	  return Ingredient.ofItems(WorldOfPain.UNSTABLE_POWER);
  }
}
