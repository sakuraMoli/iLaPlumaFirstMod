package com.example.test;

import com.example.test.client.render.GreenCubeEntityModel;
import com.example.test.client.render.GreenCubeEntityRenderer;
import com.example.test.utils.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class La_pluma_modClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(GreenCubeEntityModel.LAYER, GreenCubeEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.GREEN_CUBE, GreenCubeEntityRenderer::new);
    }
}

