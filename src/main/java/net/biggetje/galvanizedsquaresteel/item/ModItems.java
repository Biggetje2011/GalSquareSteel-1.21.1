package net.biggetje.galvanizedsquaresteel.item;

import net.biggetje.galvanizedsquaresteel.SquareSteel;
import net.biggetje.galvanizedsquaresteel.item.custom.CutterItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SquareSteel.MOD_ID);

    public static final DeferredItem<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () ->  new Item(new Item.Properties()));

    public static final DeferredItem<Item> CUTTER = ITEMS.register("cutter",
            () ->  new CutterItem(new Item.Properties().durability(128)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
