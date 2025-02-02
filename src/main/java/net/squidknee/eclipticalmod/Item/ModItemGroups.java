package net.squidknee.eclipticalmod.Item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.squidknee.eclipticalmod.Block.ModBlocks;
import net.squidknee.eclipticalmod.EclipticalMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ModItemGroups {
    public static final ItemGroup ECLIPTICAL_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(EclipticalMod.MOD_ID, "ecliptical_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.TRANQUIL))
                    .displayName(Text.translatable("itemgroup.eclipticalmod.ecliptical"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ATLAS);
                        entries.add(ModItems.ACID);
                        entries.add(ModItems.COMBAT);
                        entries.add(ModItems.CURRENT);
                        entries.add(ModItems.DISC);
                        entries.add(ModItems.DISTORTION);
                        entries.add(ModItems.DUST);
                        entries.add(ModItems.EDGE);
                        entries.add(ModItems.HARMONY);
                        entries.add(ModItems.INDUSTRIAL);
                        entries.add(ModItems.JET);
                        entries.add(ModItems.MINERAL);
                        entries.add(ModItems.SEAR);
                        entries.add(ModItems.SLICE);
                        entries.add(ModItems.SPLASH);
                        entries.add(ModItems.TRANQUIL);
                        entries.add(ModItems.TREASURE);
                        entries.add(ModItems.YUKI);
                        entries.add(ModItems.ENCCOMVOUCHER);
                        entries.add(ModItems.ENCRAREVOUCHER);
                        entries.add(ModItems.ENCULTVOUCHER);
                        entries.add(ModItems.ENCUNCVOUCHER);
                        entries.add(ModItems.CASINOCARD);
                        entries.add(ModItems.CASINOCOIN);
                        entries.add(ModItems.BLACKJACKDECK);
                        entries.add(ModItems.RANGERCARD);
                        entries.add(ModItems.VIPRANGERCARD);
                        entries.add(ModItems.GOLDGEARCARD);
                        entries.add(ModItems.LEANCARD);
                        entries.add(ModItems.DIAMONDCHARM);
                        entries.add(ModItems.PEARLCHARM);
                        entries.add(ModItems.SINISTERCHARM);
                        entries.add(ModItems.MONARCHCHARM);
                        entries.add(ModItems.GAMMAPIN);
                        entries.add(ModItems.CANNONPIN);
                        entries.add(ModItems.AURA);
                        entries.add(ModBlocks.SLOTMACHINE);
                    }).build());
    public static void registerItemGroups(){
        EclipticalMod.LOGGER.info("Registering Item Groups for " + EclipticalMod.MOD_ID);
    }
}

