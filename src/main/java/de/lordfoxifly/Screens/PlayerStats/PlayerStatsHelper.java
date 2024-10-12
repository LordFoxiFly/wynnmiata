package de.lordfoxifly.Screens.PlayerStats;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.Identifier;

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

}
