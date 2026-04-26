package com.github.theredbrain.slotcustomizationapi.mixin.client.gui.screens.inventory;

import com.github.theredbrain.slotcustomizationapi.api.SlotCustomization;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(targets = {"net/minecraft/client/gui/screens/inventory/CreativeModeInventoryScreen$SlotWrapper"})
public class CreativeModeInventoryScreenSlotWrapperMixin extends Slot {

	public CreativeModeInventoryScreenSlotWrapperMixin(Container container, int slot, int x, int y) {
		super(container, slot, x, y);
	}

	@Inject(method = "<init>", at = @At("TAIL"))
	public void CreativeModeInventoryScreen$SlotWrapper(Slot target, int index, int x, int y, CallbackInfo ci) {
		((SlotCustomization) this).slotcustomizationapi$setSlotTooltipText(((SlotCustomization) target).slotcustomizationapi$getSlotTooltipText());
	}
}
