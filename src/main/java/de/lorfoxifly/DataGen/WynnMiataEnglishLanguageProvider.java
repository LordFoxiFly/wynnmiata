package de.lorfoxifly.DataGen;

import de.lorfoxifly.Client.Keybinds;
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
        translationBuilder.add("key.category.wynnmiata", "WynnMiata");
        translationBuilder.add("gui.wynnmiata.settings.TCC.Button.Open", "TCC");
        translationBuilder.add("gui.wynnmiata.settings.NOL.Button.Open", "NOL");
        translationBuilder.add("gui.wynnmiata.settings.MISC.Button.Open", "MISC");
        translationBuilder.add("gui.wynnmiata.settings.TCC.Checkbox.HighlightLava", "Lava Highlight");
        translationBuilder.add("gui.wynnmiata.settings.Misc.Checkbox.HeadRendering", "Head Rendering");
        translationBuilder.add("gui.wynnmiata.settings.Misc.Checkbox.FireEntityRendering", "FireEntity Rendering");
        translationBuilder.add("gui.wynnmiata.settings.Misc.Checkbox.FireHudRendering", "Fire Hud Rendering");
        translationBuilder.add("gui.wynnmiata.settings.Misc.Checkbox.ArmorHudRendering", "Armor Hud Rendering");
    }
}
