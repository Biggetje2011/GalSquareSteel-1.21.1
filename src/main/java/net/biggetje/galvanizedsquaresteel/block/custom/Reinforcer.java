package net.biggetje.galvanizedsquaresteel.block.custom;

import net.biggetje.galvanizedsquaresteel.block.ModBlocks;
import net.biggetje.galvanizedsquaresteel.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.particles.ParticleTypes;

public class Reinforcer extends Block {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public Reinforcer(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH));
    }

    // Property toevoegen aan blockstate
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    // Richting instellen bij plaatsing (kijkt naar speler)
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    // Interactie code
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos,
                                               Player player, BlockHitResult hitResult) {
        level.playLocalSound(player, SoundEvents.BLAZE_AMBIENT, SoundSource.HOSTILE, 1f, 1f);
        return InteractionResult.SUCCESS;
    }

    // Item op block stappen
    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getItem().getItem() == Blocks.IRON_BLOCK.asItem()) {
                itemEntity.setItem(new ItemStack(ModBlocks.STEEL_BLOCK.get(), itemEntity.getItem().getCount()));
                level.addParticle(ParticleTypes.SMOKE , pos.getX()+0.5, pos.getY()+1.5 , pos.getZ()+0.5 , 0.0F, 0.0F, 0.0F);
                level.playSound(null, pos, SoundEvents.LAVA_EXTINGUISH, SoundSource.BLOCKS, 0.8f, 1.0f);
            }
            if (itemEntity.getItem().getItem() == Items.IRON_INGOT) {
                itemEntity.setItem(new ItemStack(ModItems.STEEL_INGOT.get(), itemEntity.getItem().getCount()));

            }
        }
        super.stepOn(level, pos, state, entity);
    }
}