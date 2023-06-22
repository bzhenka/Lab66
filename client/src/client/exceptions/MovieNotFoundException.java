package client.exceptions;

public class MovieNotFoundException extends Exception{
    public MovieNotFoundException(int id) {
        super("Фильм с данным id " + id + " не найден");
    }
}
