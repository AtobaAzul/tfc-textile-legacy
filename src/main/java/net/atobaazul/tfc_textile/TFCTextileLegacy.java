package net.atobaazul.tfc_textile;

import com.lumintorious.tfcambiental.TFCAmbiental;
import com.mojang.logging.LogUtils;
import net.atobaazul.tfc_textile.registries.TextileItems;
import net.atobaazul.tfc_textile.registries.TextileLootModifiers;
import net.atobaazul.tfc_textile.registries.TextileMaterials;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.slf4j.Logger;

import static net.atobaazul.tfc_textile.registries.TextileItems.*;

@Mod(TFCTextileLegacy.MOD_ID)
public class TFCTextileLegacy {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "tfc_textile_legacy";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public TFCTextileLegacy(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);


        //NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        TextileMaterials.CLOTHES_MATERIALS.register(modEventBus);
        TextileItems.ITEMS.register(modEventBus);
        TextileLootModifiers.LOOT_MODIFIER_SERIALIZERS.register(modEventBus);
    }


    private void commonSetup(FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

        if (event.getTabKey() == TFCAmbiental.EXAMPLE_TAB.getKey()) {
            BLACK_BEAR_CLOTHES.forEach(event::accept);
            CARIBOU_CLOTHES.forEach(event::accept);
            COUGAR_CLOTHES.forEach(event::accept);
            CROCODILE_CLOTHES.forEach(event::accept);
            DIREWOLF_CLOTHES.forEach(event::accept);
            GRIZZLY_BEAR_CLOTHES.forEach(event::accept);
            LION_CLOTHES.forEach(event::accept);
            PANTHER_CLOTHES.forEach(event::accept);
            POLAR_BEAR_CLOTHES.forEach(event::accept);
            RAW_HIDE_CLOTHES.forEach(event::accept);
            SABERTOOTH_CLOTHES.forEach(event::accept);
            TIGER_CLOTHES.forEach(event::accept);
            FURS.forEach(event::accept);

            event.accept(PRIMITIVE_INSULATION);
        }
    }
}
