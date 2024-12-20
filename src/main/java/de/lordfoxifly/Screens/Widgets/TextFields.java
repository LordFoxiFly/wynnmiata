package de.lordfoxifly.Screens.Widgets;

import de.lordfoxifly.Client.Config.WynnMiataConfig;
import de.lordfoxifly.Screens.PlayerStatsScreen;
import de.lordfoxifly.WynnMiata;
import de.lordfoxifly.WynnMiataUtils.WynnMiataUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFields {
    private  static final int leftBackGroundX = 6;
    public static TextFieldWidget PlayerStatSearch(int leftpos, int toppos){
        return new TextFieldWidget(MinecraftClient.getInstance().textRenderer, leftpos + 125 +124,toppos + 15, 80,18, Text.translatable("gui." + WynnMiata.MOD_ID + ".playerstats.TextWidget.NameInput"));
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

    }).dimensions( leftpos + 205 + 124, toppos  + 15, 40, 19).tooltip(Tooltip.of(Text.of("Enter your Input"))).build();
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

    public static TextFieldWidget ShowPlayerRaidsColorTextField(int x, int y){
        return new TextFieldWidget(MinecraftClient.getInstance().textRenderer, x,y, 50,15, Text.translatable("gui." + WynnMiata.MOD_ID + ".layout.TextWidget.ShowPlayerRaidsColorInput"));
    }
    public static ButtonWidget ShowPlayerRaidsColorEnter(int x, int y, TextFieldWidget textFieldWidget){
        return ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".layout.Button.showPlayerRaidsColorEnter"), (btn) -> {
            Pattern pattern = Pattern.compile("[^0-9A-F]");
            Matcher matcher = pattern.matcher(textFieldWidget.getText());
            if (!matcher.find() && textFieldWidget.getText().length() < 7){
                WynnMiata.CONFIG.setShowPlayerRaidColor(textFieldWidget.getText());
                WynnMiata.CONFIG.save();
                WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();

            }
            else{
                textFieldWidget.setText(WynnMiata.CONFIG.getShowPlayerRaidColor());
            }

        }).dimensions( x, y, 40, 15).tooltip(Tooltip.of(Text.of("Enter your Input"))).build();
    }

    public static TextFieldWidget LavaHighlightColorTextField(int x, int y){
        return new TextFieldWidget(MinecraftClient.getInstance().textRenderer, x,y, 50,15, Text.translatable("gui." + WynnMiata.MOD_ID + ".customize.TextWidget.LavaHighlightColorInput"));
    }
    public static ButtonWidget LavaHighlightColorEnter(int x, int y, TextFieldWidget textFieldWidget){
        return ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".customize.Button.HighlightLavaColorEnter"), (btn) -> {
            Pattern pattern = Pattern.compile("[^0-9A-F]");
            Matcher matcher = pattern.matcher(textFieldWidget.getText());
            if (!matcher.find() && textFieldWidget.getText().length() < 7){
                WynnMiata.CONFIG.setHighLightLavaColor(textFieldWidget.getText());
                WynnMiata.CONFIG.save();
                WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();

            }
            else{
                textFieldWidget.setText(WynnMiata.CONFIG.getHighLightLavaColor());
            }

        }).dimensions( x, y, 40, 15).tooltip(Tooltip.of(Text.of("Enter your Input"))).build();
    }

    public static TextFieldWidget LayoutMenuXTextField(int x, int y){
        return new TextFieldWidget(MinecraftClient.getInstance().textRenderer, x ,y , 60,15, Text.translatable("gui." + WynnMiata.MOD_ID + ".layout.TextWidget.showPlayerRaidsX"));
    }
    public static TextFieldWidget LayoutMenuYTextField(int x, int y){
        return new TextFieldWidget(MinecraftClient.getInstance().textRenderer, x ,y , 60,15, Text.translatable("gui." + WynnMiata.MOD_ID + ".playerstats.TextWidget.showPlayerRaidsY"));
    }
    public static ButtonWidget ArmorDurabilityCoordsEnter(int leftpos, int toppos, int screenwidth, int screenheight, TextFieldWidget x, TextFieldWidget y){
        return ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".layout.Button.armorDurabilityEnter"), (btn) -> {
            if (WynnMiataUtils.isNumeric(y.getText()) && WynnMiataUtils.isNumeric(x.getText())){
                int iy = Integer.parseInt(y.getText());
                int ix = Integer.parseInt(x.getText());
                if (iy > screenheight || iy < 0 || ix < 0 || ix > screenwidth){
                    y.setText(String.valueOf(WynnMiata.CONFIG.getArmorDurabilityY()));
                    x.setText(String.valueOf(WynnMiata.CONFIG.getArmorDurabilityX()));
                }
                else {
                    WynnMiata.CONFIG.setArmorDurabilityX(ix);
                    WynnMiata.CONFIG.setArmorDurabilityY(iy);
                    WynnMiata.CONFIG.save();
                    WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();
                }

            }
            else{
                y.setText(String.valueOf(WynnMiata.CONFIG.getArmorDurabilityY()));
                x.setText(String.valueOf(WynnMiata.CONFIG.getArmorDurabilityX()));
            }

        }).dimensions( leftpos + 180, toppos  + 33, 40, 15).tooltip(Tooltip.of(Text.of("Enter your Input"))).build();
    }

    public static TextFieldWidget LayoutMenuColorTextField(int x, int y){
        return new TextFieldWidget(MinecraftClient.getInstance().textRenderer, x,y, 50,15, Text.translatable("gui." + WynnMiata.MOD_ID + ".layout.TextWidget.ShowPlayerRaidsColorInput"));
    }
    public static ButtonWidget ArmorDurabilityColorEnter(int x, int y, TextFieldWidget textFieldWidget){
        return ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".layout.Button.armorDurabilityColorEnter"), (btn) -> {
            Pattern pattern = Pattern.compile("[^0-9A-F]");
            Matcher matcher = pattern.matcher(textFieldWidget.getText());
            if (!matcher.find() && textFieldWidget.getText().length() < 7){
                WynnMiata.CONFIG.setArmorDurabilityTextColor(textFieldWidget.getText());
                WynnMiata.CONFIG.save();
                WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();

            }
            else{
                textFieldWidget.setText(WynnMiata.CONFIG.getArmorDurabilityTextColor());
            }

        }).dimensions( x, y, 40, 15).tooltip(Tooltip.of(Text.of("Enter your Input"))).build();
    }

    public static ButtonWidget ArmorDurabilityTextCoordsEnter(int leftpos, int toppos, int screenwidth, int screenheight, TextFieldWidget x, TextFieldWidget y){
        return ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".layout.Button.armorDurabilityTextCoordsEnter"), (btn) -> {
            if (WynnMiataUtils.isNumeric(y.getText()) && WynnMiataUtils.isNumeric(x.getText())){
                int iy = Integer.parseInt(y.getText());
                int ix = Integer.parseInt(x.getText());
                if (iy > screenheight || iy < 0 || ix < 0 || ix > screenwidth){
                    y.setText(String.valueOf(WynnMiata.CONFIG.getArmorDurabilityTextY()));
                    x.setText(String.valueOf(WynnMiata.CONFIG.getArmorDurabilityTextX()));
                }
                else {
                    WynnMiata.CONFIG.setArmorDurabilityTextX(ix);
                    WynnMiata.CONFIG.setArmorDurabilityTextY(iy);
                    WynnMiata.CONFIG.save();
                    WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();
                }

            }
            else{
                y.setText(String.valueOf(WynnMiata.CONFIG.getArmorDurabilityTextY()));
                x.setText(String.valueOf(WynnMiata.CONFIG.getArmorDurabilityTextX()));
            }

        }).dimensions( leftpos + 180, toppos  + 88, 40, 15).tooltip(Tooltip.of(Text.of("Enter your Input"))).build();
    }

    public static ButtonWidget ProfessionHudCoordsEnter(int leftpos, int toppos, int screenwidth, int screenheight, TextFieldWidget x, TextFieldWidget y){
        return ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".layout.Button.ProfessionHudEnter"), (btn) -> {
            if (WynnMiataUtils.isNumeric(y.getText()) && WynnMiataUtils.isNumeric(x.getText())){
                int iy = Integer.parseInt(y.getText());
                int ix = Integer.parseInt(x.getText());
                if (iy > screenheight || iy < 0 || ix < 0 || ix > screenwidth){
                    y.setText(String.valueOf(WynnMiata.CONFIG.getProfessionHudY()));
                    x.setText(String.valueOf(WynnMiata.CONFIG.getProfessionHudX()));
                }
                else {
                    WynnMiata.CONFIG.setProfessionHudX(ix);
                    WynnMiata.CONFIG.setProfessionHudY(iy);
                    WynnMiata.CONFIG.save();
                    WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();
                }

            }
            else{
                y.setText(String.valueOf(WynnMiata.CONFIG.getProfessionHudY()));
                x.setText(String.valueOf(WynnMiata.CONFIG.getProfessionHudX()));
            }

        }).dimensions( leftpos + 180, toppos  + 33, 40, 15).tooltip(Tooltip.of(Text.of("Enter your Input"))).build();
    }

    public static ButtonWidget ProfessionHudColorEnter(int x, int y, TextFieldWidget textFieldWidget){
        return ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".layout.Button.ProfessionHudColorEnter"), (btn) -> {
            Pattern pattern = Pattern.compile("[^0-9A-F]");
            Matcher matcher = pattern.matcher(textFieldWidget.getText());
            if (!matcher.find() && textFieldWidget.getText().length() < 7){
                WynnMiata.CONFIG.setProfessionHudTextColor(textFieldWidget.getText());
                WynnMiata.CONFIG.save();
                WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();

            }
            else{
                textFieldWidget.setText(WynnMiata.CONFIG.getProfessionHudTextColor());
            }

        }).dimensions( x, y, 40, 15).tooltip(Tooltip.of(Text.of("Enter your Input"))).build();
    }

    public static ButtonWidget ProfessionHudTextCoordsEnter(int leftpos, int toppos, int screenwidth, int screenheight, TextFieldWidget x, TextFieldWidget y){
        return ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".layout.Button.ProfessionHudTextCoordsEnter"), (btn) -> {
            if (WynnMiataUtils.isNumeric(y.getText()) && WynnMiataUtils.isNumeric(x.getText())){
                int iy = Integer.parseInt(y.getText());
                int ix = Integer.parseInt(x.getText());
                if (iy > screenheight || iy < 0 || ix < 0 || ix > screenwidth){
                    y.setText(String.valueOf(WynnMiata.CONFIG.getProfessionHudTextY()));
                    x.setText(String.valueOf(WynnMiata.CONFIG.getProfessionHudTextX()));
                }
                else {
                    WynnMiata.CONFIG.setProfessionHudTextX(ix);
                    WynnMiata.CONFIG.setProfessionHudTextY(iy);
                    WynnMiata.CONFIG.save();
                    WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();
                }

            }
            else{
                y.setText(String.valueOf(WynnMiata.CONFIG.getProfessionHudTextY()));
                x.setText(String.valueOf(WynnMiata.CONFIG.getProfessionHudTextX()));
            }

        }).dimensions( leftpos + 180, toppos  + 88, 40, 15).tooltip(Tooltip.of(Text.of("Enter your Input"))).build();
    }

    public static ButtonWidget AccessoryDurabilityCoordsEnter(int leftpos, int toppos, int screenwidth, int screenheight, TextFieldWidget x, TextFieldWidget y){
        return ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".layout.Button.armorDurabilityEnter"), (btn) -> {
            if (WynnMiataUtils.isNumeric(y.getText()) && WynnMiataUtils.isNumeric(x.getText())){
                int iy = Integer.parseInt(y.getText());
                int ix = Integer.parseInt(x.getText());
                if (iy > screenheight || iy < 0 || ix < 0 || ix > screenwidth){
                    y.setText(String.valueOf(WynnMiata.CONFIG.getAccessoryDurabilityY()));
                    x.setText(String.valueOf(WynnMiata.CONFIG.getAccessoryDurabilityX()));
                }
                else {
                    WynnMiata.CONFIG.setAccessoryDurabilityX(ix);
                    WynnMiata.CONFIG.setAccessoryDurabilityY(iy);
                    WynnMiata.CONFIG.save();
                    WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();
                }

            }
            else{
                y.setText(String.valueOf(WynnMiata.CONFIG.getAccessoryDurabilityY()));
                x.setText(String.valueOf(WynnMiata.CONFIG.getAccessoryDurabilityX()));
            }

        }).dimensions( leftpos + 180, toppos  + 33, 40, 15).tooltip(Tooltip.of(Text.of("Enter your Input"))).build();
    }

    public static ButtonWidget AccessoryDurabilityColorEnter(int x, int y, TextFieldWidget textFieldWidget){
        return ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".layout.Button.armorDurabilityColorEnter"), (btn) -> {
            Pattern pattern = Pattern.compile("[^0-9A-F]");
            Matcher matcher = pattern.matcher(textFieldWidget.getText());
            if (!matcher.find() && textFieldWidget.getText().length() < 7){
                WynnMiata.CONFIG.setAccessoryDurabilityTextColor(textFieldWidget.getText());
                WynnMiata.CONFIG.save();
                WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();

            }
            else{
                textFieldWidget.setText(WynnMiata.CONFIG.getAccessoryDurabilityTextColor());
            }

        }).dimensions( x, y, 40, 15).tooltip(Tooltip.of(Text.of("Enter your Input"))).build();
    }

    public static ButtonWidget AccessoryDurabilityTextCoordsEnter(int leftpos, int toppos, int screenwidth, int screenheight, TextFieldWidget x, TextFieldWidget y){
        return ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".layout.Button.armorDurabilityTextCoordsEnter"), (btn) -> {
            if (WynnMiataUtils.isNumeric(y.getText()) && WynnMiataUtils.isNumeric(x.getText())){
                int iy = Integer.parseInt(y.getText());
                int ix = Integer.parseInt(x.getText());
                if (iy > screenheight || iy < 0 || ix < 0 || ix > screenwidth){
                    y.setText(String.valueOf(WynnMiata.CONFIG.getAccessoryDurabilityTextY()));
                    x.setText(String.valueOf(WynnMiata.CONFIG.getAccessoryDurabilityTextX()));
                }
                else {
                    WynnMiata.CONFIG.setAccessoryDurabilityTextX(ix);
                    WynnMiata.CONFIG.setAccessoryDurabilityTextY(iy);
                    WynnMiata.CONFIG.save();
                    WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();
                }

            }
            else{
                y.setText(String.valueOf(WynnMiata.CONFIG.getAccessoryDurabilityTextY()));
                x.setText(String.valueOf(WynnMiata.CONFIG.getAccessoryDurabilityTextX()));
            }

        }).dimensions( leftpos + 180, toppos  + 88, 40, 15).tooltip(Tooltip.of(Text.of("Enter your Input"))).build();
    }
}
