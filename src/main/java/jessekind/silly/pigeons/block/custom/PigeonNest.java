package jessekind.silly.pigeons.block.custom;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class PigeonNest extends Block {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

    public PigeonNest(Settings settings) {
        super(settings);
    }

    // All VoxelShapes (hitboxes), shape + number = direction (Shape_N = North, Shape_E = East, Shape_S = South, Shape_W = West)
    private static final VoxelShape Shape_N = Stream.of(
        Block.createCuboidShape(3, 0, 3, 13, 1, 13),
        Block.createCuboidShape(3, 1, 13, 14, 3, 14),
        Block.createCuboidShape(13, 1, 2, 14, 3, 13),
        Block.createCuboidShape(2, 1, 2, 13, 3, 3),
        Block.createCuboidShape(2, 1, 3, 3, 3, 14)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape Shape_E = Stream.of(
        Block.createCuboidShape(3, 0, 3, 13, 1, 13),
        Block.createCuboidShape(2, 1, 3, 3, 3, 14),
        Block.createCuboidShape(3, 1, 13, 14, 3, 14),
        Block.createCuboidShape(13, 1, 2, 14, 3, 13),
        Block.createCuboidShape(2, 1, 2, 13, 3, 3)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape Shape_S = Stream.of(
        Block.createCuboidShape(3, 0, 3, 13, 1, 13),
        Block.createCuboidShape(2, 1, 2, 13, 3, 3),
        Block.createCuboidShape(2, 1, 3, 3, 3, 14),
        Block.createCuboidShape(3, 1, 13, 14, 3, 14),
        Block.createCuboidShape(13, 1, 2, 14, 3, 13)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape Shape_W = Stream.of(
        Block.createCuboidShape(3, 0, 3, 13, 1, 13),
        Block.createCuboidShape(13, 1, 2, 14, 3, 13),
        Block.createCuboidShape(2, 1, 2, 13, 3, 3),
        Block.createCuboidShape(2, 1, 3, 3, 3, 14),
        Block.createCuboidShape(3, 1, 13, 14, 3, 14)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return Shape_N;
            case EAST:
                return Shape_E;
            case SOUTH:
                return Shape_S;
            case WEST:
                return Shape_W;
            default:
                return Shape_N;
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
