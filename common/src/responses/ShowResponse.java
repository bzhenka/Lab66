package responses;

import models.Movie;

import java.io.Serial;
import java.util.ArrayDeque;

public class ShowResponse extends Response {
    @Serial
    private static final long serialVersionUID = 1L;
    public final ArrayDeque<Movie> movieDeque;
    public ShowResponse(ArrayDeque<Movie> movieDeque, String error) {
        super("show", error);
        this.movieDeque = movieDeque;
    }
}
