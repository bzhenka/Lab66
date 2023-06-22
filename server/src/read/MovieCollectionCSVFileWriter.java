package read;

import models.Movie;
import server.MovieCollection;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class MovieCollectionCSVFileWriter implements MovieCollectionFileWriter {
    private final String filepath;
    private final char delimiter = ';';
    public MovieCollectionCSVFileWriter(String filename){
        this.filepath = filename;
    }
    @Override
    public void write(MovieCollection movieCollection) throws IOException {
        try (OutputStream outputStream = new FileOutputStream(filepath);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            CSVWriter csvWriter = new CSVWriter(outputStreamWriter, delimiter)) {

            ArrayList<String[]> processedMovies = new ArrayList<>();
            ArrayDeque<Movie> movieArrayDeque = movieCollection.getMovieArrayDeque().clone();
            int numberOfMovies = movieArrayDeque.size();
            for (int i = 0; i < numberOfMovies; i++) {

                Movie movie = movieArrayDeque.pop();
                String[] movieArgs = new String[16];

                movieArgs[0] = movie.getName();
                movieArgs[1] = String.valueOf(movie.getCoordinates().getX());
                movieArgs[2] = String.valueOf(movie.getCoordinates().getY());
                movieArgs[3] = movie.getCreationDate().toString();
                movieArgs[4] = movie.getOscarsCount().toString();
                movieArgs[5] = movie.getGenre().toString();
                movieArgs[6] = movie.getMpaaRating().toString();
                movieArgs[7] = movie.getOperator().getName();
                movieArgs[8] = movie.getOperator().getWeight().toString();
                movieArgs[9] = movie.getOperator().getAge().toString();
                movieArgs[10] = movie.getOperator().getEyeColor().toString();
                movieArgs[11] = movie.getOperator().getHairColor().toString();
                movieArgs[12] = movie.getOperator().getNationality().toString();
                movieArgs[13] = String.valueOf(movie.getOperator().getLocation().getX());
                movieArgs[14] = String.valueOf(movie.getOperator().getLocation().getY());
                movieArgs[15] = String.valueOf(movie.getOperator().getLocation().getZ());

                processedMovies.add(movieArgs);
            }

            outputStreamWriter.write(movieCollection.getInitializationDate().toString() + '\n');
            outputStreamWriter.write(String.format("\"movieName\"%s\"coordinatesX\"%<s\"coordinatesY\"%<s\"creationDate\"%<s\"oscarsCount\"%<s\"genre\"%<s\"mpaaRating\"%<s\"operatorName\"%<s\"weight\"%<s\"eyeColor\"%<s\"hairColor\"%<s\"nationality\"%<s\"locationX\"%<s\"locationY\"%<s\"locationZ\"\n", delimiter));
            csvWriter.writeAll(processedMovies);
        }
    }
}
