package uk.co.extraspecialstudio.dead_air_wayfarer_radio;

import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.slf4j.Logger;

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

    public Dead_air_wayfarer_radio(IEventBus modEventBus) {
        modEventBus.addListener(this::onRegister);
    }

    private void onRegister(RegisterEvent event) {
        event.register(Registries.SOUND_EVENT, registry -> {
            for (String slug : TRACK_SLUGS) {
                ResourceLocation id = ResourceLocation.fromNamespaceAndPath(MODID, "music." + slug);
                registry.register(id, SoundEvent.createVariableRangeEvent(id));
            }
        });
        LOGGER.info("[Wayfarer Radio] Registered {} tracks.", TRACK_SLUGS.size());
    }
}
