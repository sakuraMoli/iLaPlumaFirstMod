package com.example.test.item;

import com.example.test.utils.ModBlocks;
import com.example.test.utils.MyItemGroups;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.sound.BlockSoundGroup;


public class PureWhiteBlock extends Blocks {
    public static final Block PURE_WHITE_BLOCK = ModBlocks.register(
            new Block(AbstractBlock
                    .Settings.create()
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
                    .luminance(state->15)
                    .strength(1.0f,8.0f)
            ),
            "pure_white_block",
            true
    );

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(MyItemGroups.CUSTOM_ITEM_GROUP_KEY)
                .register((itemGroup) -> itemGroup.add(PureWhiteBlock.PURE_WHITE_BLOCK));
    }

}
