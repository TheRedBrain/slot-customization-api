package com.github.theredbrain.slotcustomizationapi.config;

import com.github.theredbrain.slotcustomizationapi.SlotCustomizationAPI;
import me.fzzyhmstrs.fzzy_config.config.Config;
import me.fzzyhmstrs.fzzy_config.validation.misc.ValidatedBoolean;

public class ClientConfig extends Config {

	public ClientConfig() {
		super(SlotCustomizationAPI.identifier("client"));
	}

	public ValidatedBoolean show_slot_tooltips = new ValidatedBoolean(true);

}
