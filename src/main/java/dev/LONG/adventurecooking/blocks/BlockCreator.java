package dev.LONG.adventurecooking.blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

import java.util.HashMap;

public class BlockCreator {
    public static final HashMap<String, BlockBehaviour.Properties> allBlocks = new HashMap<>();

    public BlockCreator() {

    }

    public static void create(String name) {
        allBlocks.put(name, BlockBehaviour.Properties.of(Material.CAKE));
    }
}
