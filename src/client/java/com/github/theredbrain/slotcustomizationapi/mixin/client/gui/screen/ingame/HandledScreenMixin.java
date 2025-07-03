package com.github.theredbrain.slotcustomizationapi.mixin.client.gui.screen.ingame;

import com.github.theredbrain.slotcustomizationapi.api.SlotCustomization;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Optional;

@Mixin(HandledScreen.class)
public abstract class HandledScreenMixin<T extends ScreenHandler> extends Screen {

	@Shadow @Final protected T handler;

	@Shadow @Nullable protected Slot focusedSlot;

	protected HandledScreenMixin(Text title) {
		super(title);
	}

	@Inject(method = "drawMouseoverTooltip", at = @At("RETURN"))
	protected void drawMouseoverTooltip(DrawContext context, int x, int y, CallbackInfo ci) {
		if (this.handler.getCursorStack().isEmpty() && this.focusedSlot != null && !this.focusedSlot.hasStack()) {
			if (this.focusedSlot instanceof SlotCustomization slotWithTooltip) {
				List<Text> list = slotWithTooltip.slotcustomizationapi$getSlotTooltipText();
				if (!list.isEmpty()) {
					context.drawTooltip(this.textRenderer, list, Optional.empty(), x, y);
				}
			}
		}
	}

}
