package de.lordfoxifly.Screens.PlayerStats;

import de.lordfoxifly.Api.CharacterDataAPI.CharacterData.CharacterData;
import de.lordfoxifly.Api.CharacterDataAPI.CharacterDataUtils;
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
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    /**
     * Creates ImageButtons for the Characters from a Player
     * @param leftpos
     * @param toppos
     * @param player
     * @return
     */
    public static List<ImageButtonWidget> getClassWidgets(int leftpos, int toppos, Player player){
        List<ImageButtonWidget> imageButtonWidgets = new ArrayList<>();
        Map<String, CharacterListData> characterListData = player.getCharacters();
        int yOffset = 35;
        for (Map.Entry<String, CharacterListData> entry: characterListData.entrySet()){
            ImageButtonWidget tempbutton = new ImageButtonWidget(leftpos - 20, toppos + yOffset, 20, 20, Text.translatable("gui." + WynnMiata.MOD_ID + ".playerstats.Button." + entry.getKey()),getClassIdentifier(entry.getValue().getType().toLowerCase()), false, button -> {
                player.setSelectedCharacterData(CharacterDataUtils.getCharacterData(player, entry.getKey()));
                player.setSelectedCharacterUUID(entry.getKey());
                MinecraftClient.getInstance().setScreen(new PlayerStatsScreen(player));
            });
            if (Objects.equals(player.getSelectedCharacterUUID(), entry.getKey())){
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
