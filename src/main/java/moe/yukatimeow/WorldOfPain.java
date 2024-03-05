package moe.yukatimeow;

import moe.yukatimeow.worldofpain.items.UnstablePower;
import moe.yukatimeow.worldofpain.items.WorldPoint;
import moe.yukatimeow.worldofpain.tools.weapon.UnstablePowerSword;
import moe.yukatimeow.worldofpain.tools.weapon.WorldSword;
import moe.yukatimeow.worldofpain.tools.UnstablePowerToolMaterial;
import moe.yukatimeow.worldofpain.armor.material.WoodenArmorMaterial;
import moe.yukatimeow.worldofpain.armor.WoodenArmorItem;
import moe.yukatimeow.worldofpain.tools.WorldToolMaterial;
import moe.yukatimeow.worldofpain.tools.UnstablePowerAxe;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityWorldChangeEvents;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.effect.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.*;
import net.minecraft.util.registry.Registry;
import net.minecraft.block.Material;
import net.minecraft.block.AbstractBlock;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.block.v1.FabricBlock;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricMaterialBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.GameRules;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.block.entity.BlockEntityType;

public class WorldOfPain implements ModInitializer {

  public static final UnstablePower UNSTABLE_POWER = new UnstablePower(new Item.Settings().group(ItemGroup.MISC).maxCount(16).fireproof());
  public static final UnstablePowerSword UNSTABLE_POWER_SWORD = new UnstablePowerSword(new UnstablePowerToolMaterial(), 14, -0.08f, new Item.Settings().group(ItemGroup.COMBAT));
  public static final WorldSword WORLDSWORD = new WorldSword(new WorldToolMaterial(), 2147483647, -0.10f, new Item.Settings().group(ItemGroup.COMBAT));
  public static final WorldPoint WORLDPOINT = new WorldPoint(new Item.Settings().group(ItemGroup.MISC).maxCount(1));
  public static final UnstablePowerAxe UNSTABLE_POWER_AXE = new UnstablePowerAxe(new UnstablePowerToolMaterial(), 16, -0.08f, new Item.Settings().group(ItemGroup.TOOLS));
  public static final Item ANCIENT_NETHERITE = new Item(new Item.Settings());
  public static final Item HORSE_MEAT = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder()
    .hunger(10)
    .meat()
    .snack()
    .saturationModifier(4.0f)
    .build()));
  public static final Block OBSIDIAN_ORE = new Block(AbstractBlock.Settings.of(Material.STONE).strength(50.0f, 2400.0f));
  public static final ArmorMaterial WOODEN_MATERIAL = new WoodenArmorMaterial();
  public static final WoodenArmorItem WOODEN_HELMET = new WoodenArmorMaterial(WOODEN_MATERIAL, EquipmentSlot.HEAD, Item.Settings());
  public static final WoodenArmorItem WOODEN_CHEST = new WoodenArmorMaterial(WOODEN_MATERIAL, EquipmentSlot.CHEST, Item.Settings());
  public static final WoodenArmorItem WOODEN_LEGGINGS = new WoodenArmorMaterial(WOODEN_MATERIAL, EquipmentSlot.LEGS, Item.Settings());
  public static final WoodenArmorItem WOODEN_BOOTS = new WoodenArmorMaterial(WOODEN_MATERIAL, EquipmentSlot.FEET, Item.Settings());


  @Override
  public void onInitialize() {


    Registry.register(Registry.ITEM,new Identifier("worldofpain", "unstable_power"),UNSTABLE_POWER);
    Registry.register(Registry.ITEM,new Identifier("worldofpain", "unstable_power_sword"),UNSTABLE_POWER_SWORD);
    Registry.register(Registry.ITEM,new Identifier("worldofpain", "worldpoint"),WORLDPOINT);
    Registry.register(Registry.ITEM,new Identifier("worldofpain", "unstable_power_axe"),UNSTABLE_POWER_AXE);
    Registry.register(Registry.ITEM,new Identifier("worldofpain", "horse_meat"),HORSE_MEAT);
    FuelRegistry.INSTANCE.add(WorldOfPain.UNSTABLE_POWER, 1310700);
    Registry.register(Registry.ITEM,new Identifier("worldofpain", "worldsword"),WORLDSWORD);
    Registry.register(Registry.BLOCK,new Identifier("worldofpain", "obsidian_ore"),OBSIDIAN_ORE);
    Registry.register(Registry.ITEM,new Identifier("worldofpain", "obsidian_ore"), new BlockItem(OBSIDIAN_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
    Registry.register(Registry.ITEM,new Identifier("worldofpain", "ancient_netherite"),ANCIENT_NETHERITE);
    Registry.register(Registry.ITEM,new Identifier("worldofpain", "wooden_helmet"), WOODEN_HELMET);
    Registry.register(Registry.ITEM,new Identifier("worldofpain", "wooden_chest"), WOODEN_CHEST);
    Registry.register(Registry.ITEM,new Identifier("worldofpain", "wooden_leggings"), WOODEN_LEGGINGS);
    Registry.register(Registry.ITEM,new Identifier("worldofpain", "wooden_boots"), WOODEN_BOOTS);
  
    ServerTickEvents.END_SERVER_TICK.register(server -> {
      for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()){
        StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.MINING_FATIGUE, Integer.MAX_VALUE, 0, false, false);
        player.addStatusEffect(effect);
        if (player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).getBaseValue() != 12.0) {
          player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(12.0);
          if (player.getHealth() > 12.0f) {
            player.setHealth(12.0f);
          }
        }
      }
    });

  }

  public static final ItemGroup OTHER_GROUP = FabricItemGroupBuilder.create(
                  new Identifier("worldofpain", "other"))
          .icon(() -> new ItemStack(WorldOfPain.UNSTABLE_POWER))
          .appendItems(stacks -> {
            stacks.add(new ItemStack(WorldOfPain.UNSTABLE_POWER));
            stacks.add(new ItemStack(WorldOfPain.UNSTABLE_POWER_AXE));
            stacks.add(new ItemStack(WorldOfPain.UNSTABLE_POWER_SWORD));
            stacks.add(new ItemStack(WorldOfPain.WORLDSWORD));
            stacks.add(new ItemStack(WorldOfPain.WORLDPOINT));
            stacks.add(new ItemStack(WorldOfPain.HORSE_MEAT));
            stacks.add(new ItemStack(WorldOfPain.OBSIDIAN_ORE));
            stacks.add(new ItemStack(WorldOfPain.ANCIENT_NETHERITE));
            stacks.add(new ItemStack(WorldOfPain.WOODEN_HELMET));
            stacks.add(new ItemStack(WorldOfPain.WOODEN_CHEST));
            stacks.add(new ItemStack(WorldOfPain.WOODEN_LEGGINGS));
            stacks.add(new ItemStack(WorldOfPain.WOODEN_BOOTS));
          })
          .build();

}
