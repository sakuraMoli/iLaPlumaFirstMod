package com.example.test.item;

import com.example.test.utils.ModItems;
import com.example.test.utils.MyArmorMaterials;
import com.example.test.utils.MyItemGroups;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class SuperSuit extends ArmorItem{
    public SuperSuit(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }
    public static final Item SUPER_SUIT_HELMET = ModItems.register(new SuperSuit(MyArmorMaterials.SUPER_SUIT, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(MyArmorMaterials.SUPER_SUIT_DURABILITY_MULTIPLIER))), "super_suit_helmet");
    public static final Item SUPER_SUIT_CHESTPLATE = ModItems.register(new SuperSuit(MyArmorMaterials.SUPER_SUIT, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(MyArmorMaterials.SUPER_SUIT_DURABILITY_MULTIPLIER))), "super_suit_chestplate");
    public static final Item SUPER_SUIT_LEGGINGS = ModItems.register(new SuperSuit(MyArmorMaterials.SUPER_SUIT, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(MyArmorMaterials.SUPER_SUIT_DURABILITY_MULTIPLIER))), "super_suit_leggings");
    public static final Item SUPER_SUIT_BOOTS = ModItems.register(new SuperSuit(MyArmorMaterials.SUPER_SUIT, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(MyArmorMaterials.SUPER_SUIT_DURABILITY_MULTIPLIER))), "super_suit_boots");




    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(MyItemGroups.CUSTOM_ITEM_GROUP_KEY)
                .register((itemGroup)
                        ->itemGroup.add(SuperSuit.SUPER_SUIT_HELMET));
        ItemGroupEvents.modifyEntriesEvent(MyItemGroups.CUSTOM_ITEM_GROUP_KEY)
                .register((itemGroup)
                        ->itemGroup.add(SuperSuit.SUPER_SUIT_BOOTS));
        ItemGroupEvents.modifyEntriesEvent(MyItemGroups.CUSTOM_ITEM_GROUP_KEY)
                .register((itemGroup)
                        ->itemGroup.add(SuperSuit.SUPER_SUIT_LEGGINGS));
        ItemGroupEvents.modifyEntriesEvent(MyItemGroups.CUSTOM_ITEM_GROUP_KEY)
                .register((itemGroup)
                        ->itemGroup.add(SuperSuit.SUPER_SUIT_CHESTPLATE));
    }
    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.la_pluma_mod_test_01.super_suit").formatted(Formatting.GREEN));
    }
}
