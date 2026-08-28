package net.zenanaomi.desidelight.block;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.zenanaomi.desidelight.DesiDelight;
import net.zenanaomi.desidelight.block.custom.*;
import net.zenanaomi.desidelight.item.ModItems;
import net.zenanaomi.desidelight.util.ModWoodTypes;
import net.zenanaomi.desidelight.worldgen.tree.ModTreeGrowers;
import vectorwing.farmersdelight.common.block.CabinetBlock;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(DesiDelight.MOD_ID);

    //handi
    public static final DeferredBlock<Block> HANDI = registerBlock("handi", () -> new Handi(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));

    //tandoor
    public static final DeferredBlock<Block> TANDOOR = registerBlock("tandoor", () -> new Tandoor(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS).lightLevel((state) -> 13)));

    //cinnamon tree blocks
    public static final DeferredBlock<Block> CINNAMON_LOG = registerBlock("cinnamon_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> CINNAMON_WOOD = registerBlock("cinnamon_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CINNAMON_LOG = registerBlock("stripped_cinnamon_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_CINNAMON_WOOD = registerBlock("stripped_cinnamon_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> CINNAMON_LEAVES = registerBlock("cinnamon_leaves", () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> CINNAMON_PLANKS = registerBlock("cinnamon_planks", () -> new ModPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredBlock<StairBlock> CINNAMON_STAIRS = registerBlock("cinnamon_stairs", () -> new StairBlock(ModBlocks.CINNAMON_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));
    public static final DeferredBlock<SlabBlock> CINNAMON_SLAB = registerBlock("cinnamon_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));
    public static final DeferredBlock<FenceBlock> CINNAMON_FENCE = registerBlock("cinnamon_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<FenceGateBlock> CINNAMON_FENCE_GATE = registerBlock("cinnamon_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final DeferredBlock<DoorBlock> CINNAMON_DOOR = registerBlock("cinnamon_door",() -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
    public static final DeferredBlock<TrapDoorBlock> CINNAMON_TRAPDOOR = registerBlock("cinnamon_trapdoor", () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));
    public static final DeferredBlock<PressurePlateBlock> CINNAMON_PRESSURE_PLATE = registerBlock("cinnamon_pressure_plate", () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));
    public static final DeferredBlock<ButtonBlock> CINNAMON_BUTTON = registerBlock("cinnamon_button", () -> new ButtonBlock(BlockSetType.OAK, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));

    public static final DeferredBlock<Block> CINNAMON_SIGN = BLOCKS.register("cinnamon_sign", () -> new ModStandingSignBlock(ModWoodTypes.CINNAMON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)));
    public static final DeferredBlock<Block> CINNAMON_WALL_SIGN = BLOCKS.register("cinnamon_wall_sign", () -> new ModWallSignBlock(ModWoodTypes.CINNAMON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN)));
    public static final DeferredBlock<Block> CINNAMON_HANGING_SIGN = BLOCKS.register("cinnamon_hanging_sign", () -> new ModHangingSignBlock(ModWoodTypes.CINNAMON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)));
    public static final DeferredBlock<Block> CINNAMON_WALL_HANGING_SIGN = BLOCKS.register("cinnamon_wall_hanging_sign", () -> new ModWallHangingSignBlock(ModWoodTypes.CINNAMON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN)));

    public static final DeferredBlock<Block> CINNAMON_SAPLING = registerBlock("cinnamon_sapling", () -> new SaplingBlock(ModTreeGrowers.CINNAMON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<Block> CINNAMON_CABINET = registerBlock("cinnamon_cabinet", () -> new ModCabinetBlock(BlockBehaviour.Properties.ofFullCopy(vectorwing.farmersdelight.common.registry.ModBlocks.OAK_CABINET.get())));

    //cashew tree blocks
    public static final DeferredBlock<Block> CASHEW_LOG = registerBlock("cashew_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LOG)));
    public static final DeferredBlock<Block> CASHEW_WOOD = registerBlock("cashew_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CASHEW_LOG = registerBlock("stripped_cashew_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_BIRCH_LOG)));
    public static final DeferredBlock<Block> STRIPPED_CASHEW_WOOD = registerBlock("stripped_cashew_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_BIRCH_WOOD)));
    public static final DeferredBlock<Block> CASHEW_LEAVES_GROWN = registerBlock("cashew_leaves_grown", () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<Block> CASHEW_LEAVES = registerBlock("cashew_leaves", () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)));
    public static final DeferredBlock<Block> CASHEW_PLANKS = registerBlock("cashew_planks", () -> new ModPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));

    public static final DeferredBlock<StairBlock> CASHEW_STAIRS = registerBlock("cashew_stairs", () -> new StairBlock(ModBlocks.CASHEW_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_STAIRS)));
    public static final DeferredBlock<SlabBlock> CASHEW_SLAB = registerBlock("cashew_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_SLAB)));
    public static final DeferredBlock<FenceBlock> CASHEW_FENCE = registerBlock("cashew_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_FENCE)));
    public static final DeferredBlock<FenceGateBlock> CASHEW_FENCE_GATE = registerBlock("cashew_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_FENCE_GATE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final DeferredBlock<DoorBlock> CASHEW_DOOR = registerBlock("cashew_door", () -> new DoorBlock(BlockSetType.BIRCH, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_DOOR)));
    public static final DeferredBlock<TrapDoorBlock> CASHEW_TRAPDOOR = registerBlock("cashew_trapdoor", () -> new TrapDoorBlock(BlockSetType.BIRCH, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_TRAPDOOR)));
    public static final DeferredBlock<PressurePlateBlock> CASHEW_PRESSURE_PLATE = registerBlock("cashew_pressure_plate", () -> new PressurePlateBlock(BlockSetType.BIRCH, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PRESSURE_PLATE)));
    public static final DeferredBlock<ButtonBlock> CASHEW_BUTTON = registerBlock("cashew_button", () -> new ButtonBlock(BlockSetType.BIRCH, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_BUTTON)));

    public static final DeferredBlock<Block> CASHEW_SIGN = BLOCKS.register("cashew_sign", () -> new ModStandingSignBlock(ModWoodTypes.CASHEW, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_SIGN)));
    public static final DeferredBlock<Block> CASHEW_WALL_SIGN = BLOCKS.register("cashew_wall_sign", () -> new ModWallSignBlock(ModWoodTypes.CASHEW, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_WALL_SIGN)));
    public static final DeferredBlock<Block> CASHEW_HANGING_SIGN = BLOCKS.register("cashew_hanging_sign", () -> new ModHangingSignBlock(ModWoodTypes.CASHEW, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_HANGING_SIGN)));
    public static final DeferredBlock<Block> CASHEW_WALL_HANGING_SIGN = BLOCKS.register("cashew_wall_hanging_sign", () -> new ModWallHangingSignBlock(ModWoodTypes.CASHEW, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_WALL_HANGING_SIGN)));

    public static final DeferredBlock<Block> CASHEW_SAPLING = registerBlock("cashew_sapling", () -> new SaplingBlock(ModTreeGrowers.CASHEW, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_SAPLING)));

    public static final DeferredBlock<Block> CASHEW_CABINET = registerBlock("cashew_cabinet", () -> new ModCabinetBlock(BlockBehaviour.Properties.ofFullCopy(vectorwing.farmersdelight.common.registry.ModBlocks.BIRCH_CABINET.get())));

    //wild crop blocks
    //crop blocks
    //storage blocks
    //feast blocks

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
