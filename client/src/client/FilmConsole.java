package client;

import models.Movie;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class FilmConsole {
    public static void printMovie(ArrayDeque<Movie> movies){
        for (Movie movie: movies){
            oneMovie(movie);
//            System.out.println(movie.getId() + ";" + movie.getName() + ";" + movie.getCoordinates().getX() + ";" + movie.getCoordinates().getY() + ";" + movie.getCreationDate() + ";" + movie.getOscarsCount() + ";" + movie.getGenre() + ";" + movie.getMpaaRating() + ";" + movie.getOperator().getName() + ";" + movie.getOperator().getWeight() + ";" + movie.getOperator().getAge() + ";" + movie.getOperator().getEyeColor() + ";" + movie.getOperator().getHairColor() + ";" + movie.getOperator().getNationality() + ";" + movie.getOperator().getLocation().getX() + ";" + movie.getOperator().getLocation().getY() + ";" + movie.getOperator().getLocation().getZ());
        }
    }
    public static void printMovie(ArrayList<Movie> movies){
        for (Movie movie: movies){
            oneMovie(movie);
//            System.out.println(movie.getId() + ";" + movie.getName() + ";" + movie.getCoordinates().getX() + ";" + movie.getCoordinates().getY() + ";" + movie.getCreationDate() + ";" + movie.getOscarsCount() + ";" + movie.getGenre() + ";" + movie.getMpaaRating() + ";" + movie.getOperator().getName() + ";" + movie.getOperator().getWeight() + ";" + movie.getOperator().getAge() + ";" + movie.getOperator().getEyeColor() + ";" + movie.getOperator().getHairColor() + ";" + movie.getOperator().getNationality() + ";" + movie.getOperator().getLocation().getX() + ";" + movie.getOperator().getLocation().getY() + ";" + movie.getOperator().getLocation().getZ());
        }
    }
    public static void oneMovie(Movie movie){
        System.out.println(movie.getId() + ";" + movie.getName() + ";" + movie.getCoordinates().getX() + ";" + movie.getCoordinates().getY() + ";" + movie.getCreationDate() + ";" + movie.getOscarsCount() + ";" + movie.getGenre() + ";" + movie.getMpaaRating() + ";" + movie.getOperator().getName() + ";" + movie.getOperator().getWeight() + ";" + movie.getOperator().getAge() + ";" + movie.getOperator().getEyeColor() + ";" + movie.getOperator().getHairColor() + ";" + movie.getOperator().getNationality() + ";" + movie.getOperator().getLocation().getX() + ";" + movie.getOperator().getLocation().getY() + ";" + movie.getOperator().getLocation().getZ());
    }
}
