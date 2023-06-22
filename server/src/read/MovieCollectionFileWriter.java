package read;

import java.io.IOException;

import server.MovieCollection;

public interface MovieCollectionFileWriter {
    void write(MovieCollection movieCollection) throws IOException;
}
