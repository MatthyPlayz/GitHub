package com.matthyfamily.init;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import com.matthyfamily.Reference;
import com.matthyfamily.items.ItemBasic;
import com.matthyfamily.items.ItemCustomFood;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import panda.corn.objects.*;
import net.minecraft.block.Block;

@Mod.EventBusSubscriber(modid=Reference.MODID)
public class ModItems {
	@ObjectHolder("simplecorn:corncob")
	static Item corncobname = null;
	static Item Taco;
	static Object[] craftTaco = {
			" # ",
	        "#CO",
	        "CCC",
	        Character.valueOf('#'), Items.COOKED_BEEF,
	        Character.valueOf('C'), corncobname,
	        Character.valueOf('O'), Blocks.LEAVES
	};
	
	public static void init() {
		Taco = new ItemCustomFood("taco", 4, 4, false); // goes name, amt, saturation, eaten by dogs?
		System.out.println("GBNID: " + corncobname);
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(Taco);
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerModels(Taco);
		GameRegistry.addShapedRecipe(new ResourceLocation("inbc:taco"), null, new ItemStack(Taco, 1), craftTaco);
	}
	
	public static void registerModels(Item item) {
		System.out.println(new ModelResourceLocation(item.getRegistryName(), "inventory") + " " + item.getRegistryName());
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

}