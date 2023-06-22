package responses;

import models.Movie;

import java.io.Serial;
import java.util.ArrayList;

public class FilterContainsNameResponse extends Response {
    @Serial
    private static final long serialVersionUID = 1L;
    public final ArrayList<Movie> movies;

    public FilterContainsNameResponse(String error, ArrayList<Movie> movies) {
        super("FilterContainsName", error);
        this.movies = movies;

    }
}
