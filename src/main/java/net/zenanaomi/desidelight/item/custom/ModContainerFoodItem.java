package net.zenanaomi.desidelight.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ModContainerFoodItem extends Item {
    private final Item containerItem;

    public ModContainerFoodItem(Item containerItem, Properties properties) {
        super(properties);
        this.containerItem = containerItem;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        ItemStack result = super.finishUsingItem(stack, level, livingEntity);

        if (livingEntity instanceof Player player && !player.getAbilities().instabuild) {
            ItemStack container = new ItemStack(containerItem);

            if (result.isEmpty()) {
                return container;
            }

            if (player.getInventory().add(container)) {
                player.drop(container, false);
            }
        }

        return result;
    }
}
