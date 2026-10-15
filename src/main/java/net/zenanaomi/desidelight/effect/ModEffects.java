package net.zenanaomi.desidelight.effect;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.zenanaomi.desidelight.DesiDelight;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, DesiDelight.MOD_ID);

    public static final Holder<MobEffect> BURNING = EFFECTS.register("burning", BurningEffect::new);
    public static final Holder<MobEffect> BURNING_SP = EFFECTS.register("burning_sp", BurningSpecialEffect::new);

    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }
}
