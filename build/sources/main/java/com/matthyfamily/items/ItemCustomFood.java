package com.matthyfamily.items;

import net.minecraft.item.ItemFood;

public class ItemCustomFood extends ItemFood {

	public ItemCustomFood(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		setTranslationKey(name);
		setRegistryName(name);
	}
	
}