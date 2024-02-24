package moe.yukatimeow;

import moe.yukatimeow.worldofpain.items.UnstablePower;
import moe.yukatimeow.worldofpain.tools.weapon.UnstablePowerSword;
import moe.yukatimeow.worldofpain.tools.UnstablePowerToolMaterial;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.*;
import net.minecraft.util.registry.Registry;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.GameRules;

public class WorldOfPain implements ModInitializer {

    public static final UnstablePower UNSTABLE_POWER = new UnstablePower(new Item.Settings().group(ItemGroup.MISC).maxCount(16).fireproof());
    public static final UnstablePowerSword UNSTABLE_POWER_SWORD = new UnstablePowerSword(new UnstablePowerToolMaterial(), 14, -0.08f, new Item.Settings().group(ItemGroup.COMBAT));

    @Override
    public void onInitialize() {
	
        Registry.register(Registry.ITEM,new Identifier("worldofpain", "unstable_power"),UNSTABLE_POWER);
        Registry.register(Registry.ITEM,new Identifier("worldofpain", "unstable_power_sword"),UNSTABLE_POWER_SWORD);
        
    }
}
