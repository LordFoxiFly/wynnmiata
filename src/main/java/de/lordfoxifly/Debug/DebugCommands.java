package de.lordfoxifly.Debug;

import com.mojang.brigadier.context.CommandContext;
import de.lordfoxifly.Features.ScoreboardHandler;
import de.lordfoxifly.Screens.Widgets.CheckBoxs;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.scoreboard.*;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.text.Format;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DebugCommands {
    public static int getScoreBoardString(CommandContext<FabricClientCommandSource> context) {

        Scoreboard scoreboard =  MinecraftClient.getInstance().player.getScoreboard();
        ScoreboardObjective objectives = scoreboard.getObjectiveForSlot(ScoreboardDisplaySlot.SIDEBAR);

        if ( scoreboard == null){
            context.getSource().sendFeedback(Text.literal("SCOREBOARD = null"));
            return 1;
        }
        else{

            List<String> lines = ScoreboardHandler.scoreboardLines(scoreboard.getObjectiveForSlot(ScoreboardDisplaySlot.SIDEBAR));
            lines.reversed();
            for (String line : lines){
                context.getSource().sendFeedback(Text.literal(line));
                Devutils.appendToFile(Formatting.strip(line));
            }
        }

        return 1;
    }


}
