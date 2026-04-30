package com.example.test.client.render;

import com.example.test.entity.GreenCubeEntity;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

import static com.example.test.La_pluma_mod.MOD_ID;

public class GreenCubeEntityModel extends SinglePartEntityModel<GreenCubeEntity> {
    public static final EntityModelLayer LAYER = new EntityModelLayer(Identifier.of(MOD_ID, "green_cube"), "main");

    private final ModelPart root;
    private final ModelPart cube;

    public GreenCubeEntityModel(ModelPart root) {
        this.root = root;
        this.cube = root.getChild("cube");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        root.addChild(
                "cube",
                ModelPartBuilder.create()
                        .uv(0, 0)
                        // Align cube closer to the 1x1x1 hitbox; shifted further down by 8px.
                        .cuboid(-8.0f, 8.0f, -8.0f, 16.0f, 16.0f, 16.0f),
                ModelTransform.NONE
        );

        return TexturedModelData.of(modelData, 16, 16);
    }

    @Override
    public ModelPart getPart() {
        return root;
    }

    @Override
    public void setAngles(GreenCubeEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        // Idle bobbing: sine wave, amplitude 1 pixel, 25% of previous speed.
        float bob = MathHelper.sin(animationProgress * 0.04f) * 1.0f;
        cube.setPivot(0.0f, bob, 0.0f);
    }
}

