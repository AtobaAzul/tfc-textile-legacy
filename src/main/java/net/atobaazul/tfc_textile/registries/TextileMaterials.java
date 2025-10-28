package net.atobaazul.tfc_textile.registries;

import com.lumintorious.tfcambiental.api.EquipmentTemperatureProvider;
import com.lumintorious.tfcambiental.data.TemperatureModifier;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.*;

import static net.atobaazul.tfc_textile.TFCTextileLegacy.MOD_ID;
import static net.atobaazul.tfc_textile.TFCTextileUtil.TextileResource;

public class TextileMaterials {
    public static final DeferredRegister<ArmorMaterial> CLOTHES_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, MOD_ID);

    public static Map<ArmorMaterial, EquipmentTemperatureProvider> tempMappings = new HashMap<>();

    public final static Holder<ArmorMaterial> BLACK_BEAR_MATERIAL = createClothArmorMaterial("black_bear", 4f, -0.15f);
    public final static Holder<ArmorMaterial> CARIBOU_MATERIAL = createClothArmorMaterial("caribou", 6f, -0.15f, -0.15f);
    public final static Holder<ArmorMaterial> COUGAR_MATERIAL = createClothArmorMaterial("cougar", 4f, -0.15f);
    public final static Holder<ArmorMaterial> CROCODILE_MATERIAL = createClothArmorMaterial("crocodile", -5f, -0.25f, -0.25f);
    public final static Holder<ArmorMaterial> DIREWOLF_MATERIAL = createClothArmorMaterial("direwolf", 5f, -0.15f);
    public final static Holder<ArmorMaterial> GRIZZLY_BEAR_MATERIAL = createClothArmorMaterial("grizzly_bear", 4f, -0.15f);
    public final static Holder<ArmorMaterial> LION_MATERIAL = createClothArmorMaterial("lion", 3f, -0.20f, 0.15f);
    public final static Holder<ArmorMaterial> PANTHER_MATERIAL = createClothArmorMaterial("panther", 4f, -0.15f);
    public final static Holder<ArmorMaterial> POLAR_BEAR_MATERIAL = createClothArmorMaterial("polar_bear", 6f, -0.15f, -0.15f);
    public final static Holder<ArmorMaterial> RAW_HIDE_MATERIAL = createClothArmorMaterial("raw_hide", 2f, -0.10f);
    public final static Holder<ArmorMaterial> SABERTOOTH_MATERIAL = createClothArmorMaterial("sabertooth", 4f, -0.15f);
    public final static Holder<ArmorMaterial> TIGER_MATERIAL = createClothArmorMaterial("tiger", 4f, -0.15f);


    public static Holder<ArmorMaterial> createClothArmorMaterial(String name, float change, float potency) {
        ArmorMaterial material = new ArmorMaterial(
                Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                    map.put(ArmorItem.Type.BOOTS, 1);
                    map.put(ArmorItem.Type.LEGGINGS, 2);
                    map.put(ArmorItem.Type.CHESTPLATE, 2);
                    map.put(ArmorItem.Type.HELMET, 1);
                    map.put(ArmorItem.Type.BODY, 4);
                }),
                0,
                Holder.direct(SoundEvents.WOOL_PLACE),
                () -> Ingredient.EMPTY,
                List.of(new ArmorMaterial.Layer(TextileResource(name), "", true), new ArmorMaterial.Layer(TextileResource(name), "", false)),
                1,
                0
        );

        tempMappings.put(material, (player, stack) -> Optional.of(new TemperatureModifier("clothes", change, potency)));


        return CLOTHES_MATERIALS.register(name, () -> material);
    }

    public static Holder<ArmorMaterial> createClothArmorMaterial(String name, float change, float potency, float wetness) {
        ArmorMaterial material = new ArmorMaterial(
                Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                    map.put(ArmorItem.Type.BOOTS, 1);
                    map.put(ArmorItem.Type.LEGGINGS, 2);
                    map.put(ArmorItem.Type.CHESTPLATE, 2);
                    map.put(ArmorItem.Type.HELMET, 1);
                    map.put(ArmorItem.Type.BODY, 4);
                }),
                0,
                Holder.direct(SoundEvents.WOOL_PLACE),
                () -> Ingredient.EMPTY,
                List.of(new ArmorMaterial.Layer(TextileResource(name), "", true), new ArmorMaterial.Layer(TextileResource(name), "", false)),
                1,
                0
        );

        tempMappings.put(material, (player, stack) -> Optional.of(new TemperatureModifier("clothes", change, potency, wetness)));

        return CLOTHES_MATERIALS.register(name, () -> material);
    }


    public static EquipmentTemperatureProvider temperatureOf(ArmorMaterial material) {
        return tempMappings.get(material);
    }

}
