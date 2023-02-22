package dev.LONG.adventurecooking.init;

import dev.LONG.adventurecooking.AdventureChef;
import dev.LONG.adventurecooking.blocks.KitchenBlock;
import dev.LONG.adventurecooking.blocks.BlockCreator;
import dev.LONG.adventurecooking.items.BrieItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

public class Registration {
    public Registration() {
    }

    public static void init() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.register(Registration.class);
    }

    @SubscribeEvent
    public static void register(RegisterEvent event) {
        event.register(ForgeRegistries.Keys.BLOCKS,
                helper -> {
                    helper.register(new ResourceLocation(AdventureChef.MODID, "chashu"), new Block(BlockBehaviour.Properties.of(Material.CAKE)));
                    helper.register(new ResourceLocation(AdventureChef.MODID, "poop"), new Block(BlockBehaviour.Properties.of(Material.CAKE)));
                    helper.register(new ResourceLocation(AdventureChef.MODID, "kitchen"), new KitchenBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL)));

                    BlockCreator.allBlocks.forEach((name, blockProp) -> {
                        helper.register(new ResourceLocation(AdventureChef.MODID, name),new Block(blockProp));
                    });
                }
        );

        event.register(ForgeRegistries.Keys.ITEMS, helper -> {
            helper.register(new ResourceLocation(AdventureChef.MODID, "chashu"), new BlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(AdventureChef.MODID, "chashu")), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
            helper.register(new ResourceLocation(AdventureChef.MODID, "poop"), new BlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(AdventureChef.MODID, "poop")), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
            helper.register(new ResourceLocation(AdventureChef.MODID, "ladle"), new Item(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
            helper.register(new ResourceLocation(AdventureChef.MODID, "kitchen"), new BlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(AdventureChef.MODID, "kitchen")), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
            helper.register(new ResourceLocation(AdventureChef.MODID, "brie"), new BrieItem(new Item.Properties()
                    .tab(CreativeModeTab.TAB_FOOD)
                    .food(new FoodProperties.Builder()
                            .nutrition(2)
                            .saturationMod(5.0f)
                            .build()
                    )));

            BlockCreator.allBlocks.forEach((name, block) -> {
                ResourceLocation blockReference = new ResourceLocation(AdventureChef.MODID, name);

                helper.register(blockReference, new BlockItem(
                        ForgeRegistries.BLOCKS.getValue(blockReference),
                        new Item.Properties()
                                .tab(CreativeModeTab.TAB_BUILDING_BLOCKS)
                ));
            });
        });
    }
}
