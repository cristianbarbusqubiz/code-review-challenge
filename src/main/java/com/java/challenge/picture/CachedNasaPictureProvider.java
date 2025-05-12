package com.java.challenge.picture;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CachedNasaPictureProvider extends RemoteNasaPictureProvider {

    private final Map<LocalDate, byte[]> cache = new ConcurrentHashMap<>();

    @Override
    public byte[] fetchPicture(LocalDate date) {
        return cache.computeIfAbsent(date, d -> {
            try {
                return super.fetchPicture(d);
            } catch (IOException ex) {
                return null;
            }
        });
    }
}
