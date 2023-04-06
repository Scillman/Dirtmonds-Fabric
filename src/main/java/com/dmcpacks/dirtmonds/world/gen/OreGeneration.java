package com.dmcpacks.dirtmonds.world.gen;

import com.dmcpacks.dirtmonds.world.OrePlacedFeature;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class OreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, OrePlacedFeature.ORE_DIRTMONDS_LARGE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, OrePlacedFeature.ORE_DIRTMONDS_MEDIUM);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, OrePlacedFeature.ORE_DIRTMONDS_SMALL);
    }
}
