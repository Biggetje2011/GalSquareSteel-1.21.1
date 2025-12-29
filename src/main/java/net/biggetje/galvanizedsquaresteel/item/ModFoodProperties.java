package net.biggetje.galvanizedsquaresteel.item;


import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties LUNCHBOX = new FoodProperties.Builder()
            .nutrition(10)
            .saturationModifier(1f)
            .usingConvertsTo(ModItems.EMPTY_LUNCHBOX.get())
            .build();
}
