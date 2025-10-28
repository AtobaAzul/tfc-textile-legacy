package net.atobaazul.tfc_textile.common.item;

import com.lumintorious.tfcambiental.api.EquipmentTemperatureProvider;
import com.lumintorious.tfcambiental.item.ClothesItem;
import net.atobaazul.tfc_textile.registries.TextileMaterials;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class TextileClothingItem extends ClothesItem {
    public TextileClothingItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }

    public EquipmentTemperatureProvider getProvider() {
        return TextileMaterials.temperatureOf(material.value());
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return 1000;
    }
}
