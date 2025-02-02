package net.squidknee.eclipticalmod.Item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.squidknee.eclipticalmod.EclipticalMod;

public class ModItems {
    public static final Item ACID = registerItem("acid_badge", new Item(new Item.Settings()));
    public static final Item ATLAS = registerItem("atlas_badge", new Item(new Item.Settings()));
    public static final Item COMBAT = registerItem("combat_badge", new Item(new Item.Settings()));
    public static final Item CURRENT = registerItem("current_badge", new Item(new Item.Settings()));
    public static final Item DISC = registerItem("disc_badge", new Item(new Item.Settings()));
    public static final Item DISTORTION = registerItem("distortion_badge", new Item(new Item.Settings()));
    public static final Item DUST = registerItem("dust_badge", new Item(new Item.Settings()));
    public static final Item EDGE = registerItem("edge_badge", new Item(new Item.Settings()));
    public static final Item HARMONY = registerItem("harmony_badge", new Item(new Item.Settings()));
    public static final Item INDUSTRIAL = registerItem("industrial_badge", new Item(new Item.Settings()));
    public static final Item JET = registerItem("jet_badge", new Item(new Item.Settings()));
    public static final Item MINERAL = registerItem("mineral_badge", new Item(new Item.Settings()));
    public static final Item SEAR = registerItem("sear_badge", new Item(new Item.Settings()));
    public static final Item SLICE = registerItem("slice_badge", new Item(new Item.Settings()));
    public static final Item SPLASH = registerItem("splash_badge", new Item(new Item.Settings()));
    public static final Item TRANQUIL = registerItem("tranquil_badge", new Item(new Item.Settings()));
    public static final Item TREASURE = registerItem("treasure_badge", new Item(new Item.Settings()));
    public static final Item YUKI = registerItem("yuki_badge", new Item(new Item.Settings()));

    public static final Item ENCUNCVOUCHER = registerItem("enc_unc_voucher", new Item(new Item.Settings()));
    public static final Item ENCULTVOUCHER = registerItem("enc_ult_voucher", new Item(new Item.Settings()));
    public static final Item ENCRAREVOUCHER = registerItem("enc_rare_voucher", new Item(new Item.Settings()));
    public static final Item ENCCOMVOUCHER = registerItem("enc_com_voucher", new Item(new Item.Settings()));

    public static final Item CASINOCOIN = registerItem("casino_coin", new Item(new Item.Settings()));
    public static final Item CASINOCARD = registerItem("casino_card", new Item(new Item.Settings()));
    public static final Item BLACKJACKDECK = registerItem("blackjack_deck", new Blackjack(new Item.Settings()));

    public static final Item RANGERCARD = registerItem("ranger_card", new Item(new Item.Settings()));
    public static final Item VIPRANGERCARD = registerItem("vip_ranger_card", new Item(new Item.Settings()));
    public static final Item GOLDGEARCARD = registerItem("goldgear_card", new Item(new Item.Settings()));
    public static final Item LEANCARD = registerItem("lean_card", new Item(new Item.Settings()));

    public static final Item DIAMONDCHARM = registerItem("diamond_charm", new Item(new Item.Settings()));
    public static final Item PEARLCHARM = registerItem("pearl_charm", new Item(new Item.Settings()));
    public static final Item SINISTERCHARM = registerItem("sinister_charm", new Item(new Item.Settings()));
    public static final Item MONARCHCHARM = registerItem("monarch_charm", new Item(new Item.Settings()));

    public static final Item GAMMAPIN = registerItem("gamma_pin", new Item(new Item.Settings()));
    public static final Item CANNONPIN = registerItem("cannon_pin", new Item(new Item.Settings()));

    public static final Item AURA = registerItem("aura", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(EclipticalMod.MOD_ID, name), item);
    }
    public static void registerModItems(){
        EclipticalMod.LOGGER.info("Registering Mod Items for "+ EclipticalMod.MOD_ID);
    }
}
