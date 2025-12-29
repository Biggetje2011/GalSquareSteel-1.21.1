package net.biggetje.galvanizedsquaresteel.item;

import net.biggetje.galvanizedsquaresteel.SquareSteel;
import net.biggetje.galvanizedsquaresteel.item.custom.CutterItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.biggetje.galvanizedsquaresteel.item.ModFoodProperties

import javax.swing.*;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SquareSteel.MOD_ID);

    public static final DeferredItem<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CUTTER = ITEMS.register("cutter",
            () -> new CutterItem(new Item.Properties()
                    .durability(128)));

    public static final DeferredItem<Item> LUNCHBOX = ITEMS.register("lunchbox",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.LUNCHBOX)));

    public static final DeferredItem<Item> EMPTY_LUNCHBOX = ITEMS.register("empty_lunchbox",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
