package com.github.theredbrain.slotcustomizationapi.mixin;

import com.github.theredbrain.slotcustomizationapi.api.SlotCustomization;
import com.google.common.collect.Lists;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.Slot;

@Mixin(Slot.class)
public class SlotMixin implements SlotCustomization {

    @Shadow @Final @Mutable public int x;

    @Shadow @Final @Mutable public int y;

    @Unique
    private List<Component> slotcustomizationapi$slotTooltipText = Lists.newArrayList();

    @Unique
    private boolean slotcustomizationapi$disabledOverride = false;

    @Inject(method = "isActive", at = @At("TAIL"), cancellable = true)
    private void slotcustomizationapi$isActive(CallbackInfoReturnable<Boolean> cir) {
        if (!this.slotcustomizationapi$disabledOverride) return;
        cir.setReturnValue(false);
    }

    @Override
    public void slotcustomizationapi$setX(int x) {
        this.x = x;
    }

    @Override
    public void slotcustomizationapi$setY(int y) {
        this.y = y;
    }

    @Override
    public void slotcustomizationapi$setDisabledOverride(boolean disabled) {
        this.slotcustomizationapi$disabledOverride = disabled;
    }

    @Override
    public boolean slotcustomizationapi$getDisabledOverride() {
        return this.slotcustomizationapi$disabledOverride;
    }

    @Override
    public void slotcustomizationapi$setSlotTooltipText(List<Component> newSlotTooltipTextList) {
        this.slotcustomizationapi$slotTooltipText = newSlotTooltipTextList;
    }

    @Override
    public List<Component> slotcustomizationapi$getSlotTooltipText() {
        return this.slotcustomizationapi$slotTooltipText;
    }
}
