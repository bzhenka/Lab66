package responses;

import models.Movie;

import java.io.Serial;
import java.util.ArrayDeque;

public class FilterLessThanOscarsCountResponse extends Response {
    @Serial
    private static final long serialVersionUID = 1L;
    public final ArrayDeque<Movie> movies;

    public FilterLessThanOscarsCountResponse(String error, ArrayDeque<Movie> movies) {
        super("FilterLessThanOscarsCountRequest", error);
        this.movies = movies;
    }
}
