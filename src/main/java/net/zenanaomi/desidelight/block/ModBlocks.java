package net.zenanaomi.desidelight.block;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zenanaomi.desidelight.DesiDelight;
import net.zenanaomi.desidelight.block.custom.*;
import net.zenanaomi.desidelight.block.custom.feasts.BiryaniBlock;
import net.zenanaomi.desidelight.block.custom.feasts.ButterChickenBlock;
import net.zenanaomi.desidelight.item.ModItems;
import net.zenanaomi.desidelight.util.ModWoodTypes;
import net.zenanaomi.desidelight.worldgen.tree.CashewTreeGrower;
import net.zenanaomi.desidelight.worldgen.tree.CinnamonTreeGrower;
import vectorwing.farmersdelight.common.block.CabinetBlock;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DesiDelight.MOD_ID);

    //handi
    public static final RegistryObject<Block> HANDI = registerBlock("handi", () -> new Handi(BlockBehaviour.Properties.copy(Blocks.DECORATED_POT)));

    //tandoor
    public static final RegistryObject<Block> TANDOOR = registerBlock("tandoor", () -> new Tandoor(BlockBehaviour.Properties.copy(Blocks.MUD_BRICKS).lightLevel((state) -> 13)));

    //cinnamon tree blocks
    public static final RegistryObject<Block> CINNAMON_LOG = registerBlock("cinnamon_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> CINNAMON_WOOD = registerBlock("cinnamon_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_CINNAMON_LOG = registerBlock("stripped_cinnamon_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_CINNAMON_WOOD = registerBlock("stripped_cinnamon_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> CINNAMON_LEAVES = registerBlock("cinnamon_leaves", () -> new ModLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> CINNAMON_PLANKS = registerBlock("cinnamon_planks", () -> new ModPlanksBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> CINNAMON_STAIRS = registerBlock("cinnamon_stairs", () -> new StairBlock(() -> ModBlocks.CINNAMON_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
    public static final RegistryObject<Block> CINNAMON_SLAB = registerBlock("cinnamon_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
    public static final RegistryObject<Block> CINNAMON_FENCE = registerBlock("cinnamon_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> CINNAMON_FENCE_GATE = registerBlock("cinnamon_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> CINNAMON_DOOR = registerBlock("cinnamon_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), BlockSetType.OAK));
    public static final RegistryObject<Block> CINNAMON_TRAPDOOR = registerBlock("cinnamon_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));
    public static final RegistryObject<Block> CINNAMON_PRESSURE_PLATE = registerBlock("cinnamon_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));
    public static final RegistryObject<Block> CINNAMON_BUTTON = registerBlock("cinnamon_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10, true));

    public static final RegistryObject<Block> CINNAMON_SIGN = BLOCKS.register("cinnamon_sign", () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.CINNAMON));
    public static final RegistryObject<Block> CINNAMON_WALL_SIGN = BLOCKS.register("cinnamon_wall_sign", () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.CINNAMON));
    public static final RegistryObject<Block> CINNAMON_HANGING_SIGN = BLOCKS.register("cinnamon_hanging_sign", () -> new ModHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.CINNAMON));
    public static final RegistryObject<Block> CINNAMON_WALL_HANGING_SIGN = BLOCKS.register("cinnamon_wall_hanging_sign", () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.CINNAMON));

    public static final RegistryObject<Block> CINNAMON_SAPLING = registerBlock("cinnamon_sapling", () -> new SaplingBlock(new CinnamonTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> CINNAMON_CABINET = registerBlock("cinnamon_cabinet", () -> new CabinetBlock(BlockBehaviour.Properties.copy(vectorwing.farmersdelight.common.registry.ModBlocks.OAK_CABINET.get())));

    //cashew tree blocks
    public static final RegistryObject<Block> CASHEW_LOG = registerBlock("cashew_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_LOG)));
    public static final RegistryObject<Block> CASHEW_WOOD = registerBlock("cashew_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_WOOD)));
    public static final RegistryObject<Block> STRIPPED_CASHEW_LOG = registerBlock("stripped_cashew_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_BIRCH_LOG)));
    public static final RegistryObject<Block> STRIPPED_CASHEW_WOOD = registerBlock("stripped_cashew_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_BIRCH_WOOD)));
    public static final RegistryObject<Block> CASHEW_LEAVES = registerBlock("cashew_leaves", () -> new ModLeavesBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_LEAVES)));
    public static final RegistryObject<Block> CASHEW_LEAVES_GROWN = registerBlock("cashew_leaves_grown", () -> new ModLeavesBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_LEAVES)));
    public static final RegistryObject<Block> CASHEW_PLANKS = registerBlock("cashew_planks", () -> new ModPlanksBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));

    public static final RegistryObject<Block> CASHEW_STAIRS = registerBlock("cashew_stairs", () -> new StairBlock(() -> ModBlocks.CASHEW_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.BIRCH_STAIRS)));
    public static final RegistryObject<Block> CASHEW_SLAB = registerBlock("cashew_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_SLAB)));
    public static final RegistryObject<Block> CASHEW_FENCE = registerBlock("cashew_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_FENCE)));
    public static final RegistryObject<Block> CASHEW_FENCE_GATE = registerBlock("cashew_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_FENCE_GATE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> CASHEW_DOOR = registerBlock("cashew_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_DOOR), BlockSetType.BIRCH));
    public static final RegistryObject<Block> CASHEW_TRAPDOOR = registerBlock("cashew_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_TRAPDOOR), BlockSetType.BIRCH));
    public static final RegistryObject<Block> CASHEW_PRESSURE_PLATE = registerBlock("cashew_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.BIRCH_PRESSURE_PLATE), BlockSetType.BIRCH));
    public static final RegistryObject<Block> CASHEW_BUTTON = registerBlock("cashew_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_BUTTON), BlockSetType.BIRCH, 10, true));

    public static final RegistryObject<Block> CASHEW_SIGN = BLOCKS.register("cashew_sign", () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_SIGN), ModWoodTypes.CASHEW));
    public static final RegistryObject<Block> CASHEW_WALL_SIGN = BLOCKS.register("cashew_wall_sign", () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_WALL_SIGN), ModWoodTypes.CASHEW));
    public static final RegistryObject<Block> CASHEW_HANGING_SIGN = BLOCKS.register("cashew_hanging_sign", () -> new ModHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_HANGING_SIGN), ModWoodTypes.CASHEW));
    public static final RegistryObject<Block> CASHEW_WALL_HANGING_SIGN = BLOCKS.register("cashew_wall_hanging_sign", () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_WALL_HANGING_SIGN), ModWoodTypes.CASHEW));

    public static final RegistryObject<Block> CASHEW_SAPLING = registerBlock("cashew_sapling", () -> new SaplingBlock(new CashewTreeGrower(), BlockBehaviour.Properties.copy(Blocks.BIRCH_SAPLING)));

    public static final RegistryObject<Block> CASHEW_CABINET = registerBlock("cashew_cabinet", () -> new CabinetBlock(BlockBehaviour.Properties.copy(vectorwing.farmersdelight.common.registry.ModBlocks.BIRCH_CABINET.get())));

    //feast blocks
    public static final RegistryObject<Block> BUTTER_CHICKEN_BLOCK = BLOCKS.register("butter_chicken_block", () -> new ButterChickenBlock(Block.Properties.copy(vectorwing.farmersdelight.common.registry.ModBlocks.RICE_ROLL_MEDLEY_BLOCK.get()), ModItems.BUTTER_CHICKEN, true));
    public static final RegistryObject<Block> BIRYANI_BLOCK = BLOCKS.register("biryani_block", () -> new BiryaniBlock(Block.Properties.copy(vectorwing.farmersdelight.common.registry.ModBlocks.RICE_ROLL_MEDLEY_BLOCK.get()), ModItems.BIRYANI, false));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
