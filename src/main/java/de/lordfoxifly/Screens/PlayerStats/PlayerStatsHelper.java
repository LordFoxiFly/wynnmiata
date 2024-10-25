package de.lordfoxifly.Screens.PlayerStats;

import de.lordfoxifly.Api.CharacterListAPI.CharacterListData;
import de.lordfoxifly.Api.CharacterListAPI.CharacterListUtils;
import de.lordfoxifly.Api.PlayerAPI.Player;
import de.lordfoxifly.Screens.PlayerStats.Screens.ProfStatScreen;
import de.lordfoxifly.Screens.PlayerStatsScreen;
import de.lordfoxifly.Screens.Widgets.ImageButtonWidget;
import de.lordfoxifly.WynnMiata;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class PlayerStatsHelper {
    private static final Identifier GREENWOOL = Identifier.of("wynnmiata" , "textures/gui/wool/greenwool.png");
    private static final Identifier GRAYWOOL = Identifier.of("wynnmiata", "textures/gui/wool/graywool.png");
    private static final Identifier xpbar = Identifier.of("wynnmiata","textures/gui/experience_bar_background.png");
    private static final Identifier xpbarProgress = Identifier.of("wynnmiata","textures/gui/experience_bar_progress.png");


    public static void renderOnlineWool(DrawContext context, Boolean online, int leftpos, int toppos){
        if (online){
            context.drawTexture(GREENWOOL,leftpos+47, toppos + 44, 0 ,0 , 10,10,10,10 );
        }else {
            context.drawTexture(GRAYWOOL,leftpos+47, toppos + 44, 0 ,0 , 10,10,10,10);
        }
    }

    public static void renderProgressBar(DrawContext context, int value, Boolean isMax ,int leftpos, int toppos){
        int width = 80;
        int barProgress = Math.round( width * ((float) value / width));
        if (isMax){
            context.drawTexture(xpbar, leftpos, toppos,0 ,0 , width , 5, width ,5);
            context.drawTexture(xpbarProgress, leftpos,toppos,   0 ,0 , barProgress, 5, barProgress, 5);

        }
        else{
            context.drawTexture(xpbar, leftpos, toppos,0 ,0 , width , 5, width ,5);
            context.drawTexture(xpbarProgress, leftpos,toppos,   0 ,0 , barProgress, 5, barProgress, 5);
        }
    }

    public static List<ImageButtonWidget> getClassWidgets(int leftpos, int toppos, Player player){
        List<ImageButtonWidget> imageButtonWidgets = new ArrayList<>();

        int yOffset = 35;
        for (CharacterListData characterListData: player.getCharacters()){
            ImageButtonWidget tempbutton = new ImageButtonWidget(leftpos - 20, toppos + yOffset, 20, 20, Text.translatable("gui." + WynnMiata.MOD_ID + ".playerstats.Button." + characterListData.getCharacterUuid()),getClassIdentifier(characterListData.getType().toLowerCase()), false, button -> {
                MinecraftClient.getInstance().setScreen(new ProfStatScreen(player));
            });
            if (player.getActiveCharacter() == characterListData.getCharacterUuid()){
                tempbutton.setSelected(true);
            }
            tempbutton.setyBackgroundOffset(0);
            imageButtonWidgets.add( tempbutton);
            yOffset += 30;
        }
        return imageButtonWidgets;
    }

    public static Identifier getClassIdentifier(String classType){
        return Identifier.of("wynnmiata","textures/gui/wynncrafttexture/" +  classType+ ".png");
    }
}
