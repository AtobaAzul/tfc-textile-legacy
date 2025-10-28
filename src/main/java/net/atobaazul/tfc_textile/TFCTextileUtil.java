package net.atobaazul.tfc_textile;

import net.minecraft.resources.ResourceLocation;

import static net.atobaazul.tfc_textile.TFCTextileLegacy.MOD_ID;

public class TFCTextileUtil {
    public static ResourceLocation TextileResource(String resource) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, resource);
    }
}
