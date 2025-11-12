package com.example.test;

import com.example.test.item.Berry;
import com.example.test.item.PureWhiteBlock;
import com.example.test.item.SuperBigCupPickaxe;
import com.example.test.item.SuperSuit;
import com.example.test.utils.MyArmorMaterials;
import com.example.test.utils.MyItemGroups;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class La_pluma_mod implements ModInitializer {
	public static final String MOD_ID = "la_pluma_mod_test_01";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        MyItemGroups.initialize();
        Berry.initialize();
        SuperBigCupPickaxe.initialize();
        MyArmorMaterials.initialize();
        SuperSuit.initialize();
        PureWhiteBlock.initialize();
	}
}