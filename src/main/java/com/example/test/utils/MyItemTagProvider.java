package com.example.test.utils;

import com.example.test.item.Berry;
import com.example.test.item.SuperBigCupPickaxe;
import com.example.test.item.SuperSuit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

import static com.example.test.La_pluma_mod.MOD_ID;

public class MyItemTagProvider extends FabricTagProvider<Item> {
    /**
     * Constructs a new {@link FabricTagProvider} with the default computed path.
     *
     * <p>Common implementations of this class are provided.
     *
     * @param output           the {@link FabricDataOutput} instance
     * @param registriesFuture the backing registry for the tag type
     */
    public MyItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ITEM, registriesFuture);
    }

    public static final TagKey<Item> MY_MOD_ITEMS = TagKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, "my_mod_items"));
    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE)
                .add(SuperBigCupPickaxe.SUPER_BIG_CUP_PICKAXE);
        getOrCreateTagBuilder(ItemTags.ARMOR_ENCHANTABLE)
                .add(SuperSuit.SUPER_SUIT_HELMET)
                .add(SuperSuit.SUPER_SUIT_CHESTPLATE)
                .add(SuperSuit.SUPER_SUIT_LEGGINGS)
                .add(SuperSuit.SUPER_SUIT_BOOTS);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(SuperSuit.SUPER_SUIT_CHESTPLATE);
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(SuperSuit.SUPER_SUIT_BOOTS);
        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(SuperSuit.SUPER_SUIT_HELMET);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(SuperSuit.SUPER_SUIT_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.FOX_FOOD)
                .add(Berry.BERRY);
    }
}
