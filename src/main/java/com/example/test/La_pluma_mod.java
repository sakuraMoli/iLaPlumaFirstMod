package com.example.test;

import com.example.test.item.Berry;
import com.example.test.item.Super_Big_Cup_Pickaxe;
import com.example.test.utils.ModItems;
import com.example.test.utils.MyArmorMaterials;
import net.fabricmc.api.ModInitializer;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class La_pluma_mod implements ModInitializer {
	public static final String MOD_ID = "la_pluma_mod_test_01";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        Berry.initialize();
        Super_Big_Cup_Pickaxe.initialize();
	}
}