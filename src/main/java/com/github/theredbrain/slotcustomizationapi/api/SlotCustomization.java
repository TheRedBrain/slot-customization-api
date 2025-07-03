package com.github.theredbrain.slotcustomizationapi.api;

import net.minecraft.text.Text;

import java.util.List;

public interface SlotCustomization {
	void slotcustomizationapi$setX(int x);

	void slotcustomizationapi$setY(int y);

	void slotcustomizationapi$setDisabledOverride(boolean disabled);

	boolean slotcustomizationapi$getDisabledOverride();

	void slotcustomizationapi$setSlotTooltipText(List<Text> newSlotTooltipTextList);

	List<Text> slotcustomizationapi$getSlotTooltipText();
}
