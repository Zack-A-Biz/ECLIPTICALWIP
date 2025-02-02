package net.squidknee.eclipticalmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;
import net.squidknee.eclipticalmod.Block.ModBlocks;
import net.squidknee.eclipticalmod.Item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.SLOTMACHINE);
    }
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ACID, Models.GENERATED);
        itemModelGenerator.register(ModItems.ATLAS, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLACKJACKDECK, Models.GENERATED);
        itemModelGenerator.register(ModItems.CANNONPIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CASINOCARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CASINOCOIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMBAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CURRENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMONDCHARM, Models.GENERATED);
        itemModelGenerator.register(ModItems.DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.DISTORTION, Models.GENERATED);
        itemModelGenerator.register(ModItems.DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.EDGE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENCCOMVOUCHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENCUNCVOUCHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENCRAREVOUCHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENCULTVOUCHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.GAMMAPIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLDGEARCARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.HARMONY, Models.GENERATED);
        itemModelGenerator.register(ModItems.INDUSTRIAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.JET, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEANCARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.MINERAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.MONARCHCHARM, Models.GENERATED);
        itemModelGenerator.register(ModItems.PEARLCHARM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RANGERCARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.SEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.SINISTERCHARM, Models.GENERATED);
        itemModelGenerator.register(ModItems.SLICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPLASH, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRANQUIL, Models.GENERATED);
        itemModelGenerator.register(ModItems.TREASURE, Models.GENERATED);
        itemModelGenerator.register(ModItems.VIPRANGERCARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.YUKI, Models.GENERATED);
        itemModelGenerator.register(ModItems.AURA, Models.GENERATED);
        itemModelGenerator.register(Item.fromBlock(ModBlocks.SLOTMACHINE), Models.GENERATED);

    }
}
