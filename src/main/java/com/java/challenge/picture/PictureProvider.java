package com.java.challenge.picture;

import java.io.IOException;
import java.time.LocalDate;

public interface PictureProvider {
    byte[] fetchPicture(LocalDate date) throws IOException;
}
