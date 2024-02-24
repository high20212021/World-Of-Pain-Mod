package moe.yukatimeow.worldofpain.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;
import java.util.List;
import net.minecraft.client.item.TooltipContext;

public class UnstablePower extends Item {
    public UnstablePower(Settings settings) {
	super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
	if(hand == Hand.MAIN_HAND) {
	    user.playSound(BlockSoundGroup.ANVIL.getPlaceSound(), 3, 4);
	    user.setHealth(0.0F);
	    world.createExplosion(user, user.getX(), user.getY(), user.getZ(), 100, true, Explosion.DestructionType.DESTROY);
	}
	return TypedActionResult.pass(user.getStackInHand(hand));
    }
    
    public void appendTooltip(ItemStack stack, @Nullable World world, PlayerEntity user, List<Text> tooltip, TooltipContext context) {
	tooltip.add(new TranslatableText("item.worldofpain.unstable_power.tooltip"));
    }
}
