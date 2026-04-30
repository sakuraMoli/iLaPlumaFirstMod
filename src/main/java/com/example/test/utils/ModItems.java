package com.example.test.utils;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.example.test.La_pluma_mod.MOD_ID;

public class ModItems  {

    public static Item register(Item item, String id) {
        Identifier itemID = Identifier.of(MOD_ID, id);
        return Registry.register(Registries.ITEM, itemID, item);
    }
}