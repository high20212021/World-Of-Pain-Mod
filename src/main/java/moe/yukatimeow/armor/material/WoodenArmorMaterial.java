package moe.yukatimeow.armor.material;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.recipe.Ingredient;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class WoodenArmorMaterial implements ArmorMaterial {


  private static final int[] PROTECTION = {1,1,1,1};

  @Override
  public int getDurability(EquipmentSlot slot) {
    return 100;
  }

  @Override
  public int getProtectionAmount(EquipmentSlot slot) {
    return PROTECTION[slot.getEntitySlotId()];
  }

  @Override
  public int getEnchantability() {
    return 2;
  }

  @Override
  public SoundEvent getEquipSound() {
    return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
  }

  @Override
  public Ingredient getRepairIngredient() {
    return Ingredient.ofItems(Items.STICK);
  }

  @Override
  public String getName() {
    return "wooden";
  }

  @Override
  public float getToughness() {
    return 0.5f;
  }

  @Override
  public float getKnockbackResistance() {
    return 0f;
  }
}
