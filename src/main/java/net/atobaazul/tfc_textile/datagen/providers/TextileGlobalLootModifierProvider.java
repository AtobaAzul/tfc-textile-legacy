package net.atobaazul.tfc_textile.datagen.providers;

import net.atobaazul.tfc_textile.common.loot.ReplaceHideModifier;
import net.atobaazul.tfc_textile.registries.TextileItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static net.atobaazul.tfc_textile.TFCTextileLegacy.MOD_ID;
import static net.atobaazul.tfc_textile.common.item.TextileItemTags.FURS;

public class TextileGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public TextileGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, MOD_ID);
    }

    @Override
    protected void start() {
        TextileItems.FURS.forEach((fur) -> {
            String name = fur.getId().toString().split(":")[1].replace("_fur", "").replace("_leather", "");

            add(name + "_replace_hide_drops", new ReplaceHideModifier(new LootItemCondition[] { new LootTableIdCondition.Builder(ResourceLocation.fromNamespaceAndPath("tfc", "entities/"+name)).build()}, fur.get()));
        });
    }
}
