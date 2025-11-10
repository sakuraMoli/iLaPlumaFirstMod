package com.example.test.item;

import com.example.test.utils.ModItems;
import com.example.test.utils.MyItemGroups;
import com.example.test.utils.MyTool;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class Super_Big_Cup_Pickaxe extends PickaxeItem {
    public Super_Big_Cup_Pickaxe(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    public static final Item SUPER_BIG_CUP_PICKAXE = ModItems.register(
            new Super_Big_Cup_Pickaxe(MyTool.INSTANCE,new Item.Settings()
                    .attributeModifiers(
                            PickaxeItem.createAttributeModifiers(
                            new MyTool(),3,-2.8F
                            )
                    )
            ),
            "super_big_cup_pickaxe"
    );

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(MyItemGroups.CUSTOM_ITEM_GROUP_KEY)
                .register((itemGroup)
                        ->itemGroup.add(Super_Big_Cup_Pickaxe.SUPER_BIG_CUP_PICKAXE));
    }
    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.la_pluma_mod_test_01.super_big_cup_pickaxe").formatted(Formatting.GREEN));
    }
    @Override
    public boolean isEnchantable(ItemStack stack){
        return true;
    }
}

