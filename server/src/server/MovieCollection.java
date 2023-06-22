package server;

import enums.MovieGenre;
import enums.MpaaRating;
import models.Coordinates;
import models.Movie;
import models.Person;

import java.time.ZonedDateTime;
import java.util.*;

public class MovieCollection {
    private final ArrayDeque<Movie> movieArrayDeque = new ArrayDeque<>();
    private ZonedDateTime initializationDate;



    public MovieCollection() {
        initializationDate = ZonedDateTime.now();
    }

    public ArrayDeque<Movie> getMovieArrayDeque() {
        return movieArrayDeque;
    }

    public void add(Movie movie) {
        movieArrayDeque.addLast(movie);
    }

    public Movie remove_head() {
       return movieArrayDeque.removeFirst();
    }

    public void removeLastMovie() {
        movieArrayDeque.removeLast();
    }

    // получение количества фильмов в коллекции
    public int getSize() {
        return movieArrayDeque.size();
    }
    public void remove_first(){
        movieArrayDeque.removeFirst();
    }

    public void clear() {
        movieArrayDeque.clear();
    }

    public Movie head() {
       return movieArrayDeque.peekFirst();
    }

    public boolean remove_by_id(int id) {
        for (Movie i : movieArrayDeque) {
            if (i.getId() == id) {
                movieArrayDeque.remove(i);
                return true;
            }
        }
        return false;
    }

    public Movie get_by_id(int id) {
        for (Movie i : movieArrayDeque) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    public int count_less_than_operator(Person operator) {
        int count = 0;
        for (Movie movie : movieArrayDeque) {
            if (movie.getOperator().compareTo(operator) < 0) {
                count++;
            }
        }
        return count;
    }

    public ArrayDeque<Movie> filter_contains_name(String name) {
        ArrayDeque<Movie> movies = new ArrayDeque<>();
        for (Movie movie : movieArrayDeque) {
            if (movie.getName().contains(name))
                movies.add(movie);
        }
        return movies;
    }

    public void updateMovie(int id, String name, Coordinates coordinates, Long oscarsCount, MovieGenre genre, MpaaRating mpaaRating, Person operator) {


        for (Movie movie : movieArrayDeque) {
            if (movie.getId() == id) {
                movie.setName(name);
                movie.setCoordinates(coordinates);
                movie.setOscarsCount(oscarsCount);
                movie.setGenre(genre);
                movie.setMpaaRating(mpaaRating);
                movie.setOperator(operator);
                break;
            }
        }
    }
    public ArrayDeque<Movie> filter_less_than_oscars_count(Long oscarsCount){
        ArrayDeque<Movie> movies = new ArrayDeque<>();
        for (Movie movie: movieArrayDeque){
            if (movie.getOscarsCount().compareTo(oscarsCount) < 0){
                movies.add(movie);
            }
        }
        return movies;
    }
    public ZonedDateTime getInitializationDate() {
        return initializationDate;
    }

    public void setInitializationDate(ZonedDateTime initializationDate) {
        this.initializationDate = initializationDate;
    }
}

