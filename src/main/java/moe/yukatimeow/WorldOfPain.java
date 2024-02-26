package moe.yukatimeow;

import moe.yukatimeow.worldofpain.items.UnstablePower;
import moe.yukatimeow.worldofpain.items.WorldPoint;
import moe.yukatimeow.worldofpain.tools.weapon.UnstablePowerSword;
import moe.yukatimeow.worldofpain.tools.weapon.WorldSword;
import moe.yukatimeow.worldofpain.tools.UnstablePowerToolMaterial;
import moe.yukatimeow.worldofpain.tools.WorldToolMaterial;
import moe.yukatimeow.worldofpain.tools.UnstablePowerAxe;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.entity.effect.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.*;
import net.minecraft.util.registry.Registry;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.GameRules;

public class WorldOfPain implements ModInitializer {

  public static final UnstablePower UNSTABLE_POWER = new UnstablePower(new Item.Settings().group(ItemGroup.MISC).maxCount(16).fireproof());
  public static final UnstablePowerSword UNSTABLE_POWER_SWORD = new UnstablePowerSword(new UnstablePowerToolMaterial(), 14, -0.08f, new Item.Settings().group(ItemGroup.COMBAT));
  public static final WorldSword WORLDSWORD = new WorldSword(new WorldToolMaterial(), 2147483647, -0.10f, new Item.Settings().group(ItemGroup.COMBAT));
  public static final WorldPoint WORLDPOINT = new WorldPoint(new Item.Settings().group(ItemGroup.MISC).maxCount(1));
  public static final UnstablePowerAxe UNSTABLE_POWER_AXE = new UnstablePowerAxe(new UnstablePowerToolMaterial(), 16, -0.08f, new Item.Settings().group(ItemGroup.TOOLS));
  public static final Item HORSE_MEAT = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder()
    .hunger(10)
    .meat()
    .snack()
    .saturationModifier(4.0f)
    .build()));

  @Override
  public void onInitialize() {
	
    Registry.register(Registry.ITEM,new Identifier("worldofpain", "unstable_power"),UNSTABLE_POWER);
    Registry.register(Registry.ITEM,new Identifier("worldofpain", "unstable_power_sword"),UNSTABLE_POWER_SWORD);
    Registry.register(Registry.ITEM,new Identifier("worldofpain", "worldpoint"),WORLDPOINT);
    Registry.register(Registry.ITEM,new Identifier("worldofpain", "unstable_power_axe"),UNSTABLE_POWER_AXE);
    Registry.register(Registry.ITEM,new Identifier("worldofpain", "horse_meat"),HORSE_MEAT);
    FuelRegistry.INSTANCE.add(WorldOfPain.UNSTABLE_POWER, 1310700);
    Registry.register(Registry.ITEM,new Identifier("worldofpain", "worldsword"),WORLDSWORD);
  
  }
}
