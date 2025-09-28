package net.biggetje.squaresteel.block.custom;

import net.biggetje.squaresteel.block.ModBlocks;
import net.biggetje.squaresteel.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class Reinforcer extends Block {
    public Reinforcer(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos,
                                               Player player, BlockHitResult hitResult) {
        level.playLocalSound(player, SoundEvents.BLAZE_AMBIENT, SoundSource.HOSTILE, 1f, 1f);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getItem().getItem() == Blocks.IRON_BLOCK.asItem()) {
                itemEntity.setItem(new ItemStack(ModBlocks.STEEL_BLOCK.get(), itemEntity.getItem().getCount()));
                level.addParticle(ParticleTypes.ASH, 0, 0, 0, 0,0, 0);
            }
        }


        super.stepOn(level, pos, state, entity);
    }
}
