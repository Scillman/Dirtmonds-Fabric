package com.dmcpacks.dirtmonds.config;

import com.dmcpacks.dirtmonds.Dirtmonds;
import com.mojang.datafixers.util.Pair;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static boolean dirtmondfinder;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(Dirtmonds.MOD_ID + "config").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("dirtmondfinder", true), "false to disable, true to enable");
    }

    private static void assignConfigs() {
        dirtmondfinder = CONFIG.getOrDefault("dirtmondfinder", true);
    }
}