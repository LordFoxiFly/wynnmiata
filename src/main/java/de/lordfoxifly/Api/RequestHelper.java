package de.lordfoxifly.Api;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestHelper {

     static HttpClient httpClient = HttpClient.newHttpClient();

    public  static String getAPIData(String url) throws URISyntaxException, IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();

        HttpResponse<String> response =   httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
