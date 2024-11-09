package de.lordfoxifly.Debug;

import com.mojang.brigadier.context.CommandContext;
import de.lordfoxifly.Features.Items.ItemUtils;
import de.lordfoxifly.Features.Professions.ProfessionUtils;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.text.Text;

public class DebugCommands {
    public static int getScoreBoardString(CommandContext<FabricClientCommandSource> context) {


        /**
         * Scoreboard scoreboard =  MinecraftClient.getInstance().player.getScoreboard();
         *         ScoreboardObjective objectives = scoreboard.getObjectiveForSlot(ScoreboardDisplaySlot.SIDEBAR);
         *
         *         if ( scoreboard == null){
         *             context.getSource().sendFeedback(Text.literal("SCOREBOARD = null"));
         *             return 1;
         *         }
         *         else{
         *
         *             List<String> lines = ScoreboardHandler.scoreboardLines(scoreboard.getObjectiveForSlot(ScoreboardDisplaySlot.SIDEBAR));
         *             lines.reversed();
         *             for (String line : lines){
         *                 context.getSource().sendFeedback(Text.literal(line));
         *                 Devutils.appendToFile(Formatting.strip(line) , "wynnmiatalogs.txt");
         *             }
         *         }
         */
        /**
         *
         *  Value<NbtCompound> value = ItemData.WynncraftTag(MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.HEAD));
         *         StringBuilder stringBuilder = new StringBuilder();
         *         for (String key :value.get().getKeys()){
         *             if (value.get().get(key) == null) {
         *                 continue;
         *             }
         *             Pattern durabilityPattern = Pattern.compile("\\[\\d+/\\d+\\ Durability\\]");
         *             Matcher matcher = durabilityPattern.matcher(stringBuilder.append(Formatting.strip(Objects.requireNonNull(value.get().get(key)).asString())));
         *             if (matcher.find()){
         *                 String durabilty = matcher.group().substring(matcher.group().indexOf("[") + 1 , matcher.group().indexOf("/"));
         *                 String maxdurabilty = matcher.group().substring(matcher.group().indexOf("/") +1, matcher.group().indexOf(" "));
         *                 context.getSource().sendFeedback(Text.literal("Dura:"  + durabilty  + " | Max Dura: " + maxdurabilty));
         *             }
         *             stringBuilder.append(Formatting.strip(Objects.requireNonNull(value.get().get(key)).asString()));
         *
         *         }
         *         String s = stringBuilder.substring(stringBuilder.indexOf("{"));
         *         Devutils.appendToFile(s, "wynnmiatadevlog.txt");
         */
       //context.getSource().sendFeedback(Text.literal(ItemUtils.getItemDurability(MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.HEAD)) + " Max Dura:" + ItemUtils.getItemMaxDurability(MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.HEAD))));
        //context.getSource().sendFeedback(Text.literal(String.valueOf(ProfessionUtils.getMiningSpeed(MinecraftClient.getInstance().player.getMainHandStack()))));
        //Devutils.appendToFile(ItemUtils.getItemLore(MinecraftClient.getInstance().player.getMainHandStack()), "wynnmiatadevlog.txt");
        //context.getSource().sendFeedback(Text.literal(String.valueOf(ProfessionUtils.isGatheringTool(MinecraftClient.getInstance().player.getMainHandStack()))));
        //context.getSource().sendFeedback(Text.literal(String.valueOf(ProfessionUtils.getGatheringToolType(MinecraftClient.getInstance().player.getMainHandStack()))));
        //context.getSource().sendFeedback(Text.literal(String.valueOf(ProfessionUtils.getGatheringToolTier(MinecraftClient.getInstance().player.getMainHandStack()))));
        context.getSource().sendFeedback(Text.literal(ItemUtils.getItemLore(MinecraftClient.getInstance().player.getInventory().getStack(9))));
        return 1;
    }


}
