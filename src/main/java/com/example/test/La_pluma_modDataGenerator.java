package com.example.test;

import com.example.test.utils.MyBlockLootTableProvider;
import com.example.test.utils.MyBlockTagProvider;
import com.example.test.utils.MyItemTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class La_pluma_modDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(MyItemTagProvider::new);
        pack.addProvider(MyBlockTagProvider::new);
        pack.addProvider(MyBlockLootTableProvider::new);
	}
}