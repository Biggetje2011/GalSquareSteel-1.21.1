package net.biggetje.squaresteel.item;

import net.biggetje.squaresteel.SquareSteel;
import net.biggetje.squaresteel.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SquareSteel.MOD_ID);

    public static final Supplier<CreativeModeTab> GALVANIZED_TAB = CREATIVE_MODE_TAB.register("galvanized_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.GALVANIZED_BLOCK.get()))
                    .title(Component.translatable("creativetab.galvanizedsquaresteel.stuff"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CUTTER);
                        output.accept(ModItems.STEEL_INGOT);
                        output.accept(ModBlocks.GALVANIZED_BLOCK);
                        output.accept(ModBlocks.STEEL_BLOCK);
                    })
                    .build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
