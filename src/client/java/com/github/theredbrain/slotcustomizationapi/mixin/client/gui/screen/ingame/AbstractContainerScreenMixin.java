package com.github.theredbrain.slotcustomizationapi.mixin.client.gui.screen.ingame;

import com.github.theredbrain.slotcustomizationapi.SlotCustomizationAPIClient;
import com.github.theredbrain.slotcustomizationapi.api.SlotCustomization;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Optional;

@Mixin(AbstractContainerScreen.class)
public abstract class AbstractContainerScreenMixin<T extends AbstractContainerMenu> extends Screen {

	@Shadow
	@Final
	protected T menu;

	@Shadow
	@Nullable
	protected Slot hoveredSlot;

	protected AbstractContainerScreenMixin(Component title) {
		super(title);
	}

	@Inject(method = "renderTooltip", at = @At("RETURN"))
	protected void slotcustomizationapi$renderTooltip(GuiGraphics context, int x, int y, CallbackInfo ci) {
		if (this.menu.getCarried().isEmpty() && this.hoveredSlot != null && !this.hoveredSlot.hasItem()) {
			if (SlotCustomizationAPIClient.CLIENT_CONFIG.show_slot_tooltips.get() && this.hoveredSlot instanceof SlotCustomization slotWithTooltip) {
				List<Component> list = slotWithTooltip.slotcustomizationapi$getSlotTooltipText();
				if (!list.isEmpty()) {
					context.setTooltipForNextFrame(this.font, list, Optional.empty(), x, y);
				}
			}
		}
	}

}
