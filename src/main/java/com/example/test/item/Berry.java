package com.example.test.item;

import com.example.test.utils.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.MutableRegistry;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntryInfo;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import com.example.test.utils.ModItems;

import java.util.List;

public class Berry extends Item {
    public Berry(Settings settings){
        super(settings);
    }
    //berry创建
    public static final Item berry =ModItems.register(
            new Berry(new Item.Settings()),
            "berry"
    );

    public static void initialize() {
        //berry的初始化部分
        //设置分组为REDSTONE,向分组中添加berry物品
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> itemGroup.add(Berry.berry));
        //设置berry的堆肥参数
        CompostingChanceRegistry.INSTANCE.add(Berry.berry, 0.3f);
        //设置berry的燃烧时间,单个物品烧制需要10*20tick
        FuelRegistry.INSTANCE.add(Berry.berry, 30 * 20);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.la_pluma_mod_test_01.berry").formatted(Formatting.GREEN));
    }

}
