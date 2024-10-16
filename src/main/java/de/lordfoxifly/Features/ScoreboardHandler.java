package de.lordfoxifly.Features;

import net.minecraft.scoreboard.ScoreHolder;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardEntry;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.util.Formatting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public  class ScoreboardHandler {

    /**
     * Returns the Scoreboard as Strings
     * @param scoreboardObjective
     * @return List of Strings
     */
    public static List<String> scoreboardLines (ScoreboardObjective scoreboardObjective){
        if (scoreboardObjective == null) {
            return Collections.emptyList();
        }
        List<String> lines = new ArrayList<>();

        final Scoreboard scoreboard = scoreboardObjective.getScoreboard();
        for (ScoreHolder knownScoreHolder : scoreboard.getKnownScoreHolders()) {
            if (!scoreboard.getScoreHolderObjectives(knownScoreHolder).containsKey(scoreboardObjective)) {
                continue;
            }

            String line = knownScoreHolder.getNameForScoreboard();

            if (line.isEmpty()) {
                continue;
            }

            lines.add(Formatting.strip(line));
        }

        return lines;
    }




}
