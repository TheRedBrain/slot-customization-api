package com.github.theredbrain.slotcustomizationapi;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SlotCustomizationAPI implements ModInitializer {
	public static final String MOD_ID = "slotcustomizationapi";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Slots were customized!");
	}
}