package de.lordfoxifly.Screens.Widgets;

import de.lordfoxifly.Screens.PlayerStatsScreen;
import de.lordfoxifly.WynnMiata;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;

import java.util.Objects;

public class TextFields {

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

    }).dimensions( leftpos + 205 + 124, toppos  + 17, 40, 15).tooltip(Tooltip.of(Text.of("Testing"))).build();
}
}
