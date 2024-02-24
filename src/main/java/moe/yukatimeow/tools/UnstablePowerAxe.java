package moe.yukatimeow.worldofpain.tools;

import net.minecraft.item.AxeItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class UnstablePowerAxe extends AxeItem {
  public UnstablePowerAxe(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
    super(material, attackDamage, attackSpeed, settings);
  }
  
  @Override
  public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
    world.breakBlock(getPos(pos, 1), true);
    world.breakBlock(getPos(pos, -1), true);
    return super.postMine(stack, world, state, pos, miner);
  }

  private BlockPos getPos(BlockPos pos, int y) {
    pos = new BlockPos(pos.getX(),pos.getY()+y,pos.getZ());
    return pos;
  }
}
