package com.example.test.utils;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class FabricDocsReference {
    public static final String MOD_ID = "la_pluma_mod_test_01";

    public static final FoodComponent STRENGTH_BERRY=new FoodComponent.Builder()
            .alwaysEdible()
            .snack()
            .nutrition(3)
            .saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,60*20,1),0.1f)
            .build();

}
