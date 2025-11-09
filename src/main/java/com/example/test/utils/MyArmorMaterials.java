package com.example.test.utils;

import com.example.test.item.Berry;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static com.example.test.utils.FabricDocsReference.MOD_ID;

public class MyArmorMaterials extends ArmorMaterials {

    // Within the ModArmorMaterials class
    public static void initialize() {};

    public static RegistryEntry<ArmorMaterial> registerMaterial(String id, Map<ArmorItem.Type, Integer> defensePoints, int enchantability, RegistryEntry<SoundEvent> equipSound, Supplier<Ingredient> repairIngredientSupplier, float toughness, float knockbackResistance, boolean dyeable) {
        // 获取盔甲材质支持的图层
        List<ArmorMaterial.Layer> layers = List.of(
                // 纹理图层的ID、后缀以及该图层是否可染色。
                // 我们可以直接将盔甲材质ID作为纹理图层ID传递。
                // 我们不需要后缀，因此传递空字符串。
                // 我们将接收到的dyeable布尔值作为可染色参数传递。
                new ArmorMaterial.Layer(Identifier.of(MOD_ID, id), "", dyeable)
        );

        ArmorMaterial material = new ArmorMaterial(defensePoints, enchantability, equipSound, repairIngredientSupplier, layers, toughness, knockbackResistance);
        // 在ArmorMaterials注册表中注册该材质
        material = Registry.register(Registries.ARMOR_MATERIAL, Identifier.of(MOD_ID, id), material);

        // 大多数情况下，您会需要该材质的RegistryEntry - 特别是用于ArmorItem构造函数
        return RegistryEntry.of(material);
    }
    public static final RegistryEntry<ArmorMaterial> SUPER_SUIT = registerMaterial("super_suit",
            // Defense (protection) point values for each armor piece.
            Map.of(
                    ArmorItem.Type.HELMET, 6,
                    ArmorItem.Type.CHESTPLATE, 16,
                    ArmorItem.Type.LEGGINGS, 12,
                    ArmorItem.Type.BOOTS, 6
            ),
            // Enchantability. For reference, leather has 15, iron has 9, and diamond has 10.
            20,
            // The sound played when the armor is equipped.
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            // The ingredient(s) used to repair the armor.
            () -> Ingredient.ofItems(Berry.BERRY),
            0.5F,
            1F,
            false);
    public static final int SUPER_SUIT_DURABILITY_MULTIPLIER = 15;

}
