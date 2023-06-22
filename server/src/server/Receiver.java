package server;

import enums.*;
import server.exceptions.FilePermissionException;
import server.exceptions.IncorrectFileException;
import server.io.MovieCollectionCSVFileReader;
import server.io.MovieCollectionCSVFileWriter;
import server.io.MovieCollectionFileReader;
import server.io.MovieCollectionFileWriter;
import models.*;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;

public class Receiver {
    private final MovieCollection movieCollection;
    private final MovieCollectionFileReader csvFileReader;
    private final MovieCollectionFileWriter csvFileWriter;
    public Receiver() throws IOException, FilePermissionException, IncorrectFileException {
        String path = System.getenv("LAB5_COLLECTION");
        this.csvFileReader = new MovieCollectionCSVFileReader(path);
        this.csvFileWriter = new MovieCollectionCSVFileWriter(path);
        this.movieCollection = csvFileReader.read();
    }

    public void save() throws IOException {
        csvFileWriter.write(movieCollection);
    }

    public void clear() {
        movieCollection.clear();
    }

    public void add(String[] movieArguments) {
        String name = movieArguments[0];
        double coordinates_x = Double.parseDouble(movieArguments[1]);
        Float coordinates_y = Float.parseFloat(movieArguments[2]);
        Coordinates coordinates = new Coordinates(coordinates_x, coordinates_y);
        Long oscarCount = Long.parseLong(movieArguments[3]);
        MovieGenre movieGenre = MovieGenre.valueOf(movieArguments[4]);
        MpaaRating mpaaRating = MpaaRating.valueOf(movieArguments[5]);
        String operatorName = movieArguments[6];
        Integer weight = Integer.valueOf(movieArguments[7]);
        Integer age = Integer.valueOf(movieArguments[8]);
        Color eyeColor = Color.valueOf(movieArguments[9]);
        Color hairColor = Color.valueOf(movieArguments[10]);
        Country nationality = Country.valueOf(movieArguments[11]);
        double location_x = Double.parseDouble(movieArguments[12]);
        Float location_y = Float.valueOf(movieArguments[13]);
        Integer location_z = Integer.valueOf(movieArguments[14]);
        Location location = new Location(location_x, location_y, location_z);
        Person operator = new Person(operatorName, weight, age, eyeColor, hairColor, nationality, location);
        Movie movie = new Movie(name, coordinates, oscarCount, movieGenre, mpaaRating, operator);

        movieCollection.add(movie);
    }
    public ArrayDeque<Movie> show(){
        return movieCollection.getMovieArrayDeque();
    }
    public void updateId(int id, String[] movieArguments){
        String name = movieArguments[0];
        double coordinates_x = Double.parseDouble(movieArguments[1]);
        Float coordinates_y = Float.parseFloat(movieArguments[2]);
        Coordinates coordinates = new Coordinates(coordinates_x, coordinates_y);
        Long oscarCount = Long.parseLong(movieArguments[3]);
        MovieGenre movieGenre = MovieGenre.valueOf(movieArguments[4]);
        MpaaRating mpaaRating = MpaaRating.valueOf(movieArguments[5]);
        String operatorName = movieArguments[6];
        Integer weight = Integer.valueOf(movieArguments[7]);
        Integer age = Integer.valueOf(movieArguments[8]);
        Color eyeColor = Color.valueOf(movieArguments[9]);
        Color hairColor = Color.valueOf(movieArguments[10]);
        Country nationality = Country.valueOf(movieArguments[11]);
        double location_x = Double.parseDouble(movieArguments[12]);
        Float location_y = Float.valueOf(movieArguments[13]);
        Integer location_z = Integer.valueOf(movieArguments[14]);
        Location location = new Location(location_x, location_y, location_z);
        Person operator = new Person(operatorName, weight, age, eyeColor, hairColor, nationality, location);


        movieCollection.updateMovie(id, name, coordinates, oscarCount, movieGenre, mpaaRating, operator);
    }
    public Movie head(){
        return movieCollection.head();
    }
    public boolean removeById(int id) {
        return movieCollection.remove_by_id(id);
    }
    public void removeFirst(){
        movieCollection.remove_first();
    }
    public Movie removeHead(){
        Movie firstMovie = movieCollection.head();
        movieCollection.remove_head();
        return firstMovie;
    }
    public Integer countLessThanOperator(String[] operatorArgs){
        String operatorName = operatorArgs[0];
        Integer weight = Integer.valueOf(operatorArgs[1]);
        Integer age = Integer.valueOf(operatorArgs[2]);
        Color eyeColor = Color.valueOf(operatorArgs[3]);
        Color hairColor = Color.valueOf(operatorArgs[4]);
        Country nationality = Country.valueOf(operatorArgs[5]);
        double location_x = Double.parseDouble(operatorArgs[6]);
        Float location_y = Float.valueOf(operatorArgs[7]);
        Integer location_z = Integer.valueOf(operatorArgs[8]);
        Location location = new Location(location_x, location_y, location_z);
        Person operator = new Person(operatorName, weight, age, eyeColor, hairColor, nationality, location);
        return movieCollection.count_less_than_operator(operator);

    }
    public ArrayDeque<Movie> filterContainsName(String name){
         return movieCollection.filter_contains_name(name);
    }
    public ArrayDeque<Movie> filterLessThanOscarsCount(Long oscarCount){
        return movieCollection.filter_less_than_oscars_count(oscarCount);
    }
    public String[] info(){
        String[] data = new String[3];
        data[0] = movieCollection.getMovieArrayDeque().getClass().getName();
        data[1] = String.valueOf(movieCollection.getSize());
        data[2] = movieCollection.getInitializationDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
        return data;
    }
}
