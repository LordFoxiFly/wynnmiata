package de.lordfoxifly.Commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import de.lordfoxifly.Api.PlayerAPI.Player;
import de.lordfoxifly.Api.PlayerAPIHelper;
import de.lordfoxifly.Api.RequestHelper;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.text.Text;

import java.io.IOException;
import java.net.URISyntaxException;

public class PlayerStatsCommand  {

    public static Player getPlayer(String username) throws URISyntaxException, IOException, InterruptedException {
        String src = RequestHelper.getAPIData("https://api.wynncraft.com/v3/player/"+ username);
        return PlayerAPIHelper.getPlayer(src);
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
                case "TCC" -> context.getSource().sendFeedback(Text.literal(player.getUsername() +  " has in total " + player.getGlobalData().getRaids().getList().getTheCanyonColossus() + " " + raid + " Runs. Global Ranking: " + player.getRanking().getTccCompletion()));
                case "NOL" -> context.getSource().sendFeedback(Text.literal(player.getUsername() +  " has in total " + player.getGlobalData().getRaids().getList().getOrphionSNexusOfLight() + " " + raid + " Runs. Global Ranking: " + player.getRanking().getNolCompletion()));
                case "NOG" -> context.getSource().sendFeedback(Text.literal(player.getUsername() +  " has in total " + player.getGlobalData().getRaids().getList().getNestOfTheGrootslangs() + " " + raid + " Runs. Global Ranking: " + player.getRanking().getNogCompletion()));
                case "TNA" ->  context.getSource().sendFeedback(Text.literal(player.getUsername() + " has in total " + player.getGlobalData().getRaids().getList().getTheNamelessAnomaly() + " " + raid + " Runs. Global Ranking: " + player.getRanking().getTnaCompletion()));
                default -> context.getSource().sendFeedback(Text.literal("ERROR, Use raid[NOL|TCC|NOG|TNA] and a valide Playername"));

            }
            return 1;
    }
}
