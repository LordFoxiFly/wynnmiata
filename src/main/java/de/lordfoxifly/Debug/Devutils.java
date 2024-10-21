package de.lordfoxifly.Debug;

import de.lordfoxifly.Events.ChatMessageEvent;
import de.lordfoxifly.Events.ScoreboardUpdateEvent;
import de.lordfoxifly.WynnMiata;
import net.minecraft.client.MinecraftClient;
import net.minecraft.scoreboard.ScoreHolder;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.screen.ScreenHandlerListener;
import net.minecraft.util.Formatting;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Devutils {

    public static final Path logs_dir = Paths.get(MinecraftClient.getInstance().runDirectory.getPath()+ "/logs");

    /**
     * Writes to a log file
     * @param content
     * @param filename name of the File
     */
    public static void appendToFile( String content, String filename) {
        Path config_file = Paths.get(logs_dir + "/" +filename );
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(config_file.toFile(), true))) {
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
        if (WynnMiata.CONFIG.isDebugEventsBoolean()){
            ScoreboardUpdateEvent.EVENT.register((content -> {
                Devutils.appendToFile(Formatting.strip(content), "wynnmiatalogs.txt");
            }));
        }
    }
    public static void messagelog(){
        if (WynnMiata.CONFIG.isDebugEventsBoolean()) {
            ChatMessageEvent.EVENT.register((message -> {
                Devutils.appendToFile(Formatting.strip(message), "wynnmiatachatlogs.txt");
            }));
        }
    }

}
