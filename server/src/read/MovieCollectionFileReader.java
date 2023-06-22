package read;

import client.exceptions.IncorrectFileException;
import server.MovieCollection;

import java.io.IOException;

public interface MovieCollectionFileReader {
    MovieCollection read() throws IOException, IncorrectFileException;
}
