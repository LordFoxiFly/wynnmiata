package de.lordfoxifly.Commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import de.lordfoxifly.Api.MinecraftAPI;
import de.lordfoxifly.Api.PlayerAPI.Player;
import de.lordfoxifly.Api.PlayerAPIHelper;
import de.lordfoxifly.Api.RequestHelper;
import de.lordfoxifly.WynnMiata;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.text.Text;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.net.URISyntaxException;

public class PlayerStatsCommand  {

    private static Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    public static Player getPlayer(String username) throws URISyntaxException, IOException, InterruptedException {
        String uuid = MinecraftAPI.getPlayerUUID(username);
        WynnMiata.LOGGER.info(uuid);
        return PlayerAPIHelper.getPlayer( RequestHelper.getAPIData("https://api.wynncraft.com/v3/player/"+ uuid));
    }




    public static int GetPlayerRaidStats(CommandContext<FabricClientCommandSource> context)  {
            String username = StringArgumentType.getString(context,"playername");
            String raid = StringArgumentType.getString(context, "raid");
            Player player;
            try{
                player = getPlayer(username);
            } catch (InterruptedException | URISyntaxException | IOException e) {
                context.getSource().sendFeedback(Text.literal("An error has occured"));
                throw new RuntimeException(e);
            }
            switch (raid){
                case "TCC" ->{
                    if (player.getGlobalData() == null){
                        context.getSource().sendFeedback(Text.literal("§c Player not Found"));
                        break;
                    }
                    String contextS = player.getUsername() +  " has in total " + player.getGlobalData().getRaids().getList().getTheCanyonColossus() + " " + raid + " Runs. Global Ranking: " + player.getRanking().getTccCompletion();
                    context.getSource().sendFeedback(Text.literal(contextS));
                    if (WynnMiata.CONFIG.isCopyPlayerStatsBoolean()) clipboard.setContents(new StringSelection(contextS), new StringSelection(contextS));
                }

                case "NOL" -> {
                    if (player.getGlobalData() == null){
                        context.getSource().sendFeedback(Text.literal("§c Player not Found"));
                        break;
                    }
                    String contextS = player.getUsername() +  " has in total " + player.getGlobalData().getRaids().getList().getOrphionSNexusOfLight() + " " + raid + " Runs. Global Ranking: " + player.getRanking().getNolCompletion();
                    context.getSource().sendFeedback(Text.literal(contextS));
                    if (WynnMiata.CONFIG.isCopyPlayerStatsBoolean()) clipboard.setContents(new StringSelection(contextS), new StringSelection(contextS));
                }
                case "NOG" ->{
                    if (player.getGlobalData() == null){
                        context.getSource().sendFeedback(Text.literal("§c Player not Found"));
                        break;
                    }
                    String contextS  = player.getUsername() +  " has in total " + player.getGlobalData().getRaids().getList().getNestOfTheGrootslangs() + " " + raid + " Runs. Global Ranking: " + player.getRanking().getNogCompletion();
                    context.getSource().sendFeedback(Text.literal(contextS));
                    if (WynnMiata.CONFIG.isCopyPlayerStatsBoolean()) clipboard.setContents(new StringSelection(contextS), new StringSelection(contextS));}
                case "TNA" ->{
                    if (player.getGlobalData() == null){
                        context.getSource().sendFeedback(Text.literal("§c Player not Found"));
                        break;
                    }
                    String contextS = player.getUsername() + " has in total " + player.getGlobalData().getRaids().getList().getTheNamelessAnomaly() + " " + raid + " Runs. Global Ranking: " + player.getRanking().getTnaCompletion();
                    context.getSource().sendFeedback(Text.literal(contextS));
                    if (WynnMiata.CONFIG.isCopyPlayerStatsBoolean()) clipboard.setContents(new StringSelection(contextS), new StringSelection(contextS));
                }
                default ->
                        context.getSource().sendFeedback(Text.literal("ERROR, Use raid[NOL|TCC|NOG|TNA] and a valide Playername"));

            }
            return 1;
    }
}
