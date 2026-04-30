package com.example.test.client.render;

import com.example.test.entity.GreenCubeEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class GreenCubeEntityRenderer extends MobEntityRenderer<GreenCubeEntity, GreenCubeEntityModel> {
    private static final Identifier TEXTURE = Identifier.of("minecraft", "textures/block/green_wool.png");

    public GreenCubeEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new GreenCubeEntityModel(context.getPart(GreenCubeEntityModel.LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(GreenCubeEntity entity) {
        return TEXTURE;
    }
}

