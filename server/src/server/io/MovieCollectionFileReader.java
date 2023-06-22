package server.io;

import server.exceptions.IncorrectFileException;
import server.MovieCollection;

import java.io.IOException;

public interface MovieCollectionFileReader {
    MovieCollection read() throws IOException, IncorrectFileException;
}
