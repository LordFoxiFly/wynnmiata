package de.lordfoxifly.Debug;

import de.lordfoxifly.Events.ChatMessageEvent;
import de.lordfoxifly.Events.ScoreboardUpdateEvent;
import net.minecraft.client.MinecraftClient;
import net.minecraft.scoreboard.ScoreHolder;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.screen.ScreenHandlerListener;
import net.minecraft.util.Formatting;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class Devutils {

    public static void appendToFile( String content, String filename) {
        String filePath = Paths.get(MinecraftClient.getInstance().runDirectory.getPath())+ "/logs/" + filename;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Write the content
            writer.write(content);

            // Newline character for better readability
            writer.newLine();

            System.out.println("Content appended successfully.");
        } catch (IOException e) {
            System.err.println("Error appending to file: " + e.getMessage());
        }
    }

    public static void ScoreboardTesting() {
        ScoreboardUpdateEvent.EVENT.register((content -> {
            Devutils.appendToFile(Formatting.strip(content), "wynnmiatalogs.txt");
        }));
    }
    public static void messagelog(){
        ChatMessageEvent.EVENT.register((message->{
            Devutils.appendToFile(Formatting.strip(message), "wynnmiatachatlogs.txt");
        }));
    }

}
