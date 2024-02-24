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

public class WorldPoint extends Item {
  public WorldPoint(Settings settings) {
	  super(settings);
  }
  @Override
  public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
	  if(hand == Hand.MAIN_HAND) {
	    user.setHealth(40.0F);
	  }
	  return TypedActionResult.pass(user.getStackInHand(hand));
  }
}
