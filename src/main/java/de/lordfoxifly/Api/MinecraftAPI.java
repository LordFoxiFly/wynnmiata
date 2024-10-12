package de.lordfoxifly.Api;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MinecraftAPI {

    static HttpClient httpClient = HttpClient.newHttpClient();

    public static String getPlayerUUID(String name) throws URISyntaxException, IOException, InterruptedException, ClassCastException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.mojang.com/users/profiles/minecraft/" + name))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        String output = response.body();

        return output.substring(13, 44);
    }
}
