package net.squidknee.eclipticalmod;

import net.fabricmc.api.ModInitializer;

import net.squidknee.eclipticalmod.Item.ModItemGroups;
import net.squidknee.eclipticalmod.Item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EclipticalMod implements ModInitializer {
	public static final String MOD_ID = "eclipticalmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
	}
}