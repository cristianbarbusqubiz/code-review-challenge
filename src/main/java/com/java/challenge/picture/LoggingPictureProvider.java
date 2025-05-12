package com.java.challenge.picture;

import java.io.IOException;
import java.time.LocalDate;

public class LoggingPictureProvider implements PictureProvider {

    private static final StringBuilder LOG = new StringBuilder();

    private final PictureProvider delegate;

    public LoggingPictureProvider(PictureProvider delegate) {
        this.delegate = delegate;
    }

    @Override
    public byte[] fetchPicture(LocalDate date) {
        byte[] data = null;
        try {
            data = delegate.fetchPicture(date);
            LOG.append("SUCCESS ").append(date)
                    .append(" size=").append(data.length)
                    .append('\n');
        } catch (IOException ex) {
            LOG.append("FAIL ").append(date)
                    .append(" : ").append(ex.getMessage())
                    .append('\n');
        }
        return data;
    }

    public String getLog() {
        return LOG.toString();
    }
}
