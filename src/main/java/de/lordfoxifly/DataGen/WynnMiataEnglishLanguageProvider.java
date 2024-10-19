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
        translationBuilder.add("key.wynnmiata.debugg_key", "Debugg");
        translationBuilder.add("key.category.wynnmiata", "WynnMiata");
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
        translationBuilder.add("gui." + WynnMiata.MOD_ID + ".playerstats.raidstats.Lable.TCCComps", "TCC Completions:");
        translationBuilder.add("gui." + WynnMiata.MOD_ID + ".playerstats.raidstats.Lable.NOGComps", "NOG Completions:");
        translationBuilder.add("gui." + WynnMiata.MOD_ID + ".playerstats.raidstats.Lable.NOLComps", "NOL Completions:");
        translationBuilder.add("gui." + WynnMiata.MOD_ID + ".playerstats.raidstats.Lable.TNAComps", "TNA Completions:");
        translationBuilder.add("gui." + WynnMiata.MOD_ID + ".settings.Raids.Checkbox.copyPlayerStats", "Copy PlayerStats");


        //
        translationBuilder.add("gui.wynnmiata.playerstats.TextWidget.NameInput", "Input Name");
        translationBuilder.add("gui.wynnmiata.playerstats.Button.Enter", "Enter");
    }
}
