package de.lordfoxifly.DataGen;

import de.lordfoxifly.WynnMiata;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class WynnMiataEnglishLanguageProvider extends FabricLanguageProvider {
    protected WynnMiataEnglishLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("key.wynnmiata.settings_key", "Settings");
        translationBuilder.add("key.wynnmiata.player_preview_key", "Player Preview");
        translationBuilder.add("key.wynnmiata.debugg_key", "Debug");
        translationBuilder.add("key.category.wynnmiata", "WynnMiata");
        translationBuilder.add("gui.wynnmiata.settings.Debug.Button.Open", "Debug");
        translationBuilder.add("gui.wynnmiata.settings.TCC.Button.Open", "TCC");
        translationBuilder.add("gui.wynnmiata.settings.NOL.Button.Open", "NOL");
        translationBuilder.add("gui.wynnmiata.settings.MISC.Button.Open", "MISC");
        translationBuilder.add("gui.wynnmiata.settings.RAIDS.Button.Open", "RAIDS");
        translationBuilder.add("gui.wynnmiata.settings.TCC.Checkbox.HighlightLava", "Lava Highlight");
        translationBuilder.add("gui.wynnmiata.settings.Misc.Checkbox.HeadRendering", "Head Rendering");
        translationBuilder.add("gui.wynnmiata.settings.Misc.Checkbox.FireEntityRendering", "FireEntity Rendering");
        translationBuilder.add("gui.wynnmiata.settings.Misc.Checkbox.FireHudRendering", "Fire Hud Rendering");
        translationBuilder.add("gui.wynnmiata.settings.Misc.Checkbox.ArmorHudRendering", "Armor Hud Rendering");
        translationBuilder.add("gui.wynnmiata.settings.Raids.Checkbox.showPlayerRaids", "Show Player Raids");
        translationBuilder.add("gui.wynnmiata.playerstats.raidstats.Lable.TCCComps", "TCC Completions:");
        translationBuilder.add("gui.wynnmiata.playerstats.raidstats.Lable.NOGComps", "NOG Completions:");
        translationBuilder.add("gui.wynnmiata.playerstats.raidstats.Lable.NOLComps", "NOL Completions:");
        translationBuilder.add("gui.wynnmiata.playerstats.raidstats.Lable.TNAComps", "TNA Completions:");
        translationBuilder.add("gui.wynnmiata.settings.Raids.Checkbox.copyPlayerStats", "Copy PlayerStats");
        translationBuilder.add("gui.wynnmiata.settings.Debug.Checkbox.debugEvents", "Debug Events");
        translationBuilder.add("gui.wynnmiata.settings.Debug.Checkbox.debugRaids", "Debug Raids");
        translationBuilder.add("gui.wynnmiata.settings.Debug.Checkbox.debugHud", "Debug Hud");
        translationBuilder.add("gui.wynnmiata.settings.Layout.Button.Open", "Layout");
        translationBuilder.add("gui.wynnmiata.settings.Customize.Button.Open", "Customize");
        translationBuilder.add("gui.wynnmiata.Customize.LavaHighlight.Open", "Lava Highlight");
        translationBuilder.add("gui.wynnmiata.settings.Misc.Checkbox.ArmorDurabilityHudRendering", "Show Armor Durability");
        translationBuilder.add("gui.wynnmiata.settings.Misc.Checkbox.AcessoryDurabilityHudRendering", "Shows Acessory Durability ");
        translationBuilder.add("gui.wynnmiata.settings.Misc.Checkbox.ProfessionTrackingHudRendering", "Shows Profession Stats");
        translationBuilder.add( "gui.wynnmiata.playerstats.Button.AddFriend", "Add Friend");
        translationBuilder.add( "gui.wynnmiata.playerstats.Button.AddParty", "Party Invite");
        translationBuilder.add( "gui.wynnmiata.playerstats.Button.AddGuild", "Guild Invite");
translationBuilder.add("gui.wynnmiata.settings.Misc.Checkbox.TradeMarketMiddleClickSell", "Trade Market Quick Sell");
        //
        translationBuilder.add("gui.wynnmiata.playerstats.TextWidget.NameInput", "Input Name");
        translationBuilder.add("gui.wynnmiata.playerstats.Button.Enter", "Enter");
        translationBuilder.add("gui.wynnmiata.layout.Button.showPlayerRaidsCoordsEnter", "Enter");
        translationBuilder.add("gui.wynnmiata.customize.Button.HighlightLavaColorEnter", "Enter");
        translationBuilder.add("gui.wynnmiata.layout.Button.armorDurabilityEnter", "Enter");
        translationBuilder.add("gui.wynnmiata.layout.Button.armorDurabilityColorEnter", "Enter");
        translationBuilder.add("gui.wynnmiata.layout.Button.showPlayerRaidsColorEnter", "Enter");
        translationBuilder.add("gui.wynnmiata.layout.Button.armorDurabilityTextCoordsEnter", "Enter");
        translationBuilder.add("gui.wynnmiata.layout.Button.ProfessionHudEnter", "Enter");
        translationBuilder.add("gui.wynnmiata.layout.Button.ProfessionHudColorEnter", "Enter");
        translationBuilder.add("gui.wynnmiata.layout.Button.ProfessionHudTextCoordsEnter", "Enter");
        translationBuilder.add("gui.wynnmiata.settings.Misc.Checkbox.ArmorDurabilityOnlyRendering", "Only Durability");

    }
}
