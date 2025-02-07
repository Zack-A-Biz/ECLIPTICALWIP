package net.squidknee.eclipticalmod.Block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.squidknee.eclipticalmod.Block.custom.SlotMachine;
import net.squidknee.eclipticalmod.EclipticalMod;

public class ModBlocks {

    public static final Block SLOTMACHINE = registerBlock("slotmachine",
            new SlotMachine(AbstractBlock.Settings.create().strength(1.5f).nonOpaque()));

    public static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(EclipticalMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(EclipticalMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }
    public static void registerModBlocks(){
        EclipticalMod.LOGGER.info("Registering Mod Blocks for " + EclipticalMod.MOD_ID);
    }
}
