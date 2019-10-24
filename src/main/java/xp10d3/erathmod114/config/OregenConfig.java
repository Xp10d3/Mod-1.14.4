package xp10d3.erathmod114.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OregenConfig {
	public static ForgeConfigSpec.IntValue erath_chance;
	public static ForgeConfigSpec.BooleanValue generate_overworld;
	
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client) {
		server.comment("Oregen Config");
		
		erath_chance = server
				.comment("Maximum number of ore veins of ruby ore that can spawn in one chunk.")
				.defineInRange("oregen.erath_chance", 20, 1, 100);
		generate_overworld = server
				.comment("Decide if you want Erath Mod Ores to spawn in the overworld")
				.define("oregen.generate_overworld", true);
	}
}
