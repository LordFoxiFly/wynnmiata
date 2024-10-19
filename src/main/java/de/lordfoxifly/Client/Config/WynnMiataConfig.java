package de.lordfoxifly.Client.Config;

import com.google.gson.Gson;
import net.minecraft.client.MinecraftClient;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WynnMiataConfig {

    public static final Path config_dir = Paths.get(MinecraftClient.getInstance().runDirectory.getPath()+ "/config");
    public static final Path config_file = Paths.get(config_dir + "/wynnmiataconfig.json");



    private static WynnMiataConfigData config_data;

    public static WynnMiataConfigData loadConfigData() {
        if (config_data != null) return config_data;

        try {
            if (!Files.exists(config_file)) {
                Files.createDirectories(config_dir);
                Files.createFile(config_file);
                config_data = WynnMiataConfigData.getDefault();
                config_data.save();
                return config_data;
            }
        } catch (IOException e) {
            e.printStackTrace();
            config_data = WynnMiataConfigData.getDefault();
            return config_data;
        }
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader(config_file.toFile());
            config_data = gson.fromJson(reader, WynnMiataConfigData.class);
        } catch (IOException e) {
            e.printStackTrace();
            config_data = WynnMiataConfigData.getDefault();
        }
        return config_data;
    }

}
