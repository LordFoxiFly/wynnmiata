package de.lordfoxifly.Screens.Widgets;

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

    public static TextFieldWidget RedLavaColor(int leftpos, int topPos){
        return new TextFieldWidget(MinecraftClient.getInstance().textRenderer , leftpos +leftBackGroundX + 86, topPos +40 , 30, 20, Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.TCC.TextWidget.RedLavaColorInput"));
    }
    public static TextFieldWidget GreenLavaColor(int leftpos, int topPos){
        return new TextFieldWidget(MinecraftClient.getInstance().textRenderer , leftpos + leftBackGroundX + 126, topPos +40 , 30, 20, Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.TCC.TextWidget.GreenLavaColorInput"));
    }
    public static TextFieldWidget BlueLavaColor(int leftpos, int topPos){
        return new TextFieldWidget(MinecraftClient.getInstance().textRenderer , leftpos + leftBackGroundX + 166, topPos +40 , 30, 20, Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.TCC.TextWidget.BlueLavaColorInput"));
    }

    public static ButtonWidget HighlightColorEnter(int leftpos, int toppos, TextFieldWidget redValue, TextFieldWidget greenValue, TextFieldWidget blueValue){

        return ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.TCC.Button.HighlightLavaColorENTER"), (btn) -> {
            if (WynnMiataUtils.isNumeric(redValue.getText()) && WynnMiataUtils.isNumeric(greenValue.getText()) && WynnMiataUtils.isNumeric(greenValue.getText() ) && redValue.getText().length() == 3 && greenValue.getText().length() == 3 && blueValue.getText().length() == 3){
                ArrayList<Integer> rgbInteger = new ArrayList<>();
                rgbInteger.add(Integer.parseInt(redValue.getText()));
                rgbInteger.add(Integer.parseInt(greenValue.getText()));
                rgbInteger.add(Integer.parseInt(blueValue.getText()));
                if (WynnMiataUtils.isBetween(rgbInteger,0,255) ){
                    WynnMiata.LOGGER.info("Red:" + redValue.getText() + " Green:" + greenValue.getText() + " Blue:" +blueValue.getText() );
                    WynnMiata.CONFIG.setHighlightLavaColor(ColorUtils.rgbToARGB(Integer.parseInt(redValue.getText()),Integer.parseInt(greenValue.getText()),Integer.parseInt(blueValue.getText())));
                    WynnMiata.CONFIG.save();
                    WynnMiata.LOGGER.info(String.valueOf(ColorUtils.rgbToARGB(Integer.parseInt(redValue.getText()),Integer.parseInt(greenValue.getText()),Integer.parseInt(blueValue.getText()))));
                }else {
                    blueValue.setText("255");
                    redValue.setText("255");
                    greenValue.setText("255");
                }
            }
            else{
                blueValue.setText("255");
                redValue.setText("255");
                greenValue.setText("255");
            }

        }).dimensions( leftpos + 206, toppos  + 40, 40, 20).tooltip(Tooltip.of(Text.of("Save your Input!"))).build();
    }
}
