package net.kaupenjoe.mccourse;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.components.ModDataComponentTypes;
import net.kaupenjoe.mccourse.event.AttackEntityHandler;
import net.kaupenjoe.mccourse.item.ModItemGroups;
import net.kaupenjoe.mccourse.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCCourseMod implements ModInitializer {
	public static final String MOD_ID = "mccourse";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModDataComponentTypes.registerDataComponentTypes();

		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 600);

		AttackEntityCallback.EVENT.register(new AttackEntityHandler());
	}
}