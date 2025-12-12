package com.github.theredbrain.slotcustomizationapi;

import com.github.theredbrain.slotcustomizationapi.config.ClientConfig;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.fzzyhmstrs.fzzy_config.api.RegisterType;
import net.fabricmc.api.ClientModInitializer;

public class SlotCustomizationAPIClient implements ClientModInitializer {
	public static ClientConfig CLIENT_CONFIG;

	@Override
	public void onInitializeClient() {
		CLIENT_CONFIG = ConfigApiJava.registerAndLoadConfig(ClientConfig::new, RegisterType.CLIENT);
	}
}
