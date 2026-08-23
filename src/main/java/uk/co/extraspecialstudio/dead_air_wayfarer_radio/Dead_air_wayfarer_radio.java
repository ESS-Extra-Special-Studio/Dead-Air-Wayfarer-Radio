package uk.co.extraspecialstudio.dead_air_wayfarer_radio;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import org.slf4j.Logger;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.List;

@Mod(Dead_air_wayfarer_radio.MODID)
public class Dead_air_wayfarer_radio {
    public static final String MODID = "dead_air_wayfarer_radio";
    private static final Logger LOGGER = LogUtils.getLogger();

    private static final List<String> TRACK_SLUGS = List.of(
        "celestial_horizons",
        "cozy",
        "crystal_paths",
        "distant_lands",
        "dragonfire_path",
        "eternal_ascent",
        "farlands_horizon",
        "forest_of_first_quests",
        "gates_of_the_shimmering_realm",
        "grasslands",
        "harvest_sky",
        "heros_pulse",
        "kingdom_come",
        "lanterns_on_the_long_road",
        "overcome",
        "pathways",
        "quest_of_the_dawning_sky",
        "salt_air",
        "shimmer",
        "skyhold_over_the_emerald_vale",
        "skyward",
        "song_of_the_skyroads",
        "the_march",
        "vanguards_breath",
        "wings_of_old"
    );

    public Dead_air_wayfarer_radio() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::onRegister);
    }

    private void onRegister(RegisterEvent event) {
        if (!event.getRegistryKey().equals(ForgeRegistries.Keys.SOUND_EVENTS)) return;
        for (String slug : TRACK_SLUGS) {
            ResourceLocation id = ResourceLocation.fromNamespaceAndPath(MODID, "music." + slug);
            event.register(ForgeRegistries.Keys.SOUND_EVENTS, id, () -> SoundEvent.createVariableRangeEvent(id));
        }
        LOGGER.info("[Wayfarer Radio] Registered {} music tracks.", TRACK_SLUGS.size());
    }
}
