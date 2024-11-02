package de.lordfoxifly.Screens.Widgets;

import de.lordfoxifly.Client.Config.WynnMiataConfig;
import de.lordfoxifly.Screens.PlayerStatsScreen;
import de.lordfoxifly.WynnMiata;
import de.lordfoxifly.WynnMiataUtils.ColorUtils;
import de.lordfoxifly.WynnMiataUtils.WynnMiataUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;

import java.util.ArrayList;

public class TextFields {
    private  static final int leftBackGroundX = 6;
    public static TextFieldWidget PlayerStatSearch(int leftpos, int toppos){
        return new TextFieldWidget(MinecraftClient.getInstance().textRenderer, leftpos + 125 +124,toppos + 17, 80,15, Text.translatable("gui." + WynnMiata.MOD_ID + ".playerstats.TextWidget.NameInput"));
    }
    public static ButtonWidget PLayerStatSearchEnter(int leftpos, int toppos, TextFieldWidget textFieldWidget){
         return ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".playerstats.Button.Enter"), (btn) -> {
            if (textFieldWidget.getText().length() > 2 ){
            WynnMiata.LOGGER.info(textFieldWidget.getText());
            PlayerStatsScreen.setPlayer(textFieldWidget.getText());

            }
            else{
            textFieldWidget.setText(WynnMiata.ClientPlayer.getUsername());
            }

    }).dimensions( leftpos + 205 + 124, toppos  + 17, 40, 15).tooltip(Tooltip.of(Text.of("Enter your Input"))).build();
    }

    public static TextFieldWidget ShowPlayerRaidsXTextField(int leftpos, int toppos){
        return new TextFieldWidget(MinecraftClient.getInstance().textRenderer, leftpos +  20,toppos + 33, 60,15, Text.translatable("gui." + WynnMiata.MOD_ID + ".layout.TextWidget.showPlayerRaidsX"));
    }
    public static TextFieldWidget ShowPlayerRaidsYTextField(int leftpos, int toppos){
        return new TextFieldWidget(MinecraftClient.getInstance().textRenderer, leftpos + 100,toppos + 33, 60,15, Text.translatable("gui." + WynnMiata.MOD_ID + ".playerstats.TextWidget.showPlayerRaidsY"));
    }
    public static ButtonWidget ShowPlayerRaidsEnter(int leftpos, int toppos,int screenwidth, int screenheight, TextFieldWidget x, TextFieldWidget y){
        return ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".layout.Button.showPlayerRaidsCoordsEnter"), (btn) -> {
            if (WynnMiataUtils.isNumeric(y.getText()) && WynnMiataUtils.isNumeric(x.getText())){
                int iy = Integer.parseInt(y.getText());
                int ix = Integer.parseInt(x.getText());
                if (iy > screenheight || iy < 0 || ix < 0 || ix > screenwidth){
                    y.setText(String.valueOf(WynnMiata.CONFIG.getShowPlayerRaidy()));
                    x.setText(String.valueOf(WynnMiata.CONFIG.getShowPlayerRaidx()));
                }
                else {
                    WynnMiata.CONFIG.setShowPlayerRaidx(ix);
                    WynnMiata.CONFIG.setShowPlayerRaidy(iy);
                    WynnMiata.CONFIG.save();
                    WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();
                }

            }
            else{
                y.setText(String.valueOf(WynnMiata.CONFIG.getShowPlayerRaidy()));
                x.setText(String.valueOf(WynnMiata.CONFIG.getShowPlayerRaidx()));
            }

        }).dimensions( leftpos + 180, toppos  + 33, 40, 15).tooltip(Tooltip.of(Text.of("Enter your Input"))).build();
    }
}
