package de.lordfoxifly.Screens;

import de.lordfoxifly.Client.Config.WynnMiataConfig;
import de.lordfoxifly.Screens.Widgets.LayoutWidgets;
import de.lordfoxifly.WynnMiata;
import de.lordfoxifly.WynnMiataUtils.ColorUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class LayoutScreen extends Screen {
    private static final  Text TITLE = Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.LayoutScreen");
    private static final Identifier DIAMOND_LEGGINGS = Identifier.of(WynnMiata.MOD_ID, "textures/gui/minecraft/diamond_leggings.png");
    private static final Identifier DIAMOND_CHESTPLATE = Identifier.of(WynnMiata.MOD_ID, "textures/gui/minecraft/diamond_chestplate.png");
    private static final Identifier DIAMOND_HELMET = Identifier.of(WynnMiata.MOD_ID, "textures/gui/minecraft/diamond_helmet.png");
    private static final Identifier EMPTY_BOOTS = Identifier.of(WynnMiata.MOD_ID, "textures/gui/minecraft/empty_armor_slot_boots.png");
    int leftpos,  toppos;
    public LayoutScreen() {
        super(TITLE);
        WynnMiata.CONFIG.setRenderHudElements(false);
        WynnMiata.CONFIG.save();
        WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();
    }
    @Override
    protected void init() {
        leftpos = 0;
        toppos = 0;
        super.init();

        if (WynnMiata.CONFIG.isShowPlayerRaidsBoolean()){
            addDrawableChild(LayoutWidgets.ShowPlayerRaids());
        }
        if (WynnMiata.CONFIG.isArmorDurabilityBoolean()){
            addDrawableChild(LayoutWidgets.ArmorDurability());
        }


    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context,mouseX,mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
       if (WynnMiata.CONFIG.isShowPlayerRaidsBoolean()){
           int y = 15;
           context.drawText(MinecraftClient.getInstance().textRenderer, Text.literal("Raid: TCC"), WynnMiata.CONFIG.getShowPlayerRaidx(),WynnMiata.CONFIG.getShowPlayerRaidy(), ColorUtils.hexstringToInt(WynnMiata.CONFIG.getShowPlayerRaidColor()), true);
           for (int i = 0; i < 4; i++){
               context.drawText(MinecraftClient.getInstance().textRenderer, Text.literal(MinecraftClient.getInstance().getSession().getUsername() + ": "+ y), WynnMiata.CONFIG.getShowPlayerRaidx(),  WynnMiata.CONFIG.getShowPlayerRaidy() + y,ColorUtils.hexstringToInt(WynnMiata.CONFIG.getShowPlayerRaidColor()) ,true);
               y += 15;
               if (i == 3) y = 15;
           }
       }
       if (WynnMiata.CONFIG.isArmorDurabilityBoolean()){
           context.drawTexture(DIAMOND_HELMET, WynnMiata.CONFIG.getArmorDurabilityX() +10, WynnMiata.CONFIG.getArmorDurabilityY() , 0, 0, 15, 15, 15, 15);
           context.drawText(textRenderer, "[95/124]", WynnMiata.CONFIG.getArmorDurabilityX(), WynnMiata.CONFIG.getArmorDurabilityY() +13, ColorUtils.hexstringToInt(WynnMiata.CONFIG.getArmorDurabilityColor()), true);
           context.drawTexture(DIAMOND_CHESTPLATE, WynnMiata.CONFIG.getArmorDurabilityX()+ 10, WynnMiata.CONFIG.getArmorDurabilityY() + 20, 0, 0, 15, 15, 15, 15);
           context.drawTexture(DIAMOND_LEGGINGS, WynnMiata.CONFIG.getArmorDurabilityX() +10, WynnMiata.CONFIG.getArmorDurabilityY() + 40, 0, 0, 15, 15, 15, 15);
           context.drawTexture(EMPTY_BOOTS, WynnMiata.CONFIG.getArmorDurabilityX() +10, WynnMiata.CONFIG.getArmorDurabilityY() + 60, 0, 0, 15, 15, 15, 15);
       }

    }

    @Override
    public boolean shouldCloseOnEsc() {
        WynnMiata.CONFIG.setRenderHudElements(true);
        WynnMiata.CONFIG.save();
        WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();
        return super.shouldCloseOnEsc();
    }
}
