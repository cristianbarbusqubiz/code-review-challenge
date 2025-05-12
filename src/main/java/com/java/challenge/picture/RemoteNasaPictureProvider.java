package com.java.challenge.picture;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;

public class RemoteNasaPictureProvider implements PictureProvider {

    private final HttpClient client = HttpClient.newHttpClient();

    @Override
    public byte[] fetchPicture(LocalDate date) throws IOException {
        HttpRequest request = HttpRequest.newBuilder(
                        URI.create("https://api.nasa.gov/planetary/apod?date=" + date))
                .GET()
                .build();

        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());
            if (response.statusCode() != 200) {
                throw new IOException("Unexpected status: " + response.statusCode());
            }
            return response.body();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            throw new IOException("Interrupted while fetching APOD", ex);
        }
    }
}
